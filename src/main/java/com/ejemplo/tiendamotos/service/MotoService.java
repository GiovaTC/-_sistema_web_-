package com.ejemplo.tiendamotos.service;

import com.ejemplo.tiendamotos.model.Moto;
import com.ejemplo.tiendamotos.repository.MotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoService {

    private final MotoRepository motoRepository;

    public MotoService(MotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }

    public List<Moto> listarTodas() {

        return motoRepository.findAll();
    }

    public Optional<Moto> buscarPorId(Long id)
    {

        return motoRepository.findById(id);
    }

    public List<Moto> buscarPorMarca(String marca)
    {
        return motoRepository.findByMarcaContainingIgnoreCase(marca);
    }

    public Moto guardar(Moto moto) {

        return motoRepository.save(moto);
    }   
}
