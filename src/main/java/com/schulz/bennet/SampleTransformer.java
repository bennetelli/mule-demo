package com.schulz.bennet;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;

public class SampleTransformer extends AbstractTransformer {

	@Override
	protected Object doTransform(Object src, String enc) throws TransformerException {
		if(src == null) {
			throw new IllegalArgumentException("payload is null!");
		}
		return src;
	}

}
