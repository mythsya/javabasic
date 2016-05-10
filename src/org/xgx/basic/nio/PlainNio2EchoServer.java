package org.xgx.basic.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class PlainNio2EchoServer {

	private final class EchoCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {
		private final AsynchronousSocketChannel channel;

		EchoCompletionHandler(final AsynchronousSocketChannel channel) {
			this.channel = channel;
		}

		@Override
		public void completed(final Integer result, final ByteBuffer attachment) {
			attachment.flip();
			channel.write(attachment, attachment, new CompletionHandler<Integer, ByteBuffer>() {

				@Override
				public void completed(final Integer result, final ByteBuffer buffer) {
					if (buffer.hasRemaining()) {
						channel.write(buffer, buffer, this);
					} else {
						buffer.compact();
						channel.read(buffer, buffer, EchoCompletionHandler.this);
					}
				}

				@Override
				public void failed(final Throwable exc, final ByteBuffer buffer) {
					try {
						channel.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			});
		}

		@Override
		public void failed(final Throwable exc, final ByteBuffer attachment) {
			try {
				channel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(final String[] args) throws IOException {
		PlainNio2EchoServer server = new PlainNio2EchoServer(8899);
		server.serve();
	}

	private int port = 8899;

	public PlainNio2EchoServer(final int port) {
		this.port = port;
	}

	public void serve() throws IOException {
		final AsynchronousServerSocketChannel assc = AsynchronousServerSocketChannel.open();
		assc.bind(new InetSocketAddress(port));
		System.out.println("Listening on port " + port + " ...");

		final CountDownLatch latch = new CountDownLatch(1);

		assc.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

			@Override
			public void completed(final AsynchronousSocketChannel result, final Object attachment) {
				assc.accept(null, this);

				ByteBuffer buffer = ByteBuffer.allocate(1000);
				result.read(buffer, buffer, new EchoCompletionHandler(result));
			}

			@Override
			public void failed(final Throwable exc, final Object attachment) {
				try {
					assc.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					latch.countDown();
				}

			}

		});

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
