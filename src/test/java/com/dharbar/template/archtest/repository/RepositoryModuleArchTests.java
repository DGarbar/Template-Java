package com.dharbar.template.archtest.repository;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;

@AnalyzeClasses(packages = "com.dharbar.template", importOptions = ImportOption.DoNotIncludeTests.class)
public class RepositoryModuleArchTests {

    public static final String REPOSITORY = "..repository..";

}
