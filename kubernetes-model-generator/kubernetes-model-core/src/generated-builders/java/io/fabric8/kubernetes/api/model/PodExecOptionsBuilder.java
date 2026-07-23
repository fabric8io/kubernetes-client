package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodExecOptionsBuilder extends PodExecOptionsFluent<PodExecOptionsBuilder> implements VisitableBuilder<PodExecOptions,PodExecOptionsBuilder>{

  PodExecOptionsFluent<?> fluent;

  public PodExecOptionsBuilder() {
    this(new PodExecOptions());
  }
  
  public PodExecOptionsBuilder(PodExecOptionsFluent<?> fluent) {
    this(fluent, new PodExecOptions());
  }
  
  public PodExecOptionsBuilder(PodExecOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodExecOptionsBuilder(PodExecOptionsFluent<?> fluent,PodExecOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodExecOptions build() {
    PodExecOptions buildable = new PodExecOptions(fluent.getApiVersion(), fluent.getCommand(), fluent.getContainer(), fluent.getKind(), fluent.getStderr(), fluent.getStdin(), fluent.getStdout(), fluent.getTty());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}