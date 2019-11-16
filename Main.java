import java.util.Scanner;
import java.lang.String;
import java.util.Random;
public class Main{
    static final int MAX = 5;
    static final int MIN = 1;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        newGame();
        String[] sailorUserHits = new String[]{"THAR SHE BLOWS!", "Finally! You hit something!", "Nicely done! Now make it happen again!", "Keep those cannons firing boys!", "Next one to land a hit gets a cask of grog from the capt'n's stores!"};
        String[] sailorUserMisses = new String[]{"Avast! Make your aim true, maggots!", "Reload you sniveling pigs!", "You managed to hit water in the middle of the ocean! Congratulations!", "You missed by a mile! Are you blind or just bloody stupid?", "Next shot that misses, you're jumpin' in after it!"};
        String[] sailorUserSinks = new String[]{"We've blown those damn state dogs to hell!", "First round's on me tonight, boys!", "Ha I didn't even think that would work!", "To Davey Jones's Locker with ya!", "Down go the landlubbers!"};
        String[] sailorOppHits = new String[]{"Bloody Hell! What in Davey Jones's name just happened?!", "These damn state dogs!", "These bloody princocks will be the death of me!", "You bloody landlubbers! Just go down quietly!", "Filthy grommets!"};
        String[] sailorOppMisses = new String[]{"HA! Did your bloody cannon even go off?", "Dumb as a board, this lot!", "So much for that state Man-o-War!", "Escaped by the skin of our teeth.", "Too close for comfort."};
        String[] sailorOppSinks = new String[]{"Yo Ho Noooooo!", "Abandon ship!", "They managed to bloody do it!", "To the bottom of the sea then.", "I don't wanna die!"};
        
        String[] stateUserHits = new String[]{"Ready! Reload! Fire!", "Shot Landed!", "Get those cannons full smartly, lads!", "Success!", "Aim True!"};
        String[] stateUserMisses = new String[]{"Damn!", "Reset!", "Disregard and fire!", "Fire at will!", "Blasphamy!"};
        String[] stateUserSinks = new String[]{"The enemy has gone down!", "It was almost too easy!", "It has been done!", "For Her Majesty!", "Smartly done, men!"};
        String[] stateOppHits = new String[]{"We've taken fire!", "Those damn pirates!", "Stand firm men!", "Remember your place, sailor!", "Blimey!"};
        String[] stateOppMisses = new String[]{"Too close for comfort. Reset and fire at will!", "Drunk bastards can't even shoot.", "Pirates couldn't aim cold sober.", "Don't be arrogant, men!", "A small victory!"};
        String[] stateOppSinks = new String[]{"It's been a pleasure serving with you men!", "Go down with the ship!", "Get to the boats!", "Abandon ship!", "Stand and go down with honor!"};
    }
    
    //Set Up
    public static void newGame(){
        System.out.println("Start a New Game?");
        String choice = sc.nextLine();
    }
    public static void gameType(){
        System.out.println("How would you like to play?\n1.Swear like a Sailor\n2.Sweet like the State");
        String strChoice = sc.nextLine();
        int choice = 0;
        try{
            choice = Integer.parseInt(strChoice);
        }
        catch(Exception e){
            System.out.println("Invalid Input!");
        }
    }
    public static int random(){
        Random rand = new Random();
        int randNum = rand.nextInt(MAX - MIN + 1);
        return randNum;
    }
}
