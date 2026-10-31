package io.fabric8.kubernetes.api.model.resource.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PartitionTypeStatusBuilder extends PartitionTypeStatusFluent<PartitionTypeStatusBuilder> implements VisitableBuilder<PartitionTypeStatus,PartitionTypeStatusBuilder>{

  PartitionTypeStatusFluent<?> fluent;

  public PartitionTypeStatusBuilder() {
    this(new PartitionTypeStatus());
  }
  
  public PartitionTypeStatusBuilder(PartitionTypeStatusFluent<?> fluent) {
    this(fluent, new PartitionTypeStatus());
  }
  
  public PartitionTypeStatusBuilder(PartitionTypeStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PartitionTypeStatusBuilder(PartitionTypeStatusFluent<?> fluent,PartitionTypeStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PartitionTypeStatus build() {
    PartitionTypeStatus buildable = new PartitionTypeStatus(fluent.getAllocatable(), fluent.getAttribute(), fluent.getTotal(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}