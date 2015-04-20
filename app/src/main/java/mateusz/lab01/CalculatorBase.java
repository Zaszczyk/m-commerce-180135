package mateusz.lab01;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CalculatorBase extends Fragment {
    public String lastSign = "";
    public boolean last = false;
    public String regex = "\\s*[-,+,/,*]+\\s*";

    public void createEvents(final View view) {
        //cyfry
        Button zero = (Button) view.findViewById(R.id.zero);
        Button one = (Button) view.findViewById(R.id.one);
        Button two = (Button) view.findViewById(R.id.two);
        Button three = (Button) view.findViewById(R.id.three);
        Button four = (Button) view.findViewById(R.id.four);
        Button five = (Button) view.findViewById(R.id.five);
        Button six = (Button) view.findViewById(R.id.six);
        Button seven = (Button) view.findViewById(R.id.seven);
        Button eight = (Button) view.findViewById(R.id.eight);
        Button nine = (Button) view.findViewById(R.id.nine);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetToInput(view, "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetToInput(view, "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetToInput(view, "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetToInput(view, "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetToInput(view, "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetToInput(view, "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetToInput(view, "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetToInput(view, "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetToInput(view, "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetToInput(view, "9");
            }
        });

        //rzad 1
        Button bksp = (Button) view.findViewById(R.id.bksp);
        Button clear = (Button) view.findViewById(R.id.c);
        Button dot = (Button) view.findViewById(R.id.dot);

        bksp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bksp(view);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clear(view);
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dot(view);
            }
        });

        //oepracje
        Button plusminus = (Button) view.findViewById(R.id.plusminus);
        Button plus = (Button) view.findViewById(R.id.plus);
        Button minus = (Button) view.findViewById(R.id.minus);
        Button division = (Button) view.findViewById(R.id.division);
        Button multiplication = (Button) view.findViewById(R.id.multiply);
        Button equal = (Button) view.findViewById(R.id.equal);

        plusminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Negation(view);
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetMathematicalSign(view, "+");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetMathematicalSign(view, "-");
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetMathematicalSign(view, "/");
            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetMathematicalSign(view, "*");
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExecuteSimpleMath(view);
            }
        });
    }

    public void Bksp(View view) {
        TextView input = (TextView) view.findViewById(R.id.input);
        String val = (String) input.getText();

        if (val.length() > 1)
            input.setText(val.substring(0, val.length() - 1));
        else
            input.setText("");

    }

    public void Clear(View view) {
        TextView input = (TextView) view.findViewById(R.id.input);
        input.setText("");
        lastSign = "";
    }

    public void Dot(View view) {
        TextView input = (TextView) view.findViewById(R.id.input);
        String val = (String) input.getText();

        if (isNumeric(val.substring(val.length() - 1))) {
            input.setText(val + '.');
        }
    }

    public void Negation(View view) {
        TextView input = (TextView) view.findViewById(R.id.input);

        String val = (String) input.getText();
        float valFloat = Float.parseFloat(val);

        if (valFloat > 0)
            input.setText("-" + val);
        else {
            input.setText(val.substring(1, val.length()));
        }
    }

    public void ExecuteSimpleMath(View view) {
        TextView input = (TextView) view.findViewById(R.id.input);
        String val = (String) input.getText();

        if (isNumeric(val.substring(val.length() - 1))) {
            String parts[] = val.split(regex);
            if (parts.length > 1) {

                double tmpX = 0;
                switch (lastSign) {
                    case "-":
                        tmpX = Double.parseDouble(parts[0]) - Double.parseDouble(parts[1]);
                        break;

                    case "+":
                        tmpX = Double.parseDouble(parts[0]) + Double.parseDouble(parts[1]);
                        break;

                    case "*":
                        tmpX = Double.parseDouble(parts[0]) * Double.parseDouble(parts[1]);
                        break;

                    case "/":
                        tmpX = Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
                        break;

                    case "^":
                        tmpX = Math.pow(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                        break;
                }
                input.setText(Double.toString(tmpX));

            }

            lastSign = "";
        }
    }

    public void SetMathematicalSign(View view, String sign) {
        TextView input = (TextView) view.findViewById(R.id.input);
        String val = (String) input.getText();

        if (isNumeric(val.substring(val.length() - 1))) {
            String parts[] = val.split(regex);
            if (parts.length > 1) {

                double tmpX;
                switch (lastSign) {
                    case "-":
                        tmpX = Double.parseDouble(parts[0]) - Double.parseDouble(parts[1]);
                        input.setText(Double.toString(tmpX) + sign);
                        break;

                    case "+":
                        tmpX = Double.parseDouble(parts[0]) + Double.parseDouble(parts[1]);
                        input.setText(Double.toString(tmpX) + sign);
                        break;

                    case "*":
                        tmpX = Double.parseDouble(parts[0]) * Double.parseDouble(parts[1]);
                        input.setText(Double.toString(tmpX) + sign);
                        break;

                    case "/":
                        tmpX = Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
                        input.setText(Double.toString(tmpX) + sign);
                        break;

                    case "^":
                        tmpX = Math.pow(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                        input.setText(Double.toString(tmpX) + sign);
                        break;
                }

            } else {
                input.setText(val + sign);
            }

            lastSign = sign;
        }

    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    public void SetToInput(View view, String number) {

        TextView input = (TextView) view.findViewById(R.id.input);
        String val = (String) input.getText();

        input.setText(val + number);

        last = false;
    }
}
