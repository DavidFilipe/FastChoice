package br.com.fastchoice.DAO;

import br.com.fastchoice.entity.Estabelecimento;
import br.com.fastchoice.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author David
 */
public class EstabelecimentoDAO {

    Session sessao;
    Transaction trans;
    List<Estabelecimento> list;

    public List<Estabelecimento> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        Criteria cri = sessao.createCriteria(Estabelecimento.class);
        this.list = cri.list();
        return list;

    }
    
    public List<Estabelecimento> ordenarPontos() {
    sessao = HibernateUtil.getSessionFactory().openSession();
    trans = sessao.beginTransaction();
    String jpql = "SELECT estabelecimento FROM Estabelecimento estabelecimento ORDER BY estabelecimento.id DESC";
    return sessao.createQuery(jpql).list();
}



    public void adicionarEstabelecimento(Estabelecimento es) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Estabelecimento estabelecimento = new Estabelecimento();
            estabelecimento.setCnpj(es.getCnpj());
            estabelecimento.setNome(es.getNome());

            estabelecimento.setCidade(es.getCidade());
            estabelecimento.setBairro(es.getBairro());
            estabelecimento.setRua(es.getRua());
            estabelecimento.setNumero(es.getNumero());
            estabelecimento.setTelefone(es.getTelefone());
            estabelecimento.setPontos(es.getPontos());
            sessao.save(estabelecimento);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    public void removerEstabelecimento(Estabelecimento es) {

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.delete(es);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }

    }

    public void editarEstabelecimento(Estabelecimento es) {

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.update(es);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }

    }
}
