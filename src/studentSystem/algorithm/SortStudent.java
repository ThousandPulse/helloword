package studentSystem.algorithm;

public class SortStudent {
    public void sortForCourse(String[][] reg , String CourseName ,String[] CourseNameList){
        int courseIndex = 0;
        String[] t;
        for (int i = 0;i< CourseNameList.length; i++){
            if(CourseNameList[i].equals(CourseName)){
                courseIndex = i +1;
            }
        }
        if (courseIndex==0)
            return;
        for (int i = 0;i< reg.length;i++){
            for (int j = 0;j< reg.length;j++){
                if (Double.parseDouble(reg[j][courseIndex]) < Double.parseDouble(reg[j+1][courseIndex])){
                    t = reg[i];
                    reg[i] = reg[j];
                    reg[j] = t;
                }
            }
        }
    }

}
