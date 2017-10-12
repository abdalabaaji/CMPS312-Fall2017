package qa.edu.qu.cmps312.homework1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button convert;
    private EditText celciusEdt;
    private EditText fahrenheitEdt;
    private String lastEdited;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celciusEdt = (EditText) findViewById(R.id.cel_edt);
        fahrenheitEdt = (EditText) findViewById(R.id.far_edt);

        convert = (Button) findViewById(R.id.convert);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastEdited.matches("celcius")) {

                    double C = Double.parseDouble(celciusEdt.getText().toString());
                    double F = C * 9.0 / 5.0 + 32;
                    fahrenheitEdt.setText(F + "");

                    lastEdited = "celcius";

                } else if (lastEdited.matches("fahrenheit")) {


                    double F = Double.parseDouble(fahrenheitEdt.getText().toString());
                    double C = (F - 32.0) * 5.0 / 9.0;
                    celciusEdt.setText(C + "");

                    lastEdited = "fahrenheit";
                } else
                    Toast.makeText(MainActivity.this, "Enter Something first", Toast.LENGTH_SHORT).show();

            }
        });

        celciusEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0)
                    lastEdited = "celcius";
                else
                    lastEdited = "";
            }
        });

        fahrenheitEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0)
                    lastEdited = "fahrenheit";
                else
                    lastEdited = "";
            }
        });


    }
}
