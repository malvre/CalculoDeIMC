package com.malvre.imc;

import java.text.DecimalFormat;

import android.graphics.Color;
import android.widget.TextView;

public class IMC {

	public static final double calcula(double peso, double altura) {
		//double resultado = (peso * 1.3) / Math.pow((altura / 100), 2.5);
		double resultado = peso / Math.pow((altura / 100), 2);
		return resultado;
	}

	public static final void render(double imc, TextView v) {
		DecimalFormat df = new DecimalFormat("#,###,##0.00");
		String txtIMC = df.format(imc);

		if (imc < 18.50) {
			v.setText("Seu IMC � " + txtIMC + ", e voc� est� abaixo do peso. V� ao McDonalds mais pr�ximo.");
			v.setBackgroundColor(Color.RED);
			v.setTextColor(Color.WHITE);
		}

		if ((imc >= 18.50) && (imc <= 24.99)) {
			v.setText("Seu IMC � " + txtIMC + ", e voc� est� com o peso normal. Parab�ns.");
			v.setBackgroundColor(Color.GREEN);
			v.setTextColor(Color.BLACK);
		}

		if ((imc >= 25.0) && (imc <= 29.99)) {
			v.setText("Seu IMC � " + txtIMC + ", e voc� est� com sobrepeso. Mexa-se.");
			v.setBackgroundColor(Color.YELLOW);
			v.setTextColor(Color.BLACK);
		}

		if (imc >= 30.0) {
			v.setText("Seu IMC � " + txtIMC + ", e voc� est� obeso. Procure um m�dico, fa�a uma dieta e comece a fazer exerc�cios.");
			v.setBackgroundColor(Color.RED);
			v.setTextColor(Color.WHITE);
		}

	}
}
