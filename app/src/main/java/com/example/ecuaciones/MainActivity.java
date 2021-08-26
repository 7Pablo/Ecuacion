package com.example.ecuaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    Ecuacion ecuacion;
    EditText aTxt;
    EditText bTxt;
    EditText cTxt;

    EditText sqrt1Txt;
    EditText sqrt2Txt;

    private static MainActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ecuacion = new Ecuacion();
        aTxt = findViewById(R.id.aTxt);
        bTxt = findViewById(R.id.bTxt);
        cTxt = findViewById(R.id.cTxt);

        sqrt1Txt = findViewById(R.id.raiz1Txt);
        sqrt2Txt = findViewById(R.id.raiz2Txt);
        instance = this;
    }

    public void getSqrt(View v){
        try{
            String aString = aTxt.getText().toString();
            String bString = bTxt.getText().toString();
            String cString = cTxt.getText().toString();

            double coefA = 0, coefB = 0, coefC = 0;
            boolean valid = true;

            if(aString.length() > 0){
                coefA = Double.valueOf(aString);
            }else{
                aTxt.setText("Por favor, introduce un número");
                valid = false;
            }

            if(bString.length() > 0){
                coefB = Double.valueOf(bString);
            }else{
                bTxt.setText("Por favor, introduce un número");
                valid = false;
            }

            if(cString.length() > 0){
                coefC = Double.valueOf(cString);
            }else{
                cTxt.setText("Por favor, introduce un número");
                valid = false;
            }

            if(valid){
                String raices[] = ecuacion.obtenerRaices(coefA, coefB, coefC);
                sqrt1Txt.setText(raices[0]);
                sqrt2Txt.setText(raices[1]);
            }

        }catch (NumberFormatException nfe){
            aTxt.setText("Por favor, introduce un número");
            bTxt.setText("Por favor, introduce un número");
            cTxt.setText("Por favor, introduce un número");
        }
    }
    public static MainActivity getInstance() {
        return instance;
    }

    public void openPopUp(){
        AvisoPopUp myPopUp = new AvisoPopUp();
        myPopUp.show(getSupportFragmentManager(), AvisoPopUp.TAG);
    }

}