package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RecordEventBuilder extends RecordEventFluent<RecordEventBuilder> implements VisitableBuilder<RecordEvent,RecordEventBuilder>{

  RecordEventFluent<?> fluent;

  public RecordEventBuilder() {
    this(new RecordEvent());
  }
  
  public RecordEventBuilder(RecordEventFluent<?> fluent) {
    this(fluent, new RecordEvent());
  }
  
  public RecordEventBuilder(RecordEvent instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RecordEventBuilder(RecordEventFluent<?> fluent,RecordEvent instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RecordEvent build() {
    RecordEvent buildable = new RecordEvent(fluent.getMessage(), fluent.getOperation(), fluent.getTimestamp(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}