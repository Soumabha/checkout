package com.vinterior.checkout.models;

import com.vinterior.checkout.enums.RuleDiscountEntityType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromotionalRuleHandlerFactory {


    public static List<PromotionalRule> getCartPromoHandlers(List<PromotionalRule> promotionalRuleList) {
        List<PromotionalRule> cartPromotionalRuleList = new ArrayList<>();
        for(PromotionalRule promotionalRule: promotionalRuleList) {
            if (promotionalRule.getDiscountEntityType().equals(RuleDiscountEntityType.CART)) {
                cartPromotionalRuleList.add(promotionalRule);
            }
        }
        return cartPromotionalRuleList;
    }

    public static Map<Integer, PromotionalRule> getItemPromoHandlers(List<PromotionalRule> promotionalRuleList) {
        Map<Integer, PromotionalRule> itemPromotionalRuleMap = new HashMap<>();
        for(PromotionalRule promotionalRule: promotionalRuleList) {
            if (promotionalRule.getDiscountEntityType().equals(RuleDiscountEntityType.ITEM)) {
                ItemValueDiscount valueDiscount = (ItemValueDiscount) promotionalRule;
                itemPromotionalRuleMap.put(valueDiscount.getItemCode(), promotionalRule);
            }
        }
        return itemPromotionalRuleMap;
    }
}
