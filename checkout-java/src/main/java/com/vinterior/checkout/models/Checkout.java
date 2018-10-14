package com.vinterior.checkout.models;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Checkout {

    private List<PromotionalRule> cartPromotionalRuleList;
    private Map<Integer, PromotionalRule> itemPromotionalRuleMap;

    private Map<Integer, CheckoutItem> bucketMap;

    public Checkout(List<PromotionalRule> promotionalRuleList) {
        cartPromotionalRuleList = PromotionalRuleHandlerFactory.getCartPromoHandlers(promotionalRuleList);
        itemPromotionalRuleMap = PromotionalRuleHandlerFactory.getItemPromoHandlers(promotionalRuleList);
        bucketMap = new HashMap<>();
    }


    /**
     * Add item in bucket, increasing count
     * @param item
     */
    public void scan(Item item) {
        CheckoutItem checkoutItem = bucketMap.get(item.getProductCode());
        if(null == checkoutItem) {
            PromotionalRule rule = itemPromotionalRuleMap.get(item.getProductCode());
            checkoutItem = new CheckoutItem(item, rule);
            bucketMap.put(item.getProductCode(), checkoutItem);
        }
        checkoutItem.addItem();

    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for(CheckoutItem item: bucketMap.values()) {
            totalPrice += item.getPrice();
        }

        for(PromotionalRule cartPromoRule: cartPromotionalRuleList) {
            if(cartPromoRule.isEligibleForDiscount(totalPrice)) {
                totalPrice -= cartPromoRule.getValueType().getDiscountedPrice(totalPrice);
            }
        }
        return totalPrice;
    }
}
