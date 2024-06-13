package com.vitu.projectcaju.service;

import com.vitu.projectcaju.domain.Transaction;
import com.vitu.projectcaju.strategy.AccountStrategy;
import com.vitu.projectcaju.strategy.impl.SlStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionService {

    private final Map<String, AccountStrategy> accountStrategyMap;

    public void effect(Transaction transaction) {
        log.info("Service - {}", transaction);
        AccountStrategy accountStrategy = this.getAccountStrategy(transaction.getMcc());
        accountStrategy.apply();
    }

    private AccountStrategy getAccountStrategy(int mcc) {
        return accountStrategyMap.entrySet()
                .stream()
                .filter(entry -> entry.getKey().contains(String.valueOf(mcc)))
                .map(Map.Entry::getValue)
                .findFirst().orElse(new SlStrategy());
    }
}
