package my.edu.taruc.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_MESSAGE = "my.edu.taruc.lab2.MESSAGE" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        EditText editTextMessage;
        EditText editTextMessage2;
        editTextMessage = findViewById(R.id.editTextMessage);
        editTextMessage2 = findViewById(R.id.editTextMessage2);
        if(TextUtils.isEmpty(editTextMessage.getText())){ //check if empty
            editTextMessage.setError(getString(R.string.error_message)); //set error message
            return;
        }
        if(TextUtils.isEmpty(editTextMessage2.getText())){ //check if empty
            editTextMessage2.setError(getString(R.string.error_message)); //set error message
            return;
        }
        // String stringMsg;
       // stringMsg = editTextMessage.getText().toString();
        double weight;
        weight = Double.parseDouble(editTextMessage.getText().toString());
        double height;
        height = Double.parseDouble(editTextMessage2.getText().toString());

        double BMI;
        BMI = weight/(height*height);
        String displayWord;

        if(BMI<18.5){
            displayWord ="Underweight";
        }
        else if(BMI>=18.5 && BMI<=24.9){
            displayWord="Normal weight";
        }
        else if(BMI>=25 && BMI<=29.9){
            displayWord="Overweight";
        }
        else{
            displayWord="Obesity";
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(TAG_MESSAGE,displayWord);
        startActivity(intent);

        // intent.putExtra(TAG_MESSAGE,stringMsg);
        //startActivity(intent);

    }

}
