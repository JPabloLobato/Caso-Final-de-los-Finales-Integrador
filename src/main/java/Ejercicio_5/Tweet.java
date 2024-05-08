package Ejercicio_5;

/* 1. ¿Deberá modificar los atributos timeline y tweets de la clase UserAccount (definida en el
ejercicio 1) para que contenga elementos de la clase hija Retweet? Justifique su
razonamiento y, si cree que hay que modificarlos, explique también cómo lo haría.
2. ¿Deberá modificar el método tweet(Tweet tweet1) de la clase UserAccount (definida en el
ejercicio 1) para que pueda enviar también objetos de tipo Retweet? Justifique su
razonamiento y, si cree que hay que modificarlo, explique también cómo lo haría.

Respuesta 1: No es necesario modificar los atributos 'timeline' y 'tweets' de la clase UserAccount
para qeu contengan los elementos de la clase Retweet. Esto es debido a que 'Retweet' es una
subclase de 'Tweet' o como dice el enunciado una hija, ya que 'Retweet' hereda de 'Tweet' y por
ende, un objeto de tipo 'Retweet' es un objeto de tipo 'Tweet'. Por lo tanto, no es necesario.

Respuesta 2: No es necesario modificar el método 'tweet(Tweet tweet1)' de la clase UserAccount para
que pueda enviar objetos de tipo 'Retweet'. Ya que como menciono en la respuesta anterior, 'Retweets'
es una subclase de 'Tweet' y por ende, un objeto de tipo 'Retweet' es un objeto de tipo 'Tweet'. Por
lo tanto tampoco es necesario.
*/

import java.time.LocalDate;

public class Tweet {
    private LocalDate time;
    private String message;
    private UserAccount sender;

    public Tweet(LocalDate time, String message, UserAccount sender) {
        if (message.length() > 140) {
            throw new IllegalArgumentException("El mensaje no puede tener más de 140 caracteres");
        }
        this.time = time;
        this.message = message;
        this.sender = sender;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (message.length() > 140) {
            throw new IllegalArgumentException("El mensaje no puede tener más de 140 caracteres");
        }
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }
}
