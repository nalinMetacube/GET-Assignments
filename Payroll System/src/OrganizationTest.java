import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrganizationTest {
    
    private Organization org;
    private Department dept1;
    private Department dept2;
    private Employee emp1;
    private Employee emp2;

    @Before
    public void setUp() {
        org = new Organization("Metacube");
        dept1 = new Department("Development", 1);
        dept2 = new Department("Human Resources", 2);
        emp1 = new Developer(1, "Nalin", "Gupta", 39000.98);
        emp2 = new HR(3, "Pooja", "Saxena", 31000.027);
    }

    @Test
    public void testAddDepartment() {
        assertTrue(org.addDepartment(dept1));
        assertEquals(1, org.allDepartments.size());
    }

    @Test
    public void testJoinAndRelieveEmployee() {
        org.addDepartment(dept1);
        assertTrue(dept1.joinDeveloper(emp1));
        assertTrue(dept1.getEmployees().contains(emp1));
        
        assertTrue(dept1.relieveDeveloper(emp1));
        assertFalse(dept1.getEmployees().contains(emp1));
    }

    @Test
    public void testRemoveDepartment() {
        org.addDepartment(dept1);
        assertTrue(org.removeDepartment(dept1));
        assertEquals(0, org.allDepartments.size());
    }
}