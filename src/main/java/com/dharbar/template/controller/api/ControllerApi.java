package com.dharbar.template.controller.api;

import com.dharbar.template.controller.dto.request.TestRequest;
import com.dharbar.template.controller.dto.response.TestResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public interface ControllerApi {

    @Operation(summary = "Test summary for endpoint")
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200", description = "Test more descriptive summary for endpoint for endpoint")})
    @PostMapping(value = "/tests",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
        // @PreAuthorize("")
    ResponseEntity<TestResponse> createTest(@Valid @RequestBody TestRequest request);

    @Operation(summary = "Test summary for endpoint")
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200", description = "Test more descriptive summary for endpoint for endpoint")})
    @GetMapping(value = "/tests/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        // @PreAuthorize("")
    ResponseEntity<TestResponse> getTest(@PathVariable UUID id);
}
