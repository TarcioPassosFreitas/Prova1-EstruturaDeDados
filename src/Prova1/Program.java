package Prova1;

import java.util.Locale;
import java.util.Scanner;


public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		ListaEncadeada Kanto = new ListaEncadeada();
		ListaEncadeada Hoenn = new ListaEncadeada();
		
		System.out.println("Bem-vindo a Poké-Agenda");
		
		for(int i = 0; i < 3; i++) {
			Kanto.insert(new Pokemon(rand(1, 200), rand(300, 2000)));
			Hoenn.insert(new Pokemon(rand(1, 200), rand(300, 2000)));
		}
		
		Kanto.displayLista();
		System.out.println("**************");
		Hoenn.displayLista();
		
		int k = 0, i = 0, h = 0;
		while(k <= 0 || k > 97 ) {
			System.out.println("Digite a quantidade de Pokemons Encontrados na Região de Kanto. Considere:  (1 <= K <= 97)");
			k = sc.nextInt();
		}
		
		int ID = 0, AT = 0;
		while(i < k) {
			while(ID < 1 || ID > 200) {
				System.out.println("Digite o id do Pokemon encontrado:");
				ID = sc.nextInt();
			}
			while(AT < 300 || AT > 2000) {
				System.out.println("Digite o Ataque do Pokemon encontrado:");
				AT = sc.nextInt();
			}
			Kanto.insert(new Pokemon(ID, AT));
			ID = 0;
			AT = 0;
			i++;
		}
		
		while(h <= 0 || h > 97 ) {
			System.out.println("Digite a quantidade de Pokemons Encontrados na Região de Hoenn. Considere:  (1 <= K <= 97)");
			h = sc.nextInt();
		}
		
		ID = 0;
		AT = 0;
		i = 0;
		while(i < h) {
			while(ID < 1 || ID > 200) {
				System.out.println("Digite o id do Pokemon encontrado:");
				ID = sc.nextInt();
			}
			while(AT < 300 || AT > 2000) {
				System.out.println("Digite o Ataque do Pokemon encontrado:");
				AT = sc.nextInt();
			}
			Hoenn.insert(new Pokemon(ID, AT));
			ID = 0;
			AT = 0;
			i++;
		}
		
		System.out.println("Passando valores para os vetores");
		int[] vectIDK = Kanto.criarVetor("ID", Kanto);
		System.out.println(vectIDK);
		int[] vectATK = Kanto.criarVetor("AT", Kanto);
		System.out.println(vectATK);
		
		int[] vectIDH = Hoenn.criarVetor("ID", Hoenn);
		System.out.println(vectIDH);
		int[] vectATH = Hoenn.criarVetor("AT", Hoenn);
		System.out.println(vectATH);
		
		System.out.println("Ordenar vetores na área Kanto:");
		selectionSort(vectIDK, vectATK);
		for(int y =0; y < vectIDK.length; y++) {
			System.out.print(vectIDK[y] + ", ");
		}
		System.out.println();
		System.out.println("Ordenar vetores na área Hoenn");
		selectionSort(vectIDH, vectATH);
		
		System.out.println("Deseja fazer uma busca?");
		String resposta = sc.nextLine();
		int contador = 0;
		while(resposta != "sim") {
			System.out.println("Digite o ID: ");
			int idBusca = sc.nextInt();
			int countIDK = buscaBinaria(vectIDK, idBusca);
			int countIDH = buscaBinaria(vectIDH, idBusca);
			System.out.println("Digite o AT: ");
			int atBusca = sc.nextInt();
			int countATK = buscaBinaria(vectATK, atBusca);
			int countATH = buscaBinaria(vectATH, atBusca);
			if(countIDK == countATK) {
				System.out.println("SIM: " + vectIDK[countIDK] + ", " + vectATK[countATK]);
				continue;
			}else if(countIDH == countATH) {
				System.out.println("SIM: " + vectIDH[countIDH] + ", " + vectATH[countATH]);
			}else {
				System.out.println("Não");
			}
			System.out.println("Deseja continuar buscando?");
			resposta = sc.nextLine();
			contador++;
		}
		System.out.println("Fez a busca: " + contador + " vezes.");
		
		
		
		
		
		
		sc.close();

	}
	
	public static int rand(int str, int end) {
		 return (int) Math.ceil(Math.random() * (end - str + 1)) - 1 + str;
		}
	
	public static void selectionSort(int[] k, int[] l) {
		int menor_i, aux1, aux2;
		
		for(int i = 0; i < k.length; i++) {
			menor_i = i;
			for(int j = i + 1; j < k.length; j++) {
				if(k[j] < k[menor_i]) {
					menor_i = j;
				}
			}
			aux1 = k[i];
			aux2 = l[i];
			k[i] = k[menor_i];
			l[i] = l[menor_i];
			k[menor_i] = aux1;
			l[menor_i] = aux2;
		}
	}
	
	public static int buscaBinaria(int[] vetor, int i) {
		
		int count = 0;
		int inicio = 0;
		int meio = 0;
		int fim = vetor.length - 1;
		
		while(inicio <= fim) {
			meio = (int) (inicio + fim)/2;
			count++;
		
			if(vetor[meio] == i) {
				return count;
			}else if(vetor[meio] < i) {
				inicio = meio + 1;
			}else {
				fim = meio - 1;
			}
		}
		
		return count;
		
		
		
	}
	
	

}
