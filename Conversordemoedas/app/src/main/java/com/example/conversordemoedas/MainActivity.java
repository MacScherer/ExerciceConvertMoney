package com.example.conversordemoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @SuppressLint("DefaultLocale")
    @Override
    public void onClick(View view) {
        //Aqui foi implementado o método onclick que foi criado no começo e instanciado ao botão
        if (view.getId() == R.id.buttonCalcular){
            String valorReal = this.mViewHolder.editvalue.getText().toString();
            if ("".equals(valorReal)){
                Toast.makeText(this, R.string.informe_valor, Toast.LENGTH_SHORT).show();
            }else {
            double Real = Double.parseDouble(valorReal);
            this.mViewHolder.textViewNumeorDolar.setText(String.format("%.2f", (Real/ 4)));
            this.mViewHolder.textViewNumeroEuro.setText(String.format("%.2f", (Real/ 5)));
            }
        }
    }

    private static class ViewHolder{
        // Somente essa classe tem acesso a esse método por ser private
        // Será executado uma vez por ser static
        EditText editvalue;
        TextView textViewNumeorDolar;
        TextView textViewNumeroEuro;
        Button buttonCalcular;
    }
    private final ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editvalue = findViewById(R.id.editTextNumberReal);
        this.mViewHolder.textViewNumeorDolar = findViewById(R.id.textViewResultadoDolar);
        this.mViewHolder.textViewNumeroEuro = findViewById(R.id.textViewResultadoEuro);
        this.mViewHolder.buttonCalcular = findViewById(R.id.buttonCalcular);

        this.mViewHolder.buttonCalcular.setOnClickListener(this);

        LimpaValores();
    }

    private void LimpaValores(){
        this.mViewHolder.textViewNumeroEuro.setText("");
        this.mViewHolder.textViewNumeorDolar.setText("");
    }
}