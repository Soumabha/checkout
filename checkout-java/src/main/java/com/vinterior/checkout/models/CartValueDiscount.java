package com.vinterior.checkout.models;

import com.vinterior.checkout.RuleDiscountValue;
import com.vinterior.checkout.enums.RuleDiscountEntityType;

public class CartValueDiscount extends PromotionalRule {

    private double totalPrice;

    public CartValueDiscount(RuleDiscountValue type, double price) {
        super(type);
        totalPrice = price;
    }

    @Override
    public RuleDiscountEntityType getDiscountEntityType() {
        return RuleDiscountEntityType.CART;
    }

    @Override
    public double getRuleDiscountEntity() {
        return totalPrice;
    }


}
