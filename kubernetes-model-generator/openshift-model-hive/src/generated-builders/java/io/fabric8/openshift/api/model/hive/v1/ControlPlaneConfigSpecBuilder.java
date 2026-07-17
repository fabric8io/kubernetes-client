package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ControlPlaneConfigSpecBuilder extends ControlPlaneConfigSpecFluent<ControlPlaneConfigSpecBuilder> implements VisitableBuilder<ControlPlaneConfigSpec,ControlPlaneConfigSpecBuilder>{

  ControlPlaneConfigSpecFluent<?> fluent;

  public ControlPlaneConfigSpecBuilder() {
    this(new ControlPlaneConfigSpec());
  }
  
  public ControlPlaneConfigSpecBuilder(ControlPlaneConfigSpecFluent<?> fluent) {
    this(fluent, new ControlPlaneConfigSpec());
  }
  
  public ControlPlaneConfigSpecBuilder(ControlPlaneConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ControlPlaneConfigSpecBuilder(ControlPlaneConfigSpecFluent<?> fluent,ControlPlaneConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ControlPlaneConfigSpec build() {
    ControlPlaneConfigSpec buildable = new ControlPlaneConfigSpec(fluent.getApiServerIPOverride(), fluent.getApiURLOverride(), fluent.buildServingCertificates());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}