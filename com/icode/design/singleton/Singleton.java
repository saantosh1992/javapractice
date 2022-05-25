package com.icode.design.singleton;

import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

    private static Singleton instance;

    private Singleton() throws Exception {
        throw new Exception("Instance not created");
    }

    @Override
    protected Object clone()  {
        return new CloneNotSupportedException("Clone not supported");
    }


    protected Object readResolve() throws Exception {
        return getInstance();
    }

    public static Singleton getInstance() throws Exception {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
