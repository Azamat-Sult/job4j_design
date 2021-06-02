package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String request = "";
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.startsWith("GET /?")) {
                            String[] lineSplit = str.split(" ");
                            String[] requestSplit = lineSplit[1].split("=");
                            request = requestSplit[1];
                        }
                        System.out.println(str);
                    }
                    System.out.println("---------------------------------------------");
                    String answerToClient = request;
                    if (Objects.equals(request, "Exit")) {
                        answerToClient = "SERVER is SHUTDOWN";
                        server.close();
                    }
                    if (Objects.equals(request, "Hello")) {
                        answerToClient = "Hello, dear friend!";
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(answerToClient.getBytes());
                }
            }
            System.out.println("SERVER is SHUTDOWN");
        }
    }
}
