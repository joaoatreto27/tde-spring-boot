package com.tde_java.TDE.controllers;

import com.tde_java.TDE.entities.Tarefa;
import com.tde_java.TDE.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> getAllTarefas() {
        return tarefaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> getTarefaById(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.findById(id);
        return ResponseEntity.ok().body(tarefa);
    }

    @PostMapping
    public Tarefa createTarefa(@RequestBody Tarefa tarefa) {
        return tarefaService.save(tarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> updateTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        tarefa.setId(id);
        Tarefa updatedTarefa = tarefaService.update(tarefa);
        return ResponseEntity.ok().body(updatedTarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarefa(@PathVariable Long id) {
        tarefaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/finalizar")
    public ResponseEntity<Tarefa> finalizarTarefa(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.finalizar(id);
        return ResponseEntity.ok().body(tarefa);
    }
}
