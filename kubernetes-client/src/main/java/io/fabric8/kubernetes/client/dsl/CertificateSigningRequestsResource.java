package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequest;
import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestList;
import io.fabric8.kubernetes.client.LocalPortForward;
import io.fabric8.kubernetes.client.PortForward;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public interface CertificateSigningRequestsResource<T> extends Approvable<T>, Resource<CertificateSigningRequest> {
}
