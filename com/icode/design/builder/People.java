package com.icode.design.builder;

public class People {

    private String name;

    private int age;

    public People(Builder<?> builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public static Builder builder() {
        return new Builder() {
            @Override
            public Builder getThis() {
                return this;
            }
        };
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public abstract static class Builder<T extends Builder<T>> {

        private String name;

        private int age;

        public abstract T getThis();

        public T name(String name) {
            this.name = name;
            return this.getThis();
        }

        public T age(int age) {
            this.age = age;
            return this.getThis();
        }

        public People build() {
            return new People(this);
        }
    }
}
