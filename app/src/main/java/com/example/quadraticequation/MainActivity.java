package com.example.quadraticequation;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText e1 = findViewById(R.id.e1);
        final EditText e2 = findViewById(R.id.e2);
        final EditText e3 = findViewById(R.id.e3);
        final TextView text1 = findViewById(R.id.t1);
        final TextView text2 = findViewById(R.id.t2);
        Button button = findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a1 = e1.getText().toString();
                String b1 = e2.getText().toString();
                String c1 = e3.getText().toString();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                if (a1.isEmpty() || b1.isEmpty() || c1.isEmpty()) {
                    builder.setMessage("ALL THE COEFFICIENTS MUST BE ENTERED!!");
                    builder.setTitle("SORRY!!");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else {
                    Double a = Double.parseDouble(e1.getText().toString().trim());
                    Double b = Double.parseDouble(e2.getText().toString().trim());
                    Double c = Double.parseDouble(e3.getText().toString().trim());
                    int d = (int) (Math.pow(b, 2) - (4 * a * c));
                    if (a == 0) {
                        builder.setMessage("COEFFICIENT OF X^2 SHOULD NOT BE 0");
                        builder.setTitle("SORRY!!");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    } else {
                        if (d >= 0) {
                            double x1 = (-b + Math.sqrt(d)) / (2 * a);
                            double x2 = (-b - Math.sqrt(d)) / (2 * a);
                            text1.setText(String.valueOf(x1));
                            text2.setText(String.valueOf(x2));
                        } else {

                            builder.setMessage("THE QUADRATIC EQUATION HAS COMPLEX ROOTS");
                            builder.setTitle("SORRY!!");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                        }
                    }

                }
            }
        });
        Button clear_button = findViewById(R.id.b2);
        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(null);
                e2.setText(null);
                e3.setText(null);
                text1.setText(null);
                text2.setText(null);

            }
        });
    }
}
