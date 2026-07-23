package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PKIBuilder extends PKIFluent<PKIBuilder> implements VisitableBuilder<PKI,PKIBuilder>{

  PKIFluent<?> fluent;

  public PKIBuilder() {
    this(new PKI());
  }
  
  public PKIBuilder(PKIFluent<?> fluent) {
    this(fluent, new PKI());
  }
  
  public PKIBuilder(PKI instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PKIBuilder(PKIFluent<?> fluent,PKI instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PKI build() {
    PKI buildable = new PKI(fluent.getCaIntermediatesData(), fluent.getCaRootsData(), fluent.buildPkiCertificateSubject());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}