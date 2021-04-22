package leetcode.google;

import java.util.*;

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> idToEmpMapping = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            idToEmpMapping.put(employee.id, employee);
        }
        if (!idToEmpMapping.containsKey(id)) return 0;
        Queue<Integer> employeeIdsQueue = new LinkedList<>();
        employeeIdsQueue.add(id);
        int cost = 0;
        while (!employeeIdsQueue.isEmpty()) {
            Integer empId = employeeIdsQueue.poll();
            Employee currEmployee = idToEmpMapping.get(empId);
            cost += currEmployee.importance;
            employeeIdsQueue.addAll(currEmployee.subordinates);
        }
        return 0;
    }

    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}

