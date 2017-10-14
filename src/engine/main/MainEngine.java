package engine.main;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import engine.display.Display;

public class MainEngine{
	
	private JFrame frame;
	private Display display;
	private int scrWidth;
	private int scrHeight;
	private boolean close = false;
	
	public MainEngine(boolean full, int width, int height, String name, double fps){
		System.setProperty("sun.java2d.opengl", "true");
		scrHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		scrWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		
		frame = new JFrame(name);
		if(full){
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setUndecorated(true);
		}
		frame.setResizable(false);
		frame.setLocation((scrWidth-width)/2, (scrHeight-height)/2);
		
		display = new Display(width, height, fps);
		
		frame.add(display);
		frame.pack();
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				close = true;
			}
		});
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	public void stop() {
		System.exit(1);
	}

	public Display getDisplay() {
		return display;
	}

	public boolean isClosed() {
		return close;
	}

	public void requestClose() {
		close = true;
	}

}
