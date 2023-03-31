package com.dharbar.template.service.mapper;

import com.dharbar.template.repository.enitty.Test;
import com.dharbar.template.repository.enitty.TestInner;
import com.dharbar.template.service.dto.TestDto;
import com.dharbar.template.service.dto.TestInnerDto;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface TestMapper {

    @Mapping(target = "testInners", source = "testInners")
    Test toEntity(TestDto dto, List<TestInner> testInners);

    TestInner toEntity(TestInnerDto dto);

    List<TestInner> toEntities(List<TestInnerDto> dtos);

    TestInnerDto toDto(TestInner dto);

    List<TestInnerDto> toDtos(List<TestInner> dtos);

    // We should explicitly set the objects to be in charge of loading the nested objects
    @Mapping(target = "testInners", source = "testInners")
    TestDto toDto(Test entity, List<TestInnerDto> testInners);
}
