package com.ayo.conversion.rest;

import com.ayo.conversion.dao.ConversionResponseMapper;
import com.ayo.conversion.dao.ConversionResponseResource;
import com.ayo.conversion.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConversionController {

    private final ConversionService conversionService;
    private final ConversionResponseMapper responseMapper;

    public static final String KILOMETER_URI = "kilometer";
    public static final String MILE_URI = "mile";
    public static final String FAHRENHEIT_URI = "fahrenheit";
    public static final String CELSIUS_URI = "celsius";
    public static final String KILOGRAM_URI = "kilogram";

    @Autowired
    public ConversionController(ConversionService conversionService) {
        this.conversionService = conversionService;
        this.responseMapper = new ConversionResponseMapper();
    }

    @GetMapping (value = KILOMETER_URI + "/{mile}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConversionResponseResource> convertMileToKilometer (@PathVariable double mile) {

        ConversionResponseResource responseResource = responseMapper.map(conversionService.convertMileToKilometer(mile));

        return new ResponseEntity<>(responseResource, HttpStatus.OK);
    }

    @GetMapping (value = MILE_URI + "/{kilometer}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConversionResponseResource> convertKilometerToMile (@PathVariable double kilometer) {

        ConversionResponseResource responseResource = responseMapper.map(conversionService.convertKilometerToMile(kilometer));

        return new ResponseEntity<>(responseResource, HttpStatus.OK);
    }

    @GetMapping (value = FAHRENHEIT_URI + "/{celsius}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConversionResponseResource> convertCelsiusToFahrenheit (@PathVariable double celsius) {

        ConversionResponseResource responseResource = responseMapper.map(conversionService.convertCelsiusToFahrenheit(celsius));

        return new ResponseEntity<>(responseResource, HttpStatus.OK);
    }

    @GetMapping (value = CELSIUS_URI + "/{fahrenheit}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConversionResponseResource> convertFahrenheitToCelsius (@PathVariable double fahrenheit) {

        ConversionResponseResource responseResource = responseMapper.map(conversionService.convertFahrenheitToCelsius(fahrenheit));

        return new ResponseEntity<>(responseResource, HttpStatus.OK);
    }

    @GetMapping (value = KILOGRAM_URI + "/{pound}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConversionResponseResource> convertPoundToKilogram (@PathVariable double pound) {

        ConversionResponseResource responseResource = responseMapper.map(conversionService.convertPoundToKilogram(pound));

        return new ResponseEntity<>(responseResource, HttpStatus.OK);
    }
}
