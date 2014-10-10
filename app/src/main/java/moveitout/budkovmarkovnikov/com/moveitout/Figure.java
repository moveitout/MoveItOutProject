package moveitout.budkovmarkovnikov.com.moveitout;

import java.util.ArrayList;

/**
 * Created by Ser on 09.10.2014.
 */
public class Figure {

    public ArrayList<MyPoint> points;
    public int num;

    public Figure(int a,ArrayList<MyPoint> x){
        this.points = x;
        this.num = a;
    }

    public void addMyPoint(MyPoint p){
        this.points.add(p);
    }
}
