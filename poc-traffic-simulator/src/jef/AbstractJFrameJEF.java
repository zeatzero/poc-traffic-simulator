package jef;

import javax.swing.JFrame;

public abstract class AbstractJFrameJEF extends JFrame {
	
	protected void init(){
		createComponents();
		createLayout();
		addActionListeners();
		setLocationRelativeTo(null);
	}
	protected abstract void createComponents();

	protected abstract void createLayout();
	
	protected abstract void addActionListeners();
}
