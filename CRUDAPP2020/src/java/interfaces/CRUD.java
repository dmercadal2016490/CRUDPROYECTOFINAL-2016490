
package interfaces;

import ModeloDeDatos.Persona;
import java.util.List;


public interface CRUD {
   public List listar();
    public Persona list(int id);
    public boolean add(Persona per);
    public boolean editar(Persona per);
    public boolean eliminar(int id); 
}
