package com.example.demo.dto;

public class BuilderPattern {

    private String type;

    private String brand;

    private int engineSize;

    private String model;

    public BuilderPattern(BuilderPatternBuilder builderPatternBuilder){
        this.type = builderPatternBuilder.type;
        this.model = builderPatternBuilder.model;
        this.engineSize = builderPatternBuilder.engineSize;

    }

    public static class BuilderPatternBuilder {
        private String type;

        private String brand;

        private int engineSize;

        private String model;

//        public BuilderPatternBuilder(String type, String model){
//
//        }



        public BuilderPatternBuilder type(String type){
            this.type = type;
            return this;
        }

        public BuilderPatternBuilder brand(String brand){
            this.brand = brand;
            return this;
        }

        public BuilderPatternBuilder engineSize(int engineSize){
            this.engineSize = engineSize;
            return this;
        }

        public BuilderPatternBuilder model(String model){
            this.model = model;
            return this;
        }



        public BuilderPattern build(){
            return new BuilderPattern(this);
        }

    }

}
