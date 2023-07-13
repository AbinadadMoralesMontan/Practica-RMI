package Interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Abinadad
 */
public interface IPersona extends Remote{
    int getId() throws RemoteException;
    String getNombre() throws RemoteException;
    String getTelefono() throws RemoteException;
    String getEmail() throws RemoteException;
    
    void setId(int id) throws RemoteException;
    void setNombre(String nombre) throws RemoteException;
    void setTelefono(String telefono) throws RemoteException;
    void setEmail(String email) throws RemoteException;
    
    public String getString() throws RemoteException;
}
