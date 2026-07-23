package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RecordBuilder extends RecordFluent<RecordBuilder> implements VisitableBuilder<Record,RecordBuilder>{

  RecordFluent<?> fluent;

  public RecordBuilder() {
    this(new Record());
  }
  
  public RecordBuilder(RecordFluent<?> fluent) {
    this(fluent, new Record());
  }
  
  public RecordBuilder(Record instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RecordBuilder(RecordFluent<?> fluent,Record instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Record build() {
    Record buildable = new Record(fluent.buildEvents(), fluent.getId(), fluent.getInjectedCount(), fluent.getPhase(), fluent.getRecoveredCount(), fluent.getSelectorKey());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}