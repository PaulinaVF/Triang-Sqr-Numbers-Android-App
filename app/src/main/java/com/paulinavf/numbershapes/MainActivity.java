package com.paulinavf.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void makeToast (String string){
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    }

    public class TestNumber {
        int number;
        public boolean isSquare (){
            int raiz = (int) Math.sqrt(number);
            if(Math.pow(raiz,2) == number){
                return true;
            }else{
                return false;
            }
        }
        public boolean isTriangle(){
            int i = number;
            int take = 1;
            while (i>0){
                i-=take;
                take += 1;
            }
            if(i==0){
                return true;
            }else{
                return false;
            }
        }
    }

    public void checkShape (View view){
        EditText edtNumber = (EditText) findViewById(R.id.edtNumber);

        if(edtNumber.getText().toString().isEmpty())
            makeToast("No number entered");
        else {
            String strNumber = new String(edtNumber.getText().toString());
            TestNumber iNumber = new TestNumber();
            iNumber.number = Integer.parseInt(strNumber);
            if (iNumber.isSquare() && iNumber.isTriangle()) {
                makeToast("Both!");
            } else if (iNumber.isTriangle()) {
                makeToast("Triangle!");
            } else if (iNumber.isSquare()) {
                makeToast("Square!");
            } else {
                makeToast("None :(");
            }
        }
    }
}