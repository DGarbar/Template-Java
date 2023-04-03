package com.dharbar.template.service;

import com.dharbar.template.repository.TestRepository;
import com.dharbar.template.repository.entity.Test;
import com.dharbar.template.repository.entity.TestInner;
import com.dharbar.template.service.api.TestServiceApi;
import com.dharbar.template.service.dto.TestDto;
import com.dharbar.template.service.dto.TestInnerDto;
import com.dharbar.template.service.mapper.TestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService implements TestServiceApi {

    private final TestRepository testRepository;

    private final TestMapper testMapper;

    @Transactional
    @Override
    public TestDto createTest(TestDto testDto) {
        boolean isTestFieldExists = testRepository.findByField(testDto.getField()).isPresent();
        if (isTestFieldExists) {
            throw new RuntimeException("test exists");
        }

        List<TestInner> testInners = testMapper.toEntities(testDto.getTestInners());
        Test test = testMapper.toEntity(testDto, testInners);
        Test savedTest = testRepository.save(test);
        return toTestDto(savedTest);
    }

    @Transactional(readOnly = true)
    @Override
    public TestDto getTest(UUID id) {
        return testRepository.findByIdWithTestInner(id)
                .map(this::toTestDto)
                .orElseThrow(() -> new RuntimeException("test not found"));
    }

    private TestDto toTestDto(Test savedTest) {
        List<TestInnerDto> savedTestInnerDtos = testMapper.toDtos(savedTest.getTestInners());
        return testMapper.toDto(savedTest, savedTestInnerDtos);
    }
}
