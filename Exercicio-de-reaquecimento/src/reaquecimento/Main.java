package reaquecimento;

import java.util.Scanner;

public class Main {
	
	private static Scanner in;

	public static void main(String args[]){
		Banco banco = new Banco();
		in = new Scanner(System.in);
		boolean sair = false;
		do{
			System.out.println("Sou cliente: digite 1");
			System.out.println("Sou caixa: digite 2");
			System.out.println("Sair: digite 3");
			switch(in.nextInt()){
				case 01: {
					System.out.print("Seu Nome: ");
					String nome = in.next();
					System.out.println("Sua idade: ");
					int idade = in.nextInt();
					banco.adicionaNaFila(new Cliente(nome, idade));
					System.out.println("\n");
				}
				break;
				case 02:{
					System.out.println("Seu número de caixa: ");
					int numero = in.nextInt();
					System.out.println("Próximo usuário é: ");
					Cliente cliente = banco.retiraFila(new Caixa(numero));
					System.out.println("Nome: " + cliente.getNome());
					System.out.println("\n");
				}
				break;
				case 03: {
					sair = true;
				}
				break;
				default: {
					sair = true;
				}
			}
		}while(!sair);
	}
}
