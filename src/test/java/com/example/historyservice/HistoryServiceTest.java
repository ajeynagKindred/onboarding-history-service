package com.example.historyservice;


import org.example.historyservice.entity.History;
import org.example.historyservice.repository.HistoryRepository;
import org.example.historyservice.service.HistoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataAccessException;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class HistoryServiceTest {

    @InjectMocks
    private HistoryService historyService;

    @Mock
    private HistoryRepository historyRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetHistoryDetailsSuccess() {
        Long customerId = 1L;
        History history = new History(); // Initialize with necessary fields if needed
        List<History> historyList = List.of(history);

        // Mocking the behavior of historyRepository
        when(historyRepository.findByCustomerId(customerId)).thenReturn(historyList);

        List<History> result = historyService.getHistoryDetails(customerId);

        assertEquals(historyList, result);
        verify(historyRepository, times(1)).findByCustomerId(customerId);
    }


    @Test
    void testAddDetailsSuccess() {
        History history = new History(); // Initialize with necessary fields if needed

        // Mocking the behavior of historyRepository
        when(historyRepository.save(history)).thenReturn(history);

        History result = historyService.addDetails(history);

        assertEquals(history, result);
        verify(historyRepository, times(1)).save(history);
    }

    @Test
    void testRecover() {
        Long customerId = 1L;
        DataAccessException exception = new DataAccessException("Database error") {};

        // Invoke the recover method directly
        List<History> result = historyService.recover(exception, customerId);

        assertEquals(Collections.emptyList(), result);
        verifyNoInteractions(historyRepository); // Ensure repository is not called in recovery
    }
}

