package com.dharbar.template.controller;

import com.dharbar.template.controller.api.ControllerApi;
import com.dharbar.template.controller.dto.request.TestRequest;
import com.dharbar.template.controller.dto.response.TestResponse;
import com.dharbar.template.controller.mapper.TestRequestMapper;
import com.dharbar.template.service.api.TestServiceApi;
import com.dharbar.template.service.dto.TestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class Controller implements ControllerApi {

    private final TestRequestMapper testRequestMapper;
    private final TestServiceApi testService;

    @Override
    public ResponseEntity<TestResponse> createTest(TestRequest request) {
        TestDto test = testRequestMapper.toDto(request);
        TestDto savedTest = testService.createTest(test);
        return ResponseEntity.ok(testRequestMapper.toResponse(savedTest));
    }

    @Override
    public ResponseEntity<TestResponse> getTest(UUID id) {
        TestDto test = testService.getTest(id);
        return ResponseEntity.ok(testRequestMapper.toResponse(test));
    }
}
