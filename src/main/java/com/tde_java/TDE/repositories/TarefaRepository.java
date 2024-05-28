package com.tde_java.TDE.repositories;

import com.tde_java.TDE.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
