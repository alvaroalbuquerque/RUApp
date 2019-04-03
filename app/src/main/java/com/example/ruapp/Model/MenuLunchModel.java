package com.example.ruapp.Model;

public class MenuLunchModel {

    String protein1;
    String protein2;
    String vegetarian;
    String rice;
    String bean;
    String food3;
    String salad;
    String juice;
    String fruit;

    public MenuLunchModel(MenuModelBuilder menuModelBuilder) {
        this.protein1 =  menuModelBuilder.protein1;
        this.protein2 = menuModelBuilder.protein2;
        this.vegetarian = menuModelBuilder.vegetarian;
        this.rice = menuModelBuilder.rice;
        this.bean = menuModelBuilder.bean;
        this.food3 = menuModelBuilder.food3;
        this.salad = menuModelBuilder.salad;
        this.juice = menuModelBuilder.juice;
        this.fruit = menuModelBuilder.fruit;
    }

    public static class MenuModelBuilder{
        String protein1;
        String protein2;
        String vegetarian;
        String rice;
        String bean;
        String food3;
        String salad;
        String juice;
        String fruit;

        public MenuModelBuilder(){

        }

        public MenuModelBuilder setProtein1(String protein1) {
            this.protein1 = protein1;
            return this;
        }

        public MenuModelBuilder setProtein2(String protein2) {
            this.protein2 = protein2;
            return this;
        }

        public MenuModelBuilder setVegetarian(String vegetarian) {
            this.vegetarian = vegetarian;
            return this;
        }

        public MenuModelBuilder setRice(String rice) {
            this.rice = rice;
            return this;
        }

        public MenuModelBuilder setBean(String bean) {
            this.bean = bean;
            return this;
        }

        public MenuModelBuilder setFood3(String food3) {
            this.food3 = food3;
            return this;
        }

        public MenuModelBuilder setSalad(String salad) {
            this.salad = salad;
            return this;
        }

        public MenuModelBuilder setJuice(String juice) {
            this.juice = juice;
            return this;
        }

        public MenuModelBuilder setFruit(String fruit) {
            this.fruit = fruit;
            return this;
        }

        public MenuLunchModel build(){
            return new MenuLunchModel(this);
        }
    }

    public String getProtein1() {
        return protein1;
    }

    public void setProtein1(String protein1) {
        this.protein1 = protein1;
    }

    public String getProtein2() {
        return protein2;
    }

    public void setProtein2(String protein2) {
        this.protein2 = protein2;
    }

    public String getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(String vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String getRice() {
        return rice;
    }

    public void setRice(String rice) {
        this.rice = rice;
    }

    public String getBean() {
        return bean;
    }

    public void setBean(String bean) {
        this.bean = bean;
    }

    public String getFood3() {
        return food3;
    }

    public void setFood3(String food3) {
        this.food3 = food3;
    }

    public String getSalad() {
        return salad;
    }

    public void setSalad(String salad) {
        this.salad = salad;
    }

    public String getJuice() {
        return juice;
    }

    public void setJuice(String juice) {
        this.juice = juice;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }
}
