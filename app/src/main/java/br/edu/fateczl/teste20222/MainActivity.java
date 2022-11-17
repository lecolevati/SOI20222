package br.edu.fateczl.teste20222;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etNumero;
    private TextView tvDica;
    private Button btnJogar;
    private int random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumero = findViewById(R.id.etNumero);
        etNumero.setGravity(Gravity.CENTER);

        tvDica = findViewById(R.id.tvDica);
        tvDica.setGravity(Gravity.CENTER);

        btnJogar = findViewById(R.id.btnJogar);

        random = (int)((Math.random() * 100) + 1);

        btnJogar.setOnClickListener(click -> jogar());

    }

    private void jogar() {
        int num = Integer.parseInt(etNumero.getText().toString());
        if (num > random) {
            tvDica.setText(R.string.menor);
        } else if (num < random) {
            tvDica.setText(R.string.maior);
        } else {
            resultado();
        }
    }

    private void resultado() {
        Bundle bundle = new Bundle();
        bundle.putInt("random", random);
        Intent i = new Intent(this, ResultadoActivity.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }
}