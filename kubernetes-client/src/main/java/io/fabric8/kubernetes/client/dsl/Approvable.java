package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequest;

public interface Approvable <T>{

  public CertificateSigningRequest approve(T client, String csrName);
}
