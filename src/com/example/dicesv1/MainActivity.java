package com.example.dicesv1;

import java.util.Random;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		UpdateScore();
		
		setrollButtonOnClickListener();
	}
	
	int a[] = {1024, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288};
	public Handler mHandler = new Handler();
	public int scor1global, scor2global, rezultat=0;
	
	public Runnable mUpdateTimeTask = new Runnable() {
	    public void run()
	    	{
		    	int zar, scor1, scor2;
				Random r=new Random();
				ImageView zar1 = (ImageView) findViewById(R.id.zar1);
				ImageView zar2 = (ImageView) findViewById(R.id.zar2);
				ImageView zar3 = (ImageView) findViewById(R.id.zar3);
				ImageView zar4 = (ImageView) findViewById(R.id.zar4);
				TextView player1 = (TextView) findViewById(R.id.player1);
				TextView player2 = (TextView) findViewById(R.id.player2);
				Drawable poza;
		    	//zar1
				zar = (r.nextInt(6) + 1);
				poza = getResources().getDrawable(R.drawable.na);
				switch(zar)
				{
				case 1:
					poza = getResources().getDrawable(R.drawable.z1mo);
					break;
				case 2:
					poza = getResources().getDrawable(R.drawable.z2mo);
					break;
				case 3:
					poza = getResources().getDrawable(R.drawable.z3mo);
					break;
				case 4:
					poza = getResources().getDrawable(R.drawable.z4mo);
					break;
				case 5:
					poza = getResources().getDrawable(R.drawable.z5mo);
					break;
				case 6:
					poza = getResources().getDrawable(R.drawable.z6mo);
					break;
				}
				zar1.setImageDrawable(poza);
				scor1 = zar;
				//zar2
				zar = (r.nextInt(6) + 1);
				poza = getResources().getDrawable(R.drawable.na);
				switch(zar)
				{
				case 1:
					poza = getResources().getDrawable(R.drawable.z1mo);
					break;
				case 2:
					poza = getResources().getDrawable(R.drawable.z2mo);
					break;
				case 3:
					poza = getResources().getDrawable(R.drawable.z3mo);
					break;
				case 4:
					poza = getResources().getDrawable(R.drawable.z4mo);
					break;
				case 5:
					poza = getResources().getDrawable(R.drawable.z5mo);
					break;
				case 6:
					poza = getResources().getDrawable(R.drawable.z6mo);
					break;
				}
				zar2.setImageDrawable(poza);
				scor1+=zar;
				
				//zar3
				zar = (r.nextInt(6) + 1);
				poza = getResources().getDrawable(R.drawable.na);
				switch(zar)
				{
				case 1:
					poza = getResources().getDrawable(R.drawable.z1mo);
					break;
				case 2:
					poza = getResources().getDrawable(R.drawable.z2mo);
					break;
				case 3:
					poza = getResources().getDrawable(R.drawable.z3mo);
					break;
				case 4:
					poza = getResources().getDrawable(R.drawable.z4mo);
					break;
				case 5:
					poza = getResources().getDrawable(R.drawable.z5mo);
					break;
				case 6:
					poza = getResources().getDrawable(R.drawable.z6mo);
					break;
				}
				zar3.setImageDrawable(poza);
				scor2 = zar;
				
				//zar4
				zar = (r.nextInt(6) + 1);
				poza = getResources().getDrawable(R.drawable.na);
				switch(zar)
				{
				case 1:
					poza = getResources().getDrawable(R.drawable.z1mo);
					break;
				case 2:
					poza = getResources().getDrawable(R.drawable.z2mo);
					break;
				case 3:
					poza = getResources().getDrawable(R.drawable.z3mo);
					break;
				case 4:
					poza = getResources().getDrawable(R.drawable.z4mo);
					break;
				case 5:
					poza = getResources().getDrawable(R.drawable.z5mo);
					break;
				case 6:
					poza = getResources().getDrawable(R.drawable.z6mo);
					break;
				}
				zar4.setImageDrawable(poza);
				scor2+=zar;
				
				int blue, red, green;
				
				blue = 0xFF0000FF;
				red = 0xFFFF0000;
				green = 0xFF00FF00;
				
				if (scor1 == scor2)
				{
					player1.setText("Player 1: TIE!");
					player2.setText("Player 2: TIE!");
					player1.setTextColor(blue);
					player2.setTextColor(blue);
					rezultat = 0;
				}
				else
					if (scor1>scor2)
					{
						player1.setText("Player 1: WIN!");
						player2.setText("Player2: LOSS!");
						player1.setTextColor(green);
						player2.setTextColor(red);
						rezultat = 1;
					}
					else
					{
						player1.setText("Player 1: LOSS!");
						player2.setText("Player 2: WIN!");
						player1.setTextColor(red);
						player2.setTextColor(green);
						rezultat = 2;
					}
						
	        }
	    };
	
	public void UpdateScore()
	{
		TextView player1score = (TextView) findViewById(R.id.player1score);
		TextView player2score = (TextView) findViewById(R.id.player2score);	
		if (rezultat == 1)
		{
			scor1global++;
			player1score.setText(Integer.toString(scor1global));
		}
		if (rezultat == 2)
		{
			scor2global++;
			player2score.setText(String.valueOf(scor2global));
		}
	}
	    
	public void FunctiaOnClick()
	{
		int i, val;
		for(i=0; i<11; i++)
		{
			val = (int)java.lang.Math.sqrt((float)a[i]);
			mHandler.postDelayed(mUpdateTimeTask, val);
		}
		UpdateScore();
	}

	public void setrollButtonOnClickListener()
	{
		final Button rollDice = (Button) findViewById(R.id.rollButton);
		rollDice.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				FunctiaOnClick();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
