package com.master.common.service.statement;

import com.master.common.dao.StatementRepository;
import com.master.common.model.Statement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StatementServiceImpl implements StatementService {

    private final StatementRepository statementRepository;

    @Autowired
    public StatementServiceImpl(StatementRepository statementRepository) {
        this.statementRepository = statementRepository;
    }


    @Override
    public List<Statement> findAll() {
        return statementRepository.findAll();
    }
}
