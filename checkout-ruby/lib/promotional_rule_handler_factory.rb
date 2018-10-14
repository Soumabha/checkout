class PromotionalRuleHandlerFactory

  def self.get_cart_promotional_list(promotional_rules)
    cart_promotional_list = []
    promotional_rules.each do |promotional_rule|
      if promotional_rule.get_discount_entity_type == RuleDiscountEntityType::CART
        cart_promotional_list << promotional_rule
      end
    end
    cart_promotional_list
  end


  def self.get_item_promotional_map(promotional_rules)
    item_promotional_map = {}
    promotional_rules.each do |promotional_rule|
      if promotional_rule.get_discount_entity_type == RuleDiscountEntityType::ITEM
        item_promotional_map[promotional_rule.item_code] = promotional_rule
      end
      item_promotional_map
    end
  end

end