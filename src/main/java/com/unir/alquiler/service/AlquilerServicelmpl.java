package com.unir.alquiler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.unir.alquiler.model.pojo.Alquiler;


import com.unir.alquiler.data.AlquilerRepository;
import com.unir.alquiler.model.request.CreateAlquilerRequest;

@Service
public class AlquilerServicelmpl implements AlquilerService {
	 @Autowired
	 private AlquilerRepository repository;
	 
	 @Override
	 public List<Alquiler> getAlquileres() {
		 List<Alquiler> alquileres = repository.findAll();
		 return alquileres.isEmpty() ? null : alquileres;
	 }
	 
	 @Override
	 public Alquiler getAlquiler(String alquilerId) {
		 return repository.findById(Long.valueOf(alquilerId)).orElse(null);
	 }
	 
	 @Override
	 public Boolean removeAlquiler(String alquilerId) {
		 Alquiler alquiler = repository.findById(Long.valueOf(alquilerId)).orElse(null);
		 if (alquiler != null) {
			 repository.delete(alquiler);
			 return Boolean.TRUE;
		 } else {
			 return Boolean.FALSE;
		 }
	}
		 
	 @Override
	 public Alquiler createAlquiler(CreateAlquilerRequest request) {
	 if (request != null && StringUtils.hasLength(request.getName().trim()) 
			 && StringUtils.hasLength(request.getLastname().trim())
			 && StringUtils.hasLength(request.getEmail().trim()) 
			 && StringUtils.hasLength(request.getTitulo().trim()) 
			 && StringUtils.hasLength(request.getDeliver_date().trim())
			 && request.getDeliver () != null) {
		 Alquiler alquiler = 
			 Alquiler.builder().name(request.getName()).lastname(request.getLastname()).
			 email(request.getEmail()).deliver_date(request.getDeliver_date()).titulo(request.getTitulo()).
			 deliver(request.getDeliver()).build();
			  return repository.save(alquiler);
			  } else {
			  return null;
			  }
		}
}