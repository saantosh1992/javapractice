package com.icode.design.decorator;

interface Dress {
    void assemble();
}

class BasicDress implements Dress {

    @Override
    public void assemble() {
        System.out.println("Basic dress feature");
    }
}
class DressDecorator implements Dress {

    protected Dress dress;

    public DressDecorator(Dress dress) {
        this.dress = dress;
    }

    @Override
    public void assemble() {
        this.dress.assemble();
    }
}

class CasualDress extends DressDecorator {

    public CasualDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Casual Dress features");
    }
}

class SportyDress extends DressDecorator {

    public SportyDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Sporty Dress features");
    }
}

public class DecoratorTest {
    public static void main(String[] args) {
        Dress dress = new BasicDress();
        dress.assemble();

        Dress sportyDress = new SportyDress(new BasicDress());
        sportyDress.assemble();
    }
}

