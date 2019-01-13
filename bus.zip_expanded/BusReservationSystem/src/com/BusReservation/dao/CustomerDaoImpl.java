package com.BusReservation.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BusReservation.model.AuthorizedUser;
import com.HibernateUtil.HibernateUtil;
@Repository
public class CustomerDaoImpl  implements ICustomerDao {
 static Transaction tcx ;
private SessionFactory sessionFactory;
	
@Autowired // if annotated as repository then dont need to put entries in .xml
public void setSessionFactory(SessionFactory sf) {
    this.sessionFactory = sf;
}

	@Override
	public List<AuthorizedUser> fetchPassword(String email) {
		
		return null;
	}

	@Override
	public void AddUser(AuthorizedUser authuser) {
	
        Session session = this.sessionFactory.openSession();
        tcx = session.beginTransaction();
      
        session.save(authuser);
        tcx.commit();
        session.close();
		
	}

}
