package poc.trafficsimulator.view;

import javax.swing.JFrame;

public abstract class JFrameJEF extends JFrame {
	
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
