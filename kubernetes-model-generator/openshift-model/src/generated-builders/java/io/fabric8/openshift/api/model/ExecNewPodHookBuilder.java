package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExecNewPodHookBuilder extends ExecNewPodHookFluent<ExecNewPodHookBuilder> implements VisitableBuilder<ExecNewPodHook,ExecNewPodHookBuilder>{

  ExecNewPodHookFluent<?> fluent;

  public ExecNewPodHookBuilder() {
    this(new ExecNewPodHook());
  }
  
  public ExecNewPodHookBuilder(ExecNewPodHookFluent<?> fluent) {
    this(fluent, new ExecNewPodHook());
  }
  
  public ExecNewPodHookBuilder(ExecNewPodHook instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExecNewPodHookBuilder(ExecNewPodHookFluent<?> fluent,ExecNewPodHook instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExecNewPodHook build() {
    ExecNewPodHook buildable = new ExecNewPodHook(fluent.getCommand(), fluent.getContainerName(), fluent.buildEnv(), fluent.getVolumes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}