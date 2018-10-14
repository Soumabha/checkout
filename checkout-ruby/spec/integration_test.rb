require "spec_helper"

RSpec.describe "#integration" do
  let(:item_1) { Item.new(001, "Very Cheap Chair", 9.25) }
  let(:item_2) { Item.new(002, "Little table", 45.00) }
  let(:item_3) { Item.new(003, "Funky light", 19.95) }
  let(:item_rule_discount_value) { RuleDiscountValue.new(RuleDiscountValueType::ABSOLUTE, 8.50)}
  let(:cart_rule_discount_value) { RuleDiscountValue.new(RuleDiscountValueType::PERCENTAGE, 10.00)}
  let(:promotion_rule_1) { CartValueDiscount.new(cart_rule_discount_value, 60.00) }
  let(:promotion_rule_2) { ItemValueDiscount.new(item_rule_discount_value, item_1, 2) }
  let(:promotional_rules) { [promotion_rule_1, promotion_rule_2] }
  let(:checkout) { Checkout.new(promotional_rules) }

  describe "#testcase1" do
    it 'should return the correct amount' do
      checkout.scan(item_1)
      checkout.scan(item_2)
      checkout.scan(item_3)
      expect(checkout.total).to eq (66.78)
    end
  end

  describe "#testcase2" do
    it 'should return the correct amount' do
      checkout.scan(item_1)
      checkout.scan(item_2)
      checkout.scan(item_1)
      checkout.scan(item_3)
      expect(checkout.total).to eq (73.76)
    end
  end

  describe "#testcase3" do
    it 'should return the correct amount' do
      checkout.scan(item_1)
      checkout.scan(item_3)
      checkout.scan(item_1)
      expect(checkout.total).to eq (36.95)
    end
  end


end

