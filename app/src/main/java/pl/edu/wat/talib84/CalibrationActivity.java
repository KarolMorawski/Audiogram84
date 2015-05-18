package pl.edu.wat.talib84;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;


public class CalibrationActivity extends ActionBarActivity {

    ToneGenerator toneGenerator;
    SeekBar seekBar;
    int MAX = 10000;
    int DIV = 200000;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calibration);
        
        toneGenerator = new ToneGenerator();
        toneGenerator.playCalibration();
        toneGenerator.setCalibrationVolume((float) MAX / DIV);


        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(MAX);
        seekBar.setProgress(MAX);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean
                    fromUser)
            {
                toneGenerator.setCalibrationVolume((float) progress/ DIV);

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }


        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_calibration, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSaveClick(View view) {
        int progress = seekBar.getProgress();
        toneGenerator.setCalibrationVolume((float) progress/ DIV);

    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        toneGenerator.stop();
    }
    }


