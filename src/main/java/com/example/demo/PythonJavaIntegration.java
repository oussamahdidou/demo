package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonJavaIntegration {
    String result = "";

    public String executecode(String img) {
        try {
            // Specify the path to the Python script
            String pythonScriptPath = "C:\\Users\\ASUS\\Downloads\\ctkproject\\Food-Recognition-GUI\\model.py";

            // Specify the argument to pass to the Python script (img_file variable)
            String imgFile = img;

            // Build the command to execute the Python script with the argument
            ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScriptPath, imgFile);

            // Start the process
            Process process = processBuilder.start();

            // Read the output of the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                result =  line;
            }
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
               //  System.err.println("Python Error: " + line);
            }
            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Python Script exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
