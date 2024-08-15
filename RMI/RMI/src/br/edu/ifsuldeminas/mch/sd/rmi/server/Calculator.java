package br.edu.ifsuldeminas.mch.sd.rmi.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.edu.ifsuldeminas.mch.sd.rmi.remote.Operations;

public class Calculator implements Operations {
	private List<String> ultimasOperacoes = new ArrayList<String>();

	public Number soma(Number x, Number y) {
		Number resultado = x.doubleValue() + y.doubleValue();
		log(x, "+", y, resultado);
		return resultado;
	}

	public Number subtracao(Number x, Number y) {
		Number resultado = x.doubleValue() - y.doubleValue();
		log(x, "-", y, resultado);
		return resultado;
	}

	public Number multiplicacao(Number x, Number y) {
		Number resultado = x.doubleValue() * y.doubleValue();
		log(x, "*", y, resultado);
		return resultado;
	}

	public Number divisao(Number x, Number y) {
		Number resultado = Double.NaN;
		if (y.doubleValue() != 0)
			resultado = x.doubleValue() / y.doubleValue();
		log(x, "/", y, resultado);
		return resultado;
	}

	public Number potencia(Number x, Number y) {
		Number resultado = Math.pow(x.doubleValue(), y.doubleValue());
		log(x, "^", y, resultado);
		return resultado;
	}

	public Number porcentagem(Number x, Number y) {
		Number resultado = (x.doubleValue() * y.doubleValue()) / 100;
		log(x, "%", y, resultado);
		return resultado;
	}

	public Number modulo(Number x, Number y) {
		Number resultado = x.doubleValue() % y.doubleValue();
		log(x, "%", y, resultado);
		return resultado;
	}

	public Number fatorial(Number x) {
		int n = x.intValue();
		if (n < 0)
			return Double.NaN;
		Number resultado = 1;
		for (int i = 1; i <= n; i++) {
			resultado = resultado.doubleValue() * i;
		}
		log(x, "!", resultado);
		return resultado;
	}

	public Number raiz(Number x, int grau) {
		Number resultado = Double.NaN;
		if (grau > 0)
			resultado = Math.pow(x.doubleValue(), 1.0 / grau);
		log(x, "√" + grau, resultado);
		return resultado;
	}

	public List<String> ultimasOperacoes(int quantas) {
		if (ultimasOperacoes.size() < quantas)
			return ultimasOperacoes();
		return new ArrayList<String>(
				ultimasOperacoes.subList(ultimasOperacoes.size() - quantas, ultimasOperacoes.size()));
	}

	public List<String> ultimasOperacoes() {
		return ultimasOperacoes;
	}

	private void log(Number operadorUm, String operacao, Number operadorDois, Number resultado) {
		String operacaoFormatada = String.format("%s %s %s = %s", operadorUm.toString(), operacao,
				operadorDois.toString(), resultado.toString());
		ultimasOperacoes.add(operacaoFormatada);
		System.out.printf("%s at %s\n", operacaoFormatada, new Date());
	}

	private void log(Number operadorUm, String operacao, Number resultado) {
		String operacaoFormatada = String.format("%s %s = %s", operadorUm.toString(), operacao, resultado.toString());
		ultimasOperacoes.add(operacaoFormatada);
		System.out.printf("%s at %s\n", operacaoFormatada, new Date());
	}
}
