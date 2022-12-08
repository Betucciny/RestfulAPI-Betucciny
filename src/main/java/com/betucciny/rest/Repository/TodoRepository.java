package com.betucciny.rest.Repository;

import com.betucciny.rest.Model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Genero, Long> {

}
