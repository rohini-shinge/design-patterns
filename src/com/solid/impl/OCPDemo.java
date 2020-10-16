package com.solid.impl;

//Add interface so when we add new functionality we don't have to modify existing code
// Open for extension but Close for modification
interface CalculatorOperation
{
	public void perform(int a, int b);
}

class Addition implements CalculatorOperation
{
	@Override
	public void perform(int a, int b)
	{
		System.out.println(a + b);
	}

}

class Division implements CalculatorOperation
{
	@Override
	public void perform(int a, int b)
	{
		System.out.println(a / b);
	}

}

public class OCPDemo
{
	public static void main(String[] args)
	{
		CalculatorOperation addOperation = new Addition();
		addOperation.perform(5, 10);
		CalculatorOperation divOperation = new Division();
		divOperation.perform(10, 5);
	}

}
