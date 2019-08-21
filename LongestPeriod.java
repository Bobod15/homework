import java.util.*;

public class LongestPeriod {
    private List<ProjectsParticipationData> sort(List<ProjectsParticipationData> list){
        list.sort(Comparator.comparing(ProjectsParticipationData::getEmpID));
        return list;
    }

    public long compare(Employee emp1, Employee emp2){
        return emp1.calculateDaysSpentWIthEmployee(emp2);
    }

    public String findPairOfEmployeesWithMostHoursSpentTogether(List<ProjectsParticipationData> dataList){
        List<Employee> employeeList = establishEmployees(dataList);
        long maxDays = 0;
        Employee tempEmp = null;
        Employee tempSecondEmp = null;
        long temp = 0;
        for (Employee emp:employeeList) {
            for (Employee secondEmp:employeeList) {
                if(emp.getEmpID() < secondEmp.getEmpID()) {
                    if (maxDays < (temp = compare(emp, secondEmp))) {
                        maxDays = temp;
                        tempEmp = emp;
                        tempSecondEmp = secondEmp;
                    }
                }
            }
        }
        if(tempEmp!=null && tempSecondEmp!=null) {
            return "Employee ID:"+tempEmp.getEmpID()+" and employee ID:"+tempSecondEmp.getEmpID()+" spent "+maxDays+" together";
        }
        return "0";
    }

    public List<Employee> establishEmployees(List<ProjectsParticipationData> dataList){
        dataList = this.sort(dataList);
        List<Employee> employees = new LinkedList<>();
        int currentID = dataList.get(0).getEmpID();
        employees.add(new Employee(currentID));
        int currentIndex = 0;
        for (ProjectsParticipationData data:dataList) {
            if(currentID == data.getEmpID()){
                employees.get(currentIndex).addParticipationData(data);
            } else {
                currentID = data.getEmpID();
                employees.add(new Employee(currentID));
                currentIndex++;
                employees.get(currentIndex).addParticipationData(data);
            }
        }
        return employees;
    }
}
