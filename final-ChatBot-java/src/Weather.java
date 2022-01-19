
	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.net.*;
	import java.nio.charset.Charset;
	import java.util.Arrays;

	public class Weather 
	{
		
		public static String getWeather(String location) 
		{
			String api = "176022fc0e3786c9a9706f3c0b09dd18";
			String myURL = "http://api.openweathermap.org/data/2.5/weather?q="+ location +"&appid="+api;
			StringBuilder sb = new StringBuilder();
			URLConnection urlConn = null;
			InputStreamReader in = null;
			try 
			{
				URL url = new URL(myURL);
				urlConn = url.openConnection();
				if (urlConn != null)
				{
					urlConn.setReadTimeout(60 * 1000);
				}
				if (urlConn != null && urlConn.getInputStream() != null) 
				{
					in = new InputStreamReader(urlConn.getInputStream(),
							Charset.defaultCharset());
					BufferedReader bufferedReader = new BufferedReader(in);
					if (bufferedReader != null) 
					{
						int cp;
						while ((cp = bufferedReader.read()) != -1) 
						{
							sb.append((char) cp);
						}
						String [] list= sb.toString().split(":");
						bufferedReader.close();
						return list[6].split(",")[0];
					}
				}
				
			in.close();
			
			} 
			catch (Exception e) 
			{
				throw new RuntimeException("Exception while calling URL:"+ myURL, e);
			}
			return "Address Not Found."; 
		}
	}
