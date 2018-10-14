package com.vinterior.checkout;

import com.vinterior.checkout.enums.RuleDiscountValueType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Getter
@AllArgsConstructor
public class RuleDiscountValue {

   private RuleDiscountValueType ruleDiscountValueType;

   private double ruleDiscountValue;

   public double getDiscountedPrice(double price) {
      double discount = 0.0;
      DecimalFormat df = new DecimalFormat("0.00");
      df.setRoundingMode(RoundingMode.FLOOR);
      if(ruleDiscountValueType.equals(RuleDiscountValueType.PERCENTAGE)) {
         discount = (price * ruleDiscountValue)/100;
      } else if(ruleDiscountValueType.equals(RuleDiscountValueType.ABSOLUTE)) {
         discount = ruleDiscountValue;
      }
      return Double.parseDouble(df.format(discount));
   }
}
