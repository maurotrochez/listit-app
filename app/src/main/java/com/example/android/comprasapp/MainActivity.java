package com.example.android.comprasapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String article;
    HashMap<String, Double> car = new HashMap<String, Double>();
    double valueArticle;
    EditText edtTxtArticle, edtTxtValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.resume) {
            String res = "";
            for (Map.Entry<String, Double> entry : car.entrySet()){
                res += entry.getKey() + ": "+entry.getValue()+"\n";
            }
            Intent i = new Intent(this, ResumeActivity.class);
            i.putExtra("Resume", res);
            startActivity(i);
        }
        else if(id == R.id.shoppingCar){
            double total=0;
            double iva=0;
            double totaliva=0;
//            Iterator it = car.entrySet().iterator();
//            while (it.hasNext()){
//                Map.Entry pair = (Map.Entry)it.next();
//                pair.getValue();
//            }

            for (Double value : car.values()){
                total+=value;
            }
            iva = (total*16)/100;
            totaliva = total + iva;
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Compra")
                    .setMessage("Total compra: "+total +"\nIVA: "+iva + "\nTotal: "+totaliva)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create();
            alertDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onNext(View v){

        article = ((EditText)findViewById(R.id.edtTxtArticle)).getText().toString();
        valueArticle = Double.parseDouble(((EditText)findViewById(R.id.edtTxtValue)).getText().toString());
        car.put(article, valueArticle);

        edtTxtArticle = ((EditText) findViewById(R.id.edtTxtArticle));
        edtTxtArticle.setText("");

        edtTxtValue = (EditText) findViewById(R.id.edtTxtValue);
        edtTxtValue.setText("");
        Toast.makeText(this, "Articulo agregado", Toast.LENGTH_SHORT).show();
    }
}
