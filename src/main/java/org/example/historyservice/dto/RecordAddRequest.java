package org.example.historyservice.dto;//package org.example.walletservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.historyservice.enums.ActionType;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordAddRequest {

    private Long customerId;
    private BigDecimal amount;
    private ActionType actionType;
    private BigDecimal balance;

}
