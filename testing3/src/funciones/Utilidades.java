package funciones;

/**
 * Clase de utilidades con diversas funciones
 * @author David
 *
 */
public class Utilidades {

	/**
	 * Constante que contiene el número de horas de una joranda normal
	 * {@value}
	 */
	public static final int HORASJORNADA = 38;
	
	/**
	 * Método de la clase que devuelve la representación textual de la nota
	 * pasada como parámetro
	 * @param nota double con la nota a comprobar
	 * @return Una cadena de tipo String con el texto resultante (Suspenso, Bien,
	 * Notable, Sobrasaliente o Matrícula)
	 * @throws ArithmeticException cuando la nota no está entre 0 y 10
	 */
	public String devuelveNota(double nota) {
		String descripcion = "Matrícula";
		
		if (nota<0.0 || nota >10) {
			throw new ArithmeticException("La nota debe estar entre 0.0 y 10");
		} else if (nota<5.0) {
			descripcion="Suspenso";
		} else if (nota <6.5) {
			descripcion = "Bien";
		} else if (nota<8.5) {
			descripcion ="Notable";
		} else if (nota<10) {
			descripcion ="Sobresaliente";
		} else {
			descripcion = "Matrícula";
		}
		return descripcion;
	}
	
	/**
	 * Método que calcula el salario del empleado. Pagando las horas normales (hasta
	 * {@link HORASJORNADA} al precioHoras y las horas restantes a precioExtras)
	 * @param numHoras int número de horas totales de la jornada
	 * @param precioHoras double precio de la hora normal
	 * @param precioExtras double precio de la hora extra
	 * @return double con el salario total
	 * @throws ArithmeticException cuando numHoras, precioHoras o precioExtras son cero
	 *         o negativos
	 */
	public double calculaSalario(int numHoras, double precioHoras, double precioExtras) {
		int extras=0;
		int horas=numHoras;
		if (numHoras<=0 || precioHoras<=0 || precioExtras <= 0 ) {
			throw new ArithmeticException(); 
		}
		if (numHoras>HORASJORNADA) {
			extras = numHoras-HORASJORNADA;
			horas = HORASJORNADA;
		}
		return horas*precioHoras+extras*precioExtras;		
	}
	
	/**
	 * Función que deveuelve el número de divisores del número
	 * pasado cmo parámetro
	 * @param num int número a comprobar
	 * @return int con el número de divisores
	 */
	public int cuentaDivisores(int num) {
		int cuenta=0;
		
		for (int i = 1; i <= num; i++) {
			if (num%i==0) {
				cuenta++;
			}
		}
		return cuenta;
	}
	
	/**
	 * Método que deveulve el menor elemento de un array dado como parámetro, 
	 * por ejemplo un vector [2,3,-1,9] devolvería -1
	 * @param v int [] vector de enteros con los números
	 * @return int con el menor número del vector.
	 */
	public double devuelveMenor(int v[]) {
		double menor=v[0];
		for (int i = 0; i < v.length; i++) {
			if (v[i] < menor) {
				menor=v[i];
			}
		}
		return menor;
	}
	
	/**
	 * Función que ordena los elementos del vector por el método de la burbuja
	 * El vector pasado como parámetro también quedará ordenado.
	 * @param v int [] con los datos del vector
	 * @return int [] con todos los elementos del vector ordenador de menor a mayor
	 */
	public int [] burbuja(int[] v)
    {
      int auxiliar;
      int[] ordenado;
      for(int i = 1; i < v.length; i++)
      {
        for(int j = 0;j < v.length-i;j++)
        {
          if(v[j] > v[j+1])
          {
            auxiliar = v[j];
            v[j] = v[j+1];
            v[j+1] = auxiliar;
          }   
        }
      }
      ordenado = v;
      return ordenado;
    }
}
