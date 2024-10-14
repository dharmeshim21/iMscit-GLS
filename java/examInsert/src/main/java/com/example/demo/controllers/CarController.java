package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.Car;
import com.example.demo.repositories.CarRepository;

@Controller
public class CarController {
    
    @Autowired
    CarRepository carRepository;

    @PostMapping("/register")
    public String addCar(@RequestParam String carName,
                                  @RequestParam String carNumber,
                                  @RequestParam int carPrice,
                                  @RequestParam String carOwner,
                                  @RequestParam String gender,
                                  @RequestParam String city,
                                  RedirectAttributes redirectAttributes) { // Use RedirectAttributes for flash attributes
        try {
            Car car = new Car();
            car.setCarName(carName);
            car.setCarNumber(carNumber);
            car.setCarOwner(carOwner);
            car.setCarPrice(carPrice);
            car.setGender(gender);
            car.setCity(city);
            carRepository.save(car);

            // Add success message to redirect attributes
            redirectAttributes.addFlashAttribute("message", "Car added successfully");
            return "redirect:/car/success"; // Redirect to success page
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/car/register"; // Redirect back to the registration form
        }
    }
    
    @GetMapping("/car/list")
    public String getAllCar(Model model) {
        Iterable<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        return "listcars"; // Ensure this matches the actual HTML file name
    }
    
    @GetMapping("/car/success")
    public String showSuccess(Model model) {
        return "success"; // This should point to your success HTML template
    }
}
