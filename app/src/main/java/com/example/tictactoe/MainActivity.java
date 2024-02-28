package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.BaseMenuPresenter;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    String turn;
    String[][] board;
    int count;
    private static final String TAG = "com.android.TicTacToe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onNewGame();
    }

    public void onButtonClick (View view){
        Log.d(TAG, "onButtonclick");
        final int id = view.getId();
        if (id == R.id.btn_00)
        {
            handleClick(0, 0, R.id.btn_00);
        }
        if(id == R.id.btn_01){
            handleClick(0, 1, R.id.btn_01);
        }
        if(id == R.id.btn_02){
            handleClick(0, 2, R.id.btn_02);
        }
        if(id == R.id.btn_10){
            handleClick(1, 0, R.id.btn_10);
        }
        if(id == R.id.btn_11){
            handleClick(1, 1, R.id.btn_11);
        }
        if(id == R.id.btn_12){
            handleClick(1, 2, R.id.btn_12);
        }
        if(id == R.id.btn_20){
            handleClick(2, 0, R.id.btn_20);
        }
        if(id == R.id.btn_21){
            handleClick(2, 1, R.id.btn_21);
        }
        if(id == R.id.btn_22){
            handleClick(2, 2, R.id.btn_22);
        }
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
            Log.d(TAG, "onTurnEnd");
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
        Log.d(TAG, "endGame");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("More Info");
        builder.setMessage(s);
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
        Log.d(TAG, "isWinner");
        boolean isWinner = false;

        //אם יש בשורה טור או אלכסון שלושה איקסים או שלושה עיגולים ברצף אז שיהיה כתוב שהוא ניצח
        // אם יש בשורה שלושה אותו הדבר אז ניצחון

    if(board[0][0] == board[0][1] && board[0][1] == board[0][2]){
         isWinner = true;
    }
        if(board[1][0] == board[1][1]&& board[1][1] == board[1][2] ){
             isWinner = true;
        }
        if(board[2][0] == board[2][1]&& board[2][1] == board[2][2]){
             isWinner = true;
        }

            //אם יש בטור שלושה אותו דבר אז ניצחון
        if(board[0][0] == board[1][0] && board[1][0] ==board[2][0]){
             isWinner = true;
        }
        if(board[0][1] == board[1][1] && board[1][1] ==board[2][2]){
             isWinner = true;
        }
        if(board[0][2] == board[1][2] && board[1][2] ==board[2][2]){
             isWinner = true;
        }

        //אם יש טיר עם שלושה אותו הדבר אז ניצחון
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2]){
             isWinner = true;
        }
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0] ){
             isWinner = true;
        }
        return isWinner;
    }


    private void handleClick( int col, int row, int id) {
        Log.d(TAG, "handleclick");
        if (board[row][col].equals("")) {
            board[row][col] = turn;
            Button btn = findViewById(id);
            btn.setText(turn);
            onTurnEnd();
        }

    }
}
