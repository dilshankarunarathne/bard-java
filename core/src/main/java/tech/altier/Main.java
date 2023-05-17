package tech.altier;

import com.pkslow.ai.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;

public class Main {
    private static final String token = "e01a29d7-8a2d-4af6-9784-f8519d364209";

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

    private static void curl() throws IOException {
        String[] commands = {"curl", "-X", "POST", "http://checkip.amazonaws.com"};
        Process process = Runtime.getRuntime().exec(commands);
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(process.getInputStream()));
        String line;
        String response = "";
        while ((line = reader.readLine()) != null) {
            response += line;
        }
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
