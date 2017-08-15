import com.xdy.SpringTestApplication;
import com.xdy.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * User: xuedaiyao
 * Date: 2017/8/15
 * Time: 16:44
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringTestApplication.class)
@WebAppConfiguration
public class UserInfoTest {

    @Autowired
    private UserInfoService userInfoService;


    @Test
    public void testTansactional(){
        userInfoService.testTransational();
    }

}
