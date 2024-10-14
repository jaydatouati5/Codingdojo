package com.touati.hellohuman;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHuman {
	
	@GetMapping("/")
	public String index2(
			@RequestParam(value="name" , required=false) String name , 
			@RequestParam(value="last_name" , required=false)  String lastName,
			@RequestParam(value="times" , required=false) Integer times
			) {
		String displayedName = name == null ? "Human" : name;
		displayedName = lastName == null ? displayedName : displayedName + " " + lastName;
		if(times != null) {
			String comp = "Hello " + displayedName;
			String ret = "";
			for(int i = 0; i < times; i++) {
				ret += comp + " ";
			}
			return ret;
		}
		return "Hello " + displayedName;
	}
	

}
