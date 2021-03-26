package Prova1;

public class No1 {
	private Pokemon p;
	private No1 prox;
	
	public No1(Pokemon p) {
		this.p = p;
		this.prox = null;
	}


	public Pokemon getP() {
		return p;
	}

	public void setP(Pokemon p) {
		this.p = p;
	}

	public No1 getProx() {
		return prox;
	}

	public void setProx(No1 prox) {
		this.prox = prox;
	}
}
