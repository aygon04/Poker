import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    //<editor-fold desc="Enums">
    public enum Palo {
        TRÈBOLS,
        CORAZONES,
        PICAS,
        DIAMANTES
    }
    public enum Color {
        ROJO,
        NEGRO
    }
    //</editor-fold>
    //<editor-fold desc="Clase Card">
    public static class Card {

        private Palo palo;
        private Color color;
        private int value;

        public Card(Palo palo, Color color, int value) {
            this.palo = palo;
            this.color = color;
            this.value = value;
        }
        public Palo getPalo() {
            return palo;
        }
        public Color getColor() {
            return color;
        }
        public int getValue() {
            return value;
        }
        @Override
        public String toString() {
            String palo = this.palo.name();
            String valor = "";
            switch (value) {
                case 1:
                case 11:
                    valor = "A";
                    break;
                case 12:
                    valor = "J";
                    break;
                case 13:
                    valor = "Q";
                    break;
                case 14:
                    valor = "K";
                    break;
                default:
                    valor = String.valueOf(value);
                    break;
            }
            return String.format("%s de %s (%s)", valor, palo, color.name());
        }
    }
    //</editor-fold>
    //<editor-fold desc="Deck">
    public static class Deck {

        private List<Card> cards;
        private Set<Card> pickedCards;

        public Deck() {
            this.cards = new ArrayList<>();
            this.pickedCards = new HashSet<>();

            for (int i = 0; i < 4; i++) {
                for (int j = 2; j <= 14; j++) {
                    this.cards.add(new Card(Palo.values()[i], Color.values()[(j % 2)], j));
                }
            }
        }
        public void shuffle() {
            Collections.shuffle(this.cards);
            System.out.println("Se mezcló el Deck.");
        }

        public Card head() {
            Card card = this.cards.remove(0);
            System.out.println("Removida por head:" + card.toString());
            return card;
        }

        public Card pick() {
            Card card = this.cards.remove((int) (Math.random() * this.cards.size()));
            System.out.println("Removida por pick:" + card.toString());
            return card;
        }

        public Card[] hand() {
            Card[] hand = new Card[5];
            for (int i = 0; i < 5; i++) {
                int index = (int) (Math.random() * this.cards.size());
                Card card = this.cards.remove(index);
                System.out.println("Removida por hand:" + card.toString());
                hand[i] = card;
            }
            System.out.println("Quedan " + this.cards.size() + " cartas");
            return hand;
        }

    }
    //</editor-fold>

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        deck.head();
        deck.pick();
        deck.hand();
        }
    }
