package mateusz.lab01;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AdvancedFragment extends CalculatorBase {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_advanced, container, false);

        createEvents(view);

        //zaawansowane buttony
        Button sin = (Button) view.findViewById(R.id.sin);
        Button cos = (Button) view.findViewById(R.id.cos);
        Button tan = (Button) view.findViewById(R.id.tan);
        Button ln = (Button) view.findViewById(R.id.ln);
        Button sqrt = (Button) view.findViewById(R.id.sqrt);
        Button pow = (Button) view.findViewById(R.id.exponentiation2);
        Button powX = (Button) view.findViewById(R.id.xExponentiationY);
        Button log = (Button) view.findViewById(R.id.log);

        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExecuteAdvancedMath(view, "sin");
            }
        });

        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExecuteAdvancedMath(view, "cos");
            }
        });

        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExecuteAdvancedMath(view, "tan");
            }
        });

        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExecuteAdvancedMath(view, "ln");
            }
        });

        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExecuteAdvancedMath(view, "sqrt");
            }
        });

        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExecuteAdvancedMath(view, "pow");
            }
        });

        powX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetMathematicalSign(view, "^");
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExecuteAdvancedMath(view, "log");
            }
        });

        return view;
    }


    public void ExecuteAdvancedMath(View view, String type) {

        ExecuteSimpleMath(view);

        TextView input = (TextView) view.findViewById(R.id.input);
        String val = (String) input.getText();

        if (isNumeric(val.substring(val.length() - 1))) {
            double tmp = Double.parseDouble(val);
            switch (type) {
                case "sin":
                    tmp = Math.sin(tmp);
                    break;

                case "cos":
                    tmp = Math.cos(tmp);
                    break;

                case "tan":
                    tmp = Math.tan(tmp);
                    break;

                case "ln":
                    tmp = Math.log10(tmp);
                    break;

                case "sqrt":
                    tmp = Math.sqrt(tmp);
                    break;

                case "pow":
                    tmp = Math.pow(tmp, 2);
                    break;

                case "log":
                    tmp = Math.log(tmp);
                    break;

            }
            input.setText(Double.toString(tmp));
        }
    }

}

