package lab_8;

public class Main {
	double e = 0.001;
	double A[][] = { { 9.1, 3.6, 4.8 }, 
			{ 2.8, 6.1, 2.8 }, 
			{ 0.9, 1.2, 5.7 } };
	double F[] = { 9.8, 6.7, 5.8 };
	double[] x = new double[3];
	double[] x1 = new double[3];
	double[] old = new double[3];
	double[][] B = new double[3][3];
	double[] g = new double[3];

	void calculation() {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) 
					B[i][j] = 0;
				else if (i != j) {
					B[i][j] = -A[i][j] / A[i][i];
					System.out.println("B[" + i + "][" + j + "] = " + Math.round(B[i][j] * 1000.0) / 1000.0);

				}
			}
			System.out.println();

			g[i] = F[i] / A[i][i];
		}

		System.out.println("Вектор начального приближения g:");
		for (int i = 0; i < 3; i++)
			System.out.println("g[" + i + "] = " + Math.round(g[i] * 1000.0) / 1000.0);
		
		System.out.println();

		for (int i = 0; i < 3; i++) 
			x[i] = g[i];
		

		boolean exit = true;
		do {
			for (int i = 0; i < 3; i++) 
				old[i] = x[i];
			

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) 
					x1[i] += B[i][j] * x[j];
				
				x1[i] += g[i];
				x[i] = x1[i];
			}

			double r = Math.abs(x1[0] - old[0]);
			for (int i = 0; i < 3; i++) {
				double k = Math.abs(x1[i] - old[i]);
				if (k > r)
					r = k;
			}

			if (r <= e) {
				exit = false;
			} else {

				for (int i = 0; i < 3; i++) 
					x[i] = x1[i];

				for (int i = 0; i < 3; i++) 
					x1[i] = 0;
			}

			System.out.println("Итерация " + count);
			for (int i = 0; i < 3; i++)
				System.out.println(Math.round(x[i] * 1000.0) / 1000.0);
			count++;

		} while (exit);

		for (int i = 0; i < 3; i++)
			System.out.println("x[" + i + "] = " +Math.round(x1[i] * 1000.0) / 1000.0 );

		System.out.println();
	}

	public static void main(String[] args) {
		Main obj = new Main();
		obj.calculation();
	}

}
