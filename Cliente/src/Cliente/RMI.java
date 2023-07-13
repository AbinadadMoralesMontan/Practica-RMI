package Cliente;

import Interfaces.IPersonaController;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RMI {
    private static IPersonaController personaController;
    public static IPersonaController getIPersonaController(){
        try {
            if(personaController == null){
                personaController =
                    (IPersonaController) Naming.lookup("rmi://localhost/PersonaController");
            
            }
            
        } catch (NotBoundException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        }
          return personaController;  
    }
}
