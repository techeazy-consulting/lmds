package com.techeazy.lmds.service;

import com.techeazy.lmds.repository.ParcelRepository;
import com.techeazy.lmds.entity.Parcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelService {
    @Autowired
    private ParcelRepository parcelRepository;

    public List<Parcel> getAllParcels(){
        return parcelRepository.findAll();
    }
    public Parcel getParcelById(Long id){
        return parcelRepository.findById(id).orElse(null);
    }
    public Parcel saveParcel(Parcel parcel){
        return parcelRepository.save(parcel);
    }
    public void deleteParcel(long id){
        parcelRepository.deleteById(id);
    }
}
