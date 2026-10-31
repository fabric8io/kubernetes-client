package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReceiveDebugSpecBuilder extends ReceiveDebugSpecFluent<ReceiveDebugSpecBuilder> implements VisitableBuilder<ReceiveDebugSpec,ReceiveDebugSpecBuilder>{

  ReceiveDebugSpecFluent<?> fluent;

  public ReceiveDebugSpecBuilder() {
    this(new ReceiveDebugSpec());
  }
  
  public ReceiveDebugSpecBuilder(ReceiveDebugSpecFluent<?> fluent) {
    this(fluent, new ReceiveDebugSpec());
  }
  
  public ReceiveDebugSpecBuilder(ReceiveDebugSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReceiveDebugSpecBuilder(ReceiveDebugSpecFluent<?> fluent,ReceiveDebugSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReceiveDebugSpec build() {
    ReceiveDebugSpec buildable = new ReceiveDebugSpec(fluent.getLogLevel());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}