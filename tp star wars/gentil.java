public class Gentil extends Personnage {
    private boolean force;

    public Gentil() { }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" + 
            super.toString() + ", force=" + force + "}";
    }
}