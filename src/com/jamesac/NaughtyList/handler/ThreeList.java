package com.jamesac.NaughtyList.handler;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import com.jamesac.NaughtyList.Controller;
import com.jamesac.NaughtyList.Icon;
import com.jamesac.NaughtyList.Student;

public class ThreeList extends ListHandler {
	
	public ThreeList(Controller screen) {
		super(screen);
	}

	public void paintList(Graphics g) {
		paintIcons(g);
		good = bad = neutral = 0;
		g.setFont(new Font("Corbel", Font.BOLD, 40));
		for (Student s : students.students) {
			if (s.getScore() > 0) {
				good++;
				Rectangle2D rect = g.getFontMetrics().getStringBounds(s.getName(), g);
				s.setScreenLocation(new Rectangle(15, 100 + (int) rect.getHeight() * (good - 1),
																					(int) rect.getWidth(), (int) rect.getHeight()));
				g.setColor(new Color(1.0f, 1.0f, 1.0f, 0.01f));
				g.fillRect(	15, 100 + (int) rect.getHeight() * (good - 1), (int) rect.getWidth(),
										(int) rect.getHeight());
				g.setColor(Color.BLACK);
				g.drawString(s.getName(), 15, 100 + (int) rect.getHeight() * good);
			} else if (s.getScore() < 0) {
				bad++;
				Rectangle2D rect = g.getFontMetrics().getStringBounds(s.getName(), g);
				s.setScreenLocation(new Rectangle(screen.width - 15 - (int) rect.getWidth(),
																					100 + (int) rect.getHeight() * (bad - 1),
																					(int) rect.getWidth(), (int) rect.getHeight()));
				g.setColor(new Color(1.0f, 1.0f, 1.0f, 0.01f));
				g.fillRect(	screen.width - 15 - (int) rect.getWidth(), 100 + (int) rect.getHeight()
																																* (bad - 1), (int) rect.getWidth(),
										(int) rect.getHeight());
				g.setColor(Color.BLACK);
				g.drawString(	s.getName(), screen.width - 15 - (int) rect.getWidth(),
											100 + (int) rect.getHeight() * bad); // Fix position
			} else {
				neutral++;
				Rectangle2D rect = g.getFontMetrics().getStringBounds(s.getName(), g);
				s.setScreenLocation(new Rectangle((screen.width >> 1) - ((int) rect.getWidth() >> 1),
																					100 + (int) rect.getHeight() * (neutral - 1),
																					(int) rect.getWidth(), (int) rect.getHeight()));
				g.setColor(new Color(1.0f, 1.0f, 1.0f, 0.01f));
				g.fillRect(	(screen.width >> 1) - ((int) rect.getWidth() >> 1),
										100 + (int) rect.getHeight() * (neutral - 1),
										(int) rect.getWidth(), (int) rect.getHeight());
				g.setColor(Color.BLACK);
				g.drawString(	s.getName(), (screen.width >> 1) - ((int) rect.getWidth() >> 1),
											100 + (int) rect.getHeight() * neutral);
			}
		}
	}

	private void paintIcons(Graphics g) {
		g.drawImage(Icon.happy.image, 15, 15, screen);
		g.drawImage(Icon.neutral.image, screen.width / 2 - 25, 15, screen);
		g.drawImage(Icon.happy.image, screen.width - 65, 15, screen);
	}

	public boolean actOnClick(MouseEvent e) {
		for (Student s : students.students) {
			if (s.getScreenLocation().contains(e.getPoint())) {
				if (s.getScore() < 0) {
					s.setScore(0);
				} else if (s.getScore() > 0) {
					s.setScore(0);
				} else if (s.getScore() == 0) {
					s.setScore((e.getButton() == MouseEvent.BUTTON3) ? -1 : 1);
				}
				return true;
			}
		}
		return false;
	}

}
