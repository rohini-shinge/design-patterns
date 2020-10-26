package com.singleton.impl;

class BasicSingleton
{
	private BasicSingleton()
	{

	}

	private static BasicSingleton INSTANCE = new BasicSingleton();

	public static BasicSingleton getInstace()
	{
		return INSTANCE;
	}

	private int value;

	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

}

public class BasicSingletonDemo
{
	public static void main(String[] args)
	{
		BasicSingleton basicSingleton = BasicSingleton.getInstace();
		basicSingleton.setValue(2953);
		System.out.println(basicSingleton.getValue());
	}
}
