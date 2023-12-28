import java.util.ArrayList;
import java.lang.Math;
import java.util.*;

public class ListaExtendivel extends MinhaListaOrdenavel{ //possui mais possiblilidades de ordenacao
	private ArrayList<PessoaIMC> v;

	public ListaExtendivel(){
		v=new ArrayList();
	}
	public void add(PessoaIMC p){
		v.add(p);
	}
	public PessoaIMC get(int i){
		return v.get(i);
	}

	public Comparator dataC = new Comparator() {
		public int compare(Object p1,Object p2){
			int d1,d2,m1,m2,a1,a2;
			String data1,data2;
			
			data1=((PessoaIMC) p1).getDataNascimento();
			data2=((PessoaIMC) p2).getDataNascimento();
			
			d1=Integer.parseInt(data1.substring(0,2));
			d2=Integer.parseInt(data2.substring(0,2));
			m1=Integer.parseInt(data1.substring(3,5));
			m2=Integer.parseInt(data2.substring(3,5));
			a1=Integer.parseInt(data1.substring(6,10));
			a2=Integer.parseInt(data2.substring(6,10));
			if(a1!=a2){
				return a2-a1;
			}
			else if(m1!=m2){
				return m2-m1;
			}
			else{
				return d2-d1;
			}
		}
	};

	public int tamanho(){
		return v.size();
	}

	public ArrayList ordena(int criterio){
		switch(criterio){
			case 1:
				Collections.sort(this.v, alfabetoC.reversed());
				break;
			case 2:
				Collections.sort(this.v, alfabetoC);
				break;
			case 3:
				Collections.sort(this.v, pesoC.reversed());
				break;
			case 4:
				Collections.sort(this.v, pesoC);
				break;
			case 5:
				Collections.sort(this.v, alturaC.reversed());
				break;
			case 6:
				Collections.sort(this.v, alturaC);
				break;
			case 7:
				Collections.sort(this.v, imcC.reversed());
				break;
			case 8:
				Collections.sort(this.v, imcC);
				break;
			case 9:
				Collections.sort(this.v, generoC.reversed());
				break;
			case 10:
				Collections.sort(this.v, generoC);
				break;
			case 11:
			 	Collections.sort(this.v, dataC.reversed());
				break;
			case 12:
				Collections.sort(this.v, dataC);
				break;
		}
		return this.v;
	}

	
}
