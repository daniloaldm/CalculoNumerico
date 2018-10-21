
public class PontoFixo {

	public static void main(String[] args) {
		System.out.println("Opções de x inicial para a iteração"); // Achar um x0 dentro do intervalo do for
		double inicio = 1;
		double fim = 2;
		double salto = 0.1;
		
		for(double k = inicio; k < fim; k += salto) {
			double resultado = derivadaFI(k);
			if(Math.abs(resultado)<1) {
				System.out.println(k + " - " + resultado);
			}
		}
		
		
		System.out.println("\nIterações do Ponto Fixo:"); // Resultados (Irá convergir ou Divergir)
		int ciclos = 20;
		double x0 = 1.5;
		pontoFixo(x0, ciclos);
		
		
		System.out.println("\n\nResultados Específicos"); // Somente se quiser saber um dado valor
		System.out.println("FI: " + FI(0.2));
		System.out.println("Derivada de FI: " + derivadaFI(0.2) + "\n\n");
		
	}
	
	/*
	 * Math.sin(x)
	 * Math.cos(x)
	 * 
	 * Math.sqrt(x)
	 * Math.pow(x, x)
	 * Math.abs(resultado)
	 * 
	 * Math.E
	 * Math.PI
	 * 
	 * */
	
	static double FI(double x) { // Fórmula FI(x) obtida da f(x)
		double res = Math.pow(x, 2) - 3*x + 3;
		return res;
	}
	
	static double derivadaFI(double x) { // Derivada de FI(x)
		double res =  2*x - 3;
		return res;
	}
	
	static void pontoFixo(double x, int ciclos) {
		for(float k = 0; k < ciclos; k++) {
			System.out.println(FI(x));
			x = FI(x);
		}
	}
	
}

