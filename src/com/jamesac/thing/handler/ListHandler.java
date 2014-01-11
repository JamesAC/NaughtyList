package com.jamesac.thing.handler;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

import com.jamesac.thing.Controller;
import com.jamesac.thing.NameList;

public class ListHandler {

	protected static NameList students;
	protected Controller screen;

	protected int good, bad, neutral;

	public ListHandler(Controller screen) {
		this.screen = screen;
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			System.out.println("Unable to load Window look and feel");
		}
		JFileChooser fileChooser = new JFileChooser();
		int retVal = fileChooser.showOpenDialog(screen.getFrame());

		if (retVal == JFileChooser.APPROVE_OPTION) {
			students = new NameList(fileChooser.getSelectedFile().toPath());
		} else {
			System.exit(0);
		}
	}

	public void paintList(Graphics g) {
		
	}

	public boolean actOnClick(MouseEvent e) {
		return false;
	}
}
