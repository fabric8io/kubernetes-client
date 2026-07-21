package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReceiveSpecBuilder extends ReceiveSpecFluent<ReceiveSpecBuilder> implements VisitableBuilder<ReceiveSpec,ReceiveSpecBuilder>{

  ReceiveSpecFluent<?> fluent;

  public ReceiveSpecBuilder() {
    this(new ReceiveSpec());
  }
  
  public ReceiveSpecBuilder(ReceiveSpecFluent<?> fluent) {
    this(fluent, new ReceiveSpec());
  }
  
  public ReceiveSpecBuilder(ReceiveSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReceiveSpecBuilder(ReceiveSpecFluent<?> fluent,ReceiveSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReceiveSpec build() {
    ReceiveSpec buildable = new ReceiveSpec(fluent.buildContainers(), fluent.getReplicas(), fluent.buildResources(), fluent.getServiceAccountAnnotations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}