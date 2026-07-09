package io.fabric8.kubernetes.api.model.resource.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PoolStatusBuilder extends PoolStatusFluent<PoolStatusBuilder> implements VisitableBuilder<PoolStatus,PoolStatusBuilder>{

  PoolStatusFluent<?> fluent;

  public PoolStatusBuilder() {
    this(new PoolStatus());
  }
  
  public PoolStatusBuilder(PoolStatusFluent<?> fluent) {
    this(fluent, new PoolStatus());
  }
  
  public PoolStatusBuilder(PoolStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PoolStatusBuilder(PoolStatusFluent<?> fluent,PoolStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PoolStatus build() {
    PoolStatus buildable = new PoolStatus(fluent.getAllocatedDevices(), fluent.getAvailableDevices(), fluent.getDriver(), fluent.getGeneration(), fluent.getNodeName(), fluent.getPoolName(), fluent.getResourceSliceCount(), fluent.getTotalDevices(), fluent.getUnavailableDevices(), fluent.getValidationError());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}