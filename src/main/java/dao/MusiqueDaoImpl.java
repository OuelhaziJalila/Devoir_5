package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Musique;
import util.JPAutil;

public class MusiqueDaoImpl {
    private Object TP5_JEE2;
	private EntityManager entityManager = JPAutil.getEntityManager();

    // Ajouter une musique
    public Musique save(Musique m) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(m);
        tx.commit();
        return m;
    }

    // Rechercher des musiques par titre
    public List<Musique> musiquesParTitre(String titre) {
        return entityManager.createQuery("SELECT m FROM Musique m WHERE m.titre LIKE :ptitre", Musique.class)
                .setParameter("ptitre", "%" + titre + "%")
                .getResultList();
    }

    // Rechercher des musiques par genre
    public List<Musique> musiquesParGenre(String genre) {
        return entityManager.createQuery("SELECT m FROM Musique m WHERE m.genre LIKE :pgenre", Musique.class)
                .setParameter("pgenre", "%" + genre + "%")
                .getResultList();
    }

    // Consulter une musique par ID
    public Musique getMusique(Long id) {
        return entityManager.find(Musique.class, id);
    }

    // Mettre à jour une musique
    public Musique updateMusique(Musique m) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(m);
        tx.commit();
        return m;
    }

    // Supprimer une musique
    public void deleteMusique(Long id) {
        Musique musique = entityManager.find(Musique.class, id);
        if (musique != null) {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.remove(musique);
            tx.commit();
        }
    }
}
