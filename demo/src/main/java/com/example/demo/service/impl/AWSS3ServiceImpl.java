package com.example.demo.service.impl;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.example.demo.service.AWSS3Service;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class AWSS3ServiceImpl implements AWSS3Service {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    private AmazonS3 amazonS3;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Value("${aws.region}")
    private String awsRegion;

    @Override
    public void setAmazonS3(AmazonS3 amazonS3) {

    }

    @Override
    public boolean isBucketExist(String bucketName) {
        boolean isExist = amazonS3.doesBucketExistV2(bucketName);
        return isExist;
    }

    @Override
    public boolean isObjectExist(String bucketName, String objectKey) {
        boolean isExist = amazonS3.doesObjectExist(bucketName,objectKey);
        return isExist;
    }

    @Override
    public Bucket createBucket(String bucketName) {
        Bucket bucket = null;
        if(!amazonS3.doesBucketExistV2(bucketName)){
            bucket = amazonS3.createBucket(bucketName);
        }else{
            logger.info("========This bucket name: {} already exists, please try a different name.", bucketName);
        }
        return bucket;
    }

    @Override
    public List<Bucket> getBucketList() {
        List<Bucket> bucketList = amazonS3.listBuckets();
        return bucketList;
    }

    @Override
    public void deleteBucket(String bucketName) {
        try{
            amazonS3.deleteBucket(bucketName);
        }catch(AmazonServiceException e){
            logger.error("=======delete bucket failed with bucket name = {}, error = {}", bucketName, e.getMessage());
        }

    }

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        return null;
    }

    @Override
    public String uploadMultipartFile(String bucketName, MultipartFile multipartFile) throws IOException {
        String s3Key = multipartFile.getOriginalFilename();
        String homeDir = System.getProperty("catalina.base") !=null ? System.getProperty("catalina.base") : "/tmp/";
        File localFile = new File(homeDir + s3Key);
        multipartFile.transferTo(localFile);
        amazonS3.putObject(bucketName, s3Key, localFile);
        return null;
    }

    @Override
    public void uploadObject(String bucketName, String key, String fullFilepath) {
        amazonS3.putObject(bucketName, key, new File(fullFilepath));

    }

    @Override
    public ObjectListing listObjects(String bucketName) {
        ObjectListing objectListing = amazonS3.listObjects(bucketName);
        return objectListing;
    }

    @Override
    public List<String> findObjectKeyList(String bucketName) {
        ObjectListing objectListing = amazonS3.listObjects(bucketName);
        List<String> objectKeyList = new ArrayList<>();
        for(S3ObjectSummary s3ObjectSummary : objectListing.getObjectSummaries()){
            objectKeyList.add(s3ObjectSummary.getKey());
        }
        return objectKeyList;
    }

    @Override
    public File downloadObject(String bucketName, String objectKey, String destinationFullPath) throws IOException {
        S3Object s3Object = amazonS3.getObject(bucketName,objectKey);
        S3ObjectInputStream s3ObjectInputStream = s3Object.getObjectContent();
        File destFile = new File(destinationFullPath);
        FileUtils.copyInputStreamToFile(s3ObjectInputStream, destFile);
        return destFile;
    }

    @Override
    public void copyObject(String oriBucketName, String oriObjectKey, String destBucketName, String destObjectKey) {
        amazonS3.copyObject(oriBucketName, oriObjectKey,
                destBucketName, destObjectKey);
    }

    @Override
    public void copyObjectUsingCopyObjectRequest(String oriBucketName, String oriObjectKey,
                                                 String destBucketName, String destObjectKey) {
        CopyObjectRequest copyObjectRequest = new CopyObjectRequest(oriBucketName, oriObjectKey,
                destBucketName, destObjectKey);
        amazonS3.copyObject(copyObjectRequest);
    }

    @Override
    public void deleteObject(String bucketName, String objectKey) {
        amazonS3.deleteObject(bucketName, objectKey);
    }

    @Override
    public void deleteMultipleObjects(String bucketName, String[] objectKeyArray) {

        DeleteObjectsRequest deleteObjectsRequest = new DeleteObjectsRequest(bucketName).withKeys(objectKeyArray);
        amazonS3.deleteObjects(deleteObjectsRequest);
    }

    @Override
    public String generatePresignedURLForUploading(String bucketName, String objectKey) {
        return null;
    }

    @Override
    public String generatePresignedURLForDownloading(String objectKey) {
        return null;
    }

    @Override
    public String generatePresignedURLForDownloading(String bucketName, String objectKey) {
        return null;
    }

    @Override
    public String generatePresignedURL(String bucketName,
                                       String objectKey, String httpMethodString) {
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withRegion(awsRegion)
                .build();

        // Set the pre-signed URL to expire after one hour.
        java.util.Date expiration = new java.util.Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60 * 60;
        expiration.setTime(expTimeMillis);

        // Generate the pre-signed URL.
        logger.info("Generating pre-signed URL.");
        GeneratePresignedUrlRequest generatePresignedUrlRequest =
                new GeneratePresignedUrlRequest(bucketName, objectKey)
                        .withMethod(HttpMethod.valueOf(httpMethodString))
                        .withExpiration(expiration);
        URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
        return url.toString();
    }
}
