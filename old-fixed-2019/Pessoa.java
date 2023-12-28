public class Pessoa{

	private String nome;
	private String dataNascimento;

	public Pessoa(String n, String d){
		nome=n;
		dataNascimento=d;
	}
	public String getNome(){
		return nome;
	}
	public String getDataNascimento(){
		return dataNascimento;
	}

	public String toString(){
		String s="Nome: "+nome+"\n"+"Data de Nascimento: "+dataNascimento+"\n";
		return s;
	}
}
