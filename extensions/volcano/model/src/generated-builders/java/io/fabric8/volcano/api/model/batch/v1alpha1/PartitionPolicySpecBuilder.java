package io.fabric8.volcano.api.model.batch.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PartitionPolicySpecBuilder extends PartitionPolicySpecFluent<PartitionPolicySpecBuilder> implements VisitableBuilder<PartitionPolicySpec,PartitionPolicySpecBuilder>{

  PartitionPolicySpecFluent<?> fluent;

  public PartitionPolicySpecBuilder() {
    this(new PartitionPolicySpec());
  }
  
  public PartitionPolicySpecBuilder(PartitionPolicySpecFluent<?> fluent) {
    this(fluent, new PartitionPolicySpec());
  }
  
  public PartitionPolicySpecBuilder(PartitionPolicySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PartitionPolicySpecBuilder(PartitionPolicySpecFluent<?> fluent,PartitionPolicySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PartitionPolicySpec build() {
    PartitionPolicySpec buildable = new PartitionPolicySpec(fluent.getMinPartitions(), fluent.buildNetworkTopology(), fluent.getPartitionSize(), fluent.getTotalPartitions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}