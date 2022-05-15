package com.example.calculapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button0 ;
    private Button button1 ;
    private Button button2 ;
    private Button button3 ;
    private Button button4 ;
    private Button button5 ;
    private Button button6 ;
    private Button button7 ;
    private Button button8 ;
    private Button button9 ;
    private Button buttonAdd ;
    private Button buttonSub ;
    private Button buttonMul ;
    private Button buttonDiv ;
    private Button buttonPui ;
    private Button buttonClear ;
    private Button buttonmodulo ;
    private TextView display ;
    private ImageButton delete ;
    private Button equal ;
    private Button point ;
    private  String result;
    private String tmp;
    private String operator;
    private boolean deci ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display=findViewById(R.id.input);
        button0=findViewById(R.id.zeroButton);
        button1=findViewById(R.id.oneButton);
        button2=findViewById(R.id.twoButton);
        button3=findViewById(R.id.threeButton);
        button4=findViewById(R.id.fourButton);
        button5=findViewById(R.id.fiveButton);
        button6=findViewById(R.id.sixButton);
        button7=findViewById(R.id.sevenButton);
        button8=findViewById(R.id.eightButton);
        button9=findViewById(R.id.nineButton);
        buttonClear=findViewById(R.id.clearButton);
        buttonAdd=findViewById(R.id.plusButton);
        buttonSub=findViewById(R.id.minusButton);
        buttonMul=findViewById(R.id.multiButton);
        buttonDiv=findViewById(R.id.divButton);
        buttonmodulo=findViewById(R.id.moduloButton);
        buttonPui=findViewById(R.id.puissButton);
        delete=findViewById(R.id.button2);
        equal=findViewById(R.id.equalButton);
        point=findViewById(R.id.pointButton);

        initControlListener();
    }

    private void initControlListener() {
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("9");
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked(".");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClearButtonClicked();
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                onOperatorButtonClicked("-");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("+");
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("X");
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("/");
            }
        });
        buttonmodulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("%");
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEqualButtonClicked();
            }
        });
        buttonPui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("^");
            }
        });





    }
    private void onEqualButtonClicked() {
        double res = 0.0;
        try {
            double number = Double.valueOf(tmp);
            double number2 = Double.valueOf(display.getText().toString());
            switch (operator) {
                case "+":
                    res = number + number2;
                    break;
                case "/":
                    res = number / number2;
                    break;
                case "-":
                    res = number - number2;
                    break;
                case "X":
                    res = number * number2;
                    break;
                case "^":
                    res=  Math.pow(number, number2);
                    break ;
                case "%":
                    res = (int)number%number2;
            }
            result = String.valueOf(res);
            display.setText(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void onOperatorButtonClicked(String operator) {
        tmp = display.getText().toString();
        onClearButtonClicked();
        this.operator = operator;
    }
    private void onClearButtonClicked(){
        result = "";
        display.setText("");
    }

    private void onNumberButtonClicked(String pos) {
        result = display.getText().toString();
        result = result + pos;
        display.setText(result);
    }
    public void backspaceButton(View view){
        display = findViewById(R.id.input);
        String val = display.getText().toString();
        if(val.length()>0){
            val=val.substring(0,val.length() -1);
            display.setText(val);
        }
    }
    public void point(View view){


        if (deci) {
            //do nothing or you can show the error
        } else {
            display.setText(display.getText() + ".");
            deci = true;
        }

    }

}
