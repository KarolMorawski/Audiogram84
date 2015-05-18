package pl.edu.wat.talib84;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Talib on 2015-05-16.
 */
public class ResultActivity extends ActionBarActivity {

    private TextView textExamination;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int[] left = getIntent().getBundleExtra("bundle").getIntArray("left");
        int[] right = getIntent().getBundleExtra("bundle").getIntArray("right");

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







        int wynik=0;
        int wynik2=0;

        if (Math.abs(x2-x4)>40)
        {
            wynik = (x2+x3+x4+x6) / 4;
        }
        else if (Math.abs(x2-x4)<=40 && x6>=x4)
        {
            wynik = (x2+x3+x6)/3;
        }
        else
        {
            wynik = (x1+x2+x3) / 3;
        }




        if (Math.abs(y2-y4)>40)
        {
            wynik2 = (y2+y3+y4+y6) / 4;
        }
        else if (Math.abs(y2-y4)<=40 && y6>=y4)
        {
            wynik2 = (y2+y3+y6)/3;
        }
        else
        {
            wynik2 = (y1+y2+y3) / 3;
        }

        textExamination = (TextView) findViewById(R.id.textView11);
        textExamination.setText(String.format("LEWE UCHO: %d dB", wynik));

        textExamination = (TextView) findViewById(R.id.textView12);
        textExamination.setText(String.format("PRAWE UCHO: %d dB", wynik2));

        int sprawdzenie = 0;

        if (wynik < wynik2 && Math.abs(wynik - wynik2) < 25)
        {
            sprawdzenie = wynik;
        }
        else if (wynik > wynik2 && Math.abs(wynik - wynik2) < 25 )
        {
            sprawdzenie = wynik2;
        }
        else if (wynik < wynik2 && Math.abs(wynik - wynik2) >= 25 )
        {
            sprawdzenie = wynik + 5;
        }
        else if (wynik > wynik2 && Math.abs(wynik - wynik2) >= 25 )
        {
            sprawdzenie = wynik2 + 5;
        }


        if (sprawdzenie <= 11)
        {
            textExamination = (TextView) findViewById(R.id.textView13);
            textExamination.setText(String.format("%d dB - NORMA", sprawdzenie));
        }
        else if (sprawdzenie > 11 && sprawdzenie <= 25)
        {
            textExamination = (TextView) findViewById(R.id.textView13);
            textExamination.setText(String.format("%d dB - MINIMALNY UBYTEK S£UCHU", sprawdzenie));
        }
        else if (sprawdzenie > 26 && sprawdzenie <= 40)
        {
            textExamination = (TextView) findViewById(R.id.textView13);
            textExamination.setText(String.format("%d dB - LEKKI UBYTEK S£UCHU", sprawdzenie));
        }
        else if (sprawdzenie > 41 && sprawdzenie <= 55)
        {
            textExamination = (TextView) findViewById(R.id.textView13);
            textExamination.setText(String.format("%d dB - UMIARKOWANY UBYTEK S£UCHU", sprawdzenie));
        }
        else if (sprawdzenie > 56 && sprawdzenie <= 70)
        {
            textExamination = (TextView) findViewById(R.id.textView13);
            textExamination.setText(String.format("%d dB - UMIARKOWANIE POWA¯NY UBYTEK S£UCHU", sprawdzenie));
        }
        else if (sprawdzenie > 71 && sprawdzenie <= 91)
        {
            textExamination = (TextView) findViewById(R.id.textView13);
            textExamination.setText(String.format("%d dB - POWA¯NY UBYTEK S£UCHU", sprawdzenie));
        }
        else if (sprawdzenie > 92 && sprawdzenie <= 120 )
        {
            textExamination = (TextView) findViewById(R.id.textView13);
            textExamination.setText(String.format("%d dB - G£ÊBOKI UBYTEK S£UCHU", sprawdzenie));
        }
        else if (sprawdzenie > 120 )
        {
            textExamination = (TextView) findViewById(R.id.textView13);
            textExamination.setText(String.format("%d dB - CA£KOWITA G£UCHOTA", sprawdzenie));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
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


    public void onStartClick(View view)
    {
        Intent intent = new Intent(ResultActivity.this,
                CharActivity.class);

        int[] left = getIntent().getBundleExtra("bundle").getIntArray("left");
        int[] right = getIntent().getBundleExtra("bundle").getIntArray("right");

        Bundle bundle= new Bundle();
        bundle.putIntArray("lewe", left);
        bundle.putIntArray("prawe", right);
        intent.putExtra("bundle", bundle);

        startActivity(intent);

    }
}
