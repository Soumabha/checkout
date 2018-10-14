require_relative "./promotional_rule"

class ItemValueDiscount < PromotionalRule

  attr_accessor :item_code

  def initialize(type, item, count)
    @value_type = type
    @item_code = item.product_code
    @item_count = count
  end

  def get_discount_entity_type
    RuleDiscountEntityType::ITEM
  end

  def get_rule_discount_entity
    item_count
  end

  private
  attr_accessor :item_count
end
