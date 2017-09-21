import java.math.BigDecimal;

/*
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
 */
public class TemperatureConvert {

    public double temp;
    public String toScale;
    // public String fromScale;
    private TemperatureConvert() {}

    public String toString () {
        return "To temperature is " + this.temp;
    }

    public static class Conversion extends TemperatureConvert{

        private Conversion() {}

        public Conversion convert(int temp, String unit) {
            System.out.println("Converting temperature: " + temp + unit);
            this.temp = temp;
            this.toScale = unit;
            return this;
        }

        public Conversion to(String unit) {
            this.toScale = unit;
            return this;
        }

        public Conversion execute() {
            double temp = 0;

            //Celsius to Fahrenheit
            if(this.toScale == "F") {
                // Celsius to Fahrenheit
                temp = (this.temp * 9.0/5.0) + 32;
                //round to 2 decimal places
                BigDecimal rounded_temp = new BigDecimal(temp).setScale(2, BigDecimal.ROUND_HALF_EVEN);
                temp = rounded_temp.doubleValue();

            }
            // Kelvin to Celsius
            else if(this.toScale == "C") {
                temp = this.temp - 273.0;

                //round to 2 decimal places
                BigDecimal rounded_temp = new BigDecimal(temp).setScale(2, BigDecimal.ROUND_HALF_EVEN);
                temp = rounded_temp.doubleValue();
            }
            //Fahrenheit to Kelvin
            else if(this.toScale == "K") {
                temp = ((5.0/9.0) * (this.temp - 32) + 273.15);
                //round to 2 decimal places
                BigDecimal rounded_temp = new BigDecimal(temp).setScale(2, BigDecimal.ROUND_HALF_EVEN);
                temp = rounded_temp.doubleValue();
            }
            else {
                throw new IllegalArgumentException("Invalid Conversion Error.  Only the following conversions are supported: Celsius to Fahrenheit, Kelvin to Celsius and Fahrenheit to Kelvin." +
                        "Use Arguements 'F' to Convert to Fahrenheit; 'C' to convert to Celsius; or 'K' to convert to Kelvin.");
            }
            this.temp = temp;
            return this;

        }
    }

    public static void main(String[] args) {
        TemperatureConvert tc1 = new Conversion()
                .convert(100,"C")
                .to("F") //Convert from Celsius to Fahrenheit
                .execute();
        System.out.println(tc1 + tc1.toScale);

        TemperatureConvert tc2 = new Conversion()
                .convert(100,"K")
                .to("C") // Convert from Kelvin to Celsius
                .execute();
        System.out.println(tc2 + tc2.toScale);

        TemperatureConvert tc3 = new Conversion()
                .convert(100,"F") //Convert from Fahrenheit to Kelvin
                .to("K")
                .execute();
        System.out.println(tc3 + tc3.toScale);
    }
}
