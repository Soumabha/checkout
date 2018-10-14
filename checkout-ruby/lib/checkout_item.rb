class CheckoutItem

  attr_reader :item, :rule, :count

  def initialize(item, rule)
    @item = item
    @rule = rule
    @count = 0
  end

  def add_item
    @count +=1
  end

  def get_price
    if !rule.nil? && rule.is_eligible_for_discount?(count)
      rule.value_type.get_discounted_price(item.price) * count
    else
      item.price * count
    end
  end

end