package org.example.historyservice.mapper;


import org.example.historyservice.dto.RecordAddRequest;
import org.example.historyservice.entity.History;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HistoryMapper {

    HistoryMapper INSTANCE = Mappers.getMapper(HistoryMapper.class);



    History cutomerDtoToEntity(RecordAddRequest recordAddRequest);
}

