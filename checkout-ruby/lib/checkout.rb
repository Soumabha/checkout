require 'pry'

class Checkout
  attr_accessor :cart_promotional_rule_list, :item_promotional_rule_map

  def initialize(promotional_rule_list)
    @cart_promotional_rule_list = PromotionalRuleHandlerFactory.get_cart_promotional_list(promotional_rule_list)
    @item_promotional_rule_map = PromotionalRuleHandlerFactory.get_item_promotional_map(promotional_rule_list)
    @bucket_map = {}
  end

  def scan(item)
    item_product_code = item.product_code
    checkout_item = bucket_map[item_product_code]
    if checkout_item.nil?
      rule = item_promotional_rule_map[item_product_code]
      checkout_item = CheckoutItem.new(item, rule)
      bucket_map[item_product_code] = checkout_item
    end
    checkout_item.add_item()
  end

  def total
    total_price = 0.0
    bucket_map.values.each do |item|
      total_price += item.get_price
    end

    cart_promotional_rule_list.each do |cart_promo_rule|
      if cart_promo_rule.is_eligible_for_discount?(total_price)
        total_price -= cart_promo_rule.value_type.get_discounted_price(total_price)
      end
    end
    total_price
  end

  private
  attr_accessor :bucket_map
end