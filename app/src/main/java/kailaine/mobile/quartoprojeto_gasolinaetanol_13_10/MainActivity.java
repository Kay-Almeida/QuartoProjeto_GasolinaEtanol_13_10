package kailaine.mobile.quartoprojeto_gasolinaetanol_13_10;
/*
 *@author:<Kailaine Almeida de Souza RA: 1110482313026>
 */
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText etGasolina;
    private EditText etEtanol;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etGasolina = findViewById(R.id.etGasolina);
        etEtanol = findViewById(R.id.etEtanol);
        tvRes = findViewById(R.id.tvRes);

        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(op -> calc());
    }
    private void calc() {
        double precoGasolina = Double.parseDouble(etGasolina.getText().toString());
        double precoEtanol = Double.parseDouble(etEtanol.getText().toString());
        double proporcao = precoEtanol / precoGasolina;

        if (proporcao <= 0.7) {
            tvRes.setText("É mais vantajoso abastecer com Etanol.");
        } else {
            tvRes.setText("É mais vantajoso abastecer com Gasolina.");
        }

        etGasolina.setText("");
        etEtanol.setText("");
    }

}