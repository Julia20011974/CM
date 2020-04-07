package lab5;

public class Main {
	private double[][] A = { { 3.23, 1.62, 0.65 }, { 1.62, -2.33, -0.43 }, { 0.65, -0.43, 2.16 } };
	private double[] F = { 1.28, 0.87, -2.87 };
	double X[];

	void squareRoot() {
		int N = A.length;
		double[][] S = new double[N][N];
		double[][] D = new double[N][N];
		// S11
		S[0][0] = Math.sqrt(Math.abs(A[0][0]));
		System.out.println("S[0][0] корень из A[0][0] = " + Math.round(S[0][0] * 1000.0) / 1000.0 + " ");
		D[0][0] = Math.signum(A[0][0]);
		// S1j
		for (int j = 1; j < N; j++) {
			S[0][j] = A[0][j] / (S[0][0] * D[0][0]);
			System.out.println("S[0][" + j + "] = " + Math.round(S[0][j] * 1000.0) / 1000.0 + " ");
		}
		// Sij, Sii
		double sum;
		for (int i = 1; i < N; i++) {
			sum = 0;
			for (int k = 0; k <= i - 1; k++) {
				sum += Math.pow(S[k][i], 2) * D[k][k];
			}
			S[i][i] = Math.sqrt(Math.abs(A[i][i] - sum));
			System.out.println("S[" + i + "][" + i + "] = " + Math.round(S[i][i] * 1000.0) / 1000.0);
			D[i][i] = Math.signum(A[i][i] - sum);
			for (int j = i + 1; j < N; j++) {
				sum = 0;
				for (int k = 0; k <= i - 1; k++) {
					sum += S[k][i] * S[k][j] * D[k][k];
				}
				S[i][j] = (A[i][j] - sum) / (S[i][i] * D[i][i]);
				System.out.println("S[" + i + "][" + j + "] = " + Math.round(S[i][j] * 1000.0) / 1000.0);

			}
		}
		System.out.println();
		outputArray(S);
		System.out.println('\n');

		outputArray(D);
		System.out.println();

		// Y
		double Y[] = new double[F.length];
		Y[0] = F[0] / (S[0][0] * D[0][0]);
		for (int i = 1; i < Y.length; i++) {
			sum = 0;
			for (int j = 0; j <= i - 1; j++) {
				sum += S[j][i] * Y[j] * D[j][j];
			}
			Y[i] = (F[i] - sum) / (S[i][i] * D[i][i]);
		}
		for (int i = 0; i < N; i++) {
			System.out.println("Y" + (i + 1) + ": " + (Math.round(Y[i] * 1000.0) / 1000.0));
		}
		System.out.println();
		// X
		double X[] = new double[N];
		X[N - 1] = Y[N - 1] / S[N - 1][N - 1];
		for (int i = N - 2; i >= 0; i--) {
			sum = 0;
			for (int j = i + 1; j < N; j++) {
				sum += S[i][j] * X[j];
			}
			X[i] = (Y[i] - sum) / S[i][i];
		}
		for (int i = 0; i < N; i++) {
			System.out.println("X" + (i + 1) + ": " + (Math.round(X[i] * 1000.0) / 1000.0));
		}

	}

	void outputArray(double[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				System.out.print(Math.round(array[i][j] * 1000.0) / 1000.0 + "  ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		Main obj = new Main();
		obj.squareRoot();
	}
}
