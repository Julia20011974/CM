package lab_7;

public class Main {
	private double A[][] = { { -0.58, -0.32, 0.03, 0 }, 
			{ 0.11, -1.26, -0.36, 0 }, 
			{ 0.12, 0.08, -1.14, -0.24 },
			{ 0.15, -0.35, -0.18, -1 } };
	private double F[] = { -0.44, -1.42, 0.83, 1.42 };
	private double E = 0.001;
	private double X[] = new double[A.length];

	void calculation() {
		for (int i = 0; i < A.length; i++) {
			X[i] = F[i] / A[i][i];
		}
		int k = 0;
		double max = E + 1;
		double Xn[] = new double[X.length];
		while (max > E) {
			for (int i = 0; i < A.length; i++) {
				double sum = 0;
				for (int j = 0; j < A.length; j++) {
					if (j != i) {
						sum -= A[i][j] * (X[j]) / A[i][i];
					}
				}
				Xn[i] = sum + F[i] / A[i][i];
			}

			// первая норма
			max = Math.abs(Xn[0] - X[0]);
			for (int i = 1; i < A.length; i++) {
				if (Math.abs(Xn[i] - X[i]) > max) {
					max = Math.abs(Xn[i] - X[i]);
				}
			}
			System.out.println("Итерация " + k);
			outputX();
			System.out.println();

			if (max < E) {
				System.out.println("Ответ: ");
				outputX();
				System.exit(1);
			}

			for (int i = 0; i < X.length; i++) {
				X[i] = Xn[i];
			}
			k++;
		}
	}
	private void outputX() 
	{
		for (int i = 0; i < X.length; i++) {
			System.out.println("X" + (i + 1) + ": " + Math.round(X[i] * 1000.0) / 1000.0);
		}
		
	}
	public static void main(String[] args) {
		Main obj = new Main();
		obj.calculation();
	}

}
