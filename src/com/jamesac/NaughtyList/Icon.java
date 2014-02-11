package com.jamesac.NaughtyList;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Icon {
	
	private String path;
	public final int WIDTH, HEIGHT;
	
	public BufferedImage image;
	
	public static Icon happy = new Icon("/HappyTrans.png", 50, 50, 1);
	public static Icon neutral = new Icon("/NeutralTrans.png", 50, 50, 1);
	public static Icon sad = new Icon("/SadTrans.png", 50, 50, 1);
		
	public Icon(String paths, int x, int y, int index) {
		this.path = paths;
		WIDTH = x;
		HEIGHT = y;
		try {
			image = ImageIO.read(Icon.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
