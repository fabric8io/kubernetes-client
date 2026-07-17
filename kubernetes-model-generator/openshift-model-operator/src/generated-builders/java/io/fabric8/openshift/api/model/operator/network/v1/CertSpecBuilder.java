package io.fabric8.openshift.api.model.operator.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertSpecBuilder extends CertSpecFluent<CertSpecBuilder> implements VisitableBuilder<CertSpec,CertSpecBuilder>{

  CertSpecFluent<?> fluent;

  public CertSpecBuilder() {
    this(new CertSpec());
  }
  
  public CertSpecBuilder(CertSpecFluent<?> fluent) {
    this(fluent, new CertSpec());
  }
  
  public CertSpecBuilder(CertSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertSpecBuilder(CertSpecFluent<?> fluent,CertSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertSpec build() {
    CertSpec buildable = new CertSpec(fluent.getCommonName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}