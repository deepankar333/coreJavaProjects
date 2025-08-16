package QuizApp;

public class Question {
	private String questionText;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private char correctAnswer;
	
	public Question() {}

	public Question(String questionText, String optionA, String optionB, String optionC, String optionD,char correctAnswer) {
		super();
		this.questionText = questionText;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.correctAnswer = Character.toUpperCase(correctAnswer);
	}
	
	public void displayQuestion() {
		System.out.println("\n"+questionText);
		System.out.println("A. "+optionA);
		System.out.println("B. "+optionB);
		System.out.println("C. "+optionC);
		System.out.println("D. "+optionD);
	}
	
	public boolean isCorrect(char answer) {
		return Character.toUpperCase(answer)== correctAnswer;
	}

}
