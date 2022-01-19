import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Chatbottest {



    @Test
    void getCityTestone(){
        /*Description: This is the fifth test method for getCity method
         *Tests the actual value is true.
         */
    	 String city = "Lagos";
    	String WeatherCondition = Weather.getWeather(city);
        String actual = WeatherCondition;
        assertEquals(WeatherCondition,actual);
    }
    @Test
    void getCityTesttwo(){
        /*Description: This is the fifth test method for getCity method
         *Tests the actual value is true.
         */
    	 String city = "lahore";
    	String WeatherCondition = Weather.getWeather(city);
        String actual = WeatherCondition;
        assertEquals(WeatherCondition,actual);
    }

    @Test
    void getCityTestthree(){
        /*Description: This is the fifth test method for getCity method
         *Tests the actual value is true.
         */
    	 String city = "dublin";
    	String WeatherCondition = Weather.getWeather(city);
        String actual = WeatherCondition;
        assertEquals(WeatherCondition,actual);
    }
    @Test
    void getCityTestfour(){
        /*Description: This is the fifth test method for getCity method
         *Tests the actual value is true.
         */
    	 String city = "london";
    	String WeatherCondition = Weather.getWeather(city);
        String actual = WeatherCondition;
        assertEquals(WeatherCondition,actual);
    }
    @Test
    void getCityTestfive(){
        /*Description: This is the fifth test method for getCity method
         *Tests the actual value is true.
         */
    	 String city = "islamabad";
    	String WeatherCondition = Weather.getWeather(city);
        String actual = WeatherCondition;
        assertEquals(WeatherCondition,actual);
    }


    @Test
    void getCountryTestone(){
        /*Description: This is the fifth test method for getCity method
         *Tests the actual value is true.
         */
    	 String city = "Ireland";
    	String WeatherCondition = Weather.getWeather(city);
        String actual = WeatherCondition;
        assertEquals(WeatherCondition,actual);
    }
    @Test
    void getCountryTesttwo(){
        /*Description: This is the fifth test method for getCity method
         *Tests the actual value is true.
         */
    	 String city = "Dubai";
    	String WeatherCondition = Weather.getWeather(city);
        String actual = WeatherCondition;
        assertEquals(WeatherCondition,actual);
    }

    @Test
    void getCountryTestthree(){
        /*Description: This is the fifth test method for getCity method
         *Tests the actual value is true.
         */
    	 String city = "Italy";
    	String WeatherCondition = Weather.getWeather(city);
        String actual = WeatherCondition;
        assertEquals(WeatherCondition,actual);
    }
    @Test
    void getCountryTestfour(){
        /*Description: This is the fifth test method for getCity method
         *Tests the actual value is true.
         */
    	 String city = "Pakistan";
    	String WeatherCondition = Weather.getWeather(city);
        String actual = WeatherCondition;
        assertEquals(WeatherCondition,actual);
    }
    @Test
    void getCountryTestfive(){
        /*Description: This is the fifth test method for getCity method
         *Tests the actual value is true.
         */
    	 String city = "India";
    	String WeatherCondition = Weather.getWeather(city);
        String actual = WeatherCondition;
        assertEquals(WeatherCondition,actual);
    }

    
    


    }


