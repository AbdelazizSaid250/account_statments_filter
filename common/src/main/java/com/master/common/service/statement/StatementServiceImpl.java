package com.master.common.service.account;

import com.master.common.dao.AccountRepository;
import com.master.common.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void saveOrUpdate(Account account) {
        accountRepository.save(account);
        log.info("Saved account is: {}", account);
    }
}
