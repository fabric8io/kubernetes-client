package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodCertificateProjectionBuilder extends PodCertificateProjectionFluent<PodCertificateProjectionBuilder> implements VisitableBuilder<PodCertificateProjection,PodCertificateProjectionBuilder>{

  PodCertificateProjectionFluent<?> fluent;

  public PodCertificateProjectionBuilder() {
    this(new PodCertificateProjection());
  }
  
  public PodCertificateProjectionBuilder(PodCertificateProjectionFluent<?> fluent) {
    this(fluent, new PodCertificateProjection());
  }
  
  public PodCertificateProjectionBuilder(PodCertificateProjection instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodCertificateProjectionBuilder(PodCertificateProjectionFluent<?> fluent,PodCertificateProjection instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodCertificateProjection build() {
    PodCertificateProjection buildable = new PodCertificateProjection(fluent.getCertificateChainPath(), fluent.getCredentialBundlePath(), fluent.getKeyPath(), fluent.getKeyType(), fluent.getMaxExpirationSeconds(), fluent.getSignerName(), fluent.getUserAnnotations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}