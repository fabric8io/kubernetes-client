package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CertInfoBuilder extends CertInfoFluent<CertInfoBuilder> implements VisitableBuilder<CertInfo,CertInfoBuilder>{

  CertInfoFluent<?> fluent;

  public CertInfoBuilder() {
    this(new CertInfo());
  }
  
  public CertInfoBuilder(CertInfoFluent<?> fluent) {
    this(fluent, new CertInfo());
  }
  
  public CertInfoBuilder(CertInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CertInfoBuilder(CertInfoFluent<?> fluent,CertInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CertInfo build() {
    CertInfo buildable = new CertInfo(fluent.getCertFile(), fluent.getKeyFile());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}