package io.fabric8.kubernetes.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostPortRangeBuilder extends HostPortRangeFluent<HostPortRangeBuilder> implements VisitableBuilder<HostPortRange,HostPortRangeBuilder>{

  HostPortRangeFluent<?> fluent;

  public HostPortRangeBuilder() {
    this(new HostPortRange());
  }
  
  public HostPortRangeBuilder(HostPortRangeFluent<?> fluent) {
    this(fluent, new HostPortRange());
  }
  
  public HostPortRangeBuilder(HostPortRange instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostPortRangeBuilder(HostPortRangeFluent<?> fluent,HostPortRange instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostPortRange build() {
    HostPortRange buildable = new HostPortRange(fluent.getMax(), fluent.getMin());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}