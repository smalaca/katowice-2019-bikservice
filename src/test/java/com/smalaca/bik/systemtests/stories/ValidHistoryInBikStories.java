package com.smalaca.bik.systemtests.stories;

import com.smalaca.bik.systemtests.JBehaveConfiguration;
import com.smalaca.credit.CreditGrantedScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidHistoryInBikStories extends JBehaveConfiguration {
    private String pesel;
    private String status;

    @Given("bank client with pesel")
    public void bankClientWithPesel() {
        pesel = CreditGrantedScenario.PESEL;
    }

    @When("ask for status in bik")
    public void askForStatusInBik() {
        status = getRestClient().checkHistory(pesel);
    }

    @Then("status is valid")
    public void statusIsValid() {
        assertThat(status).isEqualTo(CreditGrantedScenario.CREDIT_STATUS);
    }
}
