package com.prototype.impl;

import java.util.Arrays;

class Address implements Cloneable {

	String street, city;

	public Address(String street, String city) {
		super();
		this.street = street;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + "]";
	}

	// base class clone() is protected
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Address(street, city);
	}

}

class Person implements Cloneable {

	String[] names;
	Address address;

	public Person(String[] names, Address address) {
		super();
		this.names = names;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person : names=" + Arrays.toString(names) + " " + address.toString() + "";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Person(
				// clone() creates a shallow copy!
				/* names */ names.clone(),

				// fixes address but not names
				/* address */ // (Address) address.clone()
				address instanceof Cloneable ? (Address) address.clone() : address);
	}

}

public class PrototypeDemo {

	public static void main(String[] args) throws CloneNotSupportedException {

		Person avani = new Person(new String[] { "Avani" }, new Address("Baner", "Pune"));
		Person rohini = (Person) avani.clone();
		rohini.names[0] = "Shinge";
		System.out.println(avani);
		System.out.println(rohini);

	}

}
