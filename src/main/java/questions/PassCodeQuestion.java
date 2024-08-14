package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import static pages.EvertAppPage.PASS_CODE;

public class PassCodeQuestion implements Question<String>{

    public static PassCodeQuestion codeValue() {
        return new PassCodeQuestion();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(PASS_CODE).answeredBy(actor);
    }
    
}
