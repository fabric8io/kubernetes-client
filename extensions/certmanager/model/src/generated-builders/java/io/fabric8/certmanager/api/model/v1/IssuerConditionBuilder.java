package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IssuerConditionBuilder extends IssuerConditionFluent<IssuerConditionBuilder> implements VisitableBuilder<IssuerCondition,IssuerConditionBuilder>{

  IssuerConditionFluent<?> fluent;

  public IssuerConditionBuilder() {
    this(new IssuerCondition());
  }
  
  public IssuerConditionBuilder(IssuerConditionFluent<?> fluent) {
    this(fluent, new IssuerCondition());
  }
  
  public IssuerConditionBuilder(IssuerCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IssuerConditionBuilder(IssuerConditionFluent<?> fluent,IssuerCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IssuerCondition build() {
    IssuerCondition buildable = new IssuerCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getObservedGeneration(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}