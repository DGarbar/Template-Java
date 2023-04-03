package com.dharbar.template.archtest.repository;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.elements.GivenClassesConjunction;
import com.tngtech.archunit.lang.syntax.elements.GivenMethodsConjunction;
import org.h2.mvstore.Page;

import java.util.Collection;
import java.util.Optional;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

@AnalyzeClasses(packages = "com.dharbar.template", importOptions = ImportOption.DoNotIncludeTests.class)
public class RepositoryArchTests {

    public static final String REPOSITORY = "..repository";
    public static final GivenClassesConjunction CLASSES = classes().that().resideInAPackage(REPOSITORY);
    public static final GivenMethodsConjunction METHODS = methods().that().areDeclaredInClassesThat().resideInAPackage(REPOSITORY);

    @ArchTest
    static final ArchRule haveSuffix = CLASSES.should().haveSimpleNameEndingWith("Repository");

    // @ArchTest
    // static final ArchRule beJpaRepository = CLASSES.should().implement(JpaRepository.class);

    @ArchTest
    static final ArchRule returningWrapper = METHODS.should()
            .haveRawReturnType(Optional.class).orShould()
            .haveRawReturnType(Collection.class).orShould()
            .haveRawReturnType(Page.class);

}
