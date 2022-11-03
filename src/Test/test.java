package Test;

import java.awt.EventQueue;
import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

import Model.NhanModel;
import View.NhanView;

public class test {
	private static double log2_10 = 3.321928095;

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
//		int[] a = {1,2,3,4,5};
//		String s = Arrays.toString(a);
//		System.out.println(s);

	}
}
