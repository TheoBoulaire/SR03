package projet.sr03.fr;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Couleur;
import model.Motorisation;
import model.OptionSup;
import model.Voiture;

/**
 * Session Bean implementation class Requests
 */
@Stateless
public class Requests implements RequestsLocal {
	@PersistenceContext(name = "SR03_JPA")
	EntityManager em;

    /**
     * Default constructor. 
     */
    public Requests() {
        // TODO Auto-generated constructor stub
    }
    
    @SuppressWarnings("unchecked")
    public String getCouleurOfVoiture(Integer vId) {
        Query q = em.createQuery("SELECT c.couleur "
                                + "FROM Couleur c "
                                + "JOIN c.voitures v "
                                + "WHERE v.id = :vId");

        q.setParameter("vId", vId);

        return (String) q.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public List<OptionSup> getOptionSupForVoiture(Integer voitureId)
    {
    	Query q = em.createQuery("SELECT op "
    							+ "FROM OptionSup op "
    							+ "JOIN op.voitures v "
    							+ "WHERE v.id = :id");
    	q.setParameter("id", voitureId);
		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public Couleur getCouleurOfId(Integer cId)
    {
        Query q = em.createQuery("select c "
                                + "from Couleur c "
                                + "where c.id = :cId ");

        q.setParameter("cId", cId);
        return (Couleur) q.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public List<String> getMotorisations()
    {
    		Query q = em.createQuery("select m.nomMoteur from Motorisation m");
		
		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public Long countMotorisations()
    {
    		Query q = em.createQuery("select COUNT(m) from Motorisation m");
		
		return (Long) q.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public List<Couleur> getCouleurs()
    {
    		Query q = em.createQuery("select c from Couleur c left join fetch c.voitures");
		
		return q.getResultList();
    }

    /*
    public SmeGroupeEnseig getGroupeEnseigByDef(RefVersionSmeEffectifPrev rvsep, SmeDefGroupe sdg,EnseigAdministration ea)
    {
            try
            {
                Query q = em.createQuery("select sge "
                                        + "from SmeGroupeEnseig sge "
                                        + "join fetch sge.refVersionSmeEffectifPrev rvsep "
                                        + "join fetch sge.smeDefGroupe sdg "
                                        + "join fetch sge.enseigAdministration ea "
                                        + "join fetch ea.enseigFormule ef "
                                        + "join fetch ef.enseignement ens "
                                        + "where sdg.sdgId=:sdgId "
                                        + "and rvsep.rvsepId=:rvsepId "
                                        + "and ea.edaId=:edaId ");

                q.setParameter("sdgId", sdg.getSdgId());
                q.setParameter("rvsepId", rvsep.getRvsepId());
                q.setParameter("edaId", ea.getEdaId());

                return (SmeGroupeEnseig) q.getSingleResult();
            }
            catch(NoResultException e){ return new SmeGroupeEnseig();}


    }*/
    /*
    public void updateSmeGroupeEnseig(SmeGroupeEnseig sge)
    {
            em.merge(sge);
    }*/

    public void deleteCouleur(Integer cId) {
    	Query q = em.createQuery("select c "
                + "from Couleur c "
                + "where c.id=:cId ");
    	q.setParameter("cId", cId.toString());
        em.remove((Couleur) q.getSingleResult());
    }
    /*
    public void addCouleur(Couleur c)
    {
            em.persist(c);
    }*/

}
