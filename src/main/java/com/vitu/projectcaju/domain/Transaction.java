package com.vitu.projectcaju.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Transaction {
    private Integer id;
    private Integer accountId;
    private String merchant;
    private Integer mcc;
    private BigDecimal amount;
}
