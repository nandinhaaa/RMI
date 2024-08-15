package br.edu.ifsuldeminas.mch.sd.rmi.client;

import java.net.MalformedURLException;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import br.edu.ifsuldeminas.mch.sd.rmi.remote.Operations;

public class Client {
	public static void main(String[] args) {
		try {
			Operations calc = (Operations) Naming.lookup("rmi://localhost/CalculatorService");
			System.out.println("Soma: " + calc.soma(100, 5));
			System.out.println("Subtração: " + calc.subtracao(1040, 5));
			System.out.println("Multiplicação: " + calc.multiplicacao(10, 200));
			System.out.println("Divisão: " + calc.divisao(10.5, 0.1));
			System.out.println("Raiz: " + calc.raiz(27, 2));
			System.out.println("Potência: " + calc.potencia(2, 3));
			System.out.println("Porcentagem: " + calc.porcentagem(50, 20));
			System.out.println("Módulo: " + calc.modulo(10, 3));
			System.out.println("Fatorial: " + calc.fatorial(5));

			List<String> ultimasOperacoes = calc.ultimasOperacoes(2);
			for (String operacao : ultimasOperacoes)
				System.out.printf("Operação: %s\n", operacao);
		} catch (MalformedURLException murle) {
			System.out.println("Erro na URL de acesso ao serviço.");
		} catch (NotBoundException nbe) {
			System.out.println("Erro ao se ligar ao stub remoto. Nome de serviço inválido.");
		} catch (ConnectException re) {
			System.out.println("Erro ao se conectar. Servidor não iniciado.");
		} catch (RemoteException re) {
			System.out.println("Erro na chamada remota.");
			re.printStackTrace();
		}
	}
}
