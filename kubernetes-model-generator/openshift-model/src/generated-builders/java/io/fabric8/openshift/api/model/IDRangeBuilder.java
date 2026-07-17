package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IDRangeBuilder extends IDRangeFluent<IDRangeBuilder> implements VisitableBuilder<IDRange,IDRangeBuilder>{

  IDRangeFluent<?> fluent;

  public IDRangeBuilder() {
    this(new IDRange());
  }
  
  public IDRangeBuilder(IDRangeFluent<?> fluent) {
    this(fluent, new IDRange());
  }
  
  public IDRangeBuilder(IDRange instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IDRangeBuilder(IDRangeFluent<?> fluent,IDRange instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IDRange build() {
    IDRange buildable = new IDRange(fluent.getMax(), fluent.getMin());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}