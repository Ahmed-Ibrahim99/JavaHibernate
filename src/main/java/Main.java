import dao.EmployeeDAO;
import model.Employee;
import util.HibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        // Create new Employee
        Employee employee = new Employee("John", "Doe", "john.doe@example.com");
        employeeDAO.saveEmployee(employee);

        // Read Employee
        Employee retrievedEmployee = employeeDAO.getEmployee(employee.getId());
        System.out.println("Employee: " + retrievedEmployee.getFirstName() + " " + retrievedEmployee.getLastName());

        // Update Employee
        retrievedEmployee.setFirstName("Jane");
        employeeDAO.updateEmployee(retrievedEmployee);

        // Get All Employees
        List<Employee> employees = employeeDAO.getAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp.getFirstName() + " " + emp.getLastName() + " - " + emp.getEmail());
        }

        // Delete Employee
        employeeDAO.deleteEmployee(employee.getId());

        // Shutdown Hibernate
        HibernateUtil.shutdown();
    }
}
