import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Employee {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private List<ProjectsParticipationData> participations = new LinkedList<>();
    private int EmpID;

    public int getEmpID() {
        return EmpID;
    }

    public Employee(int empID) {
        EmpID = empID;
    }

    public List<ProjectsParticipationData> getParticipations() {
        return participations;
    }

    public void addParticipationData(ProjectsParticipationData data){
        participations.add(data);
    }

    private long convertToDays(Date firstDate, Date secondDate){
        return (firstDate.getTime() / (1000 * 60 * 60 * 24)) - (secondDate.getTime() / (1000 * 60 * 60 * 24));
    }

    public long calculateDaysSpentWIthEmployee(Employee employee){
        long daysWithThisEmployee = 0;
        for (ProjectsParticipationData data:this.participations) {
            for (ProjectsParticipationData empData:employee.getParticipations()) {
                if(data.getProjectID() == empData.getProjectID()){
                    if(data.getDateFrom().after(empData.getDateFrom()) && data.getDateFrom().before(empData.getDateTo())) {
                        if(data.getDateTo().after(empData.getDateTo())){
                            daysWithThisEmployee+= convertToDays(empData.getDateTo(),data.getDateFrom());
                            System.out.println("1 : "+sdf.format(data.getDateFrom())+" "+sdf.format(data.getDateTo()));
                            System.out.println("1 : "+sdf.format(empData.getDateFrom())+" "+sdf.format(empData.getDateTo()));
                        } else {
                            daysWithThisEmployee+= convertToDays(data.getDateTo(),data.getDateFrom());
                            System.out.println("2 : "+sdf.format(data.getDateFrom())+" "+sdf.format(data.getDateTo()));
                            System.out.println("2 : "+sdf.format(empData.getDateFrom())+" "+sdf.format(empData.getDateTo()));
                        }
                    }else if(empData.getDateFrom().after(data.getDateFrom()) && empData.getDateFrom().before(data.getDateTo())){
                            if(empData.getDateTo().after(data.getDateTo())){
                                daysWithThisEmployee+= convertToDays(data.getDateTo(),empData.getDateFrom());
                                System.out.println("3 : "+sdf.format(data.getDateFrom())+" "+sdf.format(data.getDateTo()));
                                System.out.println("3 : "+sdf.format(empData.getDateFrom())+" "+sdf.format(empData.getDateTo()));
                            } else {
                                daysWithThisEmployee+= convertToDays(empData.getDateTo(),empData.getDateFrom());
                                System.out.println("4 : "+sdf.format(data.getDateFrom())+" "+sdf.format(data.getDateTo()));
                                System.out.println("4 : "+sdf.format(empData.getDateFrom())+" "+sdf.format(empData.getDateTo()));
                            }
                    } else if(data.getDateFrom().equals(empData.getDateFrom())){
                            if(data.getDateTo().after(empData.getDateTo())){
                                daysWithThisEmployee+= convertToDays(empData.getDateTo(),data.getDateFrom());
                                System.out.println("SAME START DATE DT after ET"+sdf.format(data.getDateFrom())+" "+sdf.format(data.getDateTo()));
                                System.out.println("SAME START DATE DT after ET"+sdf.format(empData.getDateFrom())+" "+sdf.format(empData.getDateTo()));
                            } else {
                                daysWithThisEmployee+= convertToDays(data.getDateTo(),data.getDateFrom());
                                System.out.println("SAME START DATE DT <= ET"+sdf.format(data.getDateFrom())+" "+sdf.format(data.getDateTo()));
                                System.out.println("SAME START DATE DT <= ET"+sdf.format(empData.getDateFrom())+" "+sdf.format(empData.getDateTo()));
                            }
                    } else{
                        System.out.println("DIFFERENT TIME SAME PROJ");
                        System.out.println(sdf.format(data.getDateFrom())+" "+sdf.format(data.getDateTo()));
                        System.out.println(sdf.format(empData.getDateFrom())+" "+sdf.format(empData.getDateTo()));
                    }
                } else {
                    System.out.println("DIFFERENT PROJ");
                    System.out.println(sdf.format(data.getDateFrom())+" "+sdf.format(data.getDateTo()));
                    System.out.println(sdf.format(empData.getDateFrom())+" "+sdf.format(empData.getDateTo()));
                }
            }
        }
        return daysWithThisEmployee;
    }
}
