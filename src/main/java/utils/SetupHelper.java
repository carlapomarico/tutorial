package utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration("classpath:/application-context.xml")
public class SetupHelper extends AbstractTestNGSpringContextTests {

    protected BrowserUtil browserUtil = new BrowserUtil();
}
