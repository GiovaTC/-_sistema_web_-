package com.ejemplo.tiendamotos.repository;

import com.ejemplo.tiendamotos.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotoRepository extends JpaRepository<Moto, Long> {

    List<Moto> findByMarcaContainingIgnoreCase(String marca);
}
