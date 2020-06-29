package com.example.guessingnumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int generatedRandomNumber;
    int usersLife=3;
    public int generateRandomNumber()
    {
        Random random=new Random();
         return random.nextInt(20)+1;
    }
    public void toastMaker(String displayedMassage)
    {
        Toast.makeText(this, displayedMassage, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generatedRandomNumber =generateRandomNumber();
        usersLife=3;
    }

    public void guess(View view) {
        EditText userGuess=findViewById(R.id.usersGuess);
        int userGuessConverted=Integer.parseInt(userGuess.getText().toString());
        if(usersLife==0)
        {
            toastMaker("You don't have any life number will be generated again..");
            generatedRandomNumber=generateRandomNumber();
        }

        if(generatedRandomNumber>userGuessConverted)
        {
            toastMaker("Higher");
            usersLife=usersLife-1;
        }
        else if(generatedRandomNumber<userGuessConverted)
        {
            toastMaker("Lower");
            usersLife=usersLife-1;
        }
        else
            {
                toastMaker("Congratulations you've guessed right, Try again");
                generatedRandomNumber=generateRandomNumber();
                usersLife=3;
            }

    }

}