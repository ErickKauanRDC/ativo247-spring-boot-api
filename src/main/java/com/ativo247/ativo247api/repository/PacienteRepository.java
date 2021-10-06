package com.ativo247.ativo247api.repository;

import com.ativo247.ativo247api.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {

}
