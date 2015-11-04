/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fastchoice.bean;

import br.com.fastchoice.DAO.EstabelecimentoDAO;
import br.com.fastchoice.entity.Estabelecimento;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
    
@ManagedBean
@SessionScoped
public class EstabelecimentosBean {

    private Estabelecimento estabelecimento = new Estabelecimento();
    public EstabelecimentoDAO estabelecimentoDao = new EstabelecimentoDAO();
    List<Estabelecimento> listaEstabelecimentos;
    
    
    public List listaEstabelecimentos(){
      listaEstabelecimentos =  estabelecimentoDao.getList();
      return this.listaEstabelecimentos;
    }
    
    public EstabelecimentosBean() {
    
    }
    
    public String adicionarEstabelecimento (){
       estabelecimentoDao.adicionarEstabelecimento(estabelecimento);
       estabelecimento.setNome(null);
       estabelecimento.setBairro(null);
       estabelecimento.setCidade(null);
       estabelecimento.setCnpj(null);
       estabelecimento.setRua(null);
       estabelecimento.setTelefone(null);
        return "cadastroEstabelecimento";
    }

     public String removerEstabelecimento (Estabelecimento es){
       this.estabelecimento = es;
       estabelecimentoDao.removerEstabelecimento(this.estabelecimento);
       this.estabelecimento.setBairro("");
       this.estabelecimento.setCidade("");
       this.estabelecimento.setCnpj("");
       this.estabelecimento.setNome("");
       this.estabelecimento.setRua("");
       this.estabelecimento.setNumero("");
       return "cadastroEstabelecimento";
    }
     
    /**
     *
     * @param c
     * @return
     */
    
     public String atualizarEstabelecimento(){
         estabelecimentoDao.editarEstabelecimento(estabelecimento);
         estabelecimento.setNome(null);
         estabelecimento.setBairro(null);
         estabelecimento.setCidade(null);
         estabelecimento.setCnpj(null);
         estabelecimento.setRua(null);
         estabelecimento.setTelefone(null);
         return "cadastroEstabelecimento";
     }
     
     public String carregarEstabelecimento(Estabelecimento es){
        this.estabelecimento = es;
         return "editarEstabelecimento";
         
        }
     
    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.estabelecimento);
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
        final EstabelecimentosBean other = (EstabelecimentosBean) obj;
        if (!Objects.equals(this.estabelecimento, other.estabelecimento)) {
            return false;
        }
        return true;
    }
    
}