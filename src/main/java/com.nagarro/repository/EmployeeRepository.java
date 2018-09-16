package com.nagarro.repository;

import com.nagarro.models.Employee;
import com.nagarro.utils.SessionUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sanyam Goel created on 16/9/18
 */
@Repository
public class EmployeeRepository {

    @SuppressWarnings("unchecked")
    public List<Employee> getEmployees() {
        List<Employee> employees = null;

        Session session = SessionUtil.getSession();
//        Query query = session.createQuery("from Employee");
//        employees = query.list();
        employees = session.createCriteria(Employee.class).list();
        session.close();
        return employees;
    }

    public Employee getEmployee(long empCode) {
        Session session = SessionUtil.getSession();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.add(Restrictions.eq("employeeCode", empCode));
        Employee employee1 = (Employee) criteria.uniqueResult();
        session.close();
        return employee1;
    }

    public void addEmployee(Employee employee) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(employee);
        tx.commit();
        session.close();
    }

    public void updateEmployee(Employee employee) {
        Session session = SessionUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Employee.class);
            criteria.add(Restrictions.eq("employeeCode", employee.getEmployeeCode()));
            Employee employee1 = (Employee) criteria.uniqueResult();
            tx.commit();
            employee.setId(new Long(employee1.getId()));
            session.clear();
            session.beginTransaction();
            session.update(employee);
            tx.commit();
        } catch (HibernateException he) {
            System.err.println("Hibernate Exception FOUND!! ->  " + he);
        }

        session.close();
    }
}
