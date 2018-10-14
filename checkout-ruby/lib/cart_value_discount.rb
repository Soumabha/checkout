require_relative "./promotional_rule"
class CartValueDiscount < PromotionalRule

  def initialize(type, price)
    @value_type = type
    @total_price = price
  end

  def get_discount_entity_type
    RuleDiscountEntityType::CART
  end

  def get_rule_discount_entity
    total_price
  end

  private
  attr_accessor :total_price
end