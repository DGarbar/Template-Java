package com.dharbar.template.archtest.repository;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.elements.GivenClassesConjunction;
import com.tngtech.archunit.lang.syntax.elements.GivenMethodsConjunction;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

@AnalyzeClasses(packages = "com.dharbar.template", importOptions = ImportOption.DoNotIncludeTests.class)
public class RepositoryEntityArchTests {

    public static final String REPOSITORY_ENTITY = "..repository.entity..";
    public static final GivenClassesConjunction CLASSES = classes().that().resideInAPackage(REPOSITORY_ENTITY);
    public static final GivenMethodsConjunction METHODS = methods().that().areDeclaredInClassesThat().resideInAPackage(REPOSITORY_ENTITY);

    @ArchTest
    static final ArchRule hasJpaAnnotation = CLASSES.should()
            .beAnnotatedWith(Entity.class).andShould()
            .beAnnotatedWith(Table.class);

    @ArchTest
    static final ArchRule hasEntityListenerAnnotation = CLASSES.should().beAnnotatedWith(EntityListeners.class);

    // TODO lombok validation
}
