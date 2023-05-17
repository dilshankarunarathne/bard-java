package tech.altier;

import com.pkslow.ai.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;

public class Main {
    private static final String token = "e01a29d7-8a2d-4af6-9784-f8519d364209";

    public static void main(String[] args) {
        while (true) {
            
        }
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
