package org.example.historyservice.repository;

import org.example.historyservice.entity.History;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {

    List<History> findByCustomerId (long customerId);
}



