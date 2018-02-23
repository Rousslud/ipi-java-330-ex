package com.ipiecoles.java.java330.repository;

import com.ipiecoles.java.java330.model.Manager;
import org.springframework.data.jpa.repository.EntityGraph;

public interface ManagerRepository extends BaseEmployeRepository<Manager> {
    @EntityGraph(attributePaths = "equipe")
    Manager findOneWithEquipeById(Long id);
}
