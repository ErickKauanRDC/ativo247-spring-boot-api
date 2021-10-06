package com.ativo247.ativo247api.controllers;

import com.ativo247.ativo247api.models.Paciente;
import com.ativo247.ativo247api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ativo247.ativo247api.controllers.UsuarioController;
import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
public class PacienteController {
    @Autowired
    PacienteRepository repository;
    @GetMapping(path="/pacientes/listar-pacientes")
    public List<Paciente> listar(){
        return repository.findAll();
    }


    @PostMapping(path = "pacientes/cadastrar-paciente")
    public Paciente cadastrar(@RequestBody Paciente paciente){

        return repository.save(paciente);
    }


    @PostMapping(path = "pacientes/deletar-paciente")
    public String deletar(@RequestParam Long codigo){
        if(repository.findById(codigo).isPresent()) {
            repository.deleteById(codigo);
            return "Paciente: " + codigo + " deletado";
        }
        else{
            return "Paciente não encontrado";
        }
    }

    @GetMapping(path="pacientes/buscar-paciente")
    public Optional<Paciente> paciente(@RequestParam Long codigo){
        if(repository.findById(codigo).isPresent()){
            return repository.findById(codigo);
        }
        return null;
    }

}
