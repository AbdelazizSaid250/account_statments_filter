package com.master.common.dao;

import com.master.common.model.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "statement")
public interface StatementRepository extends JpaRepository<Statement, Integer> {
}
