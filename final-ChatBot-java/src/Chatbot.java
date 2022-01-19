
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import java.awt.Color;

import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.lang.Math;

public class Chatbot extends JFrame implements KeyListener
{
	String userinput;
	String quote; // reads what the user entered
	String temp1; //used for user input
	String temp2; //used for user input
	String temp3; //used for user input
	String temp4; //used for user input
	String temp5; //used for user input
	String temp6; //used for user input
	int intFormString = 5; // user hoildays list size
	String getWeather; // gets weather based on entered location by user
	String [] placesVistingOnHoildays; // array for storing user location where there going on hoildays 
	ArrayList<String>  placesHoildays = new ArrayList<String>();
	
	JPanel p = new JPanel();
	JTextArea dialog = new JTextArea(20,60);
	JTextArea input = new JTextArea(2,60);
	JScrollPane scroll = new JScrollPane(dialog,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private KeyEvent e;

	
	public static void main(String [] args) 
	{
		new Chatbot();	
	}

	public Chatbot()
	{
		super("cortana");
		setSize(750,450);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		JButton btClear = new JButton("Clear");
		
        btClear.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent arg0) 
            {
                onClearButtonPressed();
            }

			private void onClearButtonPressed() 
			{
				
				
			}
        }
        );

        //JLabel lbInputText = new JLabel("Input Text:  (press ENTER-KEY to send)"); 
		
		dialog.setEditable(false);
		input.addKeyListener(this);
	
		p.add(scroll);
		p.add(input);
		
		add(p);
		
		setVisible(true);
	}
	

	public String getInput()
	{
		
		return userinput = input.getText();
	}
	
	
	public void keyPressed(KeyEvent e)
	{
		
		  if(e.getKeyCode()==KeyEvent.VK_ENTER)
		  {
			input.setEditable(false);
					//-----grab quote-----------			
			quote = getInput();
					
			input.setText("");

			addText("-->You:\t" + quote);
					
			quote.trim();
					
			while(
			quote.charAt(quote.length()-1)=='!' ||
			quote.charAt(quote.length()-1)=='.' ||
			quote.charAt(quote.length()-1)=='?'
			)
						
			{
				quote = quote.substring(0,quote.length()-1);
			}
					
			quote.trim();

			reponses();
		  }
		  
	}  
		  public void reponses() 
		  {

			ChatBotResponsesfile CB = new ChatBotResponsesfile(); //calling the ChatBot responsefile where bots responses are
			String [][] ChatBotResponses = CB.ChatBotResponses();
			
			
			/*
			 * gets weather based on location entered
			 */
			if(quote.contains("whats the weather")) //"whats the weather"
			{
				addText("\n-->cortana:\twhere would u like to know the weather for\n"); 
				temp1 = quote;
				
			}
			else if(temp1.contains("whats the weather")) //"whats the weather"
			{
				
				temp2 = quote;
				String getWeather = Chatbot.getweatherconidition(temp2);//gets the weather for entered location	
				addText("\n-->cortana:\t" + getWeather + "\n");
				
				temp1 = ""; //reset varible for use again
				temp2 = "";  //reset varible for use again
			}
			
			/*
			 * places user is going on hoildays - store list
			 */
			else if(quote.contains("im going on hoildays"))
			{
				placesHoildays.add("dublin");
				placesHoildays.add("galway");
				placesHoildays.add("kerry");
				placesHoildays.add("kildare");
				placesHoildays.add("belfast");
				
				addText("\n-->cortana:\tlocations stored\n");
				
			}
			
			/*
			 * packing suggestions for user going on trip
			 */
			else if(quote.contains("what should i pack for my hoildays"))
			{
				addText("\n-->cortana:\ti suggest the following");
				
				for(int i=0;i<5;i++) 
				{
			
					String suggestion = Chatbot.clothingsuggestions(placesHoildays.get(i));
					addText("\n-->cortana:\tfor " + placesHoildays.get(i) + suggestion + "\n");
				}
				
			}

			/*
			 * other reponses 
			 */
			else
			{

			byte response=0;
			/*
			0:we're searching through chatBot[][] for matches
			1:we didn't find anything
			2:we did find something
			*/
			//-----check for matches----
			int j=0;//which group we're checking
			
			while(response==0)
			{

				if(inArray(quote.toLowerCase(),ChatBotResponses[j*2]))
				{
					response=2;
					
					int r=(int)Math.floor(Math.random()*ChatBotResponses[(j*2)+1].length);
					
					addText("\n-->cortana:\t" + ChatBotResponses[(j*2)+1][r]);
				}
				j++;
				
				//if bot cant understand anything
				if(j*2==ChatBotResponses.length-1 && response==0)
				{
					response=1;
				}
	
			}

			if(quote.contains("goodbye"))      
			{
				System.exit(0);
			}


			if(response==1) // TODO note - changed to else if 
			{
				int r=(int)Math.floor(Math.random()*ChatBotResponses[ChatBotResponses.length-1].length);
						
				addText("\n-->cortana:\t" + ChatBotResponses[ChatBotResponses.length-1][r]);
			}
			
			addText("\n");
			}
		 } //end key press
	

	/*
	 * method for suggestion clothing based on locations weather that the user is going to vist // TODO finish filling in 
	 */
	public static String clothingsuggestions(String location)
	{
		String clothingsuggestion = null;
		
		String WeatherCondition = Weather.getWeather(location); // getting weather condition based on location
		
		if(WeatherCondition.contains("Clear"))
		{
			clothingsuggestion = " Weather condition is clear - i suggest u pack : jeans or maybe shorts,long or short slevee t-shirt,socks,jocks,shoes";
		}
		else if(WeatherCondition.contains("Cloud"))
		{
			clothingsuggestion = " Weather condition is cloudy - i suggest u pack : jeans,hoodie,socks,jocks,shoes";
		}
		else if(WeatherCondition.contains("Rain"))
		{
			clothingsuggestion = " Weather condition is rain - i suggest u pack : jeans,warm jumper,socks,jocks,shoes,umbrella,rain jacket";
		}
		else
		{
			clothingsuggestion = " i have no suggestion"; // if all fails 
		}
		
		return clothingsuggestion; 
	}
	
	/*
	 * method for getting the weather conidition based on entered location
	 */
	public static String getweatherconidition(String location)
	{
		String weatherconidition = Weather.getWeather(location);
		return "the weather for " + location + " is " + weatherconidition;
	}


	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			input.setEditable(true);
		}
	}
	
	public void keyTyped(KeyEvent e)
	{
		
	}
	
	public void addText(String str)
	{
		dialog.setText(dialog.getText()+str);
	}
	
	public boolean inArray(String in,String[] str)
	{
		boolean match=false;
		
		for(int i=0;i<str.length;i++)
		{
			if(str[i].equals(in))
			{
				match=true;
			}
		}
		return match;
	}	
}

