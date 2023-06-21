package cl.acabrera.main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void mainTest() {
        TestBrowser testBrowser = new TestBrowser();

        testBrowser.initializeDriver("Firefox");
        testBrowser.testWikipediaSearch();

    }
}