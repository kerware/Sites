package fr.caensup.licsts.sites;

public class Ville {
    private String nom;
    private int rouge;
    private int vert;
    private int bleu;
    private double evaluation;

    public Ville(String nom, int rouge, int vert, int bleu, double evaluation) {
        this.nom = nom;
        this.rouge = rouge;
        this.vert = vert;
        this.bleu = bleu;
        this.evaluation = evaluation;
    }

    // Getters et setters
    public String getNom() { return nom; }
    public int getRouge() { return rouge; }
    public int getVert() { return vert; }
    public int getBleu() { return bleu; }
    public double getEvaluation() { return evaluation; }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setRouge(int rouge) {
        this.rouge = rouge;
    }

    public void setVert(int vert) {
        this.vert = vert;
    }

    public void setBleu(int bleu) {
        this.bleu = bleu;
    }

    public void setEvaluation(double evaluation) {
        this.evaluation = evaluation;
    }
}
