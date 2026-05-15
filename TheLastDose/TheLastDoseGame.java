package TheLastDose;

import java.util.*;

public class TheLastDoseGame {
    static Scanner scanner = new Scanner(System.in);
    
    // settings
    static boolean typingEffect = true;
    static int typingSpeed = 20;

    // values
    static boolean hasKey = false;
    static boolean phoneUnlocked = false;
    static boolean foundMedicineLog = false;
    static boolean puzzleBoxUnlocked = false;
    static boolean husbandRealizesTruth = false;
    static boolean passedChap1 = false;
    static String option="";
    
    public static void main(String[] args) {
    	passedChap1 = false;
    	menu();
    }
    public static String menu() {
        System.out.println("\r\n"
                + "┏━━━━┳┓╋╋╋╋╋┏┓╋╋╋╋╋╋╋╋┏┓╋┏━━━┓\r\n"
                + "┃┏┓┏┓┃┃╋╋╋╋╋┃┃╋╋╋╋╋╋╋┏┛┗┓┗┓┏┓┃\r\n"
                + "┗┛┃┃┗┫┗━┳━━┓┃┃╋╋┏━━┳━┻┓┏┛╋┃┃┃┣━━┳━━┳━━┓\r\n"
                + "╋╋┃┃╋┃┏┓┃┃━┫┃┃╋┏┫┏┓┃━━┫┃╋╋┃┃┃┃┏┓┃━━┫┃━┫\r\n"
                + "╋╋┃┃╋┃┃┃┃┃━┫┃┗━┛┃┏┓┣━━┃┗┓┏┛┗┛┃┗┛┣━━┃┃━┫\r\n"
                + "╋╋┗┛╋┗┛┗┻━━┛┗━━━┻┛┗┻━━┻━┛┗━━━┻━━┻━━┻━━┛");

        System.out.println("1) Start the game"
                + "\n2) Leave the game");

        String option = scanner.next();

        if (option.equals("1")) {
            intro();
            return "start";  // Indicating the game has started
        } 
        else if (option.equals("2")) {
            System.out.println("You leave the game.");
            return "exit";  // Indicating the player chose to leave
        } 
        else {
            System.out.println("Invalid choice. Try again.");
            return menu();  //call menu again
        }
    }
    
    // chapter 1 - wife's POV before death
    public static void intro() {
    	typeWriterEffect("--- Chapter 1: Before the Tragedy ---");
        typeWriterEffect("You are assigned an investigation into a mysterious death involving two couples, Jamey and Amy. Amy died, but nobody knows how she died.");
        typeWriterEffect("You need to gather clues from the wife’s perspective to understand what happened.");
        typeWriterEffect("-Press 'C' to continue: "
        		+ "\n-Press 'M' to go to the menu.");
        option=scanner.next();
        if(option.equalsIgnoreCase("C")) {
            livingRoom(); // main room
    	}
        else if(option.equalsIgnoreCase("M")) {
        	menu();
        }
        else {
        	intro();
        }
    }

    public static String livingRoom() {
    	isChapComplete();
        typeWriterEffect("\n[Living Room]");
        typeWriterEffect("1. Search the drawer");
        typeWriterEffect("2. Head to the kitchen");
        typeWriterEffect("3. Investigate the wife's room"
        		+ "\n4. Go to the menu");
        typeWriterEffect("Enter your choice: ");

        option=scanner.next();

        switch (option) {
            case "1":
                if (hasKey) {
                    typeWriterEffect("You unlock the drawer and find a Medicine Log. The wife was overdosing.");
                    foundMedicineLog = true;
                } else {
                    typeWriterEffect("The drawer is locked. You need a key.");
                }
                return livingRoom();  // Instead of recursion, return the current location
            case "2":
                return kitchen();
            case "3":
                return wifeRoom();
            case "4":
           return menu();
            default:
                typeWriterEffect("Invalid scan. Try again.");
                return livingRoom();
        }
    }
    
    // the kitchen (wife POV)
    public static String kitchen() {
    	isChapComplete();
        typeWriterEffect("\n[Kitchen]");
        typeWriterEffect("1. Search the drawer for a key");
        typeWriterEffect("2. Return to the living room"
        		+ "\n3. Go to the menu");
       typeWriterEffect("-Enter your choice: ");
        
       option=scanner.next();
        
        switch (option) {
            case "1":
                typeWriterEffect("You found a key!");
                hasKey = true;
                return kitchen();
                
            case "2":
                return livingRoom();
            case "3":
            	return menu();
            default:
                typeWriterEffect("Invalid scan. Try again.");
                return kitchen();
        }
    }
    
    // the wife's room (wife POV)
    public static String wifeRoom() {
    	isChapComplete();
        typeWriterEffect("\n[Wife's Room]");
        typeWriterEffect("1. Search the diary");
        typeWriterEffect("2. Try to unlock the phone");
        typeWriterEffect("3. Go back to the living room"
        		+ "\n4. Go to the menu");
       typeWriterEffect("-Enter your choice: ");
        
       option=scanner.next();
        
        switch (option) {
            case "1": typeWriterEffect("You found the phone password: 0421"); phoneUnlocked = false; 
            return wifeRoom();
            
		case "2":
                if (phoneUnlocked==false) {
                    typeWriterEffect("You unlocked the phone and found a voice memo:"
                    		+ " 'I need him to see what’s happening… but what if he doesn’t?'");
                    phoneUnlocked = true; 
                    isChapComplete();   } 
                else {
                    typeWriterEffect("The phone is locked. You need to find the password.");
                }
               return wifeRoom();
               
            case "3":
                return livingRoom();
            case "4":
            	return menu();         	
		default:
                typeWriterEffect("Invalid scan. Try again.");
                return wifeRoom();
        }
    }
    
    // chapter 2 - husband's POV
    public static boolean chapterTwo() {
        typeWriterEffect("\n--- Chapter 2: The Husband's Mind ---");
        typeWriterEffect("Now, from the husband's perspective. He struggles to remember the events leading to the tragic outcome.");
        typeWriterEffect("The wife is dead. Was it his fault?");
        typeWriterEffect("-Press Enter to continue: ");

        scanner.next();

        wifeRoomHusband();

        return true; // Indicating that Chapter 2 has started successfully
    }

    // wife's room (husband POV)
    public static void wifeRoomHusband() {
        typeWriterEffect("\n[Wife's Room]");
        typeWriterEffect("1. Search the drawer for his notes");
        typeWriterEffect("2. Go to the living room"
        		+ "\n3. Go to the menu");
       typeWriterEffect("-Enter your choice: ");
        
       option =scanner.next();
        
        switch (option) {
            case "1":
                typeWriterEffect("You found a half-erased note: 'Did I give her the medicine already?'");
                wifeRoomHusband();
                break;
            case "2":
                livingRoomHusband();
                break;
            case"3":
            	menu();
            	break;
            default:
                typeWriterEffect("Invalid scan. Try again.");
                wifeRoomHusband();
        }
    }

    // living room (husband POV)
    public static void livingRoomHusband() {
    	isChapComplete(); // checks if the level is completed
        typeWriterEffect("\n[Living Room]");
        typeWriterEffect("1. Check the clock");
        typeWriterEffect("2. Check his phone logs for calls"
        		+ "3. Go to the Menu");
       typeWriterEffect("-Enter your choice: ");
        
       option =scanner.next();
        
        switch (option) {
            case "1":
                typeWriterEffect("The clock is stuck at 10pm, but the husband recalls giving the medicine at 8pm. Something doesn't add up.");
                livingRoomHusband();
                break;
            case "2":
                typeWriterEffect("You check his phone logs. A long call at 8pm suggests his memory is off. The timeline doesn't add up.");
                puzzleBox();
                break;
            case "":
            	menu();
            	break;
            default:
                typeWriterEffect("Invalid scan. Try again.");
                livingRoomHusband();
       }
   }

    // opens puzzle box
    public static void puzzleBox() {
       
    	typeWriterEffect("\n[Storage Room]");
        typeWriterEffect("1. Search for the puzzle box");
        typeWriterEffect("2. Go back to check other rooms"
        		+ "\n3. Go to the menu");
       typeWriterEffect("Enter your scan: ");
        
       option =scanner.next();
        
        switch (option) {
            case "1":
                typeWriterEffect("You found a locked puzzle box with a note.");
                openingFinalBox();
                break;
            case "2":
                livingRoomHusband();
                break;
            case "3":
            	menu();
            	break;
            default:
                typeWriterEffect("Invalid choice. Try again.");
                puzzleBox();
        }
    }
    
    // checks if we passed the chapter
    public static boolean isChapComplete() {
        if (foundMedicineLog==true && phoneUnlocked==true && puzzleBoxUnlocked==false && passedChap1==false) {
            passedChap1 = true;
            return chapterTwo();  // Chapter is complete
        }
        else if (hasKey==true && phoneUnlocked==true && puzzleBoxUnlocked==true) {
            return chapterThree();  // Progress to chapter 3
        }
        else {
            return false;  // Chapter not complete yet
        }
    }

 // opens the final box
    public static void openingFinalBox() {
        typeWriterEffect("Using the clues gathered, you unlock the final box.");
        typeWriterEffect("Inside, you find a letter from the wife: 'I thought if I tested him, he would see the truth… I was wrong.'");
        puzzleBoxUnlocked = true;
        puzzleBox();
    }
    // chapter 3 - The final revelation
    public static boolean chapterThree() {
        typeWriterEffect("\n--- Chapter 3: The Truth Unveiled ---");
        typeWriterEffect("The husband slowly realizes... he was the one who killed her. His mind distorted the truth.");
        typeWriterEffect("He thought he was the victim, but the evidence shows otherwise.");
        typeWriterEffect("-Press Enter to continue: ");

        scanner.next();
        
        finalScene();
        
        return true; // Indicating that Chapter 3 has started successfully
    }
    public static void finalScene() {
        typeWriterEffect("\n[Final Scene]");
        typeWriterEffect("The detective presents all the evidence to the husband.");
        typeWriterEffect("The husband is devastated, realizing he was responsible all along.");
        typeWriterEffect("Was it his memory loss that led to the tragic event? Or was he just a victim of his own mind?");
       typeWriterEffect("-Press Enter to end: ");
   
        scanner.next();
        typeWriterEffect("----------------------");
        intro();
    }
 
    public static String options(String options) {
		return option;
    	
    }
        public static void typeWriterEffect(String text) {
           if (typingEffect == true) {
        	   
        	for (int i = 0; i < text.length(); i++) {
            	System.out.print(text.charAt(i));
                
                try {
					Thread.sleep(typingSpeed);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            }
            System.out.println("");      
           }
           else 
        	 System.out.println(text);
 
    }
}
