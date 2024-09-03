package org.example.historyservice.jms.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.historyservice.dto.RecordAddRequest;

import org.example.historyservice.entity.History;
import org.example.historyservice.mapper.HistoryMapper;
import org.example.historyservice.service.HistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserUpdateEventListener {

    @Autowired
    private HistoryService historyService;


    @Autowired
    private ObjectMapper objectMapper;


    @JmsListener(destination = "balance-update-event")
    public void onMessage(String message) throws JsonProcessingException {
        log.info("Received message: " + message);
        RecordAddRequest recordAddRequest =  objectMapper.readValue(message, RecordAddRequest.class);
        History history = HistoryMapper.INSTANCE.cutomerDtoToEntity(recordAddRequest);
        historyService.addDetails(history);
    }
}
