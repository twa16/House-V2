/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Object representing an AuthenticationServer instance.
 * @author Manuel Gauto
 */
public class AuthenticationServer {

    Thread server;
    int port;
    Connection conn;

    /**
     * Constructor for AuthenticationServer
     * @param port Port that server will listen on
     * @param c Connection to MYSQL
     */
    public AuthenticationServer(int port, Connection c) {
        this.port = port;
        this.conn = c;
    }

    /**
     * Returns thread that AuthenticationServer runs in.
     * @return Thread of AuthenticationServer
     */
    public Thread getThread() {
        return server;
    }

    /**
     * Method that starts the AuthenticationServer
     */
    public void start() {
        server = new Thread(new AuthenticationServerThread(port, conn));
        server.start();
    }
}

/**
 * Represents Thread that accepts connections and distributes
 * them among different threads.
 * @author Manuel Gauto
 */
class AuthenticationServerThread implements Runnable {

    /**
     * Server port
     */
    int port;
    /**
     * ServerSocket for server thread
     */
    ServerSocket svrskt;
    /**
     * Socket that will be used to connect to client
     */
    Socket skt;
    /**
     * Connection to MYSQL server
     */
    Connection conn;

    /**
     * Constructor for server thread
     * @param port Port that server will listen on
     * @param conn Connection to MYSQL server
     */
    public AuthenticationServerThread(int port, Connection conn) {
        this.port = port;
        this.conn = conn;
    }

    /**
     * Thread contents
     */
    public void run() {
        try {
            svrskt = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(AuthenticationServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            try {
                skt = svrskt.accept();
            } catch (IOException ex) {
                Logger.getLogger(AuthenticationServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            Thread t = new Thread(new CommunicationThread(skt, conn));
            t.start();
        }
    }
}