package com.master.controller;

import com.master.common.dto.AmountDTO;
import com.master.common.dto.DateDTO;
import com.master.common.model.Statement;
import com.master.common.util.NumberUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("filter")
public class FilterController {

    private final NumberUtils numberUtils;

    @Autowired
    public FilterController(NumberUtils numberUtils) {
        this.numberUtils = numberUtils;
    }

    @GetMapping("userStatement")
    public List<Statement> filterUser() {
        return numberUtils.userFilter();
    }

    @GetMapping("adminStatement")
    public List<Statement> filterAdmin(
            @RequestParam Optional<DateDTO> dateDTO,
            @RequestParam Optional<AmountDTO> amountDTO
    ) {
        return numberUtils.adminFilter(dateDTO, amountDTO);
    }
}
