package com.dharbar.template.controller.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
@Setter(AccessLevel.PRIVATE)
@Builder
public class TestRequest {

    @NotBlank
    String field;

    @Valid
    @NotEmpty
    List<TestInnerRequest> testInners;

    @Valid
    @NotNull
    TestInnerRequest testInner;

    @NotNull
    @Positive
    Long parameter;
}
