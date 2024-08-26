package com.unir.alquiler.model.pojo;



import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "det_alquiler_libros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Alquiler {
     @Id
	 //@GeneratedValue(strategy = GenerationType.AUTO)
	 private int cve_id;
	 @Column(name = "nom_nombre")
	 private String name;
	 @Column(name = "nom_apellidos")
	 private String lastname;
	 @Column(name = "des_email", unique = true)
	 private String email;
	 @Column (name = "nom_titulo")
	 private String titulo;
	 @Column(name = "bnd_status_devolucion")
	 private Boolean deliver;
	 @Column(name = "fec_devolucion")
	 private String deliver_date;
	
	 @Override
	public String toString() {
		return "alquiler [nombre=" + name + "]";
	}	
	 
	 
}
