package tasks;

import static pages.EvertAppPage.*;

import java.math.BigInteger;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import utils.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompleteCycleTask implements Task{

    public static CompleteCycleTask completeCycleChallenge(){
        return instrumented(CompleteCycleTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String operation = CALCULATION_TEXT.resolveFor(actor).getText();
        String inputForSplit = INSTRUCTION_TEXT.resolveFor(actor).getText();

        System.out.println("The operation is: "+operation);
        System.out.println("The text to repeat is: "+inputForSplit);

        BigInteger resultMathOperation = MathOperation.evaluateMathExpression(operation);
        String inputForTxtArea = SplitInput.splitAndReturnD(inputForSplit);

        System.out.println("op"+ resultMathOperation);
        System.out.println("txt"+ inputForTxtArea);

        actor.attemptsTo(
            SelectFromOptions.byValue(String.valueOf(resultMathOperation)).from(ANSWER_SELECT),
            Enter.theValue(inputForTxtArea).into(TEXT_INPUT_AREA),
            Click.on(SEND_BUTTON)
        );
    }
    
}
