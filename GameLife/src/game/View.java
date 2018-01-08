package game;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//Из Лабы недоделанны пункты графики с 7-го по 10-ый , остальное работает

public class View extends JPanel {
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		JFrame frame = new JFrame("Life ver 1.3");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);

		Container panelMain = frame.getContentPane(); // подрамка
		panelMain.setLayout(new BorderLayout());
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());

		
		JChild jc1 = new JChild(); // для главного поля
		jc1.setVisible(true);
		JButton northButton = new JButton("Population: "); // для верха
		
		
		JPanel panel2 = new JPanel(); // для низа с кнопками
		Box box = Box.createHorizontalBox();
		JButton saveButton = new JButton("Save");
		JButton loadButton = new JButton("Load");
		JButton importButton = new JButton("Import");
		box.add(saveButton);
		box.add(loadButton);
		box.add(importButton);
		box.add(Box.createHorizontalStrut(5));
		JButton startButton = new JButton("Start");
		JButton stepButton = new JButton("Step");
		JButton clearButton = new JButton("Clear");
		JButton stopButton = new JButton("Stop");
		box.add(startButton);
		box.add(stepButton);
		box.add(clearButton);
		box.add(stopButton);

		stepButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JChild.logic.next();
				jc1.repaint();
			}
		});

		JRadioButton grid = new JRadioButton("grid");
		box.add(grid);
		JLabel speedLabel = new JLabel("Speed:");
		box.add(speedLabel);
		JSlider slider = new JSlider(JSlider.HORIZONTAL);
		box.add(slider);
		JLabel sizeLabel = new JLabel("Size:");
		box.add(sizeLabel);
		int min = 1;
		int max = 20;
		int step = 1;
		SpinnerModel model = new SpinnerNumberModel(6, min, max, step);
		JSpinner spinner = new JSpinner(model);
		box.add(spinner);
		panel2.add(box);
		
		panel1.add(northButton, BorderLayout.NORTH);
		panel1.add(panel2, BorderLayout.SOUTH);
		panel1.add(jc1);

		panelMain.add(panel1);

		frame.setVisible(true);
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				JChild.logic.next();
				jc1.repaint();
			}
		});
		
		slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                timer.setDelay(slider.getValue()*100);
            }
        });

		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				timer.start();
				((Component) startButton).setEnabled(false);
			}
		});

		stopButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				timer.stop();
				((Component) startButton).setEnabled(true);
			}
		});

		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int mas[][] = new int[JChild.logic.cells.length][JChild.logic.cells[1].length];
				JChild.logic.cells = mas;
				jc1.repaint();
			}
		});
	}
}