package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatementEntryBuilder extends StatementEntryFluent<StatementEntryBuilder> implements VisitableBuilder<StatementEntry,StatementEntryBuilder>{

  StatementEntryFluent<?> fluent;

  public StatementEntryBuilder() {
    this(new StatementEntry());
  }
  
  public StatementEntryBuilder(StatementEntryFluent<?> fluent) {
    this(fluent, new StatementEntry());
  }
  
  public StatementEntryBuilder(StatementEntry instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatementEntryBuilder(StatementEntryFluent<?> fluent,StatementEntry instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatementEntry build() {
    StatementEntry buildable = new StatementEntry(fluent.getAction(), fluent.getEffect(), fluent.getPolicyCondition(), fluent.getResource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}