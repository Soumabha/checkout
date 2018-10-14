package com.vinterior.checkout.models;

import com.vinterior.checkout.RuleDiscountValue;
import com.vinterior.checkout.enums.RuleDiscountEntityType;
import lombok.Getter;

public class ItemValueDiscount extends PromotionalRule {

    @Getter
    private Integer itemCode;

    private int itemCount;

    public ItemValueDiscount(RuleDiscountValue ruleDiscountValue, Item item, int count) {
        super(ruleDiscountValue);
        itemCode = item.getProductCode();
        itemCount = count;
    }
    @Override
    public RuleDiscountEntityType getDiscountEntityType() {
        return RuleDiscountEntityType.ITEM;
    }

    @Override
    public double getRuleDiscountEntity() {
        return itemCount;
    }

}
