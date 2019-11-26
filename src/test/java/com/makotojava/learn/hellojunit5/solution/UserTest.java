package com.makotojava.learn.hellojunit5.solution;

import org.junit.jupiter.api.*;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    private void setUp(){
        user = new User("snail", -2);
    }

    @Test
    @DisplayName("测试获取五年以后的年龄")
    void getFiveYearAge() {
        assertThrows(IllegalArgumentException.class, () -> user.getFiveYearAge());
    }


    @Test
    @DisplayName("有条件的测试，条件不成立方法就会退出")
    public void testAssume() {
        Assumptions.assumeTrue(3 > 2);
        System.out.println("我被执行了");
        assertTrue(3 > 2);
        Assumptions.assumeTrue(2 > 3);
        System.out.println("我被执行了");
    }

    @Test
    @DisplayName("有条件的测试，不影响后面的断言的执行")
    public void testAssumeThat() {
        System.out.println("开始执行了");
        Assumptions.assumingThat(ThreadLocalRandom.current().nextInt(1,5) > 2,
                () -> System.out.println("条件成立"));
        System.out.println("我也被执行了");
    }


    @Nested
    @DisplayName("正常用户")
    class CommonUser {
        private User user;

        @BeforeEach
        public void setUp() {
            user = new User("zhangsan", 24);
        }

        @Test
        public void testFiveYearAge() {
            assertEquals(29, user.getFiveYearAge());
        }
    }
}