package com.javatechie.spring.orm.api.dao;

import com.javatechie.spring.orm.api.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao
{
    @Autowired
    private SessionFactory sessionFactory;

    public void savePersion(Person person)
    {
            getSession().save(person);
    }

    public List<Person> getPersons()
    {
        return getSession().createCriteria(Person.class).list();
    }

    private Session getSession()
    {
        Session session = sessionFactory.getCurrentSession();

        if(session == null)
        {
            session = sessionFactory.openSession();
        }
        return session;
    }
}
