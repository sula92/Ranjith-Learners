package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.model.Vehicle;
import com.sula.ranjith_learners.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }

    @GetMapping("/vehicles/{id}")
    public Vehicle getVehicle(@PathVariable long id){
        return vehicleRepository.findById(id).get();
    }

    @PostMapping("/vehicles")
    public Vehicle createVehile(@RequestBody Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    @PutMapping("/vehicles/{id}")
    public Vehicle editVehicle(@PathVariable Long id, @RequestBody  Vehicle vehicle){
        if(!(vehicleRepository.findById(id).get()==null)){
            return vehicleRepository.save(vehicle);
        }
        else {
            return null;
        }
    }

    @DeleteMapping("/vehicles/{id}")
    public void deleteVehicle(@PathVariable long id){
        vehicleRepository.delete(vehicleRepository.getOne(id));
    }



}
