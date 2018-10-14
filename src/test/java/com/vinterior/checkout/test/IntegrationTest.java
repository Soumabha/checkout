package com.vinterior.checkout.test;

import com.vinterior.checkout.RuleDiscountValue;
import com.vinterior.checkout.enums.RuleDiscountValueType;
import com.vinterior.checkout.models.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class IntegrationTest {

	public static Item ITEM_1 = new Item(1, "Very Cheap Chair", 9.25);
	public static Item ITEM_2 = new Item(2, "Little table", 45.00);
	public static Item ITEM_3 = new Item(3, "Funky light", 19.95);

	public static PromotionalRule PROMO_RULE_1 = new CartValueDiscount(new RuleDiscountValue(RuleDiscountValueType.PERCENTAGE, 10.00),60.00);
	public static PromotionalRule PROMO_RULE_2 = new ItemValueDiscount(new RuleDiscountValue(RuleDiscountValueType.ABSOLUTE, 8.50), ITEM_1, 2);

	private static List<PromotionalRule> promotionalRules;

	@BeforeClass
	public static void initialisePromotionalRules() {
		promotionalRules = new ArrayList<>();
		promotionalRules.add(PROMO_RULE_1);
		promotionalRules.add(PROMO_RULE_2);
	}

	/** 
	* Output: price: 66.78
	* Input : Basket: 001,002,003
	*/
	@Test
	public void testcase1() {
		print("Started testcase1");
		double outputPrice = 66.78;
		Checkout c = new Checkout(promotionalRules);
		c.scan(ITEM_1);
		c.scan(ITEM_2);
		c.scan(ITEM_3);
		double evaluatedPrice = c.getTotalPrice();
		Assert.assertEquals(outputPrice, evaluatedPrice, 0.0);
		print("Successfully terminated testcase1");

	}

	/** 
	* Output: price : 73.76
	* Input : Basket: 001,002,001,003
	*/
	@Test
	public void testcase2() {
		print("Started testcase2");
		double outputPrice = 73.76;
		Checkout c = new Checkout(promotionalRules);
		c.scan(ITEM_1);
		c.scan(ITEM_2);
		c.scan(ITEM_1);
		c.scan(ITEM_3);
		double evaluatedPrice = c.getTotalPrice();
		Assert.assertEquals(evaluatedPrice, outputPrice, 0.0);
		print("Successfully terminated testcase2");

	}

	/** 
	* Output: Total price expected: £36.95
	* Input : Basket: 001,003,001
	*/
	@Test
	public void testcase3() {
		print("Started testcase3");
		double outputPrice = 36.95;
		Checkout c = new Checkout(promotionalRules);
		c.scan(ITEM_1);
		c.scan(ITEM_3);
		c.scan(ITEM_1);
		double evaluatedPrice = c.getTotalPrice();
		Assert.assertEquals(evaluatedPrice, outputPrice, 0.0);
		print("Successfully terminated testcase3");

	}

	protected void print(Object message) {
		System.out.println(message);
	}

}
