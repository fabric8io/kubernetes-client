package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.base.Status;

public class KubernetesClientException extends Exception {

    private int code;
    private Status status;

    public KubernetesClientException(String message) {
        super(message);
    }

    public KubernetesClientException(String message, Throwable t) {
        super(message, t);
    }

    public KubernetesClientException(String message, int code, Status status) {
        super(message);
        this.code = code;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }
}
