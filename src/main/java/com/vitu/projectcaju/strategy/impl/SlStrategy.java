package com.vitu.projectcaju.strategy.impl;

import com.vitu.projectcaju.strategy.AccountStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SlStrategy implements AccountStrategy {

    @Override
    public void apply() {
        log.info("Utilizado saldo livre");
    }
}
