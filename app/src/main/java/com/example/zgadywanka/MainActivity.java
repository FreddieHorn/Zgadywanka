package com.example.zgadywanka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText editNumber;
    ImageView imageView;
    int randomNumber;
    int proby = 0;
    int trafienia = 0;

    public void generateRandomNumbers(){
        Random random = new Random();
        randomNumber = random.nextInt(50)+1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNumber = findViewById(R.id.editNumber);
        imageView = findViewById(R.id.imageView);
        generateRandomNumbers();
    }



    public void sprawdz(View view) throws InterruptedException {
        if(editNumber.getText().toString().isEmpty())
        {
            Toast.makeText(this, "musisz podać liczbę", Toast.LENGTH_LONG).show();
        }
        else
        {
            int liczba = (int) (Integer.valueOf(editNumber.getText().toString()));
            if (liczba<01 || liczba >50)
                Toast.makeText(this, "podaj liczbe z przedzialu 0-50", Toast.LENGTH_LONG).show();
            else {
                if (liczba > randomNumber) {
                    Toast.makeText(this, "za dużo", Toast.LENGTH_LONG).show();
                    proby++;
                } else if (liczba < randomNumber) {
                    Toast.makeText(this, "za mało", Toast.LENGTH_LONG).show();
                    proby++;
                } else {
                    Toast.makeText(this, "trafiles/as! liczba nieznana to " + liczba + "losujemy nowa liczbe", Toast.LENGTH_LONG).show();
                    trafienia++;
                    proby++;
                    generateRandomNumbers();
                    imageView.setVisibility(View.VISIBLE);
                }
                    String notry = String.valueOf(proby);
                    TextView textTraf = findViewById(R.id.textTraf);
                    textTraf.setText(notry);
                    String notraf = String.valueOf(trafienia);
                    TextView textProb = findViewById(R.id.textProb);
                    textProb.setText(notraf);
                }
            }
        }


    public void reset (View view) {
        int proby = 0;
        int trafienia = 0;
        generateRandomNumbers();
        String notry = String.valueOf(proby);
        TextView textTraf = findViewById(R.id.textTraf);
        textTraf.setText(notry);
        String notraf = String.valueOf(trafienia);
        TextView textProb = findViewById(R.id.textProb);
        textProb.setText(notraf);
        imageView.setVisibility(View.INVISIBLE);
    }


}