package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Car;

public interface CarRepository extends CrudRepository<Car,Integer>{

}
