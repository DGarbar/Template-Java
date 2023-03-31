package com.dharbar.template.controller.mapper;

import com.dharbar.template.controller.dto.request.TestRequest;
import com.dharbar.template.controller.dto.response.TestResponse;
import com.dharbar.template.service.dto.TestDto;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

// For controller level mapping internal mapping (hidden by compiled file) is allowed
@Mapper(componentModel = SPRING)
public interface TestRequestMapper {

    TestDto toDto(TestRequest testRequest);

    TestResponse toResponse(TestDto test);
}
