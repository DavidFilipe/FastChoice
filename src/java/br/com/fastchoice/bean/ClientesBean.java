/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fastchoice.bean;

import br.com.fastchoice.DAO.ClienteDAO;
import br.com.fastchoice.entity.Cliente;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author David
 */
@ManagedBean
@SessionScoped
public class ClientesBean {

    private Cliente cliente = new Cliente();
    public ClienteDAO clienteDao = new ClienteDAO();
    List<Cliente> listaClientes;
    
    
    public List listaClientes(){
      listaClientes =  clienteDao.getList();
      return this.listaClientes;
    }
    
    public ClientesBean() {
    
    }
    
    public String adicionarCliente (){
       clienteDao.adicionarCliente(cliente);
       cliente.setUsuario(null);
       cliente.setEmail(null);
       cliente.setSenha(null);
       cliente.setConfSenha(null);
        return "cadastroUsuario";
    }

     public String removerCliente (Cliente c){
       this.cliente = c;
       clienteDao.removerCliente(this.cliente);
       this.cliente.setUsuario("");
       this.cliente.setEmail("");
       this.cliente.setSenha("");
       this.cliente.setConfSenha("");
       return "cadastroUsuario";
    }
     
    /**
     *
     * @param c
     * @return
     */
    
     public String atualizarCliente(){
         clienteDao.editarCliente(cliente);
         cliente.setUsuario(null);
         cliente.setEmail(null);
         cliente.setSenha(null);
         cliente.setConfSenha(null);
         return "cadastroUsuario";
     }
     
     public String carregarCliente(Cliente c){
        this.cliente = c;
         return "editarUsuario";
         
        }
     
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.cliente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClientesBean other = (ClientesBean) obj;
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }
    
}