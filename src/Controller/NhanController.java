package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.NhanView;

public class NhanController implements ActionListener{
	private NhanView view;

	public NhanController(NhanView view) {
		this.view = view;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equalsIgnoreCase("Tính")) {
			this.view.outputString();
		} else if (actionCommand.equalsIgnoreCase("format")) {
				this.view.xoaForm();
			}
		
	}
	
	
}
