package com.jamesac.NaughtyList;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.jamesac.NaughtyList.handler.ListHandler;
import com.jamesac.NaughtyList.handler.Middle;

public class Controller extends Canvas implements MouseListener {
	private static final long serialVersionUID = 1L;

	public int width;
	public int height;

	private static int mouseX = -1;
	private static int mouseY = -1;
	private static int mouseB = -1;

	private JFrame frame;

	private ListHandler handler;

	public Controller() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		width = gd.getDisplayMode().getWidth();
		height = gd.getDisplayMode().getHeight();
		Dimension size = new Dimension(width, height);
		setPreferredSize(size);

		init();

		frame = new JFrame();

		frame.setUndecorated(true);
		frame.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		requestFocus();

		addMouseListener(this);
	}

	private void init() {
		handler = new Middle(this);
	}

	public void clear() {
		// for (int i = 0; i < pixels.length; i++) {
		// pixels[i] = Color.TRANSLUCENT;
		// }
	}

	public void paint(Graphics g) {
		super.paint(g);

		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
																RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		handler.paintList(g);
	}

	public JFrame getFrame() {
		return frame;
	}

	public static int getMouseX() {
		return mouseX;
	}

	public static int getMouseY() {
		return mouseY;
	}

	public static int getButton() {
		return mouseB;
	}

	public void mouseClicked(MouseEvent e) {
		boolean changed = handler.actOnClick(e);
		if (changed) {
			frame.getContentPane().revalidate();
			frame.getContentPane().repaint();
		} else {
			System.exit(0);
		}
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
		mouseB = -1;
	}

	// public void renderTile(int xp, int yp, Tile tile) {
	// xp -= xOffset;
	// yp -= yOffset;
	// for (int y = 0; y < tile.sprite.SIZE; y++) {
	// int ya = y + yp;
	// for (int x = 0; x < tile.sprite.SIZE; x++) {
	// int xa = x + xp;
	// if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
	// if (xa < 0) xa = 0;
	// pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
	// }
	// }
	// }
}
