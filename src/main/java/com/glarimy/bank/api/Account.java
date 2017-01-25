package com.glarimy.bank.api;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Account {
	@Id
	@GeneratedValue
	protected int number;
	protected double balance;
	@OneToOne(cascade = CascadeType.ALL)
	protected CustomerData data;

	public Account() {
	}

	public Account(int number, double balance, CustomerData data) {
		super();
		this.number = number;
		this.balance = balance;
		this.data = data;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public CustomerData getData() {
		return data;
	}

	public void setData(CustomerData data) {
		this.data = data;
	}

}
