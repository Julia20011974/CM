package lab_6;

public class Runing {
	double A[][] = { { 3.23, 1.62, 0 }, 
			{ 1.62, -2.33, -0.43 }, 
			{ 0, -0.43, 2.16 } };
	double F[] = { 1.27, 0.87, -2.87 };
	int N = A.length;
	double X[] = new double[N];

	double AA[] = new double[N - 1];
	double BB[] = new double[N - 1];

	void runing() {
		AA[0] = (-1) * A[0][1] / A[0][0];
		System.out.println("AA[0] = (-1)*A[0][1] / A[0][0] = " + Math.round(AA[0] * 1000.0) / 1000.0);
		BB[0] = F[0] / A[0][0];
		System.out.println("BB[0] = (-1)*F[0] / A[0][0] = " + Math.round(BB[0] * 1000.0) / 1000.0);
		System.out.println();

		for (int i = 1; i < N - 1; i++) {
			AA[i] = (-1) * A[i][i + 1] / (A[i][i] + A[i][i - 1] * AA[i - 1]);
			System.out.println("AA[" + i + "] = (-1)*A[" + i + "][" + (i + 1) + "] / (A[" + i + "][" + i + "] + A[" + i
					+ "][" + (i + 1) + "] * AA[" + (i - 1) + "] = " + Math.round(AA[i] * 1000.0) / 1000.0);
			BB[i] = (F[i] - A[i][i - 1] * BB[i - 1]) / (A[i][i] + A[i][i - 1] * AA[i - 1]);
			System.out.println("BB[" + i + "] " + Math.round(BB[i] * 1000.0) / 1000.0);
		}
		System.out.println();
	}

	void outputArrayX() {
		X[N - 1] = (F[N - 1] - A[N - 1][N - 2] * BB[N - 2]) / (A[N - 1][N - 1] + A[N - 1][N - 2] * AA[N - 2]);
		for (int i = N - 2; i >= 0; i--) 
			X[i] = AA[i] * X[i + 1] + BB[i];
		
		for (int i = 0; i < N; i++) 
			System.out.println("X" + (i + 1) + ": " + Math.round(X[i] * 1000.0) / 1000.0);
	}

	public static void main(String[] args) {

		Runing obj = new Runing();
		obj.runing();
		obj.outputArrayX();
	}

}
