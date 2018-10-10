package com.example.moose.gpa_mohaam_calculator;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   ConstraintLayout layout;
   TextView gpaTV;
   EditText class1, class2, class3, class4, class5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gpaTV = findViewById(R.id.textViewGPA);
        class1 = findViewById(R.id.editText1);
        class2 = findViewById(R.id.editText2);
        class3 = findViewById(R.id.editText3);
        class4 = findViewById(R.id.editText4);
        class5 = findViewById(R.id.editText5);
        layout = findViewById(R.id.layout1);

    }

    //Checks to see if editText fields are empty
    private boolean isEmpty()
    {
        if(class1.getText().toString().trim().isEmpty() || Double.parseDouble(class1.getText().toString().trim()) > 100)
            return false;
        else if(class2.getText().toString().trim().isEmpty() || Double.parseDouble(class2.getText().toString().trim()) > 100)
            return false;
        else if(class3.getText().toString().trim().isEmpty()|| Double.parseDouble(class3.getText().toString().trim()) > 100)
            return false;
        else if(class4.getText().toString().trim().isEmpty()|| Double.parseDouble(class4.getText().toString().trim()) > 100)
            return false;
        else if(class5.getText().toString().trim().isEmpty()|| Double.parseDouble(class5.getText().toString().trim()) > 100)
            return false;

        else
            return true;
    }


    public void btn_Calc(View view) {

        if (!isEmpty())
        {
            Toast.makeText(MainActivity.this,"INVALID INPUT...empty fields and numbers over 100 not allowed...TRY AGAIN",Toast.LENGTH_SHORT).show();
            class1.getText().toString().trim();
            class2.getText().toString().trim();
            class3.getText().toString().trim();
            class4.getText().toString().trim();
            class5.getText().toString().trim();
            isEmpty();
        }
        else
            calc_Grade();
    }

    private void calc_Grade()
    {
        double grade1, grade2, grade3, grade4, grade5;
        grade1 = Double.parseDouble(class1.getText().toString().trim());
        grade2 = Double.parseDouble(class2.getText().toString().trim());
        grade3 = Double.parseDouble(class3.getText().toString().trim());
        grade4 = Double.parseDouble(class4.getText().toString().trim());
        grade5 = Double.parseDouble(class5.getText().toString().trim());



        double gpa = ((grade1 + grade2 + grade3 + grade4 + grade5)/5);

        if(gpa <= 60)
        {
            layout.setBackgroundColor(Color.RED);
            gpaTV.setText("Uh-oh, your GPA is " + gpa);
        }
        else if (gpa >60 && gpa <=79)
        {
            layout.setBackgroundColor(Color.YELLOW);
            gpaTV.setText("Keep it up, your GPA is " + gpa);
        }
        else if (gpa > 80 && gpa <=100)
        {
            layout.setBackgroundColor(Color.GREEN);
            gpaTV.setText("Nice job, your GPA is " + gpa);
        }

        clear_Form();
    }

    private void clear_Form() {
        class1.setText("");
        class2.setText("");
        class3.setText("");
        class4.setText("");
        class5.setText("");
    }

}
