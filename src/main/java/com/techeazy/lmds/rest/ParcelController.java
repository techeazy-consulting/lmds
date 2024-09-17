package com.techeazy.lmds.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techeazy.lmds.model.Parcel;
import com.techeazy.lmds.service.ParcelService;

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

	@GetMapping("/track/{trackingid}")
	public Parcel getParcelByTrackingId(@PathVariable String trackingid) {
		return parcelService.getParcelByTrackingId(trackingid);

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
}
