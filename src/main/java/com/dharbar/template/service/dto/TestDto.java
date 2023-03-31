package com.dharbar.template.service.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Data
@Setter(AccessLevel.PRIVATE)
@Builder
public class TestDto {

    UUID id;

    String field;

    List<TestInnerDto> testInners;

    TestInnerDto testInner;

    Long parameter;
}
