package org.igt.PlayerServicesManagement.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.igt.PlayerServicesManagement.model.PSMUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Transactional
@Repository
public class PSMUserDaoImpl implements PSMUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public PSMUserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	public boolean createUser(PSMUser psmUser) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(psmUser);

		return true;
	}

}
