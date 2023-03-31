package com.dharbar.template.controller.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Data
@Setter(AccessLevel.PRIVATE)
@Builder
public class TestResponse {

    UUID id;

    String field;

    Long parameter;

    List<TestInnerResponse> testInners;
}
