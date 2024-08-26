package com.unir.alquiler.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.unir.alquiler.model.pojo.Alquiler;
import com.unir.alquiler.service.AlquilerService;
import com.unir.alquiler.model.request.CreateAlquilerRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequiredArgsConstructor
@Slf4j
public class AlquilerController {
	
	private final AlquilerService service;
	
		 @GetMapping("/alquileres")
		 public ResponseEntity<List<Alquiler>> getAlquileres(@RequestHeader Map<String, String> headers) {
			 log.info("headers: {}", headers);
			 List<Alquiler> alquileres = service.getAlquileres();
			 if (alquileres != null) {
			 return ResponseEntity.ok(alquileres);
			 } else {
			 return ResponseEntity.ok(Collections.emptyList());
			 }
		 }
	
		 @GetMapping("/alquileres/{alquilerId}")
		 public ResponseEntity<Alquiler> getAlquileres(@PathVariable String alquilerId) {
			 log.info("Request received for alquiler{}", alquilerId);
			 Alquiler alquiler = service.getAlquiler(alquilerId);
			 if (alquiler != null) {
				 return ResponseEntity.ok(alquiler);
				 } else {
				 return ResponseEntity.notFound().build();
				 }
		}
		 
		 @DeleteMapping("/alquileres/{alquilerId}")
		 public ResponseEntity<Void> deleteAlquileres(@PathVariable String alquilerId) {
			 Boolean removed = service.removeAlquiler(alquilerId);
			 if (Boolean.TRUE.equals(removed)) {
			 return ResponseEntity.ok().build();
			 } else {
			 return ResponseEntity.notFound().build();
			 }
		 }
		 
		 @PostMapping("/alquileres")
		 
		 public ResponseEntity<Alquiler> getAlquiler(@RequestBody CreateAlquilerRequest request) {
				  Alquiler createdAlquiler = service.createAlquiler(request);
				  if (createdAlquiler !=null) {
				  return 
				 ResponseEntity.status(HttpStatus.CREATED).body(createdAlquiler);
				  } else {
				  return ResponseEntity.badRequest ().build();
				  }
		}
}