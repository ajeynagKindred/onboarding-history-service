package org.example.historyservice.service;//package org.example.walletservice.service;



import lombok.extern.slf4j.Slf4j;
import org.example.historyservice.repository.HistoryRepository;
import org.example.historyservice.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;


    @Retryable(
            value = {Exception.class},
            maxAttempts = 10,
            backoff = @Backoff(delay = 2000) // Delay between retries in milliseconds
    )
    public List<History> getHistoryDetails(Long id) {
        return historyRepository.findByCustomerId(id);
    }


    @Retryable(
            value = {Exception.class},
            maxAttempts = 10,
            backoff = @Backoff(delay = 2000) // Delay between retries in milliseconds
    )
    public History addDetails(History history) {
        return historyRepository.save(history);
    }


    @Recover
    public List<History> recover(DataAccessException e, long customerId) {
        log.error("Failed to fetch history for customer {} after retries", customerId, e);
        return List.of(); // Return an empty list or handle recovery as needed
    }
}
