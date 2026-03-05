package StepDefinition01;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {
		        
		        "src/test/java/FeatureFiles/NewCustomerWithDataFile.feature",
		        "src/test/java/FeatureFiles/NewAccountCreation.feature",
		        "src/test/java/FeatureFiles/LogOut.feature"
		    },
	    glue = {"StepDefinition01"},
	  //  tags = "@smoke",
	                         //tags = "@sanity or @smoke"  we can use this also for combination
        dryRun=false,         //if false-> one of the step in feature file not implemented in step definition 
                            //it not run all other run	
        
        plugin= {"pretty","html:target/Htmlreports/index.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
},
        monochrome=false//Color combinations
        )

public class TestRunner01 {

}
