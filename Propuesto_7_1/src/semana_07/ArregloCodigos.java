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
	// M�todo tama�o que retorne la cantidad de datos ingresados hasta ese momento
	public int tamanio() {
		return indice;
	}
	// M�todo que reciba una posici�n y retorne el c�digo registrado en dicha posici�n
	public int obtener(int i) {
		return codigo[i];
	}
	// M�todo privado que extienda el arreglo en diez espacios m�s.
	public void ampliarArreglo() {
		int[] aux = codigo;
		codigo = new int[indice + 10];
		for (int i=0; i<indice; i++) {			
			codigo[i] = aux[i];
		}
	}
	// M�todo que reciba un c�digo y lo registre en la posici�n que corresponda. Verifique primero si el arreglo est� lleno para invocar al m�todo ampliarArreglo
	public void adicionar(int x) {
		if(indice == codigo.length)	ampliarArreglo();
		codigo[indice] = x;
		indice++;
	}
	// M�todo que cambie de lugar al segundo y pen�ltimo c�digo del arreglo
	public void intercambiarSegPen() {
		int segundo = codigo[1];
		codigo[1] = codigo[tamanio() - 2];
		codigo[tamanio() - 2] = segundo;
	}
	// M�todo que retire el primer c�digo del arreglo
	public void eliminarPrimero() {
		for(int i = 1; i < tamanio(); i++) {
			codigo[i] = codigo[i + 1];
		}
		indice--;
	}
	
	// M�todo que retorne la posici�n del �ltimo c�digo que se encuentre en el rango de 1000 a 1111. En caso no exista retorne -1
	public int posCodigo() {
		for(int i = tamanio() - 1; i >= 0; i--) {
			if(codigo[i] >= 1000 && codigo[i] <= 1111)	return i;
		}
		return -1;
	}
	// M�todo que cambie de lugar al �ltimo c�digo que se encuentre en el rango de 1000 a 1111 con el tercer c�digo del arreglo
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
	// M�todo que retire del arreglo al �ltimo c�digo que se encuentre en el rango de 1000 a 1111.
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
