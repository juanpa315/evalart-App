package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static pages.EvertAppPage.PASSWORD_FIELD;
import static pages.EvertAppPage.SEND_BUTTON;
import static pages.EvertAppPage.USERNAME_FIELD;

import java.util.Map;

public class LoginTask implements Task{

    private Map<String, String> userCredentials;


    public static LoginTask login(){
        return instrumented(LoginTask.class);
    }

    public LoginTask with(Map<String, String> userCredentials){
        this.userCredentials = userCredentials;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
            Enter.theValue(userCredentials.get("user")).into(USERNAME_FIELD),
            Enter.theValue(userCredentials.get("password")).into(PASSWORD_FIELD),
            Click.on(SEND_BUTTON));
    }
    
}
