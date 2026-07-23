package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GenericWebHookEventBuilder extends GenericWebHookEventFluent<GenericWebHookEventBuilder> implements VisitableBuilder<GenericWebHookEvent,GenericWebHookEventBuilder>{

  GenericWebHookEventFluent<?> fluent;

  public GenericWebHookEventBuilder() {
    this(new GenericWebHookEvent());
  }
  
  public GenericWebHookEventBuilder(GenericWebHookEventFluent<?> fluent) {
    this(fluent, new GenericWebHookEvent());
  }
  
  public GenericWebHookEventBuilder(GenericWebHookEvent instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GenericWebHookEventBuilder(GenericWebHookEventFluent<?> fluent,GenericWebHookEvent instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GenericWebHookEvent build() {
    GenericWebHookEvent buildable = new GenericWebHookEvent(fluent.buildDockerStrategyOptions(), fluent.buildEnv(), fluent.buildGit(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}