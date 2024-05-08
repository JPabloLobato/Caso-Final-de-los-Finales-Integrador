package Ejercicio_5;

import java.util.ArrayList;

public class UserAccount {
    private String alias;
    private String email;
    private final ArrayList<Tweet> tweets;
    private final ArrayList<UserAccount> followers;
    private final ArrayList<UserAccount> following;

    public UserAccount(String alias, String email) {
        if (!Utils.isValidAlias(alias)) {
            throw new IllegalArgumentException("El alias debe contener solo números y letras");
        }
        if (!Utils.isValidEmail(email)) {
            throw new IllegalArgumentException("El email no es válido");
        }
        this.alias = alias;
        this.email = email;
        this.tweets = new ArrayList<Tweet>();
        this.followers = new ArrayList<UserAccount>();
        this.following = new ArrayList<UserAccount>();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        if (!Utils.isValidAlias(alias)) {
            throw new IllegalArgumentException("El alias debe contener solo números y letras.");
        }
        this.alias = alias;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!Utils.isValidEmail(email)) {
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