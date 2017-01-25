package com.glarimy.bank.data;

import com.glarimy.bank.api.Account;

public interface DAO {
	int create(Account account);

	Account read(int number);

	void update(Account account);
}