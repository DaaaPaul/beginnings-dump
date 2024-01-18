public class Guessinggame{
    PlayerGuessinggame Winston;
    PlayerGuessinggame Bodhi;
    PlayerGuessinggame Illia;
    void StartGame(){
            Winston = new PlayerGuessinggame();
            Illia = new PlayerGuessinggame();
            Bodhi = new PlayerGuessinggame();
    System.out.println("Player 1, Player 2, Player 3, ready up, the game is starting!");    
            Illia.ReadyOrNot = true;
            Winston.ReadyOrNot = true;
            Bodhi.ReadyOrNot = true;
    if (Illia.ReadyOrNot == true && Winston.ReadyOrNot == true && Bodhi.ReadyOrNot == true){
         System.out.println("Game is starting...");
        }
    }
}
