package br.edu.ifsuldeminas.mch.sd.rmi.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Operations extends Remote {
	Number soma(Number x, Number y) throws RemoteException;

	Number subtracao(Number x, Number y) throws RemoteException;

	Number multiplicacao(Number x, Number y) throws RemoteException;

	Number divisao(Number x, Number y) throws RemoteException;

	List<String> ultimasOperacoes(int quantas) throws RemoteException;

	List<String> ultimasOperacoes() throws RemoteException;

	Number potencia(Number x, Number y) throws RemoteException;

	Number porcentagem(Number x, Number y) throws RemoteException;

	Number modulo(Number x, Number y) throws RemoteException;

	Number fatorial(Number x) throws RemoteException;

	Number raiz(Number x, int grau) throws RemoteException;
}
