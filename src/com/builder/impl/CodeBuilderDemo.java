package com.builder.impl;

class Code {

	String name;
	String type;

	public Code() {

	}

	public Code(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Code [name=" + name + ", type=" + type + "]";
	}

}

class CodeBuilder extends Code {

	Code code = new Code();

	/*
	 * public CodeBuilder(Code code) { this.code = code; }
	 */

	public CodeBuilder name(String name) {
		code.name = name;
		return this;
	}

	public CodeBuilder type(String type) {
		code.type = type;
		return this;
	}

	public Code build() {
		return this.code;
	}

}

public class CodeBuilderDemo {

	public static void main(String[] args) {
		CodeBuilder cb = new CodeBuilder();
		Code code = cb.name("Avani").type("Shinge").build();
		System.out.println(code);
	}

}
