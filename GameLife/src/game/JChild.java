package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class JChild extends JPanel implements MouseListener { 
	public static LifeLogic logic = new LifeLogic(30, 40); 
	private int gabarit = 20;
	private static final long serialVersionUID = 1L;
	JChild() 
	{
		addMouseListener(this);
	}

	@Override
	public void paint(Graphics graphics) // переопределяем метод
	{
		super.paint(graphics);
		Graphics2D g2d = (Graphics2D) graphics;
		int step;
		int x = 0;
		int y = 0;
		for (int i = 0; x <= logic.cells[1].length * gabarit; i++) {
			g2d.drawLine(x, 0, x, getHeight());
			step = gabarit;
			x += step;
		}
		for (int i = 0; y <= logic.cells.length * gabarit; i++) { 
			g2d.drawLine(0, y, getWidth(), y);
			step = gabarit;
			y += step;
		}
		
		for (int i = 0; i < logic.cells.length; i++) {
			for (int j = 0; j < logic.cells[i].length; j++) {
				if (logic.cells[i][j] == 1) {
					g2d.fillOval(j * 20, i * 20, gabarit, gabarit);
				}
			}
		}

	}

	int x = 0;
	int y = 0;
	int currentX = 0;
	int currentY = 0;
	int CoordX = 0;
	int CoordY = 0;
	
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		x = event.getX();
		y = event.getY();
		currentX = (int) (x / gabarit);
		currentY = (int) (y / gabarit);
		CoordX = currentX * 20;
		CoordY = currentY * 20;

		if (logic.getCell(currentY, currentX) == 1) { // проверяем кликнута ли
			// была клетка
			logic.removeCell(currentY, currentX);
		} else {
			logic.setCell(currentY, currentX);// здесь метод логики записывающий
			// координаты в массив
		}
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
