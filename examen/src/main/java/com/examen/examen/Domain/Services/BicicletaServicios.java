package com.examen.examen.Domain.Services;

import java.util.List;
import java.util.Optional;

import com.examen.examen.Domain.Entities.Bicicletas;

public interface BicicletaServicios {

    Optional <Bicicletas> findById(Long id); 

    Bicicletas createOne (Bicicletas bicicleta);

    Optional<Bicicletas> update(Long id, Bicicletas bicicletas);

    Optional <Bicicletas> delete(Long id);


    // Page<Chapter> findAllForChapter(Pageable pageable);



}
