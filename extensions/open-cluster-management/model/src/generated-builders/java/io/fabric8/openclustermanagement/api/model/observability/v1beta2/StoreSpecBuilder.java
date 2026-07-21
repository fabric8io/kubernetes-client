package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StoreSpecBuilder extends StoreSpecFluent<StoreSpecBuilder> implements VisitableBuilder<StoreSpec,StoreSpecBuilder>{

  StoreSpecFluent<?> fluent;

  public StoreSpecBuilder() {
    this(new StoreSpec());
  }
  
  public StoreSpecBuilder(StoreSpecFluent<?> fluent) {
    this(fluent, new StoreSpec());
  }
  
  public StoreSpecBuilder(StoreSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StoreSpecBuilder(StoreSpecFluent<?> fluent,StoreSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StoreSpec build() {
    StoreSpec buildable = new StoreSpec(fluent.buildContainers(), fluent.getReplicas(), fluent.buildResources(), fluent.getServiceAccountAnnotations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}