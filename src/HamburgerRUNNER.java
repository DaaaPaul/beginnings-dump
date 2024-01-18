public class HamburgerRUNNER {
    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger();
        hamburger.burgerSetSize(3);
        hamburger.putIng("Cucumber",0);
        hamburger.putIng("Onions",1);
        hamburger.putIng("Cream",2);
        String[] b = hamburger.getBurger();
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
