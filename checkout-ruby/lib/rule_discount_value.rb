class RuleDiscountValue

  attr_reader :rule_discount_value_type, :discount_value

  def initialize(rule_discount_value_type, discount_value)
    @discount_value = discount_value
    @rule_discount_value_type = rule_discount_value_type
  end

  def get_discounted_price(price)
    discount = 0.0
    if rule_discount_value_type == RuleDiscountValueType::PERCENTAGE
      discount = (price * discount_value)/100.00
    elsif rule_discount_value_type == RuleDiscountValueType::ABSOLUTE
      discount = discount_value
    end
    discount.floor(2)
  end


end