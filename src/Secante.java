public class Secante {

	public static void main(String[] args) {
		
		System.out.printf("\nM�TODO DA SECANTE\n");
		
		secante(1, 2, 0.01); //AQUI
	}
	
	public static double funcao(double x) {
		return Math.pow(Math.E, -x)-x; //AQUI
	}
	
	public static void secante(double x0, double x1, double erro) {
		int k = 1;
		double newX = 0;
		double erroAtual = 1;
		while(erroAtual > erro) {
			System.out.printf("X%d: Xk-1: %.5f - Xk: %.5f - f(Xk-1): %.5f - f(Xk): %.5f", k, x0, x1, funcao(x0), funcao(x1));
			newX = ( x0*funcao(x1) - x1*funcao(x0) ) / ( funcao(x1) - funcao(x0)  );
			System.out.printf(" - Xk+1: %.5f - ", newX);
			erroAtual = erro(x1, newX);
			x0 = x1;
			x1 = newX;
			k++;
		}
		System.out.println("Converge para: " + newX);
	}
	
	public static double erro(double x1, double newX) { // Erro Relativo
		double erro = Math.abs(newX - x1) / Math.abs(newX);
		System.out.printf("Erro: %.5f\n\n", erro);
		return erro;
	}
}
