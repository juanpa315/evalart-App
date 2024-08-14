package pages;

import org.openqa.selenium.By;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://tasks.evalartapp.com/automatization/")
public class EvertAppPage extends PageObject {

        public static final Target USERNAME_FIELD = Target.the("username input field")
                        .located(By.cssSelector("input[name='username'][class='p-2 rounded-md']"));

        public static final Target PASSWORD_FIELD = Target.the("password input field")
                        .located(By.cssSelector("input[type='password'][name='password']"));

        public static final Target CALCULATION_TEXT = Target.the("calculation text paragraph")
                        .located(By.xpath(
                                        "//div[contains(@class, 'flex') and contains(@class, 'bg-white')]/p[contains(@class, 'text-center') and contains(@class, 'font-bold')]"));

        public static final Target ANSWER_SELECT = Target.the("answer selection dropdown")
                        .located(By.cssSelector("select[name='select'][required]"));

        public static final Target INSTRUCTION_TEXT = Target.the("instruction text")
                        .located(By.xpath(
                                        "//p[contains(@class, 'text-center') and contains(@class, 'text-xl') and contains(text(), 'Write')]"));

        public static final Target TEXT_INPUT_AREA = Target.the("text input textarea")
                        .located(By.cssSelector("textarea[name='text'][required]"));

        public static final Target SEND_BUTTON = Target.the("send button")
                        .located(By.cssSelector("button[type='submit']"));

        public static final Target CYCLE_INFO = Target.the("cycle information")
                        .located(By.cssSelector("p.text-xl.text-center.text-green-500"));

        public static final Target ERROR_MESSAGE = Target.the("error message")
                        .located(By.cssSelector("p[class*='text-red']"));

        public static final Target PASS_CODE = Target.the("pass code successfull")
                        .located(By.xpath("//*[@class='text-white text-2xl text-center break-all']"));

}
