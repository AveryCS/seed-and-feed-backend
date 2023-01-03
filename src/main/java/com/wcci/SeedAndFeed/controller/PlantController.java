package com.wcci.SeedAndFeed.controller;

import com.wcci.SeedAndFeed.entities.Plant;
import com.wcci.SeedAndFeed.repos.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

public class PlantController {
   private PlantRepository plantRepo;

    public PlantController(PlantRepository plantRepo) {
        this.plantRepo = plantRepo;
    }

//    @CrossOrigin(origins = "https://seed-and-feed-backend.herokuapp.com/")
    @GetMapping("/")
    public Iterable<Plant> getPlants() {
        return plantRepo.findAll();
    }

//    @CrossOrigin(origins = "https://seed-and-feed-backend.herokuapp.com/")
    @GetMapping("/plant/{id}")
    public Plant getSinglePlant(@PathVariable long id) {
        return plantRepo.findById(id).get();
    }

    @GetMapping("/plants")
    public Iterable<Plant> getPlantsFilteredID(@RequestParam String plantsIds) {
        String[] stringIds = plantsIds.split(",");
        ArrayList<Long> ids = new ArrayList<Long>();
        for(String id: stringIds){
            ids.add(Long.valueOf(id));
        }
        //System.out.println(ids);

        //ids.add(1L);
        return plantRepo.findAllById(ids);
    }
}
