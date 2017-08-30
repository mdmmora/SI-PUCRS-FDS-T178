package reaquecimento;

import java.util.ArrayList;
 

public class Banco {
	private ArrayList<Cliente> fila;
	
	public Banco(){
		this.fila = new ArrayList<Cliente>();
	}
	
	public void adicionaNaFila(Cliente cliente){
		fila.add(cliente); //como é fila, vai adicionar no final
		
	}
	
	public Cliente retiraFila(Caixa caixa){
	
		if(fila.isEmpty()){
			return null;
		}
		else if(caixa.getNumeroCaixa() >=6){
			return fila.remove(0); //como é fila, devolve o da frente, que é o que está esperando a mais tempo
		}
		//se chegou aqui é porque o caixa dá preferencia para idosos
		for(Cliente c: fila){
			if(c.getIdade() >= 65){ //como é fila de banco, o for n tem problema, nunca vai se ruma fila gigaenorme
				return fila.remove(fila.indexOf(c));
			}
		}
		//se chegou aqui é pq a fila nao ta vazia e nao tem idoso, e o caixa de idoso q chamou, entao manda uma pessoa nao idosa
		return fila.remove(0);	
	}

}
