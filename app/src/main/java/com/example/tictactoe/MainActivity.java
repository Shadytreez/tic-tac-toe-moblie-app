package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int O = 1;
    int X = 2;
    boolean turn; //true for O, false for X
    int [][] graph ={{0,0,0}, // 0
            {0,0,0}, //1
            {0,0,0}}; //2
    //blank graph

    //idea of the app tiktactoe
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rd = new Random();
        turn = rd.nextBoolean();
        if( turn == true){
            ((TextView)findViewById(R.id.textView)).setText("It's O turn");
        }else if (turn == false){
            ((TextView)findViewById(R.id.textView)).setText("It's X turn");
        }
    }

    public void turn (View v){
        if(turn == true){

            //((Button)findViewById(v.getId())).setText("O");
            switch (v.getId())
            {
                case  R.id.a1:
                    if(graph[0][0] == 0){
                        graph[0][0] = 1;
                        colorO(v);
                        winner(O,0,0);
                    }
                    break;
                case  R.id.a2:
                    if(graph[0][1] == 0){
                        graph[0][1] = 1;
                        colorO(v);
                        winner(O,0,1);

                    }
                    break;
                case  R.id.a3:
                    if(graph[0][2] == 0){
                        graph[0][2] = 1;
                        colorO(v);
                        winner(O,0,2);

                    }
                    break;
                case  R.id.a4:
                    if(graph[1][0] == 0){
                        graph[1][0] = 1;
                        colorO(v);
                        winner(O,1,0);

                    }
                    break;
                case  R.id.a5:
                    if(graph[1][1] == 0){
                        graph[1][1] = 1;
                        colorO(v);
                        winner(O,1,1);

                    }
                    break;
                case  R.id.a6:
                    if(graph[1][2] == 0){
                        graph[1][2] = 1;
                        colorO(v);
                        winner(O,1,2);
                    }
                    break;
                case  R.id.a7:
                    if(graph[2][0] == 0){
                        graph[2][0] = 1;
                        colorO(v);
                        winner(O,2,0);

                    }
                    break;
                case  R.id.a8:
                    if(graph[2][1] == 0){
                        graph[2][1] = 1;
                        colorO(v);
                        winner(O,2,1);

                    }
                    break;
                case  R.id.a9:
                    if(graph[2][2] == 0){
                        graph[2][2] = 1;
                        colorO(v);
                        winner(O,2,2);


                    }
                    break;
                default:
                    break;
            }


            //((Button)findViewById(R.id.a2)).setText("O");
        }else if(turn == false){
            switch (v.getId())
            {
                case  R.id.a1:
                    if(graph[0][0] == 0){
                        graph[0][0] = 2;
                        colorX(v);
                        winner(X,0,0);

                    }
                    break;
                case  R.id.a2:
                    if(graph[0][1] == 0){
                        graph[0][1] = 2;
                        colorX(v);
                        winner(X,0,1);

                    }
                    break;
                case  R.id.a3:
                    if(graph[0][2] == 0){
                        graph[0][2] = 2;
                        colorX(v);
                        winner(X,0,2);

                    }
                    break;
                case  R.id.a4:
                    if(graph[1][0] == 0){
                        graph[1][0] = 2;
                        colorX(v);
                        winner(X,1,0);

                    }
                    break;
                case  R.id.a5:
                    if(graph[1][1] == 0){
                        graph[1][1] = 2;
                        colorX(v);
                        winner(X,1,1);

                    }
                    break;
                case  R.id.a6:
                    if(graph[1][2] == 0){
                        graph[1][2] = 2;
                        colorX(v);
                        winner(X,1,2);

                    }
                    break;
                case  R.id.a7:
                    if(graph[2][0] == 0){
                        graph[2][0] = 2;
                        colorX(v);
                        winner(X,2,0);

                    }
                    break;
                case  R.id.a8:
                    if(graph[2][1] == 0){
                        graph[2][1] = 2;
                        colorX(v);
                        winner(X,2,1);

                    }
                    break;
                case  R.id.a9:
                    if(graph[2][2] == 0){
                        graph[2][2] = 2;
                        colorX(v);
                        winner(X,2,2);

                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void colorO(View v){
        ((Button)findViewById(v.getId())).setText("O");
        ((Button)findViewById(v.getId())).setBackgroundColor(Color.GREEN);
        turn = false;
        ((TextView)findViewById(R.id.textView)).setText("It's X turn");
    }
    public void colorX(View v){
        ((Button)findViewById(v.getId())).setText("X");
        ((Button)findViewById(v.getId())).setBackgroundColor(Color.RED);
        turn = true;
        ((TextView)findViewById(R.id.textView)).setText("It's O turn");
    }

    public void winner(int shapes, int placement, int placement1){
        try {
            if (graph[placement + 1][placement1] == shapes && graph[placement - 1][placement1] == shapes) {
                gameover(shapes);
                return;
            }}
            catch(ArrayIndexOutOfBoundsException e) {     }
        try{
            if (graph[placement + 1][placement1 + 1] == shapes && graph[placement + 2][placement1 + 2] == shapes) {
                gameover(shapes);
                return;
            }
        }
        catch(ArrayIndexOutOfBoundsException e) { }

        try{
            if (graph[placement - 1][placement1 + 1] == shapes && graph[placement + 1][placement1 - 1] == shapes) {
                gameover(shapes);
                return;
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {

        }
        try{
            if (graph[placement - 2][placement1] == shapes && graph[placement - 1][placement1] == shapes) {
                gameover(shapes);
                return;
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {

        }
        try{
            if (graph[placement + 1][placement1] == shapes && graph[placement + 2][placement1] == shapes) {
                gameover(shapes);
                return;
            }
        }
        catch(ArrayIndexOutOfBoundsException e) { }

        try{
            if (graph[placement][placement1 + 1] == shapes && graph[placement][placement1 + 2] == shapes) {
                gameover(shapes);
                return;
            }
        }
        catch(ArrayIndexOutOfBoundsException e) { }
        try{
            if (graph[placement][placement1 - 1] == shapes && graph[placement][placement1 - 2] == shapes) {
                gameover(shapes);
                return;
            }
        }
        catch(ArrayIndexOutOfBoundsException e) { }
        try{
            if (graph[placement - 1][placement1 + 1] == shapes && graph[placement - 2][placement1 + 2] == shapes) {
                gameover(shapes);
                return;
            }
        }
        catch(ArrayIndexOutOfBoundsException e) { }
        try{
            if (graph[placement + 1][placement1 - 1] == shapes && graph[placement + 2][placement1 - 2] == shapes) {
                gameover(shapes);
                return;
            }
        }
        catch(ArrayIndexOutOfBoundsException e) { }

        for (int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length;j++){
                if(graph[i][j] == 0){
                    return;
                }
            }
        }
        gameover(3);

    }



    public void gameover(int win){
        if(win == 1){
            ((TextView)findViewById(R.id.textView)).setText("O won");
        }else if(win == 2){
            ((TextView)findViewById(R.id.textView)).setText("X won");
        }else if (win == 3){
            ((TextView)findViewById(R.id.textView)).setText("No one won");
        }
        ((Button)findViewById(R.id.a1)).setEnabled(false);
        ((Button)findViewById(R.id.a2)).setEnabled(false);
        ((Button)findViewById(R.id.a3)).setEnabled(false);
        ((Button)findViewById(R.id.a4)).setEnabled(false);
        ((Button)findViewById(R.id.a5)).setEnabled(false);
        ((Button)findViewById(R.id.a6)).setEnabled(false);
        ((Button)findViewById(R.id.a7)).setEnabled(false);
        ((Button)findViewById(R.id.a8)).setEnabled(false);
        ((Button)findViewById(R.id.a9)).setEnabled(false);

        ((Button)findViewById(R.id.reset)).setVisibility(View.VISIBLE);
    }

    public void reset (View v){
        recreate(); // the current instance will go through its lifecycle to onDestroy() and a new instance then created after it.
    }
}