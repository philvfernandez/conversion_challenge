# conversion_challenge
    Author: Phil Fernandez
    Description: Conversion Challenge: Implements a utility class with a Fluent API which can perform conversions between various units of temperature measurements.
    Conversions Supported: Celsius to Fahrenheit, Kelvin to Celsius and Fahrenheit to Kelvin.
    Example: Usage:
                TemperatureConvert tc1 = new Conversion()
                .convert(100,"C")
                .to("F") //Convert from Celsius to Fahrenheit
                .execute();
    Output: All conversions are rounded to 2 decimal places.
    Programming language used: Java Version: 8
