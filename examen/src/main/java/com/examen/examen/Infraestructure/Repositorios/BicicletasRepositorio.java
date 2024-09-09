package com.examen.examen.Infraestructure.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.examen.Domain.Entities.Bicicletas;

public interface BicicletasRepositorio extends JpaRepository< Bicicletas, Long> {

}


/* package com.projecto.project.Chapter.Infrastructure;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projecto.project.Chapter.Domain.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {

        
    @Query(value = "SELECT * FROM chapter WHERE survey_id = ?1", nativeQuery = true)
    List<Chapter> buscarByChapterByIdSurvey(Long idSurvey);
    
    
  //  SELECT c FROM Chapter c WHERE  c.survey_id = 1;
} 
 */