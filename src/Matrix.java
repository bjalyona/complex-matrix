public class Matrix {
    int m, n;
    private Complex[][] arr;
    Matrix(){
        m = 0;
        n = 0;
    }
    Matrix(int m, int n){
        this.m = m;
        this.n = n;
        this.arr = new Complex[m][n];
    }
    Matrix(Complex[][] arr){
        this.arr = arr;
        this.m = arr.length;
        this.n = arr[0].length;
    }
    void initM(){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[i][j]= new Complex(Math.round(Math.random() * ((10 - (-10) + 1)) + (-10)), Math.round(Math.random() * ((10 - (-10)) + 1)) + (-10));
            }
        }
    }
    public Complex[][] getArr(){
        return arr;
    }
    void addInM(Matrix matr, Complex k, int i, int j){
        matr.arr[i][j] = k;
    }
    public static Matrix sum(Matrix matr1, Matrix matr2){
        Matrix matr = new Matrix(matr1.m, matr1.n);
        if ((matr1.n == matr2.n) & (matr1.m == matr2.m)){
            for (int i = 0; i < matr1.m; i++){
                for (int j = 0; j < matr1.m; j++){
                    matr.arr[i][j] = Complex.sumC(matr1.arr[i][j], matr2.arr[i][j]);
                }
            }
        }
        return matr;
    }
    public static Matrix multiM(Matrix matr1, Matrix matr2){
        Complex tmp = new Complex(0, 0);
        Matrix matr = new Matrix(matr1.m, matr2.n);
        if (matr1.n == matr2.m){
            for (int i = 0; i < matr1.m; i++){
                for (int j = 0; j < matr2.n; j++){
                    for(int k = 0; k < matr2.m; k++){
                        tmp = Complex.sumC(tmp, Complex.multiC(matr1.arr[i][k], matr2.arr[k][j]));
                    }
                    matr.arr[i][j] = tmp;
                    tmp = new Complex(0, 0);

                }
            }
        }
        return matr;
    }
    public static Matrix transM(Matrix matr) {
        Matrix newmatr = new Matrix(matr.n, matr.m);
        for (int i = 0; i < matr.m; i++) {
            for (int j = 0; j < matr.n; j++) {
                newmatr.arr[i][j] = matr.arr[j][i];
            }
        }
        return newmatr;
    }
    void printM(){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[i][j].printC();
            }
            System.out.println();
        }
    }
    public static Complex detM(Complex[][] arr, int m, int n){
        Complex d = new Complex(0, 0);
        if (n != m){
            return d;
        }
        else if (n == 2){
            d = Complex.difC(Complex.multiC(arr[0][0], arr[1][1]), Complex.multiC(arr[1][0], arr[0][1]));
            return d;
        }
        else{
            Complex k = new Complex(1, 0);
            for(int i = 0; i < m; i ++){
                d = Complex.sumC(d,Complex.multiC(k,Complex.multiC(arr[0][i], detM(newArr(arr, i, m, n), m-1, n-1))));
                k.setA(k.getA()*(-1));

            }
            return d;
        }
    }
    public static Complex[][] newArr(Complex[][] arr, int k, int m, int n){
        Complex[][] newarr = new Complex[m-1][n-1];
        int fm = 1;
        int fn = 0;
        for(int i = 0; i < m-1; i ++){
            for(int j = 0; j < n-1; j++){
                if(fn == k){
                    fn++;
                }
                newarr[i][j] = arr[fm][fn];
                fn++;
            }
            fm++;
            fn = 0;
        }
        return newarr;
    };
}
