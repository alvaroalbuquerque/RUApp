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
}
