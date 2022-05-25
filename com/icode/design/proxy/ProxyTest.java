package com.icode.design.proxy;

interface ExpensiveObject {
    void process();
}

class ExpensiveObjectImpl implements ExpensiveObject {

    public ExpensiveObjectImpl() {
        heavyInitConfig();
    }

    private void heavyInitConfig() {
        System.out.println("Initializing the configuration...");
    }

    @Override
    public void process() {
        System.out.println("Process completed..");
    }
}

class ExpensiveObjectProxy implements ExpensiveObject {
    private static ExpensiveObject object;

    @Override
    public void process() {
        if(object == null) {
            object = new ExpensiveObjectImpl();
        }
        object.process();
    }
}

public class ProxyTest {
    public static void main(String[] args) {

        ExpensiveObject object = new ExpensiveObjectProxy();
        object.process();
        object.process();
    }
}
