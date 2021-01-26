package studentSystem.algorithm;

public class MaxValue {
    public static int maxResult(String[][] result , String CourseName ,String[] CourseNameList){
        int courseIndex = 0;
        int maxResultIndex = 0;
        double maxResult =0.0;
        for (int i = 0;i< CourseNameList.length; i++){
            if(CourseNameList[i].equals(CourseName)){
                courseIndex = i +1;
            }
        }
        if (courseIndex==0)
            return maxResultIndex;
        for (String[] strings : result) {
            if (maxResult < Double.parseDouble(strings[courseIndex])) {
                maxResult = Double.parseDouble(strings[courseIndex]);
            }
        }
        for (String[] strings : result) {
            if (maxResult == Double.parseDouble(strings[courseIndex])) {
                break;
            }
            maxResultIndex++;
        }
        return maxResultIndex;
    }
}
