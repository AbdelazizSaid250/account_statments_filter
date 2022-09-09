package com.master.controller;

import com.master.common.service.account.AccountService;
import com.master.common.service.statement.StatementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("scl")
public class CIDController {

    private final AccountService accountService;
    private final StatementService statementService;

    @Autowired
    public CIDController(AccountService accountService, StatementService statementService) {
        this.accountService = accountService;
        this.statementService = statementService;
    }

}
