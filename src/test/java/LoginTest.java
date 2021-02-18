import com.telran.model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        app.user().skipWizard();
        app.user().goToLoginForm();

    }


    @Test
    public void testLogin(){
        app.user().fillLoginForm(new User().withfName("hatum.testing").withPassword("Hatum12344$"));
        app.user().clickLoginButton();




    }
}
