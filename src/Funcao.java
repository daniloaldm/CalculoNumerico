
public class Funcao {

	public static void main(String[] args) {
		
		double x = 5;

		System.out.println("Resultado de f(" + x + ") = " + funcao(x));
		
		intervaloRaiz(-30, 30);
	}
	
	static double funcao(double x) { //Fun��o que gera os resultados
		return Math.pow(x, 3) - 5*Math.pow(x, 2) + 1.75*x + 6;
	}
	
	static void intervaloRaiz(int x0, int x1) { //Fun��o que gera os resultados
		int a = x0;
		int b = a + 1;
		System.out.println("\nIntervalos com raiz:");
		while( b < x1 ) {
			if((funcao(a)<0 && funcao(b)>0) || (funcao(a)>0 && funcao(b)<0)) {
				System.out.println("a: " + a + " e b: " + b);
				System.out.println("f(a): " + funcao(a) + " e f(b): " + funcao(b));
				System.out.println();
			}
			a++;
			b++;
		}
		
	}
}
