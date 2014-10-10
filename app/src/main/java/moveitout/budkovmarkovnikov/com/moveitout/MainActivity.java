package moveitout.budkovmarkovnikov.com.moveitout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    final int width = 60;
    final int height = 80;
    static Level sendLevel;

    TextView t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }


    Level getLevel(int num) {
        ArrayList<Pin> pins = new ArrayList<Pin>();
        ArrayList<Figure> figures = new ArrayList<Figure>();
        String[] level = new String[81];
        if (num == 1) {
            level = getResources().getStringArray(R.array.levelOne);
        }
        String[] splits;
        splits = level[0].split(" ");
        int figNum = Integer.parseInt(splits[1]);

        for (int i = 0; i < figNum; i++) {
            figures.add(new Figure(i, new ArrayList<MyPoint>()));
        }
        for (int i = 1; i < height + 1; i++) {
            for (int j = 0; j < width; j++) {

                //pin found
                if (level[i].charAt(j) == '1') {
                    MyPoint x = new MyPoint(j, i - 1, Color.GREEN);
                    Pin a = new Pin(x);
                    pins.add(a);
                }

                //some figure found
                if (level[i].charAt(j) > '1' && level[i].charAt(j) <= '9') {
                    String rS = "" + level[i].charAt(j);
                    int tNum = Integer.parseInt(rS);
                    figures.get(tNum - 2).addMyPoint(new MyPoint(j, i - 1, getColor(tNum - 2)));
                }
            }
        }
        return new Level(num, pins, figures);
    }


    public void levelTest(View v){
        parseAndSend(1);
    }

    public void parseAndSend(int x){
        sendLevel = getLevel(x);
        Intent intent = new Intent(this, LevelActivity.class);
        startActivity(intent);
    }

    public int getColor(int x) {
        if (x == 0) {
            return Color.YELLOW;
        }
        return Color.GREEN;
    }

}
