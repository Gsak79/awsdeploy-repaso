package com.docseeker.patient;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "com.docseeker.patient.cucumberglue" }
)
public class CucumberTestsRunner {
}
