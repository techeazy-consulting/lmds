package com.techeazy.lmds.rest;

import com.techeazy.lmds.model.Parcel;
import com.techeazy.lmds.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parcels")
public class ParcelController {

    @Autowired
    private ParcelService parcelService;

    @GetMapping
    public List<Parcel> getAllParcels() {
        return parcelService.getAllParcels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parcel> getParcelById(@PathVariable Long id) {
        Optional<Parcel> parcel = parcelService.getParcelById(id);
        return parcel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Parcel createParcel(@RequestBody Parcel parcel) {
        return parcelService.createParcel(parcel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParcel(@PathVariable Long id) {
        parcelService.deleteParcel(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/track")
    public ResponseEntity<Parcel> getParcelByTrackingId(@RequestParam String trackingId) {
        Optional<Parcel> parcel = parcelService.getParcelByTrackingId(trackingId);
        return parcel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/client-status")
    public ResponseEntity<List<Parcel>> getParcelsByClientAndStatus(
            @RequestParam Long clientId, @RequestParam String status) {
        List<Parcel> parcels = parcelService.getParcelsByClientIdAndStatusOfParcel(clientId, status);
        if (parcels.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(parcels);
    }
}
