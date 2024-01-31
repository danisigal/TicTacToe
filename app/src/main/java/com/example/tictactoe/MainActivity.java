package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.BaseMenuPresenter;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    String turn;
    String[][] board;
    int count;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void onButtonClick (View view){
        final int id = view.getId();
            if (id == R.id.btn_00)
            {
                handleClick(0, 0, R.id.btn_00);
            }
                if(id == R.id.btn_01){
                    handleClick(0, 1, R.id.btn_01);
                }
//add more buttons
            }


            private void onNewGame () {
                board = new String[3][3];
                for (int row = 0; row < 3; row++)
                    for (int col = 0; col < 3; col++)
                        board[row][col] = new String();
                turn = "X";
                count = 0;
            }


        private void onTurnEnd() {
            // בדיקה האם יש מנצח - חשוב לבצע לפני הבדיקה אם הלוח מלא
            if (isWinner())
                endGame(turn + " won!");
            else {
                count++;
                // בדיקת מצב לוח מלא (תיקו)
                if (count == 9)
                    endGame("Tie");
                else {
                    // העברת התור
                    turn = (turn.equals("X") ? "O" : "X");
                }
            }
        }

    private void endGame(String s) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("More Info");
        String msg = "This is the message body";
        builder.setMessage(msg);
        builder.setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
// Exit handling

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
// Cancel handling

            }
        });
        AlertDialog dialog = builder.show();

    }

    private boolean isWinner() {
        //אם יש בשורה טור או אלכסון שלושה איקסים או שלושה עיגולים ברצף אז שיהיה כתוב שהוא ניצח
        // אם יש בשורה שלושה אותו הדבר אז ניצחון

    if(R.id.btn_00 == R.id.btn_01 &&R.id.btn_01 == R.id.btn_02){
        boolean isWinner = true;
    }
        if(R.id.btn_10 == R.id.btn_11 && R.id.btn_11 == R.id.btn_12){
            boolean isWinner = true;
        }
        if(R.id.btn_20 == R.id.btn_21 && R.id.btn_21 == R.id.btn_22){
            boolean isWinner = true;
        }

            //אם יש בטור שלושה אותו דבר אז ניצחון
        if(R.id.btn_00 == R.id.btn_10 && R.id.btn_10 == R.id.btn_20){
            boolean isWinner = true;
        }
        if(R.id.btn_01 == R.id.btn_11 && R.id.btn_11 == R.id.btn_21){
            boolean isWinner = true;
        }
        if(R.id.btn_02 == R.id.btn_12  && R.id.btn_12 == R.id.btn_22){
            boolean isWinner = true;
        }

        //אם יש טיר עם שלושה אותו הדבר אז ניצחון
        if(R.id.btn_00 == R.id.btn_11 && R.id.btn_11 == R.id.btn_22){
            boolean isWinner = true;
        }
        if(R.id.btn_02 == R.id.btn_11 && R.id.btn_11 == R.id.btn_20){
            boolean isWinner = true;
        }
        return false;
    }


    private void handleClick( int col, int row, int id) {
        if (board[row][col].equals("")) {
            board[row][col] = turn;
            Button btn = findViewById(id);
            btn.setText(turn);
            onTurnEnd();
        }

    }
}
