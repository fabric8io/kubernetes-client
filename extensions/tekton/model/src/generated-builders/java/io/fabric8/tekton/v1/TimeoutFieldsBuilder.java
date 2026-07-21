package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TimeoutFieldsBuilder extends TimeoutFieldsFluent<TimeoutFieldsBuilder> implements VisitableBuilder<TimeoutFields,TimeoutFieldsBuilder>{

  TimeoutFieldsFluent<?> fluent;

  public TimeoutFieldsBuilder() {
    this(new TimeoutFields());
  }
  
  public TimeoutFieldsBuilder(TimeoutFieldsFluent<?> fluent) {
    this(fluent, new TimeoutFields());
  }
  
  public TimeoutFieldsBuilder(TimeoutFields instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TimeoutFieldsBuilder(TimeoutFieldsFluent<?> fluent,TimeoutFields instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TimeoutFields build() {
    TimeoutFields buildable = new TimeoutFields(fluent.getFinally(), fluent.getPipeline(), fluent.getTasks());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}