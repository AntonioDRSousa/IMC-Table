import java.util.ArrayList;
import java.lang.Math;
import java.util.*;

public class MinhaListaOrdenavel{
	private ArrayList<PessoaIMC> v;

	public MinhaListaOrdenavel(){
		v=new ArrayList();
	}

	public void add(PessoaIMC p){
		v.add(p);
	}
	public PessoaIMC get(int i){
		return v.get(i);
	}

	public Comparator pesoC = new Comparator() {
		public int compare(Object p1,Object p2){
			double pf1,pf2;
			pf2=((PessoaIMC) p2).getPeso();
			pf1=((PessoaIMC) p1).getPeso();
			return (int) Math.round(pf2 - pf1);
		}
	};
	public Comparator alturaC = new Comparator() {
		public int compare(Object p1,Object p2){
			double pf1,pf2;
			pf2=((PessoaIMC) p2).getAltura();
			pf1=((PessoaIMC) p1).getAltura();
			return (int) Math.round(pf2*100 - pf1*100);
		}
	};
	public Comparator imcC = new Comparator() {
		public int compare(Object p1,Object p2){
			double pf1,pf2;
			pf2=((PessoaIMC) p2).getIMC();
			pf1=((PessoaIMC) p1).getIMC();
			return (int) Math.round(pf2 - pf1);
		}
	};
	public Comparator alfabetoC = new Comparator() {
		public int compare(Object p1,Object p2){
			String pf1,pf2;
			pf2=((PessoaIMC) p2).getNome();
			pf1=((PessoaIMC) p1).getNome();
			return (int) Math.round(pf2.compareTo(pf1));
		}
	};
	public Comparator generoC = new Comparator() {
		public int compare(Object p1,Object p2){
			if((p1 instanceof Homem) && (p2 instanceof Mulher)){
				return -1;
			}
			else if((p1 instanceof Mulher) && (p2 instanceof Homem)){
				return 1;
			}
			else{
				return 0;
			}
		}
	};

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
				Collections.sort(this.v, imcC.reversed());
				break;
			case 7:
				Collections.sort(this.v, generoC);
				break;
		}
		return this.v;
	}
}
