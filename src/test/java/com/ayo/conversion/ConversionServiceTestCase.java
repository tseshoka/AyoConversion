package com.ayo.conversion;

import com.ayo.conversion.dao.ConversionDto;
import com.ayo.conversion.service.ConversionService;

import com.ayo.conversion.util.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ConversionServiceTestCase {

    @Mock
    private ConversionService conversionService;

    @Before
    public void setup () {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void canConvertMileToKilometerSuccessfully() {

        when(conversionService.convertKilometerToMile(anyDouble()))
                .thenReturn(getConversionDto(UnitOfMeasure.KILOMETER));

        ConversionDto dto = conversionService.convertKilometerToMile(4);

        assertNotNull(dto);
        assertEquals(UnitOfMeasure.KILOMETER.getDescription(), dto.getUnitOfMeasure());
    }

    @Test
    public void canConvertKilometerToMileSuccessfully() {

        when(conversionService.convertKilometerToMile(anyDouble()))
                .thenReturn(getConversionDto(UnitOfMeasure.MILE));

        ConversionDto dto = conversionService.convertKilometerToMile(500);

        assertNotNull(dto);
        assertEquals(UnitOfMeasure.MILE.getDescription(), dto.getUnitOfMeasure());
    }

    @Test
    public void canConvertCelsiusToFahrenheitSuccessfully() {

        when(conversionService.convertCelsiusToFahrenheit(anyDouble()))
                .thenReturn(getConversionDto(UnitOfMeasure.FAHRENHEIT));

        ConversionDto dto = conversionService.convertCelsiusToFahrenheit(20);

        assertNotNull(dto);
        assertEquals(UnitOfMeasure.FAHRENHEIT.getDescription(), dto.getUnitOfMeasure());
    }

    @Test
    public void canConvertFahrenheitToCelsiusSuccessfully() {

        when(conversionService.convertFahrenheitToCelsius(anyDouble()))
                .thenReturn(getConversionDto(UnitOfMeasure.CELSIUS));

        ConversionDto dto = conversionService.convertFahrenheitToCelsius(4);

        assertNotNull(dto);
        assertEquals(UnitOfMeasure.CELSIUS.getDescription(), dto.getUnitOfMeasure());
    }

    @Test
    public void canConvertPoundToKilogramSuccessfully() {

        when(conversionService.convertPoundToKilogram(anyDouble()))
                .thenReturn(getConversionDto(UnitOfMeasure.KILOGRAM));

        ConversionDto dto = conversionService.convertPoundToKilogram(80);

        assertNotNull(dto);
        assertEquals(UnitOfMeasure.KILOGRAM.getDescription(), dto.getUnitOfMeasure());
    }



    @Test
    public void failConvertMileToKilometerTest() {

        when(conversionService.convertKilometerToMile(anyDouble()))
                .thenReturn(getConversionDto(UnitOfMeasure.KILOMETER));

        ConversionDto dto = conversionService.convertKilometerToMile(4);

        assertNotNull(dto);
        assertEquals(UnitOfMeasure.KILOMETER.getDescription(), dto.getUnitOfMeasure());
    }

    private ConversionDto getConversionDto(UnitOfMeasure unitOfMeasure) {

        ConversionDto dto = new ConversionDto();
        dto.setUnit(500);
        dto.setUnitOfMeasure(unitOfMeasure.getDescription());

        return dto;
    }
}
