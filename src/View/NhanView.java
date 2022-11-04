package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControllerKey;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
		ControllerKey key = new ControllerKey(this);
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
		inputP.addKeyListener(key);

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
		inputW.addKeyListener(key);

		inputA = new JTextField();
		inputA.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (inputA.getText().trim().equalsIgnoreCase("VD: 1, 2, 3, 4, 5")) {
					inputA.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (inputA.getText().trim().equalsIgnoreCase("VD: 1, 2, 3, 4, 5")
						|| inputA.getText().trim().equalsIgnoreCase("")) {
					inputA.setText("VD: 1, 2, 3, 4, 5");
				}
			}
		});
		inputA.setText("VD: 1, 2, 3, 4, 5");
		inputA.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		inputA.setColumns(10);
		inputA.setBounds(116, 122, 226, 26);
		contentPane.add(inputA);
		inputA.addKeyListener(key);

		JLabel lblA = new JLabel("a = ");
		lblA.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblA.setBackground(new Color(240, 240, 240));
		lblA.setBounds(61, 122, 46, 23);
		contentPane.add(lblA);

		inputB = new JTextField();
		inputB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (inputB.getText().trim().equalsIgnoreCase("VD: 1, 2, 3, 4, 5")) {
					inputB.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (inputB.getText().trim().equalsIgnoreCase("VD: 1, 2, 3, 4, 5")
						|| inputB.getText().trim().equalsIgnoreCase("")) {
					inputB.setText("VD: 1, 2, 3, 4, 5");
				}
			}
		});
		inputB.setText("VD: 1, 2, 3, 4, 5");
		inputB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		inputB.setColumns(10);
		inputB.setBounds(473, 122, 226, 26);
		contentPane.add(inputB);
		inputB.addKeyListener(key);

		JLabel lblB = new JLabel("b = ");
		lblB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblB.setBackground(new Color(240, 240, 240));
		lblB.setBounds(408, 123, 46, 24);
		contentPane.add(lblB);

		outputResult = new JTextField();
		outputResult.setText("Kết quả");
		outputResult.setForeground(new Color(21, 21, 21));
		outputResult.setFont(new Font("Times New Roman", Font.BOLD, 30));
		outputResult.setBounds(61, 205, 373, 127);
		contentPane.add(outputResult);
		outputResult.setHorizontalAlignment(SwingConstants.CENTER);
		outputResult.addKeyListener(key);

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
		inputA.setText("VD: 1, 2, 3, 4, 5");
		inputB.setText("VD: 1, 2, 3, 4, 5");
		inputP.setText("");
		inputW.setText("");
		outputResult.setText("Kết quả");
	}

	public int[] processStringArrayInput(String s) { // return Array
		String[] z = s.split(",");
		for (String temp : z) {
			temp = temp.trim();
		}
		for (int i = 0; i < z.length; i++) {
			z[i] = z[i].trim();
		}
		int[] array = Stream.of(z).mapToInt(Integer::parseInt).toArray();
		return array;
	}

	public boolean checkValueInput() {
		boolean checkP = inputP.getText().trim().equals("");
		boolean checkW = inputW.getText().trim().equals("");
		boolean checkA = inputA.getText().trim().equals("") || inputA.getText().trim().equals("VD: 1, 2, 3, 4, 5");
		boolean checkB = inputB.getText().trim().equals("") || inputB.getText().trim().equals("VD: 1, 2, 3, 4, 5");
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
				double p = Double.parseDouble(inputP.getText().trim());
				int w = Integer.parseInt(inputW.getText().trim());
				int[] a = processStringArrayInput(inputA.getText().trim());
				int[] b = processStringArrayInput(inputB.getText().trim());
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
