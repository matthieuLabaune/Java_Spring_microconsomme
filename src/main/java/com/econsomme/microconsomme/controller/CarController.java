package com.econsomme.microconsomme.controller;

import com.econsomme.microconsomme.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@RestController
public class CarController {

    @Autowired
    RestTemplate restTemplate;

    //GET ALL CARS
    @RequestMapping(value = "/cars")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(
                "http://localhost:8080/cars", HttpMethod.GET, entity, String.class).getBody();
    }

    //POST A NEW CAR
    @RequestMapping(value = "/cars/", method = RequestMethod.POST)
    public String createCars(@RequestBody Car car) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Car> entity = new HttpEntity<Car>(car,headers);

        return restTemplate.exchange(
                "http://localhost:8080/cars/", HttpMethod.POST, entity, String.class).getBody();
    }

    // UPDATE A CAR
    @RequestMapping(value = "/cars/{id}", method = RequestMethod.PUT)
    public String updateCars(@PathVariable("id") String id, @RequestBody Car car) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Car> entity = new HttpEntity<Car>(car,headers);

        return restTemplate.exchange(
                "http://localhost:8080/cars/"+id, HttpMethod.PUT, entity, String.class).getBody();
    }

    //DELETE A CAR
    @RequestMapping(value = "/cars/{id}", method = RequestMethod.DELETE)
    public String deleteCar(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Car> entity = new HttpEntity<Car>(headers);

        return restTemplate.exchange(
                "http://localhost:8080/cars/"+id, HttpMethod.DELETE, entity, String.class).getBody();
    }
}
