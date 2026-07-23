package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MyOperatorResourceStatusBuilder extends MyOperatorResourceStatusFluent<MyOperatorResourceStatusBuilder> implements VisitableBuilder<MyOperatorResourceStatus,MyOperatorResourceStatusBuilder>{

  MyOperatorResourceStatusFluent<?> fluent;

  public MyOperatorResourceStatusBuilder() {
    this(new MyOperatorResourceStatus());
  }
  
  public MyOperatorResourceStatusBuilder(MyOperatorResourceStatusFluent<?> fluent) {
    this(fluent, new MyOperatorResourceStatus());
  }
  
  public MyOperatorResourceStatusBuilder(MyOperatorResourceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MyOperatorResourceStatusBuilder(MyOperatorResourceStatusFluent<?> fluent,MyOperatorResourceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MyOperatorResourceStatus build() {
    MyOperatorResourceStatus buildable = new MyOperatorResourceStatus(fluent.buildConditions(), fluent.buildGenerations(), fluent.getLatestAvailableRevision(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}