/* # Ejercicio 4:
Calcular de forma recursiva la suma de los dígitos de un número siendo un ejemplo el número 102 ->
1 + 0 + 2 = 3. Recuerde que puede realizar los cambios de tipo que crea necesarios para facilitar la
resolución:
¿ Qué t ipo de recursividad se está empleando? ¿ Qué comple jidad computacional
tiene el algoritmo?
    Respuestas preguntas:
    Se necesita implementar una recursividad descendente, ya que se esta dividiendo el número.
    La complejidad computacional de este algoritmo es O(n), ya que se recorre cada dígito (n = nº digitos) del número. */

//Código de la solución.
public class Ejercicio_4 {
    public static int sumaDigitos(int numero) {
        if (numero < 10) {
            return numero;
        } else {
            return (numero % 10) + sumaDigitos(numero / 10);
        }
    }

    public static void main(String[] args) {
        int numero = 102;
        int suma = sumaDigitos(numero);
        System.out.println("La suma de los dígitos de " + numero + " es: " + suma);
    }
}

