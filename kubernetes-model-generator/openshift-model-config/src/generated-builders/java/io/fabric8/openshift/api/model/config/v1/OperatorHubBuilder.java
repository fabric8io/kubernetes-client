package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorHubBuilder extends OperatorHubFluent<OperatorHubBuilder> implements VisitableBuilder<OperatorHub,OperatorHubBuilder>{

  OperatorHubFluent<?> fluent;

  public OperatorHubBuilder() {
    this(new OperatorHub());
  }
  
  public OperatorHubBuilder(OperatorHubFluent<?> fluent) {
    this(fluent, new OperatorHub());
  }
  
  public OperatorHubBuilder(OperatorHub instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorHubBuilder(OperatorHubFluent<?> fluent,OperatorHub instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorHub build() {
    OperatorHub buildable = new OperatorHub(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}