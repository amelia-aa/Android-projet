package com.example.dev.dev2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by DEV on 15/09/2016.
 */
public class MainActivity3 extends AppCompatActivity {

    private EditText editText;
    private Button button_ok;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("TAG_destroy", "activity:main_activity");
    }

    public void AlertDialog() {
        //Préparation de la fenêtre
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        //Message
        alertDialogBuilder.setMessage("Mon message");
        //titre
        alertDialogBuilder.setTitle("Mon titre");
        //bouton ok
        alertDialogBuilder.setPositiveButton("ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //Affiche un toast apresle click sur le bouton ok
                        Toast.makeText(MainActivity3.this, "Afficher un Toast", Toast.LENGTH_SHORT).show();
                    }
                });
        //Icone
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher);
        //Afficher la fenêtre
        alertDialogBuilder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 25, 0, "AlertDialog");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 25:
                AlertDialog();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
