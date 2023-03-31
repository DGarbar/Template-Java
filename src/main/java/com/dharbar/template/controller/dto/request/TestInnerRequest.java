package com.dharbar.template.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor(onConstructor_ = {@JsonCreator})
public class TestInnerRequest {

    @NotBlank
    String singleField;
}
