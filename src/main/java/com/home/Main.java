package com.home;

import java.io.InputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        String result = doHomework(System.in);
        System.out.println(result);

    }

    public static String doHomework(InputStream reader){
        Scanner input = new Scanner(reader);
        Long number = Long.parseLong(input.nextLine());
        Long i;
        HashMap<Long, Employee> employees = new HashMap<>();
        Employee CEO = new Employee();
        String permissionsString = input.nextLine();
        String[] permissions = permissionsString.split(" ");
        List<String> permissionsList = Arrays.asList(permissions);
        SortedSet<String> permissionsSet = new TreeSet<>(permissionsList);
        CEO.setAccessiblePermissions(permissionsSet);
        //CEO.setAccessiblePermissions(new TreeSet<>(Arrays.asList(input.nextLine().split(" "))));
        employees.put(0L, CEO);
        for (i = 1L; i <= number; i++)
        {
            Employee employee = new Employee();
            employee.setAccessiblePermissions(new TreeSet<>(Arrays.asList(input.nextLine().split(" "))));
            employees.put(i, employee);
        }

        for (i = 1L; i <= number; i++)
        {
            String managerString = input.nextLine();
            Long managerId;
            if (managerString.equals("CEO")){
                managerId = 0L;
            }
            else {
                managerId = Long.parseLong(managerString);
            }
            Employee employee = employees.get(i);
            employee.setItsManager(managerId);
            employees.put(i, employee);
            Employee manager = employees.get(managerId);
            manager.addEmployeeId(i);
            employees.put(managerId, manager);
        }

        while (true) {
            boolean isFinished = true;
            for (Map.Entry<Long, Employee>  entry : employees.entrySet()){
                Long id = entry.getKey();
                Employee employee = entry.getValue();
                if (employee.getEmployeeIds().isEmpty() && (employee.getItsManager() != null)){
                    Employee manager = employees.get(employee.getItsManager());
                    manager.removeEmployeeId(id);
                    employee.setItsManager(null);
                    manager.addAccessiblePermissions(employee.getAccessiblePermissions());
                }
                else if (!employee.getEmployeeIds().isEmpty()){
                    isFinished = false;
                }
            }
            if (isFinished) break;
        }
        StringBuilder stringBuilder = new StringBuilder();

        for (i = 0L; i <= number; i++) {
            SortedSet<String> accessiblePermissions = employees.get(i).getAccessiblePermissions();
            String output = String.join(", ", accessiblePermissions);
            stringBuilder.append(output).append("\n");
        }
        return stringBuilder.toString();
    }
}
