package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.service.CarService;
import web.service.CarServiceImpl;


@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController() {
        this.carService = new CarServiceImpl();
    }


    @GetMapping("/cars")
    public String showCars(Model model,
                           @RequestParam(value = "count", defaultValue = "5") int count) {
        model.addAttribute("cars", carService.showCarsByCount(count));
        return "cars";
    }
}
