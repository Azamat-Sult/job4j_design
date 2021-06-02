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
                    String request = null;
                    String answerToClient = "HTTP/1.1 200 OK\r\n";
                    while (!(str = in.readLine()).isEmpty()) {
                        String[] lineSplit = str.split(" ");
                        if (lineSplit[0].equals("GET")) {
                            String[] requestSplit = lineSplit[1].split("=");
                            request = requestSplit[1];
                        }
                        System.out.println(str);
                    }
                    System.out.println("---------------------------------------------");
                    if (Objects.equals(request, "Bye")) {
                        answerToClient = "HTTP/1.1 200 OK - SERVER is SHUTDOWN\r\n";
                        server.close();
                    }
                    out.write(answerToClient.getBytes());
                }
            }
            System.out.println("SERVER is SHUTDOWN");
        }
    }
}
