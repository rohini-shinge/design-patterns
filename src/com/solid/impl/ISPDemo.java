package com.solid.impl;

class Document
{}

interface Machine
{
	void print(Document d);

	void fax(Document d) throws Exception;

	void scan(Document d) throws Exception;
}

// ok if you need a multifunction machine
class MultiFunctionPrinter implements Machine
{
	@Override
	public void print(Document d)
	{
		//
	}

	@Override
	public void fax(Document d)
	{
		//
	}

	@Override
	public void scan(Document d)
	{
		//
	}
}

class OldFashionedPrinter implements Machine
{
	@Override
	public void print(Document d)
	{
		// yep
	}

	@Override
	public void fax(Document d) throws Exception
	{
		throw new Exception();
	}

	@Override
	public void scan(Document d) throws Exception
	{
		throw new Exception();
	}
}

interface Printer
{
	void Print(Document d) throws Exception;
}

interface IScanner
{
	void Scan(Document d) throws Exception;
}

class JustAPrinter implements Printer
{
	@Override
	public void Print(Document d)
	{

	}
}

class Photocopier implements Printer, IScanner
{
	@Override
	public void Print(Document d) throws Exception
	{
		throw new Exception();
	}

	@Override
	public void Scan(Document d) throws Exception
	{
		throw new Exception();
	}
}

interface MultiFunctionDevice extends Printer, IScanner //
{

}

class MultiFunctionMachine implements MultiFunctionDevice
{
	// compose this out of several modules
	private Printer		printer;
	private IScanner	scanner;

	public MultiFunctionMachine(Printer printer, IScanner scanner)
	{
		this.printer = printer;
		this.scanner = scanner;
	}

	@Override
	public void Print(Document d) throws Exception
	{
		printer.Print(d);
	}

	@Override
	public void Scan(Document d) throws Exception
	{
		scanner.Scan(d);
	}
}
