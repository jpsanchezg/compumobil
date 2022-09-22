package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.ArrayList;

public class FactorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);
        TextView multiplicacion =findViewById(R.id.multiplicacionTextView);
        TextView resultado = findViewById(R.id.resultadoTextView);
        String newString;
        setTitle("Factorial");
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("posicion");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("posicion");
        }
        int num = Integer.parseInt(newString);
        multiplicacion.setText("Operacion: "+ operacion(num));
        resultado.setText("Resultado: "+calcFactorial(num));

    }

    public void onDestroy() {
        super.onDestroy();
    }
    private String operacion(int n){
        String text="";
        ArrayList<String> fib = new ArrayList<>();
        fib.add(Integer.toString(n));
        int resta=0;
        for(int i =1;i<n;i++){
            resta = n-i;
            fib.add(Integer.toString(resta)+"*");
        }
        for(int i =0;i<n;i++){
            text = fib.get(i) +text ;
        }
        return text;
    }

    private String calcFactorial(int n){
        String text="";

        long factorial =1;
        for (int i = 1; i <= n; i++) {
            factorial = i * factorial;
        }
        return Long.toString(factorial);

    }
}