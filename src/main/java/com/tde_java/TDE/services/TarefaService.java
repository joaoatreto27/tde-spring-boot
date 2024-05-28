package com.tde_java.TDE.services;

import com.tde_java.TDE.entities.Tarefa;
import com.tde_java.TDE.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> findAll() {
        return tarefaRepository.findAll();
    }

    public Tarefa findById(Long id) {
        Optional<Tarefa> obj = tarefaRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    public Tarefa save(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Tarefa update(Tarefa tarefa) {
        Tarefa entity = findById(tarefa.getId());
        updateData(entity, tarefa);
        return tarefaRepository.save(entity);
    }

    private void updateData(Tarefa entity, Tarefa tarefa) {
        entity.setDescricao(tarefa.getDescricao());
        entity.setDataLimite(tarefa.getDataLimite());
        entity.setFinalizada(tarefa.isFinalizada());
    }

    public void delete(Long id) {
        findById(id);
        tarefaRepository.deleteById(id);
    }

    public Tarefa finalizar(Long id) {
        Tarefa tarefa = findById(id);
        tarefa.setFinalizada(true);
        return tarefaRepository.save(tarefa);
    }
}
