package semana_07;

public class ArregloTemperaturas {
	
	//  Atributos privados
	private double[] temperatura;
	private int indice;
	//  Constructor
	public ArregloTemperaturas() {
		temperatura = new double[10];
		indice = 0;
	}
	//  Operaciones públicas básicas
	public int tamanio() {
		return indice;
	}
	public double obtener(int i) {
		return temperatura[i];
	}
	public void adicionar(double numero) {
		if (indice == temperatura.length)
			ampliarArreglo();
		temperatura[indice] = numero;
		indice ++;
	}
	//  Operaciones públicas complementarias
	public void eliminarAlFinal() {
		indice --;
	}
	public void eliminarTodo() {
		indice = 0;
	}
	//  Operaciones privadas
	private void ampliarArreglo() {
		double[] aux = temperatura;
		temperatura = new double[indice + 10];
		for (int i=0; i<indice; i++)
			temperatura[i] = aux[i];
	}
	// Método que retorne el promedio de todas las temperaturas
	public double temperaturaPromedio() {
		double sum = 0;
		for(int i = 0; i < tamanio(); i++) {
			sum += temperatura[i];
		}
		return sum/tamanio();
	}
	// Método que retorne la posición de la primera temperatura febril (temperatura mayor que 37.2 oC). En caso que no exista, retorne el valor -1
	public int posPrimeraTemperaturaFebril() {
		for(int i = 0; i < tamanio(); i++) {
			if(temperatura[i] > 37.2)	return i;
		}
		return -1;
	}
	// Método que retorne la posición de la última temperatura febril (temperatura mayor que 37.2 oC). En caso que no exista, retorne el valor -1.
	public int buscarUltimaTemperaturaFebril() {
		for(int i = tamanio() - 1; i >= 0; i--) {
			if(temperatura[i] > 37.2)	return i;
		}
		return -1;
	}
	// Método que remplace la primera temperatura febril por la última temperatura febril
	public void remplazarPrimeraTemperaturaFebril() {
		temperatura[posPrimeraTemperaturaFebril()] = temperatura[buscarUltimaTemperaturaFebril()];
	}
	// Método que remplace la última temperatura febril por la temperatura promedio
	public void remplazarUltimaTemperaturaFebril() {
		temperatura[buscarUltimaTemperaturaFebril()] = temperaturaPromedio();
	}
	// Método que elimine la primera temperatura febril
	public void eliminarPrimeraTemperaturaFebril() {
		int pos = posPrimeraTemperaturaFebril();
		for(int i = pos; i < tamanio(); i++) {
			temperatura[i] = temperatura[i + 1];
		}
		indice--;
	}
	
}
