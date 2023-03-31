package com.dharbar.template.service.api;

import com.dharbar.template.service.dto.TestDto;

import java.util.UUID;

public interface TestServiceApi {

    TestDto createTest(TestDto test);

    TestDto getTest(UUID id);
}
