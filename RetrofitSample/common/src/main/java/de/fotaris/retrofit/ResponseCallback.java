package de.fotaris.retrofit;

/**
 * Created by Tobias Feldmann on 12.08.16.
 */
public interface ResponseCallback<S> {

    void success(S response);

    void error();
}
