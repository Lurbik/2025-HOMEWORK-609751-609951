public class Giocatore {

    private int cfu;
    private Borsa borsa;

    public Giocatore() {
        this.cfu = 20; // CFU iniziali
        this.borsa = new Borsa();
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public void decrementaCfu() {
        if (cfu > 0) {
            this.cfu--;
        }
    }

    public Borsa getBorsa() {
        return borsa;
    }

    
 // Metodo per "prendere" un attrezzo dalla stanza e metterlo nella borsa
    public boolean prendiAttrezzo(Attrezzo attrezzo) {
        return this.borsa.addAttrezzo(attrezzo);
    }

    // Metodo per "posare" un attrezzo dalla borsa e metterlo nella stanza
    public boolean posaAttrezzo(Attrezzo attrezzo) {
        return this.borsa.removeAttrezzo(attrezzo.getNome()) != null;
    }

    public String toString() {
        return "CFU: " + cfu + ", " + borsa.toString();
    }
}
