package com.jayda.daikichi_path_variables;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Daikichi")
public class Daikichi_Path_Variables {
	
	@GetMapping("")
	public String welcome() {
		return "Welcome!";
	}

	@GetMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}

	@GetMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
	@GetMapping("/travel/{distination}")
	public String travel(@PathVariable("distination") String distination) {
		return "Congratulations! You will soon travel to " + distination + "!";
	}
	
	@GetMapping("/lotto/{num}")
	public String num(@PathVariable("num") Integer num) {
		if(num % 2 ==0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
		}
	}
}
