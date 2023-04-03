package com.dharbar.template.archtest.service;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;

@AnalyzeClasses(packages = "com.dharbar.template", importOptions = ImportOption.DoNotIncludeTests.class)
public class ServiceModuleArchTests {

    public static final String SERVICE = "..service..";
}
