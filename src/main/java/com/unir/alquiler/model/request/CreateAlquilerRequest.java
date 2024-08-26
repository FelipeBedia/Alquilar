package com.unir.alquiler.model.request;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAlquilerRequest {
	private String name;
	private String lastname;
	private String email;
	private String titulo;
	private Boolean deliver;
	private String deliver_date;
	
}

