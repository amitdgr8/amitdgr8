package com.strategy.dove.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.strategy.dove.entity.Moves;
import com.strategy.dove.entity.Score;
import com.strategy.dove.entity.Score2;
import com.strategy.dove.service.DoveService;

@RestController
public class DoveController {
	public static int globalIteration;
	@Autowired
	public DoveService doveService;
	
	@GetMapping("/home")
	public String home() {
		return "HomePage";
	}
	
	@GetMapping("/doveApi/{number}")
	public String getIteration(@PathVariable("number") int iteration) {
		
		globalIteration = iteration;
		return doveService.getIteration(iteration);
		
	}
	
	@PostMapping("/doveApiMove")
	public Score2 getIterationMoves(@RequestBody Moves m) {
		
		
		return doveService.getIterationMoves(m);
		
	}
	@PostMapping("/eagleApiMove")
	public Score2 getIterationMovesEagle(@RequestBody Moves m) {
		return doveService.getIterationMovesEagle(m);
		
	}
	
	@PostMapping("/winApiMove")
	public Score2 getIterationMovesWin(@RequestBody Moves m) {
		return doveService.getIterationMovesWin(m);
		
	}
	
	@GetMapping("/getDataFromDB")
	public Score getDataFromDB() {
		return doveService.getDataFromDB();
		
	}
	
}
