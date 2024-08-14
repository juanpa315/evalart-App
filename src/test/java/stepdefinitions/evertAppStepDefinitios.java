package stepdefinitions;

import java.util.Map;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import static questions.PassCodeQuestion.codeValue;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static tasks.OpenBrowserTask.openBrowser;
import static tasks.CompleteCycleTask.completeCycleChallenge;
import static tasks.LoginTask.login;
import static pages.EvertAppPage.CYCLE_INFO;
import static pages.EvertAppPage.PASS_CODE;

public class evertAppStepDefinitios {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
    }

    @Given("{actor} longin with user and password")
    public void i_longin_with_user_and_password(Actor actor, Map<String, String> userCredentials) {
        actor.attemptsTo(
                openBrowser(),
                login().with(userCredentials),
                Ensure.that(CYCLE_INFO).isDisplayed()
                        .orElseThrow(new AssertionError("Cycle information is not visible after login")));
    }

    @When("{actor} complete the evert questions")
    public void i_complete_the_evert_questions(Actor actor) {

        for (int i = 0; i < 10; i++) {
            actor.attemptsTo(completeCycleChallenge());
            System.out.println("cycle" + i);
        }
    }

    @Then("{actor} can  see the passcode successfu")
    public void i_can_see_the_passcode_successfu(Actor actor) {
        actor.attemptsTo(
                Ensure.that(PASS_CODE).isDisplayed().orElseThrow(new AssertionError("passCode is not visible")));
        String passCode = actor.asksFor(codeValue());
        System.out.println("the passcode is: " + passCode);
    }

}
