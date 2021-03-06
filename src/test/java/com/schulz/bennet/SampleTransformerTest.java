package com.schulz.bennet;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.mule.api.transformer.TransformerException;

public class SampleTransformerTest {

	@Test
	public void shouldThrowException(){
		SampleTransformer transformer = new SampleTransformer();
		try {
			transformer.doTransform(null, null);
			fail();
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("payload is null!", e.getMessage());
		} catch (TransformerException e) {
			fail();
		}
	}
	
	@Test
	public void shouldReturnSamePayload() throws TransformerException {
		SampleTransformer transformer = new SampleTransformer();
		String payload = (String) transformer.doTransform("lala", null);
		Assert.assertEquals("lala", payload);
	}
}
