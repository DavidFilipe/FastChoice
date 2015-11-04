/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fastchoice.DAO;

import br.com.fastchoice.entity.Cliente;
import br.com.fastchoice.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author David
 */
public class ClienteDAO {

    Session sessao;
    Transaction trans;
    List <Cliente> list;

    /**
     *
     * @return
     */
    public List<Cliente> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        Criteria cri = sessao.createCriteria(Cliente.class);
        this.list = cri.list();
        return list;
       
    }
    
    
    
    

    public void adicionarCliente(Cliente c) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Cliente cliente = new Cliente();
            cliente.setUsuario(c.getUsuario());
            cliente.setEmail(c.getEmail());
            cliente.setSenha(c.getSenha());
            cliente.setConfSenha(c.getConfSenha());

            sessao.save(cliente);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    public void removerCliente(Cliente c) {

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.delete(c);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }

    }
    
     public void editarCliente(Cliente c) {

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.update(c);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }

    }
}