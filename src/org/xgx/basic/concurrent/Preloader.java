package org.xgx.basic.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Preloader {

	static class ProductInfo {

	}

	public static void main(String[] args) {
		Preloader preload = new Preloader();
		preload.start();

		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			i++;

			System.out.println(" waiting " + i);

		}
	}

	private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(() -> {
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			i++;

			System.out.println(" executing " + i);

		}
		return new ProductInfo();
	});

	private final Thread thread = new Thread(future);

	public ProductInfo get() throws Exception {
		try {
			return future.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	public void start() {
		thread.start();
	}
}
