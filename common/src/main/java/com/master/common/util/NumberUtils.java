package com.master.common.util;

import com.master.common.dto.AmountDTO;
import com.master.common.dto.DateDTO;
import com.master.common.model.Statement;
import com.master.common.service.statement.StatementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.master.common.util.Const.THREE_MONTHS;
import static com.master.common.util.Const.YMD_FORMAT;

@Slf4j
@Component
public class NumberUtils {

    private final StatementService statementService;

    @Autowired
    public NumberUtils(StatementService statementService) {
        this.statementService = statementService;
    }

    public List<Statement> userFilter()
            throws RuntimeException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YMD_FORMAT);
        List<Statement> finalStatement = new ArrayList<>();
        List<Statement> statements = statementService.findAll();
        log.info("statements: {}", statements);

        for (Statement statement : statements) {
            int monthValue = LocalDate.parse(statement.getDateField(), formatter).getMonthValue();
            int monthDiff = LocalDate.now().getMonthValue() - monthValue;

            if (monthDiff < THREE_MONTHS) {
                finalStatement.add(statement);
            }
        }

        return finalStatement;
    }

    public List<Statement> adminFilter(Optional<DateDTO> dateDTO, Optional<AmountDTO> amountDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YMD_FORMAT);
        List<Statement> statements = statementService.findAll();
        List<Statement> finalStatement = new ArrayList<>();

        if (dateDTO.isPresent() && amountDTO.isPresent()) {
            LocalDate dateFrom = LocalDate.parse(dateDTO.get().getDateFrom());
            LocalDate dateTo = LocalDate.parse(dateDTO.get().getDateTo());

            int amountFrom = amountDTO.get().getAmountFrom();
            int amountTo = amountDTO.get().getAmountTo();

            for (Statement statement : statements) {
                checkFromToAndAddStatement(formatter, finalStatement, dateFrom, dateTo, amountFrom, amountTo, statement);
            }
        } else {
            for (Statement statement : statements) {
                int monthValue = LocalDate.parse(statement.getDateField(), formatter).getMonthValue();
                int monthDiff = LocalDate.now().getMonthValue() - monthValue;

                if (monthDiff < THREE_MONTHS) {
                    finalStatement.add(statement);
                }
            }
        }

        return finalStatement;
    }

    private void checkFromToAndAddStatement(DateTimeFormatter formatter, List<Statement> finalStatement, LocalDate dateFrom, LocalDate dateTo, int amountFrom, int amountTo, Statement statement) {
        LocalDate currentStatementLocalDate =
                LocalDate.parse(statement.getDateField(), formatter);

        if (currentStatementLocalDate.isAfter(dateFrom) &&
                currentStatementLocalDate.isBefore(dateTo)) {

            if (Integer.parseInt(statement.getAmount()) < amountFrom ||
                    Integer.parseInt(statement.getAmount()) > amountTo) {
                return;
            }
            finalStatement.add(statement);
        }
    }
}
