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

    public String getSoup() {
        return soup;
    }

    public void setSoup(String soup) {
        this.soup = soup;
    }

    public String getMaindish1() {
        return maindish1;
    }

    public void setMaindish1(String maindish1) {
        this.maindish1 = maindish1;
    }

    public String getMaindish2() {
        return maindish2;
    }

    public void setMaindish2(String maindish2) {
        this.maindish2 = maindish2;
    }

    public String getMaindish3() {
        return maindish3;
    }

    public void setMaindish3(String maindish3) {
        this.maindish3 = maindish3;
    }

    public String getPies() {
        return pies;
    }

    public void setPies(String pies) {
        this.pies = pies;
    }

    public String getCakes() {
        return cakes;
    }

    public void setCakes(String cakes) {
        this.cakes = cakes;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getVeg1() {
        return veg1;
    }

    public void setVeg1(String veg1) {
        this.veg1 = veg1;
    }

    public String getVeg2() {
        return veg2;
    }

    public void setVeg2(String veg2) {
        this.veg2 = veg2;
    }

    public String getVeg3() {
        return veg3;
    }

    public void setVeg3(String veg3) {
        this.veg3 = veg3;
    }
}
