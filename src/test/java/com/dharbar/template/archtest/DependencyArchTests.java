package com.dharbar.template.archtest;

import com.dharbar.template.archtest.controller.ControllerApiArchTests;
import com.dharbar.template.archtest.controller.ControllerArchTests;
import com.dharbar.template.archtest.controller.ControllerDtoArchTests;
import com.dharbar.template.archtest.controller.ControllerMapperArchTests;
import com.dharbar.template.archtest.repository.RepositoryArchTests;
import com.dharbar.template.archtest.repository.RepositoryEntityArchTests;
import com.dharbar.template.archtest.service.ServiceApiArchTests;
import com.dharbar.template.archtest.service.ServiceArchTests;
import com.dharbar.template.archtest.service.ServiceDtoArchTests;
import com.dharbar.template.archtest.service.ServiceMapperArchTests;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.dharbar.template", importOptions = ImportOption.DoNotIncludeTests.class)
public class DependencyArchTests {

    @ArchTest
    static final ArchRule layeredDependency = layeredArchitecture().consideringAllDependencies()

            .layer("Controller Api").definedBy(ControllerApiArchTests.CONTROLLER_API)
            .layer("Controller").definedBy(ControllerArchTests.CONTROLLER)
            .layer("Controller Dto").definedBy(ControllerDtoArchTests.CONTROLLER_DTO)
            .layer("Controller Mapper").definedBy(ControllerMapperArchTests.CONTROLLER_MAPPER)

            .layer("Service Api").definedBy(ServiceApiArchTests.SERVICE_API)
            .layer("Service Dto").definedBy(ServiceDtoArchTests.SERVICE_DTO)
            .layer("Service").definedBy(ServiceArchTests.SERVICE)
            .layer("Service Mapper").definedBy(ServiceMapperArchTests.SERVICE_MAPPER)

            .layer("Repository").definedBy(RepositoryArchTests.REPOSITORY)
            .layer("Repository Entity").definedBy(RepositoryEntityArchTests.REPOSITORY_ENTITY)

            .whereLayer("Controller").mayOnlyBeAccessedByLayers("Controller Api")
            .whereLayer("Controller Dto").mayOnlyBeAccessedByLayers("Controller Api", "Controller", "Controller Mapper")
            .whereLayer("Controller Mapper").mayOnlyBeAccessedByLayers( "Controller")

            .whereLayer("Service Api").mayOnlyBeAccessedByLayers("Controller", "Service")
            .whereLayer("Service Dto").mayOnlyBeAccessedByLayers("Service Api", "Service", "Service Mapper", "Controller Mapper")
            .whereLayer("Service Mapper").mayOnlyBeAccessedByLayers("Service")

            .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service")
            .whereLayer("Repository Entity").mayOnlyBeAccessedByLayers("Service", "Repository", "Service Mapper");
}
