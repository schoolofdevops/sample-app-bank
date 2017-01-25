package com.glarimy.bank.biz;

import com.glarimy.bank.api.Account;
import com.glarimy.bank.api.AccountNotFoundException;
import com.glarimy.bank.api.Bank;
import com.glarimy.bank.api.BankException;
import com.glarimy.bank.api.CustomerData;
import com.glarimy.bank.api.InvalidDataException;
import com.glarimy.bank.data.JPADao;
import com.glarimy.bank.data.DAO;

public class SimpleBank implements Bank {
	private DAO dao;

	public SimpleBank() {
		dao = new JPADao();
	}

	@Override
	public int openAccount(CustomerData data) throws InvalidDataException, BankException {
		if (data == null || data.getName() == null || data.getName().trim().length() == 0 || data.getPhoneNumber() < 0)
			throw new InvalidDataException();

		Account account = new Account();
		account.setData(data);
		int number = dao.create(account);
		return number;
	}

	@Override
	public Account get(int no) throws AccountNotFoundException, BankException {
		Account account = dao.read(no);
		if (account == null)
			throw new AccountNotFoundException();
		return account;
	}

	@Override
	public void update(Account account) throws InvalidDataException, AccountNotFoundException, BankException {
		if (account.getData() == null || account.getData().getName() == null
				|| account.getData().getName().trim().length() == 0 || account.getData().getPhoneNumber() < 0)
			throw new InvalidDataException();
		dao.update(account);
	}

}
