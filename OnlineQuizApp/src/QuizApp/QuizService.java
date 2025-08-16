package QuizApp;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizService {
	private ArrayList<Question> question = new ArrayList<Question>();
	private Scanner sc = new Scanner(System.in);
	private int score = 0;

	public QuizService() {
		question.add(new Question("What is the capital of India? ", "Paris", "Delhi", "London", "Berlin", 'B'));
		question.add(new Question("Which language is created for the Backend API? ", "JavaScript", "Html5", "MySql",
				"Java", 'D'));
		question.add(new Question("Who Developed Java? ", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup",
				"Guido van Rossum", 'A'));
		question.add(new Question("What is 5 + 3 = ?", "5", "8", "9", "7", 'B'));
	}

	public void startQuiz() {
		System.out.println("\n*=*=*=Welcome to the Quiz=*=*=*");
		question.forEach(q -> {
			q.displayQuestion();
			char ans = sc.next().charAt(0);

			if (q.isCorrect(ans)) {
				System.out.println("Correct Answer");
				score++;
			} else {
				System.out.println("Wrong Answer");
			}
		});
	}
}
