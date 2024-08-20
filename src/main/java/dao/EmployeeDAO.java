package dao;

import model.Employee;
import org.hibernate.*;
import util.HibernateUtil;

import java.util.List;
import java.util.logging.*;

public class EmployeeDAO {

    private static final Logger logger = Logger.getLogger(EmployeeDAO.class.getName());
    public void saveEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.log(Level.SEVERE, "Error saving employee", e);
        }
    }

    public Employee getEmployee(int id) {
        Employee employee = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            employee = session.get(Employee.class, id);
            logger.info("Employee retrieved successfully: " + employee.getFirstName() + " " + employee.getLastName());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error retrieving employee with ID: " + id, e);
        }
        return employee;
    }

    public List<Employee> getAllEmployees() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            logger.info("Retrieving all employees");
            return session.createQuery("from Employee", Employee.class).list();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error retrieving all employees", e);
            return null;
        }
    }

    public void updateEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(employee);
            transaction.commit();
            logger.info("Employee updated successfully");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.log(Level.SEVERE, "Error updating employee", e);
        }
    }

    public void deleteEmployee(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.remove(employee);
                transaction.commit();
                logger.info("Employee deleted successfully");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.log(Level.SEVERE, "Error deleting employee with ID: " + id, e);
        }
    }
}
