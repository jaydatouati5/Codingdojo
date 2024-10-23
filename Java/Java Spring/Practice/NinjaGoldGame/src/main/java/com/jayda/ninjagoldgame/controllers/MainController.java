package com.jayda.ninjagoldgame.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@GetMapping("/")
	public String index(HttpSession session) {
		
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		
		if(session.getAttribute("logs") == null) {
			session.setAttribute("logs", new ArrayList<String[]>());
		}
		
		return "index.jsp";
	}
	
	@PostMapping("/play")
	public String play(
			@RequestParam(value="minAmount") Integer minAmount,
			@RequestParam(value="maxAmount") Integer maxAmount,
			@RequestParam(value="name") String name,
			HttpSession session
			) {
		
		Random r = new Random();
		Integer currentGold = (Integer)session.getAttribute("gold");
		Integer amount = r.nextInt(maxAmount - minAmount) + minAmount;
		boolean isPositive = true;
		if (name.equals("quest")) {
			isPositive = r.nextBoolean();
			amount = isPositive ? amount : -amount;
		}
		session.setAttribute("gold", currentGold + amount);
		
		Date date = new Date();
		String[] item = new String[2];
		item[0] = isPositive ? "Green" : "Red";
		item[1] = String.format("You entered a %s and %s %d gold. (%s)", name , isPositive ? "earned" : "lost" , amount, date);
		ArrayList<String[]> currentLogs = (ArrayList) session.getAttribute("logs");
		currentLogs.add(item);
		session.setAttribute("logs", currentLogs);
		return "redirect:/";
	}
}
