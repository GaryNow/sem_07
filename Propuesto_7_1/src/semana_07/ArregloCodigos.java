package semana_07;

public class ArregloCodigos {
	// Atributo privado
	private int codigo[];
	private int indice;
	// Constructor
	public ArregloCodigos() {
		codigo = new int[10];
		indice = 0;
	}
	// Método tamaño que retorne la cantidad de datos ingresados hasta ese momento
	public int tamanio() {
		return indice;
	}
	// Método que reciba una posición y retorne el código registrado en dicha posición
	public int obtener(int i) {
		return codigo[i];
	}
	// Método privado que extienda el arreglo en diez espacios más.
	public void ampliarArreglo() {
		int[] aux = codigo;
		codigo = new int[indice + 10];
		for (int i=0; i<indice; i++) {			
			codigo[i] = aux[i];
		}
	}
	// Método que reciba un código y lo registre en la posición que corresponda. Verifique primero si el arreglo está lleno para invocar al método ampliarArreglo
	public void adicionar(int x) {
		if(indice == codigo.length)	ampliarArreglo();
		codigo[indice] = x;
		indice++;
	}
	// Método que cambie de lugar al segundo y penúltimo código del arreglo
	public void intercambiarSegPen() {
		int segundo = codigo[1];
		codigo[1] = codigo[tamanio() - 2];
		codigo[tamanio() - 2] = segundo;
	}
	// Método que retire el primer código del arreglo
	public void eliminarPrimero() {
		for(int i = 1; i < tamanio(); i++) {
			codigo[i] = codigo[i + 1];
		}
		indice--;
	}
	
	// Método que retorne la posición del último código que se encuentre en el rango de 1000 a 1111. En caso no exista retorne -1
	public int posCodigo() {
		for(int i = tamanio() - 1; i >= 0; i--) {
			if(codigo[i] >= 1000 && codigo[i] <= 1111)	return i;
		}
		return -1;
	}
	// Método que cambie de lugar al último código que se encuentre en el rango de 1000 a 1111 con el tercer código del arreglo
	public void intercambiarCodigo() {
		int ult = -1;
		for(int i = tamanio() - 1; i >= 0; i--) {
			if(codigo[i] >= 1000 && codigo[i] <= 1111) {
				ult = i;
				break;
			}
		}
		codigo[ult] = codigo[2];
	}
	// Método que retire del arreglo al último código que se encuentre en el rango de 1000 a 1111.
	public void eliminarCodigo() {
		int ult = -1;
		for(int i = tamanio() - 1; i >= 0; i--) {
			if(codigo[i] >= 1000 && codigo[i] <= 1111) {
				ult = i;
				break;
			}
		}
		for(int i = ult; i < tamanio(); i++) {
			codigo[i] = codigo[i + 1];
		}
		indice--;	
	}
}
