package com.techeazy.lmds.controller;

import com.techeazy.lmds.entity.Parcel;
import com.techeazy.lmds.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parcels")
public class ParcelController {
    @Autowired
    private ParcelService parcelService;

    @GetMapping
    public List<Parcel> getAllParcels(){
        return parcelService.getAllParcels();
    }
    @GetMapping("/{id}")
    public Parcel getParcelById(@PathVariable Long id){
        return parcelService.getParcelById(id);
    }
    @PostMapping
    public Parcel createParcel(@RequestBody Parcel parcel){
        return parcelService.saveParcel(parcel);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParcel(@PathVariable Long id){
        parcelService.deleteParcel(id);
        return  ResponseEntity.ok().build();
    }
}
