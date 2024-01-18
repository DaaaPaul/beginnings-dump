public class Hamburger {
    private String[] burgerSize;
    private boolean PaulOrNo;
    public void burgerSetSize (int layers){
        burgerSize = new String[layers];
    }
    public void putIng(String ing, int position){
        if(ing.equalsIgnoreCase("bacon") || ing.equalsIgnoreCase("cheese")){
            System.out.println("NOOOO! NO BACON OR CHEESE!");
            return;
        }
        burgerSize[position] = ing;
        System.out.println("You have put " + ing + " on layer " + position + " of your burger!");
    }
    public void removeIng(int position){
        System.out.println("You removed " + burgerSize[position] + " from your burger!!");
        burgerSize[position] = null;
    }
    public void givePaulToCook(){
        System.out.println("You gave the burger to Paul, and he is cooking up something mysterious...");
        PaulOrNo = true;
    }
    public String[] getBurger(){
        return burgerSize;
    }
public void eatBurger() {
    if (burgerSize.length == 0) {
        System.out.println("You ate air... silly goose...");
        return;
    }
    if(PaulOrNo){
        System.out.println("Uh oh... the burger tasted too good because Paul cooked it up... " + 
        "now you have a crippling addiction and will die of heart disease in a few years...");
        return;
    }
    System.out.print("Delicious! You really enjoyed that burger of ");
    for(int i = 0; i < burgerSize.length - 1; i++){
        if(burgerSize[i] == null){
            continue;
        }
        System.out.print(burgerSize[i]);
        if(burgerSize[i+1] != null){
            System.out.print(" with ");
        }
    }
    System.out.print(burgerSize[burgerSize.length - 1]);
    System.out.print("!");
    }
}
