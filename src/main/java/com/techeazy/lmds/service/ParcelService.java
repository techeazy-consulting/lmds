package com.techeazy.lmds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techeazy.lmds.model.Parcel;
import com.techeazy.lmds.repo.ParcelRepository;

@Service
public class ParcelService {

	@Autowired
	private ParcelRepository parcelRepository;

	public List<Parcel> getAllParcels() {
		return parcelRepository.findAll();
	}

	public Optional<Parcel> getParcelById(Long id) {
		return parcelRepository.findById(id);
	}

	public Parcel getParcelByTrackingId(String trackingId) {
		return parcelRepository.findByTrackingId(trackingId);
	}

	public Parcel createParcel(Parcel parcel) {
		return parcelRepository.save(parcel);
	}

	public void deleteParcel(Long id) {
		parcelRepository.deleteById(id);
	}
}