package in.neha.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView mTxtMale, mTxtFemale, mTxthight, mTxtCurrentHeight, mTxtAge, mTxtWeight,mTxt_ResultBMI;
    SeekBar mSeekbar;
    EditText mEdtCurrentAge, mEdtCurrentWeight;
    Button mBtnAgeDec, mBtnAgeInc, mBtnWeightDec, mBtnWeightInc, mBtnCalBMI;

    int currentprogress;
    String mIntprogressHight;
    int count = 0;
    String currentage;
    String currentweight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        mTxtMale.setOnClickListener(new MaleOnClickListener());
        mTxtFemale.setOnClickListener(new FemaleOnClickListener());

        seekbar();

        mBtnAgeDec.setOnClickListener(new BtnAgeDecOnClickListener());
        mBtnAgeInc.setOnClickListener(new BtnAgeIncOnClickListener());
        mBtnWeightDec.setOnClickListener(new BtnWeightDecOnClickListener());
        mBtnWeightInc.setOnClickListener(new BtnWeightIncOnClickListener());
        mBtnCalBMI.setOnClickListener(new calculateBMIonClickListner());

    }


    public void init() {

        mTxtMale = findViewById(R.id.txt_male);
        mTxtFemale = findViewById(R.id.txt_female);
        mTxthight = findViewById(R.id.txt_height);
        mTxtCurrentHeight = findViewById(R.id.txt_currentHeight);
        mTxtAge = findViewById(R.id.txt_age);
        mTxtWeight = findViewById(R.id.txt_weight);
        mSeekbar = findViewById(R.id.seekbar);
        mTxt_ResultBMI = findViewById(R.id.txt_ResultBMI);

        mEdtCurrentAge = findViewById(R.id.edt_currentAge);
        mEdtCurrentWeight = findViewById(R.id.edt_currentWeight);

        mBtnAgeDec = findViewById(R.id.btn_ageDec);
        mBtnAgeInc = findViewById(R.id.btn_ageInc);
        mBtnWeightDec = findViewById(R.id.btn_weightDec);
        mBtnWeightInc = findViewById(R.id.btn_weightInc);
        mBtnCalBMI = findViewById(R.id.btn_calculateBMI);
    }


    private class MaleOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this,"You selected Male",Toast.LENGTH_LONG).show();
        }
    }

    private class FemaleOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this,"You selected Female",Toast.LENGTH_LONG).show();
        }
    }


    public void seekbar() {

        mSeekbar.setMax(300);
        mSeekbar.setProgress(170);
        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress = progress;
                mIntprogressHight = String.valueOf(currentprogress);
                mTxtCurrentHeight.setText(mIntprogressHight);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
    }

    private class BtnAgeDecOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            count--;
            currentage = String.valueOf(count);
            mEdtCurrentAge.setText(currentage);
        }
    }

    private class BtnAgeIncOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            count++;
            currentage = String.valueOf(count);
            mEdtCurrentAge.setText(currentage);
        }
    }

    private class BtnWeightDecOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            count--;
            currentweight = String.valueOf(count);
            mEdtCurrentWeight.setText(currentweight);
        }
    }

    private class BtnWeightIncOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            count++;
            currentweight = String.valueOf(count);
            mEdtCurrentWeight.setText(currentweight);

        }
    }

    private class calculateBMIonClickListner implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            float height = Float.parseFloat(mIntprogressHight) / 100;
            float weight = Float.parseFloat(currentweight);

            float bmi = weight / height * height;

            displayBMI(bmi);

        }

    }


    public void displayBMI(float bmi) {

        if(bmi<16){

            mTxt_ResultBMI.setText("Severe Thinness");
        }

        else if( bmi<16.1 && bmi>16 ){

            mTxt_ResultBMI.setText("Moderate Thinness");
        }

        else if( bmi<18.4 && bmi>17 ){

            mTxt_ResultBMI.setText("Mild Thinness");
        }


        else if( bmi<25 && bmi>18.4 ){

            mTxt_ResultBMI.setText("Normal");
        }

        else if( bmi<29.4 && bmi>25 ){

            mTxt_ResultBMI.setText("OverWeight");
        }

        else {

            mTxt_ResultBMI.setText("Obese Case 1");
        }


    }

}
