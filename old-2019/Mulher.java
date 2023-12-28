public class Mulher extends PessoaIMC{

	public Mulher(String n,String d,double p,double a){
		super(n,d,p,a);
	}
	
	public String resultIMC(){
		double imc=calculaIMC(super.getAltura(),super.getPeso());
		String s="IMC: "+String.format("%.2f",imc)+" ";
		s+=getEstado(imc);
		return s;
	}
	
	public String toString(){
		String s=super.toString()+resultIMC();
		return s;
	}

	public String getEstado(double imc){
		String s;
		if(imc<19){
			s="Abaixo do peso ideal\n";
		}
		else if(imc>25.8){
			s="Acima do peso ideal\n";
		}
		else{
			s="Peso ideal\n";
		}
		return s;
	}
}
