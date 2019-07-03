package com.smalaca.bik.systemtests.stories;

import com.smalaca.bik.systemtests.JBehaveConfiguration;
import com.smalaca.credit.CreditNotGrantedBikInvalidScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class InvalidHistoryInBikStories extends JBehaveConfiguration {
    private String pesel;
    private String status;

    @Given("bank client with pesel")
    public void bankClientWithPesel() {
        pesel = CreditNotGrantedBikInvalidScenario.PESEL;
    }

    @When("ask for status in bik")
    public void askForStatusInBik() {
        status = getRestClient().checkHistory(pesel);
    }

    @Then("status is invalid")
    public void statusIsInvalid() {
        assertThat(status).isEqualTo(CreditNotGrantedBikInvalidScenario.CREDIT_STATUS);
    }
}
