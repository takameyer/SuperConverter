package com.takameyer.superconverter;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
	
	private static final String CURRENT_FAHRENHEIT = "CURRENT_FAHRENHEIT";
	private static final String CURRENT_CELCIUS = "CURRENT_CELCIUS";
	private static final String CURRENT_MILES = "CURRENT_MILES";
	private static final String CURRENT_KM = "CURRENT_KM";
	private static final String CURRENT_FEET = "CURRENT_FEET";
	private static final String CURRENT_METERS = "CURRENT_METERS";
	private static final String CURRENT_INCHES = "CURRENT_INCHES";
	private static final String CURRENT_CM = "CURRENT_CM";
	private static final String CURRENT_LBS = "CURRENT_LBS";
	private static final String CURRENT_KG = "CURRENT_KG";

	private double fahrenheit;
	private double celcius;
	private double miles;
	private double km;
	private double feet;
	private double meters;
	private double inches;
	private double cm;
	private double lbs;
	private double kg;
	
	EditText fahrenheitET;
	EditText celciusET;
	EditText milesET;
	EditText kmET;
	EditText feetET;
	EditText metersET;
	EditText inchesET;
	EditText cmET;
	EditText lbsET;
	EditText kgET;
	
	public enum e_DEGREES {
	    FAHRENHEIT, CELCIUS
	}
	
	public enum e_DISTANCE {
	    MILES, KM, FEET, METERS,
	    INCHES, CM 
	}
	
	public enum e_WEIGHT {
	    LBS, KG
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if(savedInstanceState == null) // initialize variables
		{
			fahrenheit = 0.0;
			celcius = 0.0;
			miles = 0.0;
			km = 0.0;
			feet = 0.0;
			meters = 0.0;
			inches = 0.0;
			cm = 0.0;
			lbs = 0.0;
			kg = 0.0;
		}
		else // restore saved state
		{
			fahrenheit = savedInstanceState.getDouble(CURRENT_FAHRENHEIT);
			celcius = savedInstanceState.getDouble(CURRENT_CELCIUS);
			miles = savedInstanceState.getDouble(CURRENT_MILES);
			km = savedInstanceState.getDouble(CURRENT_KM);
			feet = savedInstanceState.getDouble(CURRENT_FEET);
			meters = savedInstanceState.getDouble(CURRENT_METERS);
			inches = savedInstanceState.getDouble(CURRENT_INCHES);
			cm = savedInstanceState.getDouble(CURRENT_CM);
			lbs = savedInstanceState.getDouble(CURRENT_LBS);
			kg = savedInstanceState.getDouble(CURRENT_KG);
		}
		
		// Set Edit Text field objects
		fahrenheitET = (EditText) findViewById(R.id.fahrenheitEditText);
		celciusET = (EditText) findViewById(R.id.celciusEditText);
		milesET = (EditText) findViewById(R.id.milesEditText);
		kmET = (EditText) findViewById(R.id.kmEditText);
		feetET = (EditText) findViewById(R.id.feetEditText);
		metersET = (EditText) findViewById(R.id.metersEditText);
		inchesET = (EditText) findViewById(R.id.inchesEditText);
		cmET = (EditText) findViewById(R.id.cmEditText);
		lbsET = (EditText) findViewById(R.id.lbsEditText);
		kgET = (EditText) findViewById(R.id.kgEditText);
		
		// Create Listeners
		// Update Degrees
		fahrenheitET.addTextChangedListener(fehrenheitListener);
		celciusET.addTextChangedListener(celciusListener);
		
		// Update Distance
		milesET.addTextChangedListener(milesListener);
		kmET.addTextChangedListener(kmListener);
		feetET.addTextChangedListener(feetListener);
		metersET.addTextChangedListener(metersListener);
		inchesET.addTextChangedListener(inchesListener);
		cmET.addTextChangedListener(cmListener);
		
		// Update Weight
		lbsET.addTextChangedListener(lbsListener);
		kgET.addTextChangedListener(kgListener);
	}

	private TextWatcher fehrenheitListener = new TextWatcher(){

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
					
			double fahrenheitsent = Double.parseDouble(s.toString());
			if( fahrenheit != fahrenheitsent)
				{
				try{
					fahrenheit = Double.parseDouble(s.toString());
				}
				catch(NumberFormatException e){
					fahrenheit = 0.0;
				}
				
				updateDegrees(e_DEGREES.FAHRENHEIT);
			}
								
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}
		
	};
	private TextWatcher celciusListener = new TextWatcher(){

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			double celciussent = Double.parseDouble(s.toString());
			
			if( celcius != celciussent)
			{
				try{
					celcius = Double.parseDouble(s.toString());
				}
				catch(NumberFormatException e){
					celcius = 0.0;
				}
				
				updateDegrees(e_DEGREES.CELCIUS);
			}		
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	private void updateDegrees( e_DEGREES degreeType ){
		// determine which value had the update recalculate related values
		switch( degreeType )
		{
		case FAHRENHEIT:	// dirty calculation
							celcius = ( fahrenheit - 32 ) * 0.5555;
							celciusET.setText(String.format("%.03f", celcius));
			break;
		case CELCIUS:	    // dirty calculation
							fahrenheit = celcius * 1.8 + 32;
							fahrenheitET.setText(String.format("%.03f", fahrenheit));
			break;
		default:
			break;
		}	
	}
	
	private TextWatcher milesListener = new TextWatcher(){

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			double milesSent = Double.parseDouble(s.toString());
			
			if( miles != milesSent )
			{
				try{
					miles = milesSent;
				}
				catch(NumberFormatException e){
					miles = 0.0;
				}
				
				updateDistance(e_DISTANCE.MILES);
			}
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}

	};
	
	private TextWatcher kmListener = new TextWatcher(){

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			double kmSent = Double.parseDouble(s.toString());
			
			if( km != kmSent )
			{
				try{
					km = kmSent;
				}
				catch(NumberFormatException e){
					km = 0.0;
				}
				
				updateDistance(e_DISTANCE.KM);
			}
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}

	};
	
	private TextWatcher feetListener = new TextWatcher(){

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			double feetSent = Double.parseDouble(s.toString());
			
			if( feet != feetSent )
			{
				try{
					feet = feetSent;
				}
				catch(NumberFormatException e){
					feet = 0.0;
				}
				
				updateDistance(e_DISTANCE.FEET);
			}
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}

	};
	
	private TextWatcher metersListener = new TextWatcher(){

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			double metersSent = Double.parseDouble(s.toString());
			
			if( meters != metersSent )
			{
				try{
					meters = metersSent;
				}
				catch(NumberFormatException e){
					meters = 0.0;
				}
				
				updateDistance(e_DISTANCE.METERS);
			}
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}

	};
	
	private TextWatcher inchesListener = new TextWatcher(){

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			double inchesSent = Double.parseDouble(s.toString());
			
			if( inches != inchesSent )
			{
				try{
					inches = inchesSent;
				}
				catch(NumberFormatException e){
					inches = 0.0;
				}
				
				updateDistance(e_DISTANCE.INCHES);
			}
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}

	};
	private TextWatcher cmListener = new TextWatcher(){

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			double cmSent = Double.parseDouble(s.toString());
			
			if( cm != cmSent )
			{
				try{
					cm = cmSent;
				}
				catch(NumberFormatException e){
					cm = 0.0;
				}
				
				updateDistance(e_DISTANCE.CM);
			}
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}

	};
	
	private void updateDistance( e_DISTANCE distanceType )
	{
		// DIRTY MATH! CLEAN THIS UP
		switch( distanceType )
		{
		case MILES:
			km = miles * 1.6;
			kmET.setText(String.format("%.03f", km));
			break;
		case KM:
			miles = km * 0.621;
			milesET.setText(String.format("%.03f", miles));
			break;
		case FEET:
			meters = feet * 0.305;
			metersET.setText(String.format("%.03f", meters));
			break;
		case METERS:
			feet = meters * 3.281;	
			feetET.setText(String.format("%.03f", feet));
			break;
		case INCHES:
			cm = inches * 2.540;
			cmET.setText(String.format("%.03f", cm));
			break;
		case CM:
			inches = cm * 0.394;
			inchesET.setText(String.format("%.03f", inches));
			break;
		default:
			break;
		}
	}
	
	private TextWatcher lbsListener = new TextWatcher(){

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			double lbsSent = Double.parseDouble(s.toString());
			
			if( lbs != lbsSent )
			{
				try{
					lbs = lbsSent;
				}
				catch(NumberFormatException e){
					lbs = 0.0;
				}
				
				updateWeight(e_WEIGHT.LBS);
			}
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}

	};
	
	private TextWatcher kgListener = new TextWatcher(){

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			double kgSent = Double.parseDouble(s.toString());
			
			if( kg != kgSent )
			{
				try{
					kg = kgSent;
				}
				catch(NumberFormatException e){
					kg = 0.0;
				}
				
				updateWeight(e_WEIGHT.KG);
			}
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}

	};
	
	private void updateWeight( e_WEIGHT weightType )
	{
		// DIRTY MATH! CLEAN THIS UP
		switch( weightType )
		{
		case LBS:
			kg = lbs * 0.454;
			kgET.setText(String.format("%.03f", kg));
			break;
		case KG:
			lbs = kg * 2.205;
			lbsET.setText(String.format("%.03f", lbs));
			break;
		default:
			break;
		}
	}
	
	protected void onSaveInstanceState(Bundle outState)
	{	
		super.onSaveInstanceState(outState);
		
		outState.putDouble(CURRENT_FAHRENHEIT, fahrenheit);
		outState.putDouble(CURRENT_CELCIUS, celcius );
		outState.putDouble(CURRENT_MILES, miles );
		outState.putDouble(CURRENT_KM, km );
		outState.putDouble(CURRENT_FEET, feet );
		outState.putDouble(CURRENT_METERS, meters );
		outState.putDouble(CURRENT_INCHES, inches );
		outState.putDouble(CURRENT_CM, cm );
		outState.putDouble(CURRENT_LBS, lbs );
		outState.putDouble(CURRENT_KG, kg );	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
