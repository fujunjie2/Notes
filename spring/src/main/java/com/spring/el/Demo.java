package com.spring.el;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Demo {


    public static void main(String[] args) {

        Car car = new Car();
        car.setId(111);
        car.setBrands("丰田");
        car.setName("逸泽");
        car.setLevel("A");


        ExpressionParser parser = new SpelExpressionParser();

        Expression expression = parser.parseExpression("#car.getId() + '-' + # car.getName()");

        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();

        standardEvaluationContext.setVariable("car", car);


        Object result = expression.getValue(standardEvaluationContext );

    }

    public static class Car{
        private Integer id;

        private String name;

        private String brands;

        private String level;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBrands() {
            return brands;
        }

        public void setBrands(String brands) {
            this.brands = brands;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }
    }
}


