import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Random;

public class Circle {

    private double diameter;
    private int noLoops;
    private double [] CounterArray = {0,0};

    public Circle(double diameter, int noLoops ){

        this.diameter = diameter;
        this.noLoops = noLoops;
    }

    public Circle(double diameter){
        this.diameter = diameter;
        this.noLoops = 1000000;
    }

    public void showArea(){
        System.out.printf("Pole powierzchni koła o promieniu %.0f wynosi %.6f",diameter,getPi()*Math.pow(diameter,2));
    }

    public void showPI(){
        System.out.printf("%nPi wiliczone metodą Monte Carlo wynosi %.6f",getPi());
    }


    public double getPi(){

        for(int i = 0; i< noLoops;i++) {
            double x = getRandom();
            double y = getRandom();

            if(isInCircle(x,y,diameter)) CounterArray[0]++;
            CounterArray[1]++;
        }

        return getResult(CounterArray);

    }

    private double getResult(double [] counter){

        return 4*(counter[0]/(counter[1]));
    }

    private double getRandom(){

        Random ran = new Random();
        double a = ran.nextDouble()*diameter;
        return a;
    }

    private boolean isInCircle(double x,double y, double r)
    {
        boolean flag = false;

        if(r > (Math.sqrt(Math.pow(x,2)+Math.pow(y,2)))) flag = true;

        return flag;
    }


}
