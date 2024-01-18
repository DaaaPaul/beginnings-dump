public class EncapsulationIVV{
    private int numofFingers;
    private int numofToes;

    public void toeSetter(int toes){
        if(toes == 10){
          numofToes = toes;
        }
    }
    public int toeGetter(){
        return numofToes;
    }
    public void fingerSetter(int fingers){
        if(fingers == 10){
            numofFingers = fingers;
        }
    }
    public int fingerGetter(){
        return numofFingers;
    }
    public String howmanytoes(){
        return("The number of toes are " + numofToes + " toes.");
    }
    public String howmanyfingers(){
        return("The number of fingers are " + numofFingers + " fingers.");
    }
    public static void main(String[] args) {
        EncapsulationIVV Paul = new EncapsulationIVV();
        Paul.fingerSetter(7);
        String fingers = Paul.howmanyfingers();
        System.out.println(fingers);
    }
}