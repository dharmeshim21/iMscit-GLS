package com.example.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Bike;
import com.example.demo.repositories.BikeRepository;





@Controller
public class BikeController {
	
	@Autowired
	BikeRepository bikes;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/storedata")
	public String storedata(Bike bike) {
		
		bikes.save(bike);
		return "redirect:/bike/display";
	}
	
	@GetMapping("/bike/display")
	public String getMethodName(Model model) {
		List<Bike> bikelist = (List<Bike>)bikes.findAll();
		model.addAttribute("bikes", bikelist);
		return "display";
	}
	
	@GetMapping("/bikes/delete/{id}")
	public String delete(@PathVariable Integer id){
		bikes.deleteById(id);
		return "redirect:/bike/display";

	}
	
	@GetMapping("/bikes/update/{id}")
	public String update(@PathVariable Integer id,Model model){
		Bike bike = bikes.findById(id).get();
		model.addAttribute("bike",bike);
		return "update";

	}
	
	@PostMapping("/updatedata")
	public String updatedata(Bike bike) {
		Integer id = bike.getId();
		String bikeName = bike.getBikeName();
		Integer bikeNumber = bike.getBikeNumber();
		String owner = bike.getOwner();
		Long phone = bike.getPhone();
		String bikeColor = bike.getBikeColor();
		Long bikePrice = bike.getBikePrice();
		Date bod = bike.getBod();
		
		Bike bikedb = bikes.findById(id).get();
		
		bikedb.setBikeName(bikeName);
		bikedb.setBikeNumber(bikeNumber);
		bikedb.setOwner(owner);
		bikedb.setPhone(phone);
		bikedb.setBikePrice(bikePrice);
		bikedb.setBikeColor(bikeColor);
		bikedb.setBod(bod);
		
		bikes.save(bikedb);
		return "redirect:/bike/display";

	}
	
}
