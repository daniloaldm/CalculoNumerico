
import java.util.Scanner;

public class Bissercao {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.printf("\nMÉTODO DA BISSERÇÃO\n");
		
		System.out.printf("\nInserir limite a: ");
		double a0 = in.nextDouble();
		System.out.printf("Inserir limite b: ");
		double b0 = in.nextDouble();
		
		double a = a0;
		double b = b0;
		double xAnterior = 0;
		double x = media(a, b);
		double fx = funcao(x);
		
		System.out.printf("\n(1) - Erro sobre imagem");
		System.out.printf("\n(2) - Erro sobre o domínio (absoluto)");
		System.out.printf("\n(3) - Erro sobre o domínio (relativo)");
		System.out.printf("\nInforme o critério de parada: ");
		int tipo = in.nextInt();
		
		System.out.printf("\nInforme o valor do erro: ");
		double erro = in.nextDouble();
		
		System.out.println();
		
		int k = 0;
		if(verificacaoRaiz(a, b)) {
			while(true) {
				x = media(a, b);
				fx = funcao(x);
				
				System.out.printf("a" + k + ": %.8f - b" + k + ": %.8f - Md" + k + ": %.8f - f(x" + k + "): %.8f - ", a,b,x,fx);
				k++;
				
				// Define a orientação do sinal (maior que ou menor que)
				if(verificaSinal(a0)) {
					if(fx < 0)
						a = x;
					else
						b = x;
				} else {
					if(fx > 0)
						a = x;
					else
						b = x;
				}
				
				if(verificacaoErro(tipo, x, xAnterior, fx, erro))
					break;
				
				xAnterior = x;
			}
		} else {
			System.out.println("Não é um intervalo válido para a função!");
		}
		
		if(k!=0)
			System.out.println("\nA função, no intervalo [" + a0  + ", " + b0 + "],"
				+ " converge para " + x + ", a partir do erro de valor " + erro + ".");
		
		in.close();
		
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
	
	static double funcao(double x) { //Função que gera os resultados
		return (x/(1-x)) * Math.sqrt(7/(2 + x)) - 0.04;
	}
	
	static double media(double x1, double x2) {
		return (x1+x2)/2;
	}
	
	static boolean verificacaoRaiz(double a, double b) { //Verifica se o intervalo tem uma raiz
		double num = funcao(a) * funcao(b);
		if(num < 0)
			return true;
		else
			return false;
	}
	
	static boolean verificaSinal(double a) { //Verifica se o intervalo tem uma raiz
		if(funcao(a) < 0)
			return true;
		else
			return false;
	}
	
	static boolean verificacaoErro(int tipo, double x, double xAnterior, double fx, double erro) {
		switch(tipo) {
			case 1: //Erro sobre a imagem
				double cond;
				cond = Math.abs(fx);
				System.out.printf("Erro: %.8f\n\n", cond);
				if(cond < erro) return true;
				else return false;
				
			case 2: //Erro sobre o dominio (absoluto)
				cond = Math.abs(x - xAnterior);
				System.out.printf("Erro: %.8f\n\n", cond);
				if(cond < erro) return true;
				else return false;
				
			case 3: //Erro sobre o dominio (relativo)
				cond = Math.abs(x - xAnterior) / Math.abs(x);
				System.out.printf("Erro: %.8f\n\n", cond);
				if(cond < erro) return true;
				else return false;
		}
		return false;
	}
}
