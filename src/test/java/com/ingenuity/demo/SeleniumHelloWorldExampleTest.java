package com.ingenuity.demo;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleniumException;
import junit.framework.TestCase;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: danny
 * Date: 9/10/12
 * Time: 10:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class SeleniumHelloWorldExampleTest extends TestCase {

    private DefaultSelenium selenium;

    @Override
    public void setUp() throws Exception {
        selenium = createSeleniumClient("http://localhost:8080/");
        selenium.start();
    }

    @Override
    public void tearDown() throws Exception {
        selenium.stop();
    }

    protected DefaultSelenium createSeleniumClient(String url) throws Exception {
        return new DefaultSelenium("localhost", 4444, "*chrome", url);
    }

    public void testPageContentShouldDisplayHelloWorld() {
        try {
            selenium.open("http://localhost:8080/selenium-app/index.jsp");
            assertEquals("Hello World!", selenium.getText("//h2"));
        } catch (SeleniumException ex) {
            fail(ex.getMessage());
            throw ex;
        }
    }
}
