package com.ayo.conversion.dao;

public class ConversionResponseMapper {

    public ConversionResponseResource map (ConversionDto dto) {

        ConversionResponseResource resource = new ConversionResponseResource();
        resource.setConvertedUnit(dto.getUnit());
        resource.setUnitOfMeasure(dto.getUnitOfMeasure());

        return resource;
    }

}
