package controle;

import com.google.gson.Gson;
import java.util.List;
import modelo.ClienteBD;
import objeto.Cliente;

public class teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Gson g = new Gson();
        ClienteBD cbd = new ClienteBD();
        List<Cliente> clientes = cbd.buscarCliente();
        System.out.println(g.toJson(clientes));
    }
    
}
