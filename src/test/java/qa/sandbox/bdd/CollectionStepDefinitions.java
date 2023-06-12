package qa.sandbox.bdd;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.sandbox.appmanager.ApplicationManager;

public class CollectionStepDefinitions {

    private ApplicationManager app;

    @Before
    public void init() {

    }

    @After
    public void stop() {

    }

    @Given("^a set of collection$")
    public void loadBooks() {

    }

    @When("I add a new book")
    public void addBook() {

    }

    @Then("^the new set of collection is equal to the old set with the added book$")
    public void verifyBookAdded() {

    }
}
