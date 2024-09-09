package com.examen.examen.Application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.examen.Domain.Entities.Bicicletas;
import com.examen.examen.Domain.Services.BicicletaServicios;
import com.examen.examen.Infraestructure.Repositorios.BicicletasRepositorio;


@Service
public class BicicletasImpl implements BicicletaServicios {

    @Autowired
    BicicletasRepositorio repositorio;

    @Override
    public Optional<Bicicletas> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public Bicicletas createOne(Bicicletas bicicleta) {
        return repositorio.save(bicicleta);
    }

    @Override
    public Optional<Bicicletas> update(Long id, Bicicletas bicicletas) {

        Optional<Bicicletas> bicicletaOpcional = repositorio.findById(id);

        if (bicicletaOpcional.isPresent()) {
            
            Bicicletas bicicletasDb = bicicletaOpcional.orElseThrow();
            
            
            bicicletasDb.setModelo(bicicletas.getModelo());
            bicicletasDb.setMarca(bicicletas.getMarca());
            bicicletasDb.setStock(bicicletas.getStock());
            bicicletasDb.setPrecio(bicicletas.getPrecio());

            return Optional.of(repositorio.save(bicicletasDb));
            
        }
        return bicicletaOpcional;
    }

    @Override
    public Optional<Bicicletas> delete(Long id) {

        Optional<Bicicletas> bicicletasOpcional = repositorio.findById(id);

        bicicletasOpcional.ifPresent(bicicletasdb -> {

            repositorio.delete(bicicletasdb);

        });
        return bicicletasOpcional;
    } 




}
