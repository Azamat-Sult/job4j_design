package ru.job4j.ood.lsp.foodstore;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ControlQuality {

    private final List<Item> goods;
    private final IStore warehouse;
    private final IStore shop;
    private final IStore trash;

    public ControlQuality(List<Item> goods, IStore warehouse, IStore shop, IStore trash) {
        this.goods = goods;
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    public void sortGoods(double remainPercentOfExpDateToKeepInStore,
                          double remainPercentOfExpDateToSaleWithDiscount, int discountPercent) {
        LocalDate currentDate = LocalDate.now();
        for (Item item : goods) {
            if (currentDate.isAfter(item.getExpiryDate())) {
                trash.addItem(item);
                System.out.println(item + " - moved to trash");
                continue;
            }

            long expirationDate = ChronoUnit.DAYS.between(item.getCreateDate(), item.getExpiryDate());
            long remainingExpirationDate = ChronoUnit.DAYS.between(currentDate, item.getExpiryDate());
            long remainPercentOfExpDate = 100 * remainingExpirationDate / expirationDate;

            if (remainPercentOfExpDate > remainPercentOfExpDateToKeepInStore) {
                warehouse.addItem(item);
                System.out.println(item + " - moved to warehouse");
            } else if (remainPercentOfExpDate > remainPercentOfExpDateToSaleWithDiscount
                    && remainPercentOfExpDate <= remainPercentOfExpDateToKeepInStore) {
                shop.addItem(item);
                System.out.println(item + " - moved to shop without discount");
            } else if (remainPercentOfExpDate <= remainPercentOfExpDateToSaleWithDiscount) {
                item.setDiscount(discountPercent);
                shop.addItem(item);
                System.out.println(item + " - moved to shop with discount");
            }
        }
    }
}
