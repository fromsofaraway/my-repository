package web.service;


import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("Lada", 2109, 2002));
        cars.add(new Car("Toyota", 3333, 1996));
        cars.add(new Car("BMW", 5, 2005));
        cars.add(new Car("Skoda", 888, 2022));
        cars.add(new Car("BELAZ", 1, 1666));
    }

    @Override
    public List<Car> showCarsByCount(int count) {
        return cars.stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
