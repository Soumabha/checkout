package com.vinterior.checkout.models;

import lombok.Getter;

@Getter
public class CheckoutItem {

    private int count = 0;

    private Item item;

    private PromotionalRule discountRule;

    public CheckoutItem(Item item, PromotionalRule rule) {
        this.item = item;
        this.discountRule = rule;
    }

    public void addItem() {
        count++;
    }

    public double getPrice() {
        double price = 0.0;
        if(null != discountRule && discountRule.isEligibleForDiscount(count)) {
            price = discountRule.getValueType().getDiscountedPrice(item.getPrice()) * count;
        } else {
            price = item.getPrice() * count;
        }
        return price;
    }


}
