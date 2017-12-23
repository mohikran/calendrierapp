package com.calendrierap.calendrierapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class IMC extends AppCompatActivity {
    private final String defaut = "Cliquer sur le bouton Calculer l'IMC";
    private final String bravo = "t'as apuyé sur le bouton qui ne calcule pas!";

    Button envoyer = null;
    Button raz = null;
    EditText poids = null;
    EditText taille = null;
    RadioGroup group = null;
    TextView result = null;
    CheckBox mega = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        envoyer = (Button)findViewById(R.id.calcul);
        raz = (Button)findViewById(R.id.raz);
        taille = (EditText)findViewById(R.id.taille);
        poids = (EditText)findViewById(R.id.poids);
        mega = (CheckBox)findViewById(R.id.mega);
        group = (RadioGroup)findViewById(R.id.group);
        result = (TextView)findViewById(R.id.result);


        envoyer.setOnClickListener(envoyerListener);
        raz.setOnClickListener(razListener);
        taille.addTextChangedListener(textWatcher);
        poids.addTextChangedListener(textWatcher);


        mega.setOnClickListener(checkedListener);

    }


    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            result.setText(defaut);
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {

        }
        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private View.OnClickListener envoyerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!mega.isChecked()) {

                String t = taille.getText().toString();
                String p = poids.getText().toString();

                float tValue = Float.valueOf(t);

                if(tValue == 0)
                    Toast.makeText(IMC.this, "Pas possible", Toast.LENGTH_SHORT).show();
                else {
                    float pValue = Float.valueOf(p);


                    if(group.getCheckedRadioButtonId() == R.id.metre)
                        tValue = tValue / 100;

                    tValue = (float)Math.pow(tValue, 2);
                    float imc = pValue / tValue;
                    result.setText("Votre IMC est " + String.valueOf(imc));
                }
            } else
                result.setText(bravo);
        }
    };

    private View.OnClickListener razListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            poids.getText().clear();
            taille.getText().clear();
            result.setText(defaut);
        }
    };

    // Listener du bouton de la megafonction.
    private View.OnClickListener checkedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // On remet le texte par défaut si c'était le texte de la megafonction qui était écrit
            if(!((CheckBox)v).isChecked() && result.getText().equals(bravo))
                result.setText(defaut);
        }
    };


    public void backToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
