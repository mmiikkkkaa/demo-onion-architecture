package com.example.architecturedemo.healthypizza.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = "com.example.architecturedemo.healthypizza")
public class ArchitectureTest {

    @ArchTest
    public static final ArchRule onionArchitecture = onionArchitecture()
                        .domainModels("..domain.model..")
                        .domainServices("..domain.service..")
                        .applicationServices("..application..")
                        .adapter("persistence", "..infrastructure.persistence..")
                        .adapter("rest", "..infrastructure.rest..");

}
