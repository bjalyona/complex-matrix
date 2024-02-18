public class Complex {
    private double a, b;
    Complex(){
    }
    Complex(double a, double b){
        this.a = a;
        this.b = b;
    }
    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }
    public void setA(double a){
        this.a = a;
    }
    public void setB(double b){
        this.b = b;
    }
    void printC(){
        if(b != 0){
            System.out.print(" "+a+" + "+b+"i ");}
        else{
            System.out.print(" "+a+" ");
        }
    }
    public static Complex sumC(Complex c1, Complex c2){
        Complex ans = new Complex();
        ans.a = c1.a + c2.a;
        ans.b = c1.b + c2.b;
        return ans;
    }
    public static Complex difC(Complex c1, Complex c2){
        Complex ans = new Complex();
        ans.a = c1.a - c2.a;
        ans.b = c1.b - c2.b;
        return ans;
    }
    public static Complex multiC(Complex c1, Complex c2){
        Complex ans = new Complex();
        ans.a = c1.a*c2.a - c1.b*c2.b;
        ans.b = c1.a*c2.b + c1.b*c2.a;
        return ans;
    }
}
