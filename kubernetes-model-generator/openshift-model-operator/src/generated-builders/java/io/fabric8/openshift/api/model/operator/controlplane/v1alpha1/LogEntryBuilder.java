package io.fabric8.openshift.api.model.operator.controlplane.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LogEntryBuilder extends LogEntryFluent<LogEntryBuilder> implements VisitableBuilder<LogEntry,LogEntryBuilder>{

  LogEntryFluent<?> fluent;

  public LogEntryBuilder() {
    this(new LogEntry());
  }
  
  public LogEntryBuilder(LogEntryFluent<?> fluent) {
    this(fluent, new LogEntry());
  }
  
  public LogEntryBuilder(LogEntry instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LogEntryBuilder(LogEntryFluent<?> fluent,LogEntry instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LogEntry build() {
    LogEntry buildable = new LogEntry(fluent.getLatency(), fluent.getMessage(), fluent.getReason(), fluent.getSuccess(), fluent.getTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}