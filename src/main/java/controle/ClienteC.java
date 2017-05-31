package controle;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.gson.Gson;
import com.pontua.modelo.ClienteBD;

import java.io.UnsupportedEncodingException;
import java.util.List;

import objeto.Cliente;


public class ClienteC {
	private Cliente cli;
	
    public String loginCliente(String cliente) throws IllegalArgumentException, UnsupportedEncodingException {
        System.out.println("DADOS PARA SEREM CONVERTIDOS EM JSON: "+  cliente);
    	
        
        this.cli = new Gson().fromJson(cliente, Cliente.class);
        ClienteBD cbd = new ClienteBD();
        boolean result = cbd.loginCliente(this.cli);
        
        if (result){
            Algorithm algorithm = Algorithm.HMAC256("secret");
            return JWT.create().withIssuer(cliente).sign(algorithm);
        }else{
            return "";
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
