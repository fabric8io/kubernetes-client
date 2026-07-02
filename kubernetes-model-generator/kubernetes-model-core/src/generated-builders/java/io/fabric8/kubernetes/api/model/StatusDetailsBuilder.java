package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatusDetailsBuilder extends StatusDetailsFluent<StatusDetailsBuilder> implements VisitableBuilder<StatusDetails,StatusDetailsBuilder>{

  StatusDetailsFluent<?> fluent;

  public StatusDetailsBuilder() {
    this(new StatusDetails());
  }
  
  public StatusDetailsBuilder(StatusDetailsFluent<?> fluent) {
    this(fluent, new StatusDetails());
  }
  
  public StatusDetailsBuilder(StatusDetails instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatusDetailsBuilder(StatusDetailsFluent<?> fluent,StatusDetails instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatusDetails build() {
    StatusDetails buildable = new StatusDetails(fluent.buildCauses(), fluent.getGroup(), fluent.getKind(), fluent.getName(), fluent.getRetryAfterSeconds(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}