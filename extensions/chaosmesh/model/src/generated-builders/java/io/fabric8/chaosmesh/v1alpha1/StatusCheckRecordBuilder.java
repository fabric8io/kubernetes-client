package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatusCheckRecordBuilder extends StatusCheckRecordFluent<StatusCheckRecordBuilder> implements VisitableBuilder<StatusCheckRecord,StatusCheckRecordBuilder>{

  StatusCheckRecordFluent<?> fluent;

  public StatusCheckRecordBuilder() {
    this(new StatusCheckRecord());
  }
  
  public StatusCheckRecordBuilder(StatusCheckRecordFluent<?> fluent) {
    this(fluent, new StatusCheckRecord());
  }
  
  public StatusCheckRecordBuilder(StatusCheckRecord instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatusCheckRecordBuilder(StatusCheckRecordFluent<?> fluent,StatusCheckRecord instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatusCheckRecord build() {
    StatusCheckRecord buildable = new StatusCheckRecord(fluent.getOutcome(), fluent.getStartTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}