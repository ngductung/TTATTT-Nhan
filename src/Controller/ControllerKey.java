package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import View.NhanView;

public class ControllerKey implements KeyListener {
	NhanView view;

	public ControllerKey(NhanView view) {
		this.view = view;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10) {
			this.view.outputString();
		} else if (e.getKeyCode() == 27) {
			this.view.xoaForm();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
