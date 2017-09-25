package com.easy.kotlin;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.Reader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import static java.lang.System.out;

public class HttpProxy {

    private static final int BUFSIZ = 1024;

    public static void main(String[] args) throws UnknownHostException, IOException {
        printLocalIP();

        // Port of Proxy Server
        int InPort = 8081;
        // Port of Real Server
        int OuPort = 80;
        // IP of real server
        String OuHost = "127.0.0.1";
        ServerSocket serverSocket = null;
        try {
            // Build serverSocket with request port
            serverSocket = new ServerSocket(InPort);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        while (true) {
            Socket InSocket = null;
            Socket OuSocket = null;
            InputStream input = null;
            OutputStream output = null;
            try {
                // Receive request
                InSocket = serverSocket.accept();
                // Connect with real Server
                OuSocket = new Socket(OuHost, OuPort);
                // Read request and save in reader
                input = InSocket.getInputStream();
                Reader reader = new InputStreamReader(input);
                // Transmit request to real Server
                output = OuSocket.getOutputStream();
                char chars[] = new char[BUFSIZ];
                int len;
                if ((len = reader.read(chars)) != -1) {
                    String request = new String(chars, 0, len);
                    int n = request.indexOf("HTTP");
                    request = request.substring(0, n + 8);
                    request += "\n" + "Host:" + OuHost + "\n" + "\n";
                    out.println(request);

                    output.write(request.getBytes());
                }
                // Transmit response that read from real Server
                int ir;
                byte[] bytes = new byte[BUFSIZ];
                while (true) {
                    try {
                        if ((ir = OuSocket.getInputStream().read(bytes)) > 0) {
                            InSocket.getOutputStream().write(bytes, 0, ir);
                        } else if (ir < 0) {
                            break;
                        }
                    } catch (InterruptedIOException e) {
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            } finally {
                OuSocket.close();
                InSocket.close();
            }
        }
    }

    private static void printLocalIP() {
        try {
            System.out.println("本机的IP = " + InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
