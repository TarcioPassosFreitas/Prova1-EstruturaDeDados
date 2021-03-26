package Prova1;

public class ListaEncadeada {
	private No1 first;
	private No1 last;
	private int quantity;
	
	
	public ListaEncadeada() {
		this.first = null;
		this.last = null;
		this.quantity = 0;
	}
	
	
	public No1 getFirst() {
		return first;
	}
	public void setFirst(No1 primer) {
		this.first = primer;
	}
	public No1 getLast() {
		return last;
	}
	public void setLast(No1 last) {
		this.last = last;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public boolean IsEmpty() {
		return (this.first == null);
	}
	
	public void insert(Pokemon p) {
		No1 newNo = new No1(p);
		if(this.IsEmpty()) {
			this.last = newNo;
		}
		newNo.setProx(this.first);
		this.first = newNo;
		this.quantity++;
		
	}
	
	public void displayLista() {
		System.out.println("Lista --> (Primer --> Ult): ");
		No1 current = this.first;
		while(current != null) {
			current.getP().displayPokemons();
			current = current.getProx();
		}
		System.out.println("");
	}
	


	
	public int[] criarVetor(String tipo, ListaEncadeada lista) {
		int[] vet = new int[this.getQuantity()];
		int count = 0;
		No1 inicio = lista.getFirst();
		if(inicio == null) {
			System.out.println("Lista está vazia");
		}else {
			No1 aux = inicio;
			while(aux != null) {
				Pokemon p = (Pokemon) aux.getP();
				if(tipo.equals("ID")) {
					vet[count] = p.getID();
				}else if(tipo.equals("AT")){
					vet[count] = p.getAT();
				}
				count++;
				aux = aux.getProx();
			}
		}
		return vet;
	}
}
