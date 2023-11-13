package aula;

import java.util.Date;

public class Teste {

	public static void main(String[] args) {
		
		Dao dao = new Dao();
		
		HistoricoPeso peso1 = new HistoricoPeso(new Date(), 12.2);
		
		dao.deletarId(1);
		dao.deletarId(2);
		dao.deletarId(3);
		//dao.inserir(peso1);
		
		for (HistoricoPeso peso : dao.consultar()) {
			System.out.println(peso.getId());
			System.out.println(peso.getPeso());
			System.out.println(peso.getData());
		}
		
		

	}

}
