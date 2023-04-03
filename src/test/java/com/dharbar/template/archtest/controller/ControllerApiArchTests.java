package com.dharbar.template.archtest.controller;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.elements.GivenClassesConjunction;
import com.tngtech.archunit.lang.syntax.elements.GivenMethodsConjunction;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

@AnalyzeClasses(packages = "com.dharbar.template", importOptions = ImportOption.DoNotIncludeTests.class)
public class ControllerApiArchTests {

    public static final String CONTROLLER_API = "..controller.api..";
    public static final GivenClassesConjunction CLASSES = classes().that().resideInAPackage(CONTROLLER_API);
    public static final GivenMethodsConjunction METHODS = methods().that().areDeclaredInClassesThat().resideInAPackage(CONTROLLER_API);

    @ArchTest
    static final ArchRule haveSuffix = CLASSES.should().haveSimpleNameEndingWith("ControllerApi");

    @ArchTest
    static final ArchRule beInterface = CLASSES.should().beInterfaces();

    @ArchTest
    static final ArchRule methodHasSwaggerDescription = METHODS.should()
            .beAnnotatedWith(Operation.class);

    @ArchTest
    static final ArchRule methodsReturnResponse = METHODS.should()
            .haveRawReturnType(ResponseEntity.class);

    @ArchTest
    static final ArchRule methodNameStartedWith = METHODS.should()
            .haveNameMatching("^[get|create|update|delete|upsert].*");

    // TODO RequestBody, Param, etc based on the type of parameter
}
