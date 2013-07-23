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
			v.setText("Seu IMC é " + txtIMC + ", e você está abaixo do peso. Vá ao McDonalds mais próximo.");
			v.setBackgroundColor(Color.RED);
			v.setTextColor(Color.WHITE);
		}

		if ((imc >= 18.50) && (imc <= 24.99)) {
			v.setText("Seu IMC é " + txtIMC + ", e você está com o peso normal. Parabéns.");
			v.setBackgroundColor(Color.GREEN);
			v.setTextColor(Color.BLACK);
		}

		if ((imc >= 25.0) && (imc <= 29.99)) {
			v.setText("Seu IMC é " + txtIMC + ", e você está com sobrepeso. Mexa-se.");
			v.setBackgroundColor(Color.YELLOW);
			v.setTextColor(Color.BLACK);
		}

		if (imc >= 30.0) {
			v.setText("Seu IMC é " + txtIMC + ", e você está obeso. Procure um médico, faça uma dieta e comece a fazer exercícios.");
			v.setBackgroundColor(Color.RED);
			v.setTextColor(Color.WHITE);
		}

	}
}
