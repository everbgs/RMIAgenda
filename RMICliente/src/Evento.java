import java.util.ArrayList;
import java.util.Date;


public class Evento {
	
	private Date dataInicial;
	private Date dataFinal;
	private String nomeEvento;
	private ArrayList<Pessoa> Pessoas;
	private Pessoa dono;
	
	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public ArrayList<Pessoa> getPessoas() {
		return Pessoas;
	}


	public void setPessoas(ArrayList<Pessoa> pessoas) {
		Pessoas = pessoas;
	}




	public Pessoa getDono() {
		return dono;
	}




	public void setDono(Pessoa dono) {
		this.dono = dono;
	}




	public String duracaoEvento(){
		
		return null;
	}
	
	
	
	
	
	
}
