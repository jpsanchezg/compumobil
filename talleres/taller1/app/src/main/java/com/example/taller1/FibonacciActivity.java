package com.example.taller1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigInteger;
import java.util.ArrayList;

public class FibonacciActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setVisibility(View.VISIBLE);
        ImageView btn = findViewById(R.id.imgFBTN);
        TextView num = findViewById(R.id.fiboNum);
        setTitle("Fibonacci");
        String newString;

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
        int serie = Integer.parseInt(newString);
        num.setText(calcfibonacci(serie));

        btn.setOnClickListener(view -> {
            myWebView.loadUrl("https://es.wikipedia.org/wiki/Leonardo_de_Pisa");
        });
    }



    private String calcfibonacci(int n){
        String text="";
        ArrayList<BigInteger> fib = new ArrayList<>();
        BigInteger first = new BigInteger("0");
        fib.add(first);
        BigInteger segundo = new BigInteger("1");
        fib.add(segundo);
        for(int i =1;i<n;i++){
            fib.add(fib.get(i).add(fib.get(i-1)));
        }
        for(int i =1;i<=n;i++){
            text = text + fib.get(i)+"\n";
        }
        return text;
    }
}