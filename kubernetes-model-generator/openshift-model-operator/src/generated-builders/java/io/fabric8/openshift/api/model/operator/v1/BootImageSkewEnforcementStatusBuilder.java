package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BootImageSkewEnforcementStatusBuilder extends BootImageSkewEnforcementStatusFluent<BootImageSkewEnforcementStatusBuilder> implements VisitableBuilder<BootImageSkewEnforcementStatus,BootImageSkewEnforcementStatusBuilder>{

  BootImageSkewEnforcementStatusFluent<?> fluent;

  public BootImageSkewEnforcementStatusBuilder() {
    this(new BootImageSkewEnforcementStatus());
  }
  
  public BootImageSkewEnforcementStatusBuilder(BootImageSkewEnforcementStatusFluent<?> fluent) {
    this(fluent, new BootImageSkewEnforcementStatus());
  }
  
  public BootImageSkewEnforcementStatusBuilder(BootImageSkewEnforcementStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BootImageSkewEnforcementStatusBuilder(BootImageSkewEnforcementStatusFluent<?> fluent,BootImageSkewEnforcementStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BootImageSkewEnforcementStatus build() {
    BootImageSkewEnforcementStatus buildable = new BootImageSkewEnforcementStatus(fluent.buildAutomatic(), fluent.buildManual(), fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}