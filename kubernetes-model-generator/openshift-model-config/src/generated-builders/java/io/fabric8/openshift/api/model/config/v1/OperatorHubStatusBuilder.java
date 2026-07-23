package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorHubStatusBuilder extends OperatorHubStatusFluent<OperatorHubStatusBuilder> implements VisitableBuilder<OperatorHubStatus,OperatorHubStatusBuilder>{

  OperatorHubStatusFluent<?> fluent;

  public OperatorHubStatusBuilder() {
    this(new OperatorHubStatus());
  }
  
  public OperatorHubStatusBuilder(OperatorHubStatusFluent<?> fluent) {
    this(fluent, new OperatorHubStatus());
  }
  
  public OperatorHubStatusBuilder(OperatorHubStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorHubStatusBuilder(OperatorHubStatusFluent<?> fluent,OperatorHubStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorHubStatus build() {
    OperatorHubStatus buildable = new OperatorHubStatus(fluent.buildSources());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}