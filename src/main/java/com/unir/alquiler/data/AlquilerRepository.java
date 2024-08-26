package com.unir.alquiler.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.unir.alquiler.model.pojo.Alquiler;

public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {
 List<Alquiler> findByEmail(String email);
}
