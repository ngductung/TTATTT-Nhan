package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.NhanController;
import Model.NhanModel;

import java.awt.GridLayout;
import java.util.Iterator;
import java.util.stream.Stream;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class NhanView extends JFrame {

	public NhanModel model = new NhanModel();

	private JPanel contentPane;
	private JTextField inputP;
	private JTextField inputW;
	private JTextField inputA;
	private JTextField inputB;
	private JTextField outputResult;
	private JButton calculateButton;

	/**
	 * Create the frame.
	 */
	public NhanView() {
		setTitle("Nhân");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		NhanController controller = new NhanController(this);
		setBounds(100, 100, 807, 435);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		inputP = new JTextField();
		inputP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		inputP.setBounds(116, 49, 226, 26);
		contentPane.add(inputP);
		inputP.setColumns(10);

		JLabel lblNewLabel = new JLabel("p = ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(61, 48, 59, 29);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("w = ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setBounds(408, 52, 55, 20);
		contentPane.add(lblNewLabel_1);

		inputW = new JTextField();
		inputW.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		inputW.setColumns(10);
		inputW.setBounds(473, 49, 226, 26);
		contentPane.add(inputW);

		inputA = new JTextField();
		inputA.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		inputA.setColumns(10);
		inputA.setBounds(116, 122, 226, 26);
		contentPane.add(inputA);

		JLabel lblA = new JLabel("a = ");
		lblA.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblA.setBackground(new Color(240, 240, 240));
		lblA.setBounds(61, 122, 46, 23);
		contentPane.add(lblA);

		inputB = new JTextField();
		inputB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		inputB.setColumns(10);
		inputB.setBounds(473, 122, 226, 26);
		contentPane.add(inputB);

		JLabel lblB = new JLabel("b = ");
		lblB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblB.setBackground(new Color(240, 240, 240));
		lblB.setBounds(408, 123, 46, 24);
		contentPane.add(lblB);

		outputResult = new JTextField();
		outputResult.setForeground(new Color(21, 21, 21));
		outputResult.setFont(new Font("Times New Roman", Font.BOLD, 30));
		outputResult.setBounds(61, 205, 373, 127);
		contentPane.add(outputResult);
		outputResult.setHorizontalAlignment(SwingConstants.CENTER);

		calculateButton = new JButton("Tính");
		calculateButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		calculateButton.setBounds(553, 243, 124, 50);
		contentPane.add(calculateButton);
		
		JButton btnNewButton = new JButton("Format");
		btnNewButton.setBounds(692, 362, 89, 23);
		contentPane.add(btnNewButton);
		calculateButton.addActionListener(controller);
		btnNewButton.addActionListener(controller);
	}

	public void xoaForm() {
		inputA.setText("");
		inputB.setText("");
		inputP.setText("");
		inputW.setText("");
		outputResult.setText("");
	}

	public int[] processStringArrayInput(String s) { // return Array
		String[] z = s.split(", ");
		int[] array = Stream.of(z).mapToInt(Integer::parseInt).toArray();
		return array;
	}

	public boolean checkValueInput() {
		boolean checkP = inputP.getText().equals("");
		boolean checkW = inputW.getText().equals("");
		boolean checkA = inputA.getText().equals("");
		boolean checkB = inputB.getText().equals("");
		if (checkP && checkA && checkB && checkW) {
			JOptionPane.showMessageDialog(this, "Hãy nhập các giá trị", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (checkP) {
			JOptionPane.showMessageDialog(this, "Hãy nhập p", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (checkA) {
			JOptionPane.showMessageDialog(this, "Hãy nhập a", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (checkB) {
			JOptionPane.showMessageDialog(this, "Hãy nhập b", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (checkW) {
			JOptionPane.showMessageDialog(this, "Hãy nhập w", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;


	}

	public void outputString() {

		if (checkValueInput()) {
			try {
				double p = Double.parseDouble(inputP.getText());
				int w = Integer.parseInt(inputW.getText());
				int[] a = processStringArrayInput(inputA.getText());
				int[] b = processStringArrayInput(inputB.getText());
				model.setA(a);
				model.setB(b);
				model.setP(p);
				model.setW(w);

				String result = model.getString();
				outputResult.setText(result);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Lỗi tính toán", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
		}

	}
}
