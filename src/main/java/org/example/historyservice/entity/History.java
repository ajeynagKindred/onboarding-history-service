package org.example.historyservice.entity;//package org.example.walletservice.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.example.historyservice.enums.ActionType;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private ActionType actionType;
    private BigDecimal amount;

}
