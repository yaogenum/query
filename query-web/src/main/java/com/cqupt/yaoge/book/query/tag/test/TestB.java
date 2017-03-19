package com.cqupt.yaoge.book.query.tag.test;

public class TestB {
    private TestA testA;

    
    public TestA getTestA() {
        return testA;
    }

    
    public void setTestA(TestA testA) {
        this.testA = testA;
    }
    public void sysA() {
        testA.sysA();
    }
    public void sysB() {
        System.out.println("B:"+testA);
        System.out.println("B");
    }
}
