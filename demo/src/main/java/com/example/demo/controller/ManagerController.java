package com.example.demo.controller;


import com.example.demo.dto.ManagerDto;
import com.example.demo.entity.Manager;
import com.example.demo.exception.ExceptionResponse;
import com.example.demo.exception.ItemNotFoundException;
import com.example.demo.service.ClientService;
import com.example.demo.service.ManagerService;
import com.example.demo.service.ProductService;
import com.example.demo.service.impl.ClientServiceImpl;
import com.example.demo.service.impl.ManagerServiceImpl;
import com.example.demo.service.impl.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/project_bank")
public class ManagerController {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    private ManagerServiceImpl managerServiceImpl;

//    @Autowired
//    private ClientServiceImpl clientServiceImpl;
//
//    @Autowired
//    private ProductServiceImpl productServiceImpl;


    @GetMapping(value = "/managers", produces = "application/json")
//    @GetMapping(value= "/managers", produces= "application/json", headers = {"names=Bruce", "id = 1"})
    public ResponseEntity<List<ManagerDto>> findAllManagers(){
        List<ManagerDto> managerDtoList = managerServiceImpl.getManagers();
//        return managerDtoList;
        return new ResponseEntity<>(managerDtoList, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/managers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findManagerDtoById(@PathVariable("id") Long managerId){
        ManagerDto managerDto = null;
        ResponseEntity<Object> responseEntity = null;
        try{
            managerDto = managerServiceImpl.getManagerById(managerId);
            responseEntity = new ResponseEntity<>(managerDto,HttpStatus.OK);
        }catch (ItemNotFoundException e){
            ExceptionResponse exceptionResponse = new ExceptionResponse("Something Wrong", LocalDateTime.now(), e.getMessage());
            responseEntity = new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
        }

        return responseEntity;

    }

    @GetMapping(value = "/managers/param_practice", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findManagerDtoByRequestParamId(@RequestParam("id") Long managerId){
        ManagerDto managerDto = null;
        ResponseEntity<Object> responseEntity = null;
        try{
            managerDto = managerServiceImpl.getManagerById(managerId);
            responseEntity = new ResponseEntity<>(managerDto,HttpStatus.OK);
        }catch (ItemNotFoundException e){
            ExceptionResponse exceptionResponse = new ExceptionResponse("Something Wrong", LocalDateTime.now(), e.getMessage());
            responseEntity = new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
        }

        return responseEntity;

    }


    @PostMapping(value = "/managers", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ManagerDto> saveManagerDto(@RequestBody ManagerDto managerDto){
        ManagerDto savedManagerDto = managerServiceImpl.save(managerDto);

        URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedManagerDto.getId())
                .toUri();

        logger.info("=======================================before return URI value = {}", uriLocation);

        return ResponseEntity.created(uriLocation).body(savedManagerDto);
//        return new ResponseEntity(savedManagerDto,HttpStatus.CREATED);
    }

    @PutMapping(value = "/managers", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ManagerDto updateManagerDto(@RequestBody ManagerDto managerDto){
        ManagerDto updatedManagerDto = managerServiceImpl.save(managerDto);
        return updatedManagerDto;
    }

    @DeleteMapping(value = "/managers" ,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteManagerDto(@RequestBody ManagerDto managerDto){

        boolean deleteResult = managerServiceImpl.delete(managerDto);
        if(deleteResult){
            return ResponseEntity.status(HttpStatus.OK).build();
        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }
}
