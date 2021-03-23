package com.ayo.conversion.service;

import com.ayo.conversion.dao.ConversionDto;
import com.ayo.conversion.util.UnitOfMeasure;
import org.springframework.stereotype.Service;

import javax.measure.converter.UnitConverter;

import static javax.measure.unit.NonSI.*;
import static javax.measure.unit.SI.*;

@Service
public class ConversionServiceImpl implements ConversionService{

    private UnitConverter converter;

    @Override
    public ConversionDto convertMileToKilometer(double mile) {

        converter = MILE.getConverterTo(KILOMETER);

        return getConversionDto(converter.convert(mile), UnitOfMeasure.KILOMETER.getDescription());
    }

    @Override
    public ConversionDto convertKilometerToMile(double kilometer) {

        converter = KILOMETER.getConverterTo(MILE);

        return getConversionDto(converter.convert(kilometer), UnitOfMeasure.MILE.getDescription());
    }

    @Override
    public ConversionDto convertCelsiusToFahrenheit(double celsius) {

        converter = CELSIUS.getConverterTo(FAHRENHEIT);

        return getConversionDto(converter.convert(celsius), UnitOfMeasure.FAHRENHEIT.getDescription());
    }

    @Override
    public ConversionDto convertFahrenheitToCelsius(double fahrenheit) {

        converter = FAHRENHEIT.getConverterTo(CELSIUS);

        return getConversionDto(converter.convert(fahrenheit), UnitOfMeasure.CELSIUS.getDescription());
    }

    @Override
    public ConversionDto convertPoundToKilogram(double pound) {

        converter = POUND.getConverterTo(KILOGRAM);

        return getConversionDto(converter.convert(pound), UnitOfMeasure.KILOGRAM.getDescription());
    }

    private ConversionDto getConversionDto (final double unit, final String unitOfMeasure) {

        ConversionDto dto = new ConversionDto();
        dto.setUnit(unit);
        dto.setUnitOfMeasure(unitOfMeasure);

        return dto;
    }
}
