package com.cqupt.yaoge.book.query.tag.test;

public class TestA  implements TestProxy{
    // 
    //extends TestSourceA
    private TestB testB;

    public TestB getTestB() {
        return testB;
    }

    public void setTestB(TestB testB) {
        this.testB = testB;
    }
    public void sysA() {
        System.out.println("A");
    }
    public void sysB() {
        //System.out.println("A:"+testB);
        testB.sysB();
    }
   // @Override
    public void sysAsource() {
        System.out.println("TestA sys AA 复写");
    }
    
    public void sysProxy() {
        System.out.println("TestA sys proxy");
    }
    
    

    public void sysAsourceSecod() {
        // TODO Auto-generated method stub
        System.out.println("TestA sys source second 复写");
    }
}
