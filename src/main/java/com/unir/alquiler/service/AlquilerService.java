package com.unir.alquiler.service;
import com.unir.alquiler.model.pojo.Alquiler;
import com.unir.alquiler.model.request.CreateAlquilerRequest;

import java.util.List;

public interface AlquilerService{
 List<Alquiler> getAlquileres();
 Alquiler getAlquiler(String alquilerId);
 Boolean removeAlquiler(String alquilerId);
 Alquiler createAlquiler(CreateAlquilerRequest request);
}
