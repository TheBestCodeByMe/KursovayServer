package database;

import entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SQLEmployeeTest {
    private static SQLEmployee sqlEmployee;
    private static Employee employee;

    @BeforeEach
    void setUp() {
        sqlEmployee = new SQLEmployee();
        employee = new Employee("1", "1", "1");
    }

    @Test
    void testSelectIdEmpl() {
        Assertions.assertEquals(1, sqlEmployee.selectIdEmpl(employee));
    }
}