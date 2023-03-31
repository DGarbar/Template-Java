package com.dharbar.template.controller.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.PRIVATE)
@Builder
public class TestInnerResponse {

    Long id;

    String singleField;
}
