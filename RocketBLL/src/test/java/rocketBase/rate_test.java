package rocketBase;

import static org.junit.Assert.*;



import org.junit.Test;

import exceptions.RateException;

public class rate_test {


	@Test
	public void RateTest1() throws RateException {
		assertEquals(RateBLL.getRate(750),5.75,0.001);
	}
	
	@Test (expected=RateException.class)
	public void RateTest2() throws RateException{
		RateBLL.getRate(100);
	}
	@Test
	public void paymenttest(){
		assertTrue(RateBLL.getPayment(300000.00,0.00,360.00,0.04,false)==1432.25);
	}
}
