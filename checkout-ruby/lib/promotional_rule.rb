class PromotionalRule

  def get_discount_entity_type
    raise "Implementation necessary"
  end

  def get_rule_discount_entity
    raise "Implementation necessary"
  end

  def is_eligible_for_discount?(entity)
    entity >= get_rule_discount_entity
  end

  attr_accessor :value_type

end