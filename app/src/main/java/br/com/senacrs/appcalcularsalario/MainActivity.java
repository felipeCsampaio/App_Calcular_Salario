package br.com.senacrs.appcalcularsalario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgOpcoes;
    Button btnCalc;
    EditText txtSalario;

    @Override
    protected void onCreate(Bundle savedIndtanceState){
        super.onCreate(savedIndtanceState);
        setContentView(R.layout.activity_main);
        txtSalario = (EditText) findViewById(R.id.txtSalario);
        rgOpcoes = (RadioGroup) findViewById(R.id.rgOpcoes);
        btnCalc = (Button) findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               double salario = Double.parseDouble(txtSalario.getText().toString());
               int op = rgOpcoes.getCheckedRadioButtonId();
               double novo_salario = 0;

               if(op == R.id.rd40)
                   novo_salario = salario + (salario + 0.4);
               else if (op == R.id.rd45) {
                   novo_salario = salario + (salario * 0.45);
               }else{
                   novo_salario = salario + (salario * 0.5);

               }
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
               dialogo.setTitle("Novo salário");
               dialogo.setMessage("Seu novo salário é: R$" + String.valueOf(novo_salario));
               dialogo.setNeutralButton("OK",null);
               dialogo.show();
            }

        });
    }
}