package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LastOperationBuilder extends LastOperationFluent<LastOperationBuilder> implements VisitableBuilder<LastOperation,LastOperationBuilder>{

  LastOperationFluent<?> fluent;

  public LastOperationBuilder() {
    this(new LastOperation());
  }
  
  public LastOperationBuilder(LastOperationFluent<?> fluent) {
    this(fluent, new LastOperation());
  }
  
  public LastOperationBuilder(LastOperation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LastOperationBuilder(LastOperationFluent<?> fluent,LastOperation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LastOperation build() {
    LastOperation buildable = new LastOperation(fluent.getDescription(), fluent.getLastUpdated(), fluent.getState(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}