public class Mechant extends Personnage {
    private boolean coteObscur;

    public Mechant() { }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" + 
            super.toString() + ", coteObscur=" + coteObscur + "}";
    }
}