package ran;

public class createFood {
	static int m = 25;
	static int n = 25;
	static int maxXY = 100;
	private static int a[][] = new int[maxXY][maxXY];
    private static int xFood; // Define xFood as a field
    private static int yFood; // Define yFood as a field

    public createFood(int m, int n, int[][] a) {
        this.m = m;
        this.n = n;
        this.a = a;
    }

    // ăn
    public static void creatFood() {
        int k = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (a[i][j] == 0)
                    k++;
        int h = (int) ((k - 1) * Math.random() + 1);
        k = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (a[i][j] == 0) {
                    k++;
                    if (k == h) {
                        xFood = i;
                        yFood = j;
                        a[i][j] = 3;
                        return;
                    }
                }
    }
}
