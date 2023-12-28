public abstract class PessoaIMC extends Pessoa{

	private double peso;
	private double altura;

	public PessoaIMC(String n,String d,double p,double a){
		super(n,d);
		peso=p;
		altura=a;
	}

	public double getPeso(){
		return peso;
	}
	public double getAltura(){
		return altura;
	}
	public double getIMC(){
		return peso/(altura*altura);
	}

	public double calculaIMC(double a,double p){
		return p/(a*a);
	}
	
	public abstract String resultIMC();

	public String toString(){
		String s=super.toString();
		s+="Peso: "+getPeso()+"\n";
		s+="Altura: "+getAltura()+"\n";
		return s;
	}
}
