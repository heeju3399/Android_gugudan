package com.example.mid_typea;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edtNum1,edtNum2,edtResult;
        final Button btnRandom,btnAnswer;
        final ListView list;
        edtNum1 = (EditText) findViewById(R.id.edtnum1);
        edtNum2 = (EditText) findViewById(R.id.edtnum2);
        edtResult = (EditText) findViewById(R.id.edtResult);
        btnRandom = (Button) findViewById(R.id.btnRan);
        btnAnswer = (Button) findViewById(R.id.btnAns);
        list = (ListView) findViewById(R.id.list);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int ran1 = new Random().nextInt(8)+2;
                int ran2 = new Random().nextInt(8)+2;
                edtNum1.setText(String.valueOf(ran1));
                edtNum2.setText(Integer.toString(ran2));
            }
        });
        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(), 0);
                if (edtNum1.getText().toString().equals("") || edtNum2.getText().toString().equals("") ||edtResult.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "값넣어주세요", Toast.LENGTH_SHORT).show();
                } else {
                    int num1 = Integer.parseInt(edtNum1.getText().toString());
                    int num2 = Integer.parseInt(edtNum2.getText().toString());
                    int result = Integer.parseInt(edtResult.getText().toString());
                    int mul = num1 * num2;
                    if (mul == result) {//정답
                        Toast.makeText(MainActivity.this, "정답입니다", Toast.LENGTH_SHORT).show();
                    } else {//오답
                        Toast.makeText(MainActivity.this, "오답입니다", Toast.LENGTH_SHORT).show();
                        String value[] = new String[9];
                        for (int i = 0; i < 9; i++) {
                            value[i] = String.valueOf(num1) + "X" + (i + 1) + "=" + (num1 * (i + 1));
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_list_item_1, value);
                        list.setAdapter(adapter);
                    }
                }
            }
        });
    }
}