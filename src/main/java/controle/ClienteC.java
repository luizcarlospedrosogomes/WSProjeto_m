package controle;

import com.google.gson.Gson;
import java.util.List;
import modelo.ClienteBD;
import objeto.Cliente;


public class ClienteC {

    public String loginCliente(String cliente) {
        Gson g = new Gson();
        Cliente cli = (Cliente) g.fromJson(cliente, Cliente.class);
        ClienteBD cbd = new ClienteBD();
        boolean result = cbd.loginCliente(cli);
        
        if (result){
            return "logado";
        }else{
            return "invalido";
        }
    }
    
    public String getClientes(){
        Gson g = new Gson();
        ClienteBD cbd = new ClienteBD();
        List<Cliente> clientes = cbd.buscarCliente();
        return g.toJson(clientes);
    }
    
    public boolean postClientes(String cliente){
        Gson g = new Gson();
        Cliente cli = (Cliente) g.fromJson(cliente, Cliente.class);
        ClienteBD cbd = new ClienteBD();
        return cbd.inserirCliente(cli);
    }
    
    public boolean deleteCliente(int id){
        ClienteBD cliBD = new ClienteBD();
        return cliBD.deletarCliente(id);
    }
    
    public boolean atualizarCliente(String cliente){
        Gson g = new Gson();
        Cliente cli = (Cliente) g.fromJson(cliente, Cliente.class);
        ClienteBD cbd = new ClienteBD();
        return cbd.atualizarCliente(cli);
    }
    
    public String buscaCliente(int id){
        Gson g = new Gson();
        ClienteBD cbd = new ClienteBD();
        Cliente clientes = cbd.buscaCliente(id);
        
        if (clientes==null){
            return "cliente inexistente";
        }else{
            return g.toJson(clientes);
        }
    }
    
}
