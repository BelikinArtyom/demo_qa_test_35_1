import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SimpleJunitTest {

    int result;

    @BeforeAll
    static void beforeAll() {
        System.out.println("###  beforeAll");
    }

    @BeforeEach
    void beforeEach() {
        result = GetResult();
        System.out.println("###  beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("###  afterEach");
        result = 0;
    }

    @AfterAll
    static void AfterAll() {
        System.out.println("###  AfterAll");
    }

    @Test
    void firstTest() {
        System.out.println("###  firstTest");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void secondTest() {
        System.out.println("###  secondTest");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest() {
        System.out.println("###  thirdTest");
        Assertions.assertTrue(result > 2);
    }

    private int GetResult() {
        return 3;
    }
}