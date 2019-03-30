package com.example.ruapp.SeeMenuPackage;

import java.util.List;

public class LargeViewModel {
    private int id;
    private List<ItemModel> items;
    private Integer pic;

    public LargeViewModel(int id, List<ItemModel> items, Integer pic) {
        this.id = id;
        this.items = items;
        this.pic = pic;
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public Integer getPic() {
        return pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }

    public void setPic(Integer pic) {
        this.pic = pic;
    }
}
