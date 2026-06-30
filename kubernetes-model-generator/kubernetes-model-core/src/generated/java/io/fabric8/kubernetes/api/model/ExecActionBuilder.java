package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExecActionBuilder extends ExecActionFluent<ExecActionBuilder> implements VisitableBuilder<ExecAction,ExecActionBuilder>{

  ExecActionFluent<?> fluent;

  public ExecActionBuilder() {
    this(new ExecAction());
  }
  
  public ExecActionBuilder(ExecActionFluent<?> fluent) {
    this(fluent, new ExecAction());
  }
  
  public ExecActionBuilder(ExecAction instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExecActionBuilder(ExecActionFluent<?> fluent,ExecAction instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExecAction build() {
    ExecAction buildable = new ExecAction(fluent.getCommand());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}