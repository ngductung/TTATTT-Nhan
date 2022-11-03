package Model;

import java.util.zip.ZipEntry;

public class NhanModel {
	private static double log2_10 = 3.321928095;

	private double p;
	private int[] a;
	private int[] b;
	private int w;
	private int[] result;

	public NhanModel() {

	}

	public NhanModel(double p, int[] a, int[] b, int w) {
		this.p = p;
		this.a = a;
		this.b = b;
		this.w = w;
	}

	public double getP() {
		return p;
	}

	public void setP(double p) {
		this.p = p;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int[] getA() {
		return a;
	}

	public void setA(int[] a) {
		this.a = a;
	}

	public int[] getB() {
		return b;
	}

	public void setB(int[] b) {
		this.b = b;
	}

	public void setResult() {
		int m = (int) (Math.log10(p) * log2_10);
		int t = (int) Math.ceil(((float) m) / ((float) w));

		int[] c = new int[2 * t];

		for (int i = 0; i < t; i++) {
			c[i] = 0;
		}

		for (int i = 0; i < t; i++) {
			int U = 0;
			int V = 0;
			for (int j = 0; j < t; j++) {
				String resultBin = "";
				int z = c[i + j] + a[t - 1 - i] * b[t - 1 - j] + U;
				String zToBin = Integer.toBinaryString(z);
				if (zToBin.length() < 16) {
					int p = 16 - zToBin.length();
					for (int q = 0; q < p; q++) {
						resultBin += '0';
					}
				}
				resultBin = resultBin.concat(zToBin);
				U = Integer.parseInt(resultBin.substring(0, 8), 2);
				V = Integer.parseInt(resultBin.substring(8, resultBin.length()), 2);
				c[i + j] = V;
			}
			c[i + t] = U;
		}
		this.result = c;
	}

	public int[] getResult() {
		setResult();
		return result;
	}

	public String getString() {
		String l = "";
		int[] result = getResult();
		for (int i = result.length - 1; i >= 0; i--) {
			l += result[i] + ", ";
		}
		l = l.substring(0, l.length() - 2);
		return l;
	}
}
