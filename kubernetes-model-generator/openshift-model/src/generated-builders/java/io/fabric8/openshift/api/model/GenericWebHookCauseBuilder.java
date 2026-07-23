package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GenericWebHookCauseBuilder extends GenericWebHookCauseFluent<GenericWebHookCauseBuilder> implements VisitableBuilder<GenericWebHookCause,GenericWebHookCauseBuilder>{

  GenericWebHookCauseFluent<?> fluent;

  public GenericWebHookCauseBuilder() {
    this(new GenericWebHookCause());
  }
  
  public GenericWebHookCauseBuilder(GenericWebHookCauseFluent<?> fluent) {
    this(fluent, new GenericWebHookCause());
  }
  
  public GenericWebHookCauseBuilder(GenericWebHookCause instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GenericWebHookCauseBuilder(GenericWebHookCauseFluent<?> fluent,GenericWebHookCause instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GenericWebHookCause build() {
    GenericWebHookCause buildable = new GenericWebHookCause(fluent.buildRevision(), fluent.getSecret());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}