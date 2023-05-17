package tech.altier;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("You: ");
            String input = scanner.nextLine();
            if (input.equals("exit")) break;
            System.out.println("Bot: " + chat(input));
        }
    }

    private static parseResponse(String response) {
        
    }

    private static String chat(String input) throws IOException {
        URL url = new URL("https://api.bardapi.dev/chat");
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("POST");

        httpConn.setRequestProperty("Authorization", "Bearer e01a29d7-8a2d-4af6-9784-f8519d364209");
        httpConn.setRequestProperty("Content-Type", "text/plain");

        httpConn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
        writer.write("{\"input\": \"" + input + "\"}");
        writer.flush();
        writer.close();
        httpConn.getOutputStream().close();

        InputStream responseStream = httpConn.getResponseCode() / 100 == 2
                ? httpConn.getInputStream()
                : httpConn.getErrorStream();
        Scanner s = new Scanner(responseStream).useDelimiter("\\A");
        String response = s.hasNext() ? s.next() : "";
        return response;
    }
}