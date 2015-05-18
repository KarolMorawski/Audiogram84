package pl.edu.wat.talib84;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

/**
 * Created by Talib on 2015-05-16.
 */
public class CharActivity extends ActionBarActivity {

    private RelativeLayout mainLayout;
    private LineChart mChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char);

        //PRZECHWYCENIE DANYCH

        int[] left = getIntent().getBundleExtra("bundle").getIntArray("lewe");
        int[] right = getIntent().getBundleExtra("bundle").getIntArray("prawe");

        int x1 = left[0];
        int x2 = left[1];
        int x3 = left[2];
        int x4 = left[3];
        int x5 = left[4];
        int x6 = left[5];
        int x7 = left[6];
        int x8 = left[7];
        int x9 = left[8];

        int y1 = right[0];
        int y2 = right[1];
        int y3 = right[2];
        int y4 = right[3];
        int y5 = right[4];
        int y6 = right[5];
        int y7 = right[6];
        int y8 = right[7];
        int y9 = right[8];

        //-----------------POCZ¥TEK WYKRESU---------------------------

        mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        mChart = new LineChart(this);
        mainLayout.addView(mChart);
        mChart.setDescription("");
        mChart.setNoDataTextDescription("BRAK DANYCH!");
        mChart.setHighlightEnabled(true);
        mChart.setTouchEnabled(true);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setDrawGridBackground(false);
        mChart.setPinchZoom(true);
        mChart.setBackgroundColor(Color.WHITE);

        LineData data = new LineData();
        data.setValueTextColor(Color.WHITE);
        mChart.setData(data);
        Legend l = mChart.getLegend();
        l.setForm(Legend.LegendForm.LINE);
        l.setTextColor(Color.BLACK);

        XAxis d1 = mChart.getXAxis();
        d1.setTextColor(Color.BLACK);
        d1.setDrawGridLines(false);
        d1.setAvoidFirstLastClipping(true);

        YAxis g1 = mChart.getAxisLeft();
        g1.setTextColor(Color.BLACK);
        g1.setAxisMaxValue(120f);
        g1.setDrawGridLines(true);

        YAxis g12 = mChart.getAxisRight();
        g12.setEnabled(false);


        ArrayList<Entry> leftVals = new ArrayList<>();
        ArrayList<Entry> rightVals = new ArrayList<>();

        for (int i = 0; i < left.length; i++) {
            leftVals.add(new Entry(left[i], i));
            rightVals.add(new Entry(right[i], i));
        }

        LineDataSet setComp1 = new LineDataSet(leftVals, "LEWE UCHO");
        setComp1.setFillColor(Color.RED);
        setComp1.setColor(Color.RED);
        setComp1.setCircleColor(Color.RED);
        LineDataSet setComp2 = new LineDataSet(rightVals, "PRAWE UCHO");
        setComp2.setFillColor(Color.BLUE);
        setComp2.setColor(Color.BLUE);
        setComp2.setCircleColor(Color.BLUE);

        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        dataSets.add(setComp1);
        dataSets.add(setComp2);

        ArrayList<String> xVals = new ArrayList<>();

        for (int i = 0; i < ExaminationActivity.FREQUENCY.length; i++) {
            xVals.add(String.valueOf(ExaminationActivity.FREQUENCY[i]));
        }

        LineData data1 = new LineData(xVals, dataSets);

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setAxisMaxValue(100);
        leftAxis.setAxisMinValue(-10);
        leftAxis.setStartAtZero(false);
        leftAxis.setInverted(true);

        mChart.setDescription("dB");
        mChart.setPinchZoom(true);

        mChart.setData(data1);
        mChart.invalidate();

//-------------KONIEC WYKRESU----------------------------------------

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_char, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}