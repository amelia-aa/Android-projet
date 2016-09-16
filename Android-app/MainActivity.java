package com.example.dev.dev2;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {

    private RadioButton radioButtonJ;
    private RadioButton radioButtonJP;
    private EditText editText;
    protected ImageView image_android;
    private Button button_annuler;
    private Button button_valider;
    private Button button_next;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Chargement de l'interface graphique
        setContentView(R.layout.activity_main);

        // On récupère le Button qui a été créé par le fichier XML
        button_annuler = (Button) findViewById(R.id.button_annuler);
        button_valider = (Button) findViewById(R.id.button_valider);
        button_next = (Button) findViewById(R.id.button_next);
        radioButtonJ = (RadioButton) findViewById(R.id.radioButtonJ);
        radioButtonJP = (RadioButton) findViewById(R.id.radioButtonJP);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        editText = (EditText) findViewById(R.id.editText);
        image_android = (ImageView) findViewById(R.id.image_android);

        // on applique au bouton la methode onClick
        button_annuler.setOnClickListener(this);
        button_valider.setOnClickListener(this);
        button_next.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("TAG_resume", "activity:main_activity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w("TAG_pause", "activity:main_activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("TAG_destroy", "activity:main_activity");
    }

    @Override
    public void onClick(View v) {
        if (v == button_valider) {
            if (radioButtonJ.isChecked()) {
                editText.setText(radioButtonJ.getText());
                image_android.setImageResource(R.drawable.ic_build_black_48dp);
            }

            else if (radioButtonJP.isChecked()) {
                editText.setText(radioButtonJP.getText());
            }
            else {
                editText.setText("Veuillez faire un choix");
                image_android.setImageResource(R.drawable.ic_cached_black_48dp);
            }
        }
        else if (v == button_annuler) {
            editText.setText("");
            radioGroup.clearCheck();
            image_android.setColorFilter(Color.CYAN);
        }

        else if (v == button_next) {
            Intent intent = new Intent(this, MainActivity3.class);
            startActivity(intent);

            // Toast.makeText(this, "Coucou", Toast.LENGTH_SHORT).show();
            TimePickerDialog tpd = new TimePickerDialog(this, this, 12, 12, true);
            tpd.show();
        }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(MainActivity.this,
                "La nouvelle heure est " + hourOfDay + " : " + minute, Toast.LENGTH_LONG).show();
    }
}
