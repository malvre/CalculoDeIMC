package com.malvre.imc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button		btnCalcular;
	EditText	editPeso;
	EditText	editAltura;
	TextView	txtResultado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		loadViews();

		loadEvents();

	}

	private void loadEvents() {
		btnCalcular.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					double peso = Double.parseDouble(editPeso.getText().toString());
					double altura = Double.parseDouble(editAltura.getText().toString());
					double imc = IMC.calcula(peso, altura);
					IMC.render(imc, txtResultado);
					InputMethodManager inputManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
					inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
				} catch (Exception ex) {
					Toast.makeText(MainActivity.this, "Os valores informados devem estar dentro dos par‰metros de c‡lculo",
							Toast.LENGTH_LONG).show();
				}

			}
		});

	}

	private void loadViews() {
		editPeso = (EditText) findViewById(R.id.editPeso);
		editAltura = (EditText) findViewById(R.id.editAltura);
		btnCalcular = (Button) findViewById(R.id.btnCalcular);
		txtResultado = (TextView) findViewById(R.id.txtResultado);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

}
