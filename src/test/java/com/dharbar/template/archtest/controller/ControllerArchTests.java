package com.dharbar.template.archtest.controller;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.elements.GivenClassesConjunction;
import com.tngtech.archunit.lang.syntax.elements.GivenMethodsConjunction;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

@AnalyzeClasses(packages = "com.dharbar.template",  importOptions = ImportOption.DoNotIncludeTests.class)
public class ControllerArchTests {

    public static final String CONTROLLER = "..controller";
    public static final GivenClassesConjunction CLASSES = classes().that().resideInAPackage(CONTROLLER);
    public static final GivenMethodsConjunction METHODS = methods().that().areDeclaredInClassesThat().resideInAPackage(CONTROLLER);

    @ArchTest
    static final ArchRule beInPackage = classes().that().haveNameMatching(".*Controller").should().resideInAPackage(CONTROLLER);

    @ArchTest
    static final ArchRule haveSuffix = classes().that().resideInAPackage(CONTROLLER).should().haveSimpleNameEndingWith("Controller");

    @ArchTest
    static final ArchRule beRestController = CLASSES.should().beAnnotatedWith(RestController.class);

    @ArchTest
    static final ArchRule haveOnlyFinalFields = CLASSES.should().haveOnlyFinalFields();
}
