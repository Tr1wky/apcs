/*
 *	Author:  
 *  Date: 
*/

import pkg.*;
import java.util.*;
import java.util.Scanner;
import java.util.Random;


class starter {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int questionnumber = 0;
		int points = 0; 
		int quizcounter = 0; 
		String password = "";
		String counterresponse = ""; 
		ArrayList<QuizData> quizDataList = new ArrayList<>(); 
		int tempquiz = 0;  
		boolean a = false; 
		if(quizcounter == 0){
			a = true; 
			ascii(a);
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.print("Would you like to create a quiz?: ");
			String response = sc.nextLine();
			if(response.equalsIgnoreCase("Yes")){
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				System.out.println("How many questions would you like to be on your quiz?");
				tempquiz = sc.nextInt();
				questionnumber = tempquiz;
            	for (int i = 0; i < questionnumber; i++) {
                	quizDataList.add(quiz(sc));
            	}
        		System.out.println("Press 1 if you would like to play the quiz for yourself, Press 2 if you would like to print your test.");
            	int choice = sc.nextInt();
            	sc.nextLine();
				if (choice == 1) {
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                	playQuiz(sc, quizDataList);
                } else if (choice == 2) {
                    printQuiz(quizDataList);
			}
			if(response.equalsIgnoreCase("No")){
				endingsequence(); 
			}
		}
	}
	}
 		
	public static void ascii(boolean a){
		if(a){
			System.out.println("    ____.  _________   _________        ________   ____ ___._______________________");
			System.out.println("    |    | /  _  \\   \\ /   /  _  \\       \\_____  \\ |    |   \\   \\____    /\\____    /");
			System.out.println("    |    |/  /_\\  \\   Y   /  /_\\  \\       /  / \\  \\|    |   /   | /     /   /     / ");
			System.out.println("/\\__|    /    |    \\     /    |    \\     /   \\_/.  \\    |  /|   |/     /_  /     /_ ");
			System.out.println("\\________\\____|__  /\\___/\\____|__  /     \\_____\\ \\_/______/ |___/_______ \\/_______ \\ ");
			System.out.println("                 \\/              \\/             \\__>                    \\/        \\/");
		}
	}
	
	public static void endingsequence(){
		System.out.println(" _____ _   _    _    _   _ _  ______    _____ ___  ____  ");
		System.out.println("|_   _| | | |  / \\  | \\ | | |/ / ___|  |  ___/ _ \\|  _ \\ ");
		System.out.println("  | | | |_| | / _ \\ |  \\| | ' /\\___ \\  | |_ | | | | |_) |");
		System.out.println("  | | |  _  |/ ___ \\| |\\  | . \\ ___) | |  _|| |_| |  _ < ");
		System.out.println(" _|_| |_| |_/_/ _ \\_\\_|_\\_|_|\\_\\____/__|_|   \\___/|_| \\_\\ ");
		System.out.println("|  _ \\| |      / \\ \\ / /_ _| \\ | |/ ___| |");
		System.out.println("| |_) | |     / _ \\ V / | ||  \\| | |  _| |             ");
		System.out.println("|  __/| |___ / ___ \\| |  | || |\\  | |_| |_| ");
		System.out.println("|_|   |_____/_/   \\_\\_| |___|_| \\_|\\____(_)   ");
	}
	
    public static QuizData quiz(Scanner sc) {
        String questionprompt = "";
        int numberofanswers = 0;
        int questionpoints = 0;
        int correctAnswerIndex = 0;
        ArrayList<String> answerholder = new ArrayList<>();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Enter the question prompt:");
        questionprompt = sc.nextLine();
        sc.nextLine(); 
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Enter the correct answer:");
        String correctAnswer = sc.nextLine();
        answerholder.add(correctAnswer);
        correctAnswerIndex = 0; 
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Enter the number of incorrect answers you would like for the question:");
        numberofanswers = sc.nextInt();
        sc.nextLine(); 
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        for (int i = 0; i < numberofanswers; i++) {
            System.out.println("#" + (i + 1) + ": Incorrect Answer:");
            String tempaholder = sc.nextLine();
            answerholder.add(tempaholder);
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Enter the points for this question:");
        questionpoints = sc.nextInt();
        sc.nextLine();
        Collections.shuffle(answerholder);
        correctAnswerIndex = answerholder.indexOf(correctAnswer);
        return new QuizData(questionprompt, answerholder, questionpoints, correctAnswerIndex);
    }
    public static void playQuiz(Scanner sc, ArrayList<QuizData> quizDataList) {
    	int totalPoints = 0;
    	int totalPossiblePoints = 0;
    	for (QuizData data : quizDataList) {
        totalPossiblePoints += data.getPoints();
        System.out.println("Question: " + data.getQuestion());
        ArrayList<String> answers = data.getAnswers();
        for (int i = 0; i < answers.size(); i++) {
            System.out.println((i + 1) + ". " + answers.get(i));
        }
        System.out.print("Your answer (enter the number): ");
        int answerIndex = sc.nextInt() - 1;
        sc.nextLine();
        if (answerIndex == data.getCorrectAnswerIndex()) {
            totalPoints += data.getPoints();
            System.out.println("Correct!");
        } else {
            System.out.println("Wrong! The correct answer was: " + (data.getCorrectAnswerIndex() + 1) + ". " + answers.get(data.getCorrectAnswerIndex()));
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }
    
    System.out.println("You finished the quiz with " + totalPoints + " points out of " + totalPossiblePoints + " points.");
}
    
    public static void printQuiz(ArrayList<QuizData> quizDataList) {
        for (QuizData data : quizDataList) {
            System.out.println("Question: " + data.getQuestion());
            ArrayList<String> answers = data.getAnswers();
            for (int i = 0; i < answers.size(); i++) {
                System.out.println((i + 1) + ". " + answers.get(i));
            }
            System.out.println("Correct answer: " + (data.getCorrectAnswerIndex() + 1));
            System.out.println("Points: " + data.getPoints());
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        }
    }
}

class QuizData {
    private String question;
    private ArrayList<String> answers;
    private int points;
    private int correctAnswerIndex;

    public QuizData(String question, ArrayList<String> answers, int points, int correctAnswerIndex) {
        this.question = question;
        this.answers = answers;
        this.points = points;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public int getPoints() {
        return points;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}