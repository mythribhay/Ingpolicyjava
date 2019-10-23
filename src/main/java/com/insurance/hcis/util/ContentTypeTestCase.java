package com.insurance.hcis.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.insurance.hcis.exception.CommonException;

public class ContentTypeTestCase {
	private ContentTypeTestCase() {

	}

	public static String asJsonString(final Object obj) throws CommonException {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new CommonException(e.getMessage());
		}
	}

}
