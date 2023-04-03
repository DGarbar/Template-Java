package com.dharbar.template.archtest.controller;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.elements.GivenClassesConjunction;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.dharbar.template", importOptions = ImportOption.DoNotIncludeTests.class)
public class ControllerDtoArchTests {

    public static final String CONTROLLER_DTO = "..controller.dto..";
    public static final String CONTROLLER_DTO_REQUEST = "..controller.dto.request";
    public static final String CONTROLLER_DTO_RESPONSE = "..controller.dto.response";
    public static final GivenClassesConjunction REQUEST_CLASSES = classes().that().resideInAPackage(CONTROLLER_DTO_REQUEST);
    public static final GivenClassesConjunction RESPONSE_CLASSES = classes().that().resideInAPackage(CONTROLLER_DTO_RESPONSE);

    @ArchTest
    static final ArchRule beInPackageRequest = classes().that().haveNameMatching(".*Request").should().resideInAPackage(CONTROLLER_DTO_REQUEST);

    @ArchTest
    static final ArchRule beInPackageResponse = classes().that().haveNameMatching(".*Response").should().resideInAPackage(CONTROLLER_DTO_RESPONSE);

    @ArchTest
    static final ArchRule haveSuffixRequest = REQUEST_CLASSES.should()
            .haveSimpleNameEndingWith("Request").orShould()
            .haveSimpleNameEndingWith("RequestBuilder");

    @ArchTest
    static final ArchRule haveSuffixResponse = RESPONSE_CLASSES.should()
            .haveSimpleNameEndingWith("Response").orShould()
            .haveSimpleNameEndingWith("ResponseBuilder");

    // Not working because of RetentionPolicy.SOURCE
    // @ArchTest
    // static final ArchRule requestAnnotations = REQUEST_CLASSES.should()
    //         .beAnnotatedWith(Data.class).andShould()
    //         .beAnnotatedWith(Setter.class).andShould()
    //         .beAnnotatedWith(Builder.class);
    //
    // @ArchTest
    // static final ArchRule responseAnnotations = RESPONSE_CLASSES.should()
    //         .beAnnotatedWith(Data.class).andShould()
    //         .beAnnotatedWith(Setter.class).andShould()
    //         .beAnnotatedWith(Builder.class);
}
