package tech.altier;

import com.pkslow.ai.*;

import java.time.Duration;

public class Main {
    private static final String token = "";
    public static void main(String[] args) {
        NetworkUtils.setUpProxy("localhost", "7890");

        AIClient client = new GoogleBardClient(token, Duration.ofMinutes(10));

        Answer answer = client.ask("What is the population of London?");
        printChosenAnswer(answer);

        answer = client.ask("How about Beijing?");
        printChosenAnswer(answer);

        answer = client.ask("How about Hong Kong?");
        printChosenAnswer(answer);
    }

    private static void printChosenAnswer(Answer answer) {
        StringBuilder sb = new StringBuilder();
        if (answer.status() == AnswerStatus.OK) {
            sb.append("\n### Chosen Answer\n");
            sb.append(answer.chosenAnswer());
            System.out.println("Output: \n " + sb);
        }
    }
}
