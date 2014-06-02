import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
 
public interface RmiServerIntf extends Remote {	
	public Pessoa auth(String login, String senha) throws RemoteException;
	public ArrayList<Evento> update(Pessoa usuario) throws RemoteException;
	public boolean enviaEvento(Evento novoEvento) throws RemoteException;
	public void aceitaEvento(boolean aceita, Evento evento, Pessoa usuario) throws RemoteException;
	public void alteraEvento(Evento evento, Map<String, Object> atualizacaoMap) throws RemoteException;	
}