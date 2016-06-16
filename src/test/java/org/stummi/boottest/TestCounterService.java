package org.stummi.boottest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.stummi.boottest.service.CounterService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Main.class)
public class TestCounterService {

	@Autowired
	private CounterService service;

	@Test
	public void testCreateAndIncrementCounter() {
		Assert.assertEquals(0, service.incrementAndGet("foo"));
		Assert.assertEquals(1, service.incrementAndGet("foo"));
		Assert.assertEquals(0, service.incrementAndGet("bar"));
		Assert.assertEquals(2, service.incrementAndGet("foo"));
		Assert.assertEquals(1, service.incrementAndGet("bar"));
	}

}
