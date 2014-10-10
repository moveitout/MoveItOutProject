package moveitout.budkovmarkovnikov.com.moveitout;

import java.util.ArrayList;

/**
 * Created by Ser on 09.10.2014.
 */
public class Level {

    public int number;
    public ArrayList<Pin> pins;
    public ArrayList<Figure> figures;

    public Level(int num,ArrayList<Pin> mPins,ArrayList<Figure>mFig){
       this.number = num;
       this.figures = mFig;
       this.pins = mPins;
    }
}
