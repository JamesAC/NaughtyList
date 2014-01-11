package com.jamesac.NaughtyList;

public class Main implements Runnable {
	private Thread thread;

	private Controller screen;
	
	public Main() {
		screen = new Controller();
		update();
	}

	public synchronized void start() {
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
	}

	public void update() {
	}

	public static void main(String[] args) {
		Main mainThread = new Main();

		mainThread.start();
	}

}
