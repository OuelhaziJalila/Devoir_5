package metier.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "MUSIQUES")
public class Musique implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrémentation de l'ID
    @Column(name="ID_MUSIQUE")
    private Long idMusique;

    @Column(name="TITRE", nullable = false)
    private String titre;

    @Column(name="GENRE", nullable = false)
    private String genre;

    @Column(name="ARTISTE", nullable = false)
    private String artiste;

    @Column(name="DUREE")
    private int duree; // Durée en secondes

    // Constructeurs
    public Musique() {}

    public Musique(String titre, String genre, String artiste, int duree) {
        this.titre = titre;
        this.genre = genre;
        this.artiste = artiste;
        this.duree = duree;
    }

    // Getters et Setters
    public Long getIdMusique() { return idMusique; }
    public void setIdMusique(Long idMusique) { this.idMusique = idMusique; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getArtiste() { return artiste; }
    public void setArtiste(String artiste) { this.artiste = artiste; }

    public int getDuree() { return duree; }
    public void setDuree(double duree2) { this.duree = (int) duree2; }

    // Méthode toString pour affichage
    @Override
    public String toString() {
        return "Musique [id=" + idMusique + ", titre=" + titre + ", genre=" + genre + 
               ", artiste=" + artiste + ", durée=" + duree + " sec]";
    }
}
