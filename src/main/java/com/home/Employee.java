package com.home;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class Employee {
    private  List<Long> employeeIds = new ArrayList<>();
    private Long itsManagerId;
    private SortedSet<String> accessiblePermissions;

    public Employee(){
    }

    public Employee(List<Long> employeeIds, Long itsManagerId, SortedSet<String> accessiblePermissions){
        this.employeeIds = employeeIds;
        this.itsManagerId = itsManagerId;
        this.accessiblePermissions = accessiblePermissions;
    }

    public void addEmployeeId(Long employeeId){
        this.employeeIds.add(employeeId);
    }

    public boolean hasEmployeeId(Long employeeId){
        return this.employeeIds.contains(employeeId);
    }

    public void removeEmployeeId(Long employeeId){
        this.employeeIds.remove(employeeId);
    }

    public void setEmployees(List<Long> employeeIds){
        this.employeeIds = employeeIds;
    }

    public List<Long> getEmployeeIds(){
        return this.employeeIds;
    }

    public void setItsManager(Long managerId){
        this.itsManagerId = managerId;
    }

    public Long getItsManager(){
        return this.itsManagerId;
    }

    public void setAccessiblePermissions(SortedSet<String> permissions){
        this.accessiblePermissions = permissions;
    }

    public void addAccessiblePermissions(SortedSet<String> permissions){
        this.accessiblePermissions.addAll(permissions);
    }

    public SortedSet<String> getAccessiblePermissions(){
        return this.accessiblePermissions;
    }

}
