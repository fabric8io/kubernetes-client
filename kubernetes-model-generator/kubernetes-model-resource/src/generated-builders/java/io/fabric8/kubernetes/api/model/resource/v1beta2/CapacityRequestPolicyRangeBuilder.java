package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CapacityRequestPolicyRangeBuilder extends CapacityRequestPolicyRangeFluent<CapacityRequestPolicyRangeBuilder> implements VisitableBuilder<CapacityRequestPolicyRange,CapacityRequestPolicyRangeBuilder>{

  CapacityRequestPolicyRangeFluent<?> fluent;

  public CapacityRequestPolicyRangeBuilder() {
    this(new CapacityRequestPolicyRange());
  }
  
  public CapacityRequestPolicyRangeBuilder(CapacityRequestPolicyRangeFluent<?> fluent) {
    this(fluent, new CapacityRequestPolicyRange());
  }
  
  public CapacityRequestPolicyRangeBuilder(CapacityRequestPolicyRange instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CapacityRequestPolicyRangeBuilder(CapacityRequestPolicyRangeFluent<?> fluent,CapacityRequestPolicyRange instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CapacityRequestPolicyRange build() {
    CapacityRequestPolicyRange buildable = new CapacityRequestPolicyRange(fluent.getMax(), fluent.getMin(), fluent.getStep());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}