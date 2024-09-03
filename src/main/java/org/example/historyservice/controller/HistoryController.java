package org.example.historyservice.controller;//package org.example.walletservice.controller;



import lombok.extern.slf4j.Slf4j;
import org.example.historyservice.entity.History;
import org.example.historyservice.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
@Slf4j
public class HistoryController {

    @Autowired
    private HistoryService historyService;


    @GetMapping("/transaction")
    public ResponseEntity<List<History>> getCustomerDetails(@RequestHeader String userId) {
        return ResponseEntity.ok().body(historyService.getHistoryDetails(Long.valueOf(userId)));
    }

}
