package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button generateButton = findViewById(R.id.button);
        final EditText rangeEditText = findViewById(R.id.fetch);
        final TextView resultTextView = findViewById(R.id.put);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rangeStr = rangeEditText.getText().toString();

                if (rangeStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter a range", Toast.LENGTH_SHORT).show();
                    return;
                }

                int range;
                try {
                    range = Integer.parseInt(rangeStr);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Enter a valid integer range", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (range <= 0) {
                    Toast.makeText(MainActivity.this, "Enter a valid positive range", Toast.LENGTH_SHORT).show();
                    return;
                }

                Random random = new Random();
                int randomNumber = random.nextInt(range) + 1;
                resultTextView.setText(String.valueOf(randomNumber));
            }
        });
    }
}
