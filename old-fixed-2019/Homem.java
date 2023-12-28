public class Homem extends PessoaIMC{

	public Homem(String n,String d,double p,double a){
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
		if(imc<20.7){
			s="Abaixo do peso ideal\n";
		}
		else if(imc>26.4){
			s="Acima do peso ideal\n";
		}
		else{
			s="Peso ideal\n";
		}
		return s;
	}

}
