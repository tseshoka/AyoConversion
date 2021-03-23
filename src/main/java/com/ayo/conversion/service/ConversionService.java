package com.ayo.conversion.service;

import com.ayo.conversion.dao.ConversionDto;

public interface ConversionService {

    ConversionDto convertMileToKilometer(double mile);

    ConversionDto convertKilometerToMile (double kilometer);

    ConversionDto convertCelsiusToFahrenheit(double celsius);

    ConversionDto convertFahrenheitToCelsius(double fahrenheit);

    ConversionDto convertPoundToKilogram (double pound);

}
