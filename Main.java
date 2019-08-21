import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        ProjectsParticipationData data1 = new ProjectsParticipationData(1,1,
//                format.parse("2010-1-1"),format.parse("2010-1-8"));
//        ProjectsParticipationData data2 = new ProjectsParticipationData(2,1,
//                format.parse("2010-1-2"),format.parse("2010-1-4"));
//        ProjectsParticipationData data3 = new ProjectsParticipationData(3,1,
//                format.parse("2010-1-2"),format.parse("2010-1-6"));
//        ProjectsParticipationData data4 = new ProjectsParticipationData(1,1,
//                format.parse("2010-1-3"),format.parse("2010-1-7"));
//        ProjectsParticipationData data5 = new ProjectsParticipationData(3,2,
//                format.parse("2010-1-2"),format.parse("2010-1-6"));
//
//        List<ProjectsParticipationData> listData = new LinkedList<>();
//        listData.add(data1);
//        listData.add(data2);
//        listData.add(data3);
//        listData.add(data4);
//        listData.add(data5);
//
//
//
        LongestPeriod longestPeriod = new LongestPeriod();
        CSVReader csvReader = new CSVReader();
//
//
        System.out.println("Days :" +longestPeriod.findPairOfEmployeesWithMostHoursSpentTogether(csvReader.readCSV("./ParticipationSheet.csv")));
//
//        for (ProjectsParticipationData data:csvReader.readCSV("asd")) {
//            System.out.println(data.getDateFrom());
//        }


    }
}
