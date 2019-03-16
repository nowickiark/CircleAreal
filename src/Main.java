import java.util.Random;

public class Main {

    public static void main(String[] args) {

        double diameter = 1;
        int noLoops = 1000000000;
        double [] CounterArray = {0,0};

        for(int i = 0; i< noLoops;i++) {
            double x = getRandom();
            double y = getRandom();

            if(isInCircle(x,y,diameter)) CounterArray[0]++;
            CounterArray[1]++;
        }

        System.out.printf("Pole powierzchni koła o promieniu %.0f wynosi %.6f",diameter,getResult(CounterArray));

    }

    public static double getResult(double [] counter){

        return 4*(counter[0]/(counter[0]+counter[1]));
    }


    public static double getRandom(){

        Random ran = new Random();
        double a = ran.nextDouble();
        return a;
    }

    public static boolean isInCircle(double x,double y, double r)
    {
        boolean flag = false;

        if(r > (Math.sqrt(Math.pow(x,2)+Math.pow(y,2)))) flag = true;

        return flag;
    }


}
