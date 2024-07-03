import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PayRollTest {

    private Organization org;
    private Department dept1;
    private Employee emp1;
    private Employee emp2;

    @Before
    public void setUp() {
        org = new Organization("Metacube");
        dept1 = new Department("Development", 1);
        emp1 = new Developer(1, "Nalin", "Gupta", 39000.98);
        emp2 = new HR(3, "Pooja", "Saxena", 31000.027);
        org.addDepartment(dept1);
        dept1.joinDeveloper(emp1);
        dept1.joinDeveloper(emp2);
    }

    @Test
    public void testPrintEmployeeSalarySlip() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        PayRoll.printEmployeeSalarySlip(org);

        String expectedOutput = "Salary PaySlips of Metacube Employees : ";
        assertTrue(outContent.toString().contains(expectedOutput));
        assertTrue(outContent.toString().contains("Employee ID : 1"));
        assertTrue(outContent.toString().contains("Employee name : Nalin Gupta"));
        assertTrue(outContent.toString().contains("Employee Department : Developer"));
        assertTrue(outContent.toString().contains("Employee Salary : 64000.98"));
    }
}

