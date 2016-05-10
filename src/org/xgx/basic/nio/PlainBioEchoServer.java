package org.xgx.basic.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlainBioEchoServer {

	public static void main(final String[] args) throws IOException {
		PlainBioEchoServer server = new PlainBioEchoServer(8899);
		server.serve();
	}

	private int port = 8899;

	public PlainBioEchoServer(final int port) {
		this.port = port;
	}

	public void serve() throws IOException {
		final ServerSocket server = new ServerSocket(port);
		System.out.println("Listening on port " + port + " ...");
		final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
		try {
			while (true) {
				final Socket client = server.accept();
				System.out.println("Accepted connetion from " + client);
				executor.submit(() -> {
					try {
						BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
						PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
						String data = null;
						do {
							data = reader.readLine();
							System.out.println("Read line -> " + data);
							writer.println(data);
							writer.flush();
						} while (data != null);

					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							client.close();
						} catch (Exception t) {
						}
					}

				});
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				executor.shutdown();
			} catch (Exception t) {
			}
			try {
				server.close();
			} catch (Exception t) {
			}
		}
	}

}
