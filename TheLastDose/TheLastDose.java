package TheLastDose;

import java.io.File;
import java.io.IOException;
import java.util.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TheLastDose {
    static Scanner scanner = new Scanner(System.in);
    // settings
    static boolean typingEffect = true;
    static int typingSpeed = 17;

    // values
    static boolean hasKey = false;
    static boolean phoneUnlocked = false;
    static boolean foundMedicineLog = false;
    static boolean puzzleBoxUnlocked = false;
    static boolean husbandRealizesTruth = false;
    static boolean passedChap1 = false;
    static boolean passedChap2=false;
    static boolean password=false;
    static String option="";
    static boolean clock=false;
    static boolean notes=false;
    static Clip clip2;
    static Clip clip3;
    
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    	passedChap1 = false;
    	menu();
    }
    public static String menu() throws UnsupportedAudioFileException, IOException, LineUnavailableException  {
    	    hasKey = false;
    	    phoneUnlocked = false;
    	    foundMedicineLog = false;
    	    puzzleBoxUnlocked = false;
    	    husbandRealizesTruth = false;
    	    passedChap1 = false;
    	    passedChap2=false;
    	    password=false;
    	    clock=false;
    	    notes=false;
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
            System.exit(0); //terminates the program
            return "exit";  // Indicating the player chose to leave
        } 
        else {
            System.out.println("Invalid choice. Try again.");
            return menu();  //call menu again
        }
    }
    
    // chapter 1 - wife's POV before death
    public static void intro() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    	typeWriterEffect("--- Chapter 1: Before the Tragedy ---");
        typeWriterEffect("You are assigned an investigation into a mysterious death involving two couples, Jamey and Amy. Amy died, but nobody knows how she died.");
        typeWriterEffect("You need to gather clues from the wife’s perspective to understand what happened.");
        typeWriterEffect("-Press 'C' to continue: "
        		+ "\n-Press 'M' to go to the menu.");
        option=scanner.next();
        if(option.equalsIgnoreCase("C")) {
        	background();
            livingRoom(); // main room
    	}
        else if(option.equalsIgnoreCase("M")) {
        	menu();
        }
        else {
        	typeWriterEffect("Invalid scan. Try again.");
        	intro();
        }
    }

    public static String livingRoom() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
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
                 livingRoom();  // Instead of recursion, return the current location
            case "2":
                 kitchen();
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
    public static String kitchen() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    	isChapComplete();
        typeWriterEffect("\n[Kitchen]");
        typeWriterEffect("1. Search the drawer for a key");
        typeWriterEffect("2. Return to the living room"
        		+ "\n3. Go to the menu");
       typeWriterEffect("-Enter your choice: ");
        
       option=scanner.next();
        
            if(option.equals("1")){                 
                System.out.println("What is the password");
                option=scanner.next();
                if(option.equals("34265")){
                     System.out.println("You unlock the drawer and you find a key");
                hasKey=true;
                return kitchen();
                }
                else{
                	 funny();
                	  typeWriterEffect("Your phone is ringing!");
                      typeWriterEffect("1. Pick up the call");
                      typeWriterEffect("2. Don't pick up the call");
                      typeWriterEffect("-Enter your choice: ");

                       option=scanner.next();
                       if(option.equals("1")){
                           password2();
                       }
                       else if(option.equals("2")){
                           kitchen();
                       }               
                }
               
                          
            }
            else if(option.equals("2")){
                return livingRoom();
            }
            else if(option.equals("3")){
                return menu();
            }
            else {
                typeWriterEffect("Invalid scan. Try again.");
                return kitchen();
            }
			return option;
         
    }
    public static void password2() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
                	System.out.println("Some unkown caller has been calling you and he left 5 msgs for you.");
                    System.out.println("The sequence mirrors her heart — steady, breaking, then struggling. The missing beat is where everything changed.");
                    System.out.println("1) Message"
                    		+ "\n2) Messgae"
                    		+ "\n3) Message"
                    		+ "\n4) Message"
                    		+ "\n5) Add what is missing");
                            System.out.println("6) Go back to the menu");
                            
                            option=scanner.next();
                            if(option.equals("1")){
                               sound();
                               password2();
                            }
                            else if(option.equals("2")) {
                                sound2();
                                password2();
                            }
                             else if(option.equals("3")) {
                                sound3();
                                password2();
                            }
                             else if(option.equals("4")) {
                                sound4();
                                password2();
                            }
                             else if(option.equals("5")) {
                                System.out.println("Add what is missing");
                                System.out.println("What is the password");
                option=scanner.next();
                if(option.equals("34265")){
                     password=true;
                    kitchen();
                                
                            }
                            else {
                               kitchen();
                            }
            }
                             else if(option.equals("6")) {
                            	 menu();
                             }
                            	
                }
 
        public static Clip sound() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
             File file = new File("beep.wav");
           AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
           Clip clip = AudioSystem.getClip();
           clip.open(audioStream);
           clip.loop(2);
           return clip;
        }
        public static Clip sound2() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
             File file = new File("beep.wav");
           AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
           Clip clip = AudioSystem.getClip();
           clip.open(audioStream);
           clip.loop(3);
           return clip;
        }
        public static Clip sound3() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
             File file = new File("beep.wav");
           AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
           Clip clip = AudioSystem.getClip();
           clip.open(audioStream);
           clip.loop(1);
           return clip;
        }
        public static Clip sound4() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
             File file = new File("beep.wav");
           AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
           Clip clip = AudioSystem.getClip();
           clip.open(audioStream);
           clip.loop(5);
           return clip;
        }
        public static Clip background() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
            File file = new File("background.wav");
          AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
          clip2 = AudioSystem.getClip();
          clip2.open(audioStream);
          clip2.loop(Clip.LOOP_CONTINUOUSLY);
          return clip2;
       }
        public static Clip background1() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
          clip2.stop();
          return clip2;
       }
        public static Clip background2() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
            File file = new File("theme.wav");
          AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
          clip3 = AudioSystem.getClip();
          clip3.open(audioStream);
          clip3.loop(Clip.LOOP_CONTINUOUSLY);
          return clip3;
       }
        public static Clip background3() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
          clip3.stop();
          return clip3;
       }
        public static Clip funny() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
            File file = new File("wrong.wav");
          AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
          Clip clip = AudioSystem.getClip();
          clip.open(audioStream);
          clip.start();
          return clip;
       }
        public static Clip background4() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
            File file = new File("sadSound.wav");
          AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
          Clip clip = AudioSystem.getClip();
          clip.open(audioStream);
          clip.loop(Clip.LOOP_CONTINUOUSLY);
          return clip;
       }
    // the wife's room (wife POV)
    public static String wifeRoom() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        typeWriterEffect("\n[Wife's Room]");
        typeWriterEffect("1. Search the diary");
        typeWriterEffect("2. Try to unlock the phone");
        typeWriterEffect("3. Go back to the living room"
        		+ "\n4. Go to the menu");
       typeWriterEffect("-Enter your choice: ");
        
       option=scanner.next();
        
        switch (option) {
            case "1":
                typeWriterEffect("You found the phone password: 0421");
                phoneUnlocked = true;
               return wifeRoom();
                
            case "2":
                if (phoneUnlocked) {
                    typeWriterEffect("You unlocked the phone and found a voice memo:"
                    		+ " 'I need him to see what’s happening… but what if he doesn’t?'");
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
    public static boolean chapterTwo() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        typeWriterEffect("\n--- Chapter 2: The Husband's Mind ---");
        typeWriterEffect("Now, from the husband's perspective. He struggles to remember the events leading to the tragic outcome.");
        typeWriterEffect("The wife is dead. Was it his fault?");
        typeWriterEffect("Enter anything to continue: ");
        background1();
        background2();
        scanner.next();
        wifeRoomHusband();

        return true; // Indicating that Chapter 2 has started successfully
    }

    // wife's room (husband POV)
    public static void wifeRoomHusband() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        typeWriterEffect("\n[Wife's Room]");
        typeWriterEffect("1. Search the drawer for his notes");
        typeWriterEffect("2. Go to the living room"
        		+ "\n3. Go to the menu");
       typeWriterEffect("-Enter your choice: ");
        
       option =scanner.next();
        
        switch (option) {
            case "1":
                typeWriterEffect("You found a half-erased note: 'Did I give her the medicine already?'");
                notes=true;
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
    public static void livingRoomHusband() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    	isChapComplete(); // checks if the level is completed
        typeWriterEffect("\n[Living Room]");
        typeWriterEffect("1. Check the clock");
        typeWriterEffect("2. Check his phone logs for calls"
        		+ "\n3. Go to the Menu");
       typeWriterEffect("-Enter your choice: ");
        
       option =scanner.next();
        
        switch (option) {
            case "1":
                typeWriterEffect("The clock is stuck at 10pm, but the husband recalls giving the medicine at 8pm. Something doesn't add up.");
                clock=true;
                livingRoomHusband();
                isChapComplete2();
                break;
            case "2":
                typeWriterEffect("You check his phone logs. A long call at 8pm suggests his memory is off. The timeline doesn't add up.");
                puzzleBox();
                isChapComplete2();
                break;
            case "3":
            	menu();
            	break;
            default:
                typeWriterEffect("Invalid scan. Try again.");
                livingRoomHusband();
       }
   }

    // opens puzzle box
    public static void puzzleBox() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    	 isChapComplete2();
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
    public static boolean isChapComplete() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (foundMedicineLog==true && phoneUnlocked==true && puzzleBoxUnlocked==false && passedChap1==false) {
            passedChap1 = true;
            return chapterTwo();  // Chapter is complete
        }
        
        else {
            return false;  // Chapter not complete yet
        }
    }
    public static boolean isChapComplete2() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (puzzleBoxUnlocked && clock && notes && !passedChap2 && foundMedicineLog && phoneUnlocked && passedChap1) {
            System.out.println("Conditions met! Advancing to Chapter 3...");
            passedChap2 = true;
            return chapterThree();  // Progress to chapter 3
        } else {
            return false;  // Chapter not complete yet
        }
    }
 // opens the final box
    public static void openingFinalBox() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    	isChapComplete2();
        typeWriterEffect("Using the clues gathered, you unlock the final box.");
        typeWriterEffect("Inside, you find a letter from the wife: 'I thought if I tested him, he would see the truth… I was wrong.'");
        puzzleBoxUnlocked = true;
        puzzleBox();
        isChapComplete2();
    }
    // chapter 3 - The final revelation
    public static boolean chapterThree() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    	background3();
    	background4();
        typeWriterEffect("\n--- Chapter 3: The Truth Unveiled ---");
        typeWriterEffect("The husband slowly realizes... he was the one who killed her. His mind distorted the truth.");
        typeWriterEffect("He thought he was the victim, but the evidence shows otherwise.");
        typeWriterEffect("-Press Enter to continue: ");

        scanner.nextLine();
        
        finalScene();
        
        return true; // Indicating that Chapter 3 has started successfully
    }
    public static void finalScene() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        typeWriterEffect("\n[Final Scene]");
        typeWriterEffect("The detective presents all the evidence to the husband.");
        typeWriterEffect("The husband is devastated, realizing he was responsible all along.");
        typeWriterEffect("Was it his memory loss that led to the tragic event? Or was he just a victim of his own mind?");
       typeWriterEffect("-Press Enter to end: ");
   
        scanner.nextLine();
        typeWriterEffect("----------------------");
        System.exit(0);
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
					// 
					e.printStackTrace();
				}

            }
            System.out.println("");      
           }
           else 
        	 System.out.println(text); 
    }
}