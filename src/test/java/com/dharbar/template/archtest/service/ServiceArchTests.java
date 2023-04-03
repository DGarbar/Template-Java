package com.dharbar.template.archtest.service;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.lang.syntax.elements.GivenClassesConjunction;
import com.tngtech.archunit.lang.syntax.elements.GivenMethodsConjunction;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

@AnalyzeClasses(packages = "com.dharbar.template", importOptions = ImportOption.DoNotIncludeTests.class)
public class ServiceArchTests {

    public static final String SERVICE = "..service";
    public static final GivenClassesConjunction CLASSES = classes().that().resideInAPackage(SERVICE);
    public static final GivenMethodsConjunction METHODS = methods().that().areDeclaredInClassesThat().resideInAPackage(SERVICE);


}
