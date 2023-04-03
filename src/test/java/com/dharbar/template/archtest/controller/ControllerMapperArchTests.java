package com.dharbar.template.archtest.controller;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.elements.GivenClassesConjunction;
import com.tngtech.archunit.lang.syntax.elements.GivenMethodsConjunction;
import org.mapstruct.Mapper;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

@AnalyzeClasses(packages = "com.dharbar.template", importOptions = ImportOption.DoNotIncludeTests.class)
public class ControllerMapperArchTests {

    public static final String CONTROLLER_MAPPER = "..controller.mapper..";
    public static final GivenClassesConjunction CLASSES = classes().that().resideInAPackage(CONTROLLER_MAPPER);
    public static final GivenMethodsConjunction METHODS = methods().that().areDeclaredInClassesThat().resideInAPackage(CONTROLLER_MAPPER);

    @ArchTest
    static final ArchRule haveSuffix = CLASSES.and().areInterfaces().should().haveSimpleNameEndingWith("Mapper");

    @ArchTest
    static final ArchRule hasAnnotation = CLASSES.and().areInterfaces().should().beAnnotatedWith(Mapper.class);

    @ArchTest
    static final ArchRule hasNamingConvention = METHODS.and().areDeclaredInClassesThat().areInterfaces()
            .should().haveNameMatching("^to.*[Request|Response|Dto]$");
}
