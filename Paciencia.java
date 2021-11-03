package TRAB1PT2;
import java.util.Scanner;

public class Paciencia {
    
    private static Scanner entrada;

    public void executa() {
		entrada = new Scanner(System.in);
		int opcao;
		System.out.println("--- BEM VINDO AO JOGO DE PACIENCIA MARCIANA ---");
		do
		{
			System.out.println("Digite 1 para iniciar o jogo");
			System.out.println("Digite 0 para sair da aplicacao");
			opcao = entrada.nextInt();
			switch(opcao)
			{
				case 1:
					jogo();
					break;
			}
		} while(opcao != 0);

		System.out.println("Obrigado por utilizar o programa! :D");
	}

	public void jogo() {
		LinkedListOfInteger lista = new LinkedListOfInteger();
		int numero;
		entrada.nextLine();
		System.out.println("Escolha seu numero inicial: ");
		numero = entrada.nextInt();
		while (numero >= 20) {
			System.out.println("Numero invalido");
			System.out.println("Escolha seu numero inicial: ");
			numero = entrada.nextInt();
		}
		lista.addFirst(numero);
		int numeroFinal = 1;
		int index = 0;
		int count = 0;

		while(lista.get(index) != numeroFinal)
		{
			if (lista.get(index) % 2 == 0)
			{
				lista.set(index, lista.get(index) / 2);
				if (index == 0 && lista.size() != 1)
				{
					lista.add(index + 1, lista.get(index));
					lista.add(lista.size(), lista.get(index));
				}
				else {
					lista.add(index + 1, lista.get(index));
					lista.add(index + 2, lista.get(index));
					index++;
				}
				while (count != 5) {
					if (index == lista.size() - 1) {
						index = 0;
					}
					else {
						index++;
					}
					count++;
				}
			}
			else
			{
				lista.set(index, lista.get(index) - 1);
				if (index == 0 && lista.size() != 1)
				{
					lista.add(index + 1, lista.get(index));
					lista.add(lista.size(), lista.get(index));
				}
				else {
					lista.add(index + 1, lista.get(index));
					lista.add(index + 2, lista.get(index));
					index++;
				}
				while (count != 5) {
					if (index == 0) {
						index = lista.size() - 1;
					}
					else {
						index--;
					}
					count++;
				}
			}
			count = 0;
			for (int i = 0; i < lista.size(); i++) {
				if (index == i) {
					System.out.print("["+ lista.get(i) + "]" + " ");
				}
				else {
					System.out.print(lista.get(i) + " ");
				}
			}
			System.out.println("\n");
		}
		System.out.println("Número de elementos no final: " + lista.size());
		lista.clear();
	}
	/* TABELA A PEDIDO DO PRIMO
	NÚMERO INICIAL / ELEMENTOS NO CIRCULO NO FIM DO JOGO
	100 MIL / 57475
	200 MIL / 123405
	300 MIL / 210825
	400 MIL / 312545
	500 MIL / 439705
	1 MILHÃO / 658785
	*/
}
