package Test;

import java.awt.EventQueue;
import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import Model.NhanModel;
import View.NhanView;

public class test {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanView frame = new NhanView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
