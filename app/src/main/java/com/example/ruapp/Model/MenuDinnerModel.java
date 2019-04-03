package com.example.ruapp.Model;

public class MenuDinnerModel {

    String soup;
    String maindish1;
    String maindish2;
    String maindish3;
    String pies;
    String cakes;
    String drink;
    String veg1;
    String veg2;
    String veg3;

    public MenuDinnerModel(MenuModelBuilder menuModelBuilder) {
        this.soup = soup;
        this.maindish1 = maindish1;
        this.maindish2 = maindish2;
        this.maindish3 = maindish3;
        this.pies = pies;
        this.cakes = cakes;
        this.drink = drink;
        this.veg1 = veg1;
        this.veg2 = veg2;
        this.veg3 = veg3;
    }

    public static class MenuModelBuilder {
        String soup;
        String maindish1;
        String maindish2;
        String maindish3;
        String pies;
        String cakes;
        String drink;
        String veg1;
        String veg2;
        String veg3;

        public MenuModelBuilder() {
        }

        public MenuModelBuilder setSoup(String soup) {
            this.soup = soup;
            return this;
        }

        public MenuModelBuilder setMaindish1(String maindish1) {
            this.maindish1 = maindish1;

            return this;
        }

        public MenuModelBuilder setMaindish2(String maindish2) {
            this.maindish2 = maindish2;
            return this;
        }

        public MenuModelBuilder setMaindish3(String maindish3) {
            this.maindish3 = maindish3;
            return this;
        }

        public MenuModelBuilder setPies(String pies) {
            this.pies = pies;
            return this;
        }

        public MenuModelBuilder setCakes(String cakes) {
            this.cakes = cakes;
            return this;
        }

        public MenuModelBuilder setDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public MenuModelBuilder setVeg1(String veg1) {
            this.veg1 = veg1;
            return this;
        }

        public MenuModelBuilder setVeg2(String veg2) {
            this.veg2 = veg2;
            return this;
        }

        public MenuModelBuilder setVeg3(String veg3) {
            this.veg3 = veg3;
            return this;
        }

        public MenuDinnerModel build() {
            return new MenuDinnerModel(this);
        }
    }
}
