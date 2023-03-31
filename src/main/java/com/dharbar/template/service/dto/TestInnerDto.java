package com.dharbar.template.service.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.PRIVATE)
@Builder
public class TestInnerDto {

    Long id;

    String singleField;
}
