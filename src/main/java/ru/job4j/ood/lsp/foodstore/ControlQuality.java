package ru.job4j.ood.lsp.foodstore;

import java.util.List;

public class ControlQuality {

    private final List<Item> goods;
    private final List<Store> stores;

    public ControlQuality(List<Item> goods, List<Store> stores) {
        this.goods = goods;
        this.stores = stores;
    }

    public void sortGoods() {
        for (Store store : stores) {
            for (Item item : goods) {
                if (store.accept(item)) {
                    store.addItem(item);
                }
            }
        }
    }

    public void reSortGoods() {
        goods.clear();
        for (Store store : stores) {
            goods.addAll(store.getAllItems());
            store.clearStore();
        }
        sortGoods();
    }
}
