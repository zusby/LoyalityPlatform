package it.unicam.cs.IDS.Authentication;
@FunctionalInterface
public interface Auth <T>{
    public void auth(T t);
}
