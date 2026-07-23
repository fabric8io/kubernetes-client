package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceConstraintBuilder extends DeviceConstraintFluent<DeviceConstraintBuilder> implements VisitableBuilder<DeviceConstraint,DeviceConstraintBuilder>{

  DeviceConstraintFluent<?> fluent;

  public DeviceConstraintBuilder() {
    this(new DeviceConstraint());
  }
  
  public DeviceConstraintBuilder(DeviceConstraintFluent<?> fluent) {
    this(fluent, new DeviceConstraint());
  }
  
  public DeviceConstraintBuilder(DeviceConstraint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceConstraintBuilder(DeviceConstraintFluent<?> fluent,DeviceConstraint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceConstraint build() {
    DeviceConstraint buildable = new DeviceConstraint(fluent.getDistinctAttribute(), fluent.getMatchAttribute(), fluent.getRequests());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}