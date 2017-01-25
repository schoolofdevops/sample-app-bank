package com.glarimy.bank.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.glarimy.bank.api.Account;

public class JPADao implements DAO {
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("bank");

	@Override
	public int create(Account account) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(account);
		em.getTransaction().commit();
		em.close();
		return account.getNumber();
	}

	@Override
	public Account read(int number) {
		EntityManager em = factory.createEntityManager();
		Account account = em.find(Account.class, number);
		em.close();
		return account;
	}

	@Override
	public void update(Account account) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.merge(account);
		em.getTransaction().commit();
		em.close();
	}
}
