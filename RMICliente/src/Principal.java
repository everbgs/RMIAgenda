import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;

public class Principal {

	public static void main(String[] args) {
		
		
		RmiServerIntf server = null;
		try {
			System.setSecurityManager(new RMISecurityManager());
		//	Registry registry = LocateRegistry.getRegistry("RMIServer", 1099);
			server = (RmiServerIntf)Naming.lookup("rmi://10.0.0.60:1099/RMIServer");
			//Pessoa p = server.auth("borges", "jovemainda");
			/*if (p != null)
			{
				Evento e = new Evento();
				e.setDono(p);
				e.setNomeEvento("Maratona");				
				Pessoa p2 = new Pessoa();
				p2.setLogin("toigo");
				
				SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				e.setDataInicial(f.parse("29/05/2014 10:30"));
				e.setDataFinal(f.parse("29/05/2014 20:30"));
				
				server.enviaEvento(e);				
			}			*/
        } catch( Exception e ) {            
            System.out.println("Erro: " + e);
            e.printStackTrace();            
        }   
	}
}
