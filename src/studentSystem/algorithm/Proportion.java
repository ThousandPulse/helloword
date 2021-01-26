package studentSystem.algorithm;

public class Proportion {
    public static double outstanding(double[] result){
        double outstandingInResult = 0;
        for(double a :result){
            if (a>80){
                outstandingInResult++;
            }
        }

        return outstandingInResult/result.length;
    }
    public static double fail(double[] result){
        double failInResult = 0;
        for(double a :result){
            if (a<60){
                failInResult++;
            }
        }

        return failInResult/result.length;
    }
}
