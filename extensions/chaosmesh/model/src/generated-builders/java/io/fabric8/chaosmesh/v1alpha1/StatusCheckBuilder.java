package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatusCheckBuilder extends StatusCheckFluent<StatusCheckBuilder> implements VisitableBuilder<StatusCheck,StatusCheckBuilder>{

  StatusCheckFluent<?> fluent;

  public StatusCheckBuilder() {
    this(new StatusCheck());
  }
  
  public StatusCheckBuilder(StatusCheckFluent<?> fluent) {
    this(fluent, new StatusCheck());
  }
  
  public StatusCheckBuilder(StatusCheck instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatusCheckBuilder(StatusCheckFluent<?> fluent,StatusCheck instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatusCheck build() {
    StatusCheck buildable = new StatusCheck(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}