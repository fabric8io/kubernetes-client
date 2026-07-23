package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ControlPlaneServingCertificateSpecBuilder extends ControlPlaneServingCertificateSpecFluent<ControlPlaneServingCertificateSpecBuilder> implements VisitableBuilder<ControlPlaneServingCertificateSpec,ControlPlaneServingCertificateSpecBuilder>{

  ControlPlaneServingCertificateSpecFluent<?> fluent;

  public ControlPlaneServingCertificateSpecBuilder() {
    this(new ControlPlaneServingCertificateSpec());
  }
  
  public ControlPlaneServingCertificateSpecBuilder(ControlPlaneServingCertificateSpecFluent<?> fluent) {
    this(fluent, new ControlPlaneServingCertificateSpec());
  }
  
  public ControlPlaneServingCertificateSpecBuilder(ControlPlaneServingCertificateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ControlPlaneServingCertificateSpecBuilder(ControlPlaneServingCertificateSpecFluent<?> fluent,ControlPlaneServingCertificateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ControlPlaneServingCertificateSpec build() {
    ControlPlaneServingCertificateSpec buildable = new ControlPlaneServingCertificateSpec(fluent.buildAdditional(), fluent.getDefault());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}