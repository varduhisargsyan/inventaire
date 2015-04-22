package org.sp.librairie.inventaire.util;

/**
 * Created by varduhi on 2/20/2015.
 */
public enum STATUS {
    ADD("add"), PENDING("En attente"), SEEN("Vu"), AVAILABLE("Disponible");

    private String statusCode;

    private STATUS(String statusCode) {
       this.statusCode=statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }
}
