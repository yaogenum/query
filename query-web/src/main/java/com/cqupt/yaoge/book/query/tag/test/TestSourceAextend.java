package com.cqupt.yaoge.book.query.tag.test;

public class TestSourceAextend extends TestSourceA implements TestProxy{

    public void sysAsource() {
        // TODO Auto-generated method stub
        System.out.println("TestA sys source extends");
        sysAsourceSecod();
    }
    
/*
    public void sysAsourceSecod() {
        // TODO Auto-generated method stub
        System.out.println("TestA sys source second exntends");
    }
*/

    public void sysProxy() {
        System.out.println("TestA sys proxy");
    }
    

}
