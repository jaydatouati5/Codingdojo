package com.jayda.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DateTimeController {
	@GetMapping("/")
	public String dashboard() {
		return "index.jsp";
	}

	@GetMapping("/date")
	public String date(Model model) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMM dd, yyyy", Locale.ENGLISH);
		model.addAttribute("title", "Date");
		model.addAttribute("content" , dateFormat.format(new Date()));
		return "display.jsp";
	}
	
	@GetMapping("/time")
	public String time(Model model) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);
		model.addAttribute("title", "Time");
		model.addAttribute("content" , timeFormat.format(new Date()));
		return "display.jsp";
	}
}
