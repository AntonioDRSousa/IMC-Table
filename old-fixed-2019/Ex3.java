//import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.JApplet;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.JPanel;
import java.util.ArrayList;
import javax.swing.table.*;
import javax.swing.table.TableRowSorter;
import static java.lang.Math.*;

import java.util.List;
import java.util.*;

public class Ex3 extends JFrame implements ActionListener{
	private static JTable tabela;
	private static TextField nome,data,peso,altura;
	private static CheckboxGroup genero;
	private static Checkbox masculino,feminino;
	private static Label label;
	private static Button button;
	private static JPanel parte,cadastro,tela;
	private static DefaultTableModel model;
	private static ListaExtendivel lista=new ListaExtendivel();

	private static int[] vbol={0,0,0,0,0,0,0};
	
	public Ex3(){
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLocationRelativeTo(null);
		setTitle("Ex3");
		setResizable(false);
		init();
		setVisible(true);
	}

	public Object[] criaLinha(String n,String dt,double pes,double alt,boolean estado){
		PessoaIMC p;
		String s1,s2,s3;
		if(estado){
			p=new Mulher(n,dt,pes,alt);
			s1=String.format("%.2f",p.getPeso());
			s2=String.format("%.2f",p.getAltura());
			s3=String.format("%.2f",p.getIMC());
			Object[] obj={p.getNome(),p.getDataNascimento(),"Feminino",s1,s2,s3,((Mulher) p).getEstado(p.getIMC())};
			return obj;
		}
		else{
			p=new Homem(n,dt,pes,alt);
			s1=String.format("%.2f",p.getPeso());
			s2=String.format("%.2f",p.getAltura());
			s3=String.format("%.2f",p.getIMC());
			Object[] obj={p.getNome(),p.getDataNascimento(),"Masculino",s1,s2,s3,((Homem) p).getEstado(p.getIMC())};
			return obj;
		}
	}

	public void actionPerformed(ActionEvent e){
		String n,dt;
		double pes,alt;
		String gen;
		
		try{
			n=nome.getText();
			dt=data.getText();
			pes=Double.parseDouble(peso.getText());
			alt=Double.parseDouble(altura.getText());

			valiData(dt);
			if(n.equals("")){
				throw new NomeEx();
			}
			if(alt<=0){
				throw new AlturaEx();
			}
			if(pes<=0){
				throw new PesoEx();
			}
			
			model.addRow(criaLinha(n,dt,pes,alt,feminino.getState()));
			
			if(feminino.getState()){
				lista.add(new Mulher(n,dt,pes,alt));
			}
			else{
				lista.add(new Mulher(n,dt,pes,alt));
			}
			
			nome.setText("");
			data.setText("dd/mm/aaaa");
			peso.setText("");
			altura.setText("");
		}
		catch(NomeEx ex){
			JOptionPane.showMessageDialog(null,"Erro. "+ex);
		}
		catch(DataEx ex){
			JOptionPane.showMessageDialog(null,"Erro. "+ex);
		}
		catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null,"Erro. Formato Invalido de Altura ou Peso");
		}
		catch(AlturaEx ex){
			JOptionPane.showMessageDialog(null,"Erro. "+ex);
		}
		catch(PesoEx ex){
			JOptionPane.showMessageDialog(null,"Erro. "+ex);
		}
			
	}

	public void troca(int i){//para alternar a direcao de ordenacao do sort
		if(vbol[i]==0){
			vbol[i]=1;
		}
		else{
			vbol[i]=0;
		}
	}		

	public void inicializar(){//dados iniciais da tabela
		lista.add(new Mulher("Ana","10/07/1990",59,1.68));
		lista.add(new Mulher("Maria","04/04/1982",61,1.64));
		lista.add(new Homem("Joao","13/02/1964",66,1.65));
		lista.add(new Mulher("Lucia","01/01/1987",60,1.78));
		lista.add(new Homem("Jose","07/09/1970",64,1.70));
		lista.add(new Homem("Carlos","18/03/1980",73,1.77));
		lista.add(new Homem("Tiago","20/05/1983",95,1.80));
		lista.add(new Mulher("Raquel","11/08/1972",50,1.55));
		lista.add(new Homem("Paulo","09/06/1992",67,1.83));
		lista.add(new Mulher("Sonia","14/12/1958",90,1.69));

		PessoaIMC p;
		for(int i=0;i<10;i++){
			p=lista.get(i);
			model.addRow(criaLinha(p.getNome(),p.getDataNascimento( ),p.getPeso(),p.getAltura(),p instanceof Mulher));
		}
		
	}

	public void init(){

		model = new DefaultTableModel(){ //impede de ser editada a celula
			public boolean isCellEditable(int filas, int colunas){
				return false;
			}
		};

		//cria tabela
		tabela = new JTable(model); 
		model.addColumn("Nome"); 
		model.addColumn("Data de Nascimento");
		model.addColumn("Genero");
		model.addColumn("Peso(kg)"); 
		model.addColumn("Altura(m)");
		model.addColumn("IMC");
		model.addColumn("Estado");

		inicializar();
		
		label=new Label("Digite um novo dado");
		nome=new TextField("");
		data=new TextField("dd/mm/aaaa");
		peso=new TextField("");
		altura=new TextField("");
		genero=new CheckboxGroup ();
		masculino=new Checkbox("Masculino",genero,true);
		feminino=new Checkbox("Feminino",genero,false);
		button=new Button("Cadastrar");
		button.addActionListener(this);
	
		JScrollPane sp=new JScrollPane(tabela);
		parte=new JPanel(new GridLayout(1,2)); 
		cadastro=new JPanel(new GridLayout(8,2));

		add(sp);
		cadastro.add(masculino);
		cadastro.add(feminino);
		cadastro.add(new Label("Nome: "));
		cadastro.add(nome);
		cadastro.add(new Label("Data de Nascimento: "));
		cadastro.add(data);
		cadastro.add(new Label("Peso(kg): "));
		cadastro.add(peso);
		cadastro.add(new Label("Altura(m): "));
		cadastro.add(altura);

		parte.setBackground(Color.CYAN);
		cadastro.setBackground(Color.CYAN);
		button.setBackground(Color.GREEN);

		cadastro.add(new Label());
		cadastro.add(button);
		parte.add(cadastro);
		parte.add(new Label());
		add(parte);

		tabela.getTableHeader().setReorderingAllowed (false);//impede troca de colunas por arrastar o mouse

		//sort personalizado da tabela
		tabela.getTableHeader().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int col = tabela.columnAtPoint(e.getPoint());
				switch(col){
					case 0:
						lista.ordena(1+vbol[0]);
						troca(0);
						break;
					case 1:
						lista.ordena(11+vbol[1]);
						troca(1);
						break;
					case 2:
						lista.ordena(9+vbol[2]);
						troca(2);
						break;
					case 3:
						lista.ordena(3+vbol[3]);
						troca(3);
						break;
					case 4:
						lista.ordena(5+vbol[4]);
						troca(4);
						break;
					case 5:
						lista.ordena(7+vbol[5]);
						troca(5);
						break;
					case 6:
						lista.ordena(7+vbol[6]);
						troca(6);
						break;
				}
				
				PessoaIMC p;
				for(int i=0;i<lista.tamanho();i++){
					p=lista.get(i);
					Object[] obj=criaLinha(p.getNome(),p.getDataNascimento(),p.getPeso(),p.getAltura(),p instanceof Mulher);
					tabela.setValueAt(obj[0], i, 0);
					tabela.setValueAt(obj[1], i, 1);
					tabela.setValueAt(obj[2], i, 2);
					tabela.setValueAt(obj[3], i, 3);
					tabela.setValueAt(obj[4], i, 4);
					tabela.setValueAt(obj[5], i, 5);
					tabela.setValueAt(obj[6], i, 6);
				}
				 
			}
		});

		tabela.setSelectionBackground(Color.YELLOW);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		setLayout(new GridLayout(2,1));
	}
	
	public void valiData(String data)throws DataEx{
		int ano,mes,dia;
		if(data.length()<10){
			throw new DataEx();
		}
		try{
			dia=Integer.parseInt(data.substring(0,2));
			mes=Integer.parseInt(data.substring(3,5));
			ano=Integer.parseInt(data.substring(6,10));
		}
		catch(NumberFormatException e){
			throw new DataEx();
		}

		if(ano>=0){
			if(mes>=1 || mes<=12){
				if(dia<1){
					throw new DataEx();
				}
				if(mes==2){
					if(ano%4==0){
						if(dia>29){
							throw new DataEx();
						}
					}
					else{
						if(dia>28){
							throw new DataEx();
						}
					}
				}
				else if(mes==4 || mes==6 || mes==9 || mes==11){
					if(dia>30){
						throw new DataEx();
					}
				}
				else{
					if(dia>31){
						throw new DataEx();
					}
				}
			}
			else{
				throw new DataEx();
			}
		}
		else{
			throw new DataEx();
		}
	}
	
	public static void main(String[] argc){
		new Ex3();
	}
}
