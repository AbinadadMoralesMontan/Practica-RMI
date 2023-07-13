package Cliente;

import Interfaces.IPersona;
import Interfaces.IPersonaController;
import gui.VentanaPrincipal;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {
    public static void main(String[] args) {
        VentanaPrincipal.main(args);
    }
}
