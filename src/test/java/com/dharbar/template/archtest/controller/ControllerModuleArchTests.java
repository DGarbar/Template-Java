package com.dharbar.template.archtest.controller;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;

@AnalyzeClasses(packages = "com.dharbar.template", importOptions = ImportOption.DoNotIncludeTests.class)
public class ControllerModuleArchTests {

    public static final String CONTROLLER = "..controller..";

}
