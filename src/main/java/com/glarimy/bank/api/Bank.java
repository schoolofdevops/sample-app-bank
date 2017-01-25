package com.glarimy.bank.api;

public interface Bank {
	public int openAccount(CustomerData data) throws InvalidDataException, BankException;

	public Account get(int no) throws AccountNotFoundException, BankException;

	public void update(Account account) throws InvalidDataException, AccountNotFoundException, BankException;
}
