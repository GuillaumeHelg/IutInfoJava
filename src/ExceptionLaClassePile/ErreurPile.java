package ExceptionLaClassePile;


public class ErreurPile {

    /**
     * Exception levée si on tente de créer une pile avec une capacité invalide
     * La capacité doit être égale au moins à 1
     */
    @SuppressWarnings("serial")
    public static class ErreurCapaciteInvalide extends Exception {
        public ErreurCapaciteInvalide(String message) {
            super(message);
        }
    }

    /**
     * Exception levée si on effectue une opération invalide sur une pile vide
     */
    @SuppressWarnings("serial")
    public static class ErreurPileVide extends Exception {
        public ErreurPileVide(String message) {
            super(message);
        }
    }

    /**
     * Exception levée si on effectue une opération invalide sur une pile pleine
     */
    @SuppressWarnings("serial")
    public static class ErreurPilePleine extends Exception {
        public ErreurPilePleine(String message) {
            super(message);
        }
    }
}
