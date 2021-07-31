package com.dot.freelance.common;

import java.io.Serializable;

public interface EntityID<T extends Serializable> {

	public static final String SEQ_GEN_UUID = "uuid";

	T getId();

	void setId(T id);

}
