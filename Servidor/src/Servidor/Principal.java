package Servidor;

import Interfaces.IPersonaController;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {    
    public static void main(String[] args) {
        try {
            
            LocateRegistry.createRegistry(1099);
            IPersonaController personaController = new PersonaController();
            Naming.rebind("rmi://localhost/PersonaController", personaController );
            System.out.println("Escuchando..");
        } catch (RemoteException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
