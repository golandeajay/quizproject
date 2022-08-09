package com.time.limit;

import java.text.SimpleDateFormat;  
import java.util.Date;  
public class ShowTime {
	  
	public void time() {  
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    System.out.println(formatter.format(date));  
}
}

