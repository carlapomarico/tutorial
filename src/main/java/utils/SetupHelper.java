package utils;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration("classpath:/application-context.xml")
public class SetupHelper extends AbstractTestNGSpringContextTests {

    protected BrowserUtil browserUtil = new BrowserUtil();
}
