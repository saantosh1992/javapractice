package com.icode.design.builder;

public class Student extends People {

    private String school;

    public Student(Builder builder) {
        super(builder);
        this.school = builder.school;
    }

    public static Builder builder() {
        return new Builder();
    }
    @Override
    public String toString() {
        return super.toString() + ", school: " + this.school;
    }

    public static class Builder extends People.Builder<Builder> {

        private String school;

        @Override
        public Builder getThis() {
            return this;
        }

        public Builder school(String school) {
            this.school = school;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
