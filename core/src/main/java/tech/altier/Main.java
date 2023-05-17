package tech.altier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Scanner;

public class Main {
    private static final String token = "e01a29d7-8a2d-4af6-9784-f8519d364209";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            try {
                String response = curl(input);
                System.out.println("Bard: " + response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String chat(String input) throws IOException {
        String Demo_Command = "curl -X POST https://localhost/post --data delft1=stack1&delft2=stack2";
        Process Demo_process = Runtime.getRuntime().exec(Demo_Command);
        InputStream Input_Stream = Demo_process.getInputStream();
        Demo_process.destroy();
    }

    private static String curl(String input) throws IOException {
        String[] commands = {
                "curl", "-X", "POST", "https://api.bardapi.dev/chat",
                "-H", "Authorization: Bearer " + token,
                "-H", "Content-Type: text/plain",
                "-d", "{\"input\":\"" + input + "\"}"
        };
        Process process = Runtime.getRuntime().exec(commands);
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(process.getInputStream()));
        String line;
        String response = "";
        while ((line = reader.readLine()) != null) {
            response += line;
        }

        return response;
    }
}
