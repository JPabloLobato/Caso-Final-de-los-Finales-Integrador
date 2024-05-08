package Ejercicio_5;

/* Justifique, brevemente, porqué ha seleccionado cada estructura de datos para los atributos
*
*  Justificación: Se seleccionó un ArrayList para los atributos tweets, followers y following
*  porque permite un acceso rápido a los elementos y es dinámico.
* */

import java.util.ArrayList;

public class UserAccount {
    private String alias;
    private String email;
    private final ArrayList<Tweet> tweets;
    private final ArrayList<UserAccount> followers;
    private final ArrayList<UserAccount> following;

    public UserAccount(String alias, String email) {
        if (!Utils.isInvalidAlias(alias)) {
            throw new IllegalArgumentException("El alias debe contener solo números y letras");
        }
        if (!Utils.isInvalidEmail(email)) {
            throw new IllegalArgumentException("El email no es válido");
        }
        this.alias = alias;
        this.email = email;
        this.tweets = new ArrayList<Tweet>();
        this.followers = new ArrayList<UserAccount>();
        this.following = new ArrayList<UserAccount>();
    }

    public void follow(UserAccount userToFollow) {
        if (this.following.contains(userToFollow)) {
            throw new IllegalArgumentException("Ya estás siguiendo a este usuario");
        }
        this.following.add(userToFollow);
        userToFollow.getFollowers().add(this);
    }

    public void tweet(Tweet tweet) {
        this.tweets.add(tweet);
        for (UserAccount follower : this.followers) {
            follower.getTweets().add(tweet);
        }
    }

    @Override
    public String toString() {
        return "Alias: " + this.alias + ", Email: " + this.email;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        if (!Utils.isInvalidAlias(alias)) {
            throw new IllegalArgumentException("El alias debe contener solo números y letras.");
        }
        this.alias = alias;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!Utils.isInvalidEmail(email)) {
            throw new IllegalArgumentException("El email no es válido.");
        }
        this.email = email;
    }

    public ArrayList<Tweet> getTweets() {
        return tweets;
    }

    public ArrayList<UserAccount> getFollowers() {
        return followers;
    }

    public ArrayList<UserAccount> getFollowing() {
        return following;
    }
}