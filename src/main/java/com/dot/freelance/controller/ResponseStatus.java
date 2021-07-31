package com.dot.freelance.controller;

// @formatter:off
public enum ResponseStatus {

	// SUCCESS
	GENERAL_SUCCESS(1000, "General Success"),
	ACCOUNT_CREATED(1001, "Account Created"),
	DATA_CREATED(1002, "Data Created"),

	FORBIDDEN(2403, "Forbidden, Request Refused"),

	// ERROR
	GENERAL_NOT_FOUND(9000, "Data Not Found"),
	GENERAL_WARN(4000, "General Warning"),
	GENERAL_ERROR(5000, "General Error");


	ResponseStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}

	private final int code;
	private final String message;

	public int getCode() {
		return code;
	}

	public String getCodeString() {
		return String.valueOf(this.code);
	}

	public String getMessage() {
		return message;
	}

	public Type type() {
		return Type.valueOf(this);
	}

	public enum Type {

		SUCCESS(1), FAIL(2), INFO(3), WARN(4), ERROR(5);

		Type(int code) {
			this.code = code;
		}

		private final int code;

		public int getCode() {
			return code;
		}

		public static Type valueOf(int code) {
			int typeCode = code / 1000;
			for (Type type : values()) {
				if (type.code == typeCode) {
					return type;
				}
			}
			throw new IllegalArgumentException("No matching ResponseStatus.Type for [" + code + "]");
		}

		public static Type valueOf(ResponseStatus status) {
			return valueOf(status.code);
		}

	}
	
	public String toJsonString() {
		StringBuilder json = new StringBuilder();
		json.append("{");
			json.append("\"code\"").append(":").append(this.code).append(",");
			json.append("\"message\"").append(":").append("\""+ this.message +"\"");
		json.append("}");
		return json.toString();
	}

}
//@formatter:on
