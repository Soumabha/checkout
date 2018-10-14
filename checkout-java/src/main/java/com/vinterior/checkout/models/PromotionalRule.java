package com.vinterior.checkout.models;

import com.vinterior.checkout.RuleDiscountValue;
import com.vinterior.checkout.enums.RuleDiscountEntityType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class PromotionalRule {

    abstract RuleDiscountEntityType getDiscountEntityType();

    protected RuleDiscountValue valueType;

    abstract double getRuleDiscountEntity();

    public boolean isEligibleForDiscount(double entity) {
        return entity >= getRuleDiscountEntity();
    }

}
