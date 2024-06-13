package com.vitu.projectcaju.strategy.impl;

import com.vitu.projectcaju.strategy.AccountStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("5411,5412")
public class VaStrategy implements AccountStrategy {

    @Override
    public void apply() {
        log.info("Utilizado saldo de valie alimentação");
    }
}
