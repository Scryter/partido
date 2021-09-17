package com.compasso.partido.repository;

import com.compasso.partido.entities.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoRepository  extends JpaRepository<Partido, Long> {
}
