package com.jamesac.NaughtyList.handler;

import com.jamesac.NaughtyList.Controller;
import com.jamesac.NaughtyList.Icon;
import com.jamesac.NaughtyList.Student;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class Middle extends ListHandler {

  private int stringHeight = 0;

  public Middle(Controller screen)
  {
    super(screen);
  }

  public void paintList(Graphics g)
  {
    int count = 0;
    g.setFont(new Font("Corbel", Font.BOLD, 40));
    stringHeight = (int) g.getFontMetrics().getStringBounds("String", g)
                          .getHeight();
    for (Student s : students.students) {
      Rectangle2D rect = g.getFontMetrics().getStringBounds(s.getName(), g);
      s.setScreenLocation(new Rectangle((screen.width >> 1) - ((int) rect
          .getWidth() >> 1),
                                        100 + (int) rect
                                            .getHeight() * (count - 1),
                                        (int) rect.getWidth(),
                                        (int) rect.getHeight()));

      g.setColor(new Color(0.5f, 1.0f, 1.0f, 0.01f));
      g.fillRect((screen.width >> 1) - Icon.happy.WIDTH - 20,
                 100 + (int) rect.getHeight() * (count - 1),
                 Icon.happy.WIDTH + 40 + Icon.sad.WIDTH,
                 (int) rect.getHeight());

      g.setColor(Color.BLACK);
      g.drawString(s.getName(),
                   (screen.width >> 1) - ((int) rect.getWidth() >> 1),
                   100 + (int) rect.getHeight() * count);

      paintIcons(g, count, s.getGood(), s.getBad());
      count++;
    }
  }

  private void paintIcons(Graphics g, int num, int nGood, int nBad)
  {
    for (int good = 0; good < nGood; good++) {
      g.drawImage(Icon.happy.image,
                  screen.width / 2 - Icon.happy.WIDTH * (good + 2) - 20,
                  109 + stringHeight * (num - 1),
                  screen);
    }
    for (int bad = 0; bad < nBad; bad++) {
      g.drawImage(Icon.sad.image,
                  screen.width / 2 + Icon.sad.WIDTH * (bad + 1) + 20,
                  109 + stringHeight * (num - 1),
                  screen);
    }
  }

  public boolean actOnClick(MouseEvent e)
  {
    for (Student s : students.students) {
      Rectangle2D rect = s.getScreenLocation();
      rect.setFrame(screen.width / 2 - Icon.happy.WIDTH - 20, rect.getY(),
                    Icon.happy.WIDTH + 20,
                    rect.getHeight());
      if (rect.contains(e.getPoint())) {
        s.setGood(s.getGood() + 1);
        return true;
      }
      rect.setFrame(screen.width / 2, rect.getY(),
                    Icon.sad.WIDTH + 20,
                    rect.getHeight());
      if (rect.contains(e.getPoint())) {
        s.setBad(s.getBad() + 1);
        return true;
      }
      rect.setFrame(screen.width / 2 - Icon.happy.WIDTH * (s.getGood() + 2) - 20,
                    rect.getY(),
                    Icon.happy.WIDTH * (s.getGood() + 1),
                    rect.getHeight());
      if (rect.contains(e.getPoint())) {
        s.setGood(s.getGood() - 1);
        return true;
      }
      rect.setFrame(screen.width / 2 + Icon.sad.WIDTH + 20, rect.getY(),
                    Icon.sad.WIDTH * (s.getBad() + 2) + 20,
                    rect.getHeight());
      if (rect.contains(e.getPoint())) {
        s.setBad(s.getBad() - 1);
        return true;
      }
    }
    return false;
  }
}
