package com.example.demo.dto;

public class BuilderPatternClient {


    public BuilderPattern createBuilder(){
        BuilderPattern builderPattern = new BuilderPattern.BuilderPatternBuilder().type("Cruiser").model("abc").engineSize(200).build();
        return builderPattern;

    }
}
