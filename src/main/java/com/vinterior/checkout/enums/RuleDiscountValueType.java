package com.vinterior.checkout.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public enum RuleDiscountValueType {

    ABSOLUTE(1),

    PERCENTAGE(2);

    private final int enumval;

    @Setter
    private double discountValue;
}
