import com.telran.model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        app.user().skipWizard();
        app.user().clickOnMenuButton();
        if(!app.user().isUserLoggedIn()) {
            app.user().goToLoginForm();
            app.user().fillLoginForm(new User().withfName("hatum.testing").withPassword("Hatum12344$"));
            app.user().clickLoginButton();
        }
    }

    @Test
    public void logoutTest(){
        app.user().logout();

    }
}
