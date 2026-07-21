package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EmbeddedTaskBuilder extends EmbeddedTaskFluent<EmbeddedTaskBuilder> implements VisitableBuilder<EmbeddedTask,EmbeddedTaskBuilder>{

  EmbeddedTaskFluent<?> fluent;

  public EmbeddedTaskBuilder() {
    this(new EmbeddedTask());
  }
  
  public EmbeddedTaskBuilder(EmbeddedTaskFluent<?> fluent) {
    this(fluent, new EmbeddedTask());
  }
  
  public EmbeddedTaskBuilder(EmbeddedTask instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EmbeddedTaskBuilder(EmbeddedTaskFluent<?> fluent,EmbeddedTask instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EmbeddedTask build() {
    EmbeddedTask buildable = new EmbeddedTask(fluent.getApiVersion(), fluent.getDescription(), fluent.getDisplayName(), fluent.getKind(), fluent.buildMetadata(), fluent.buildParams(), fluent.buildResources(), fluent.buildResults(), fluent.buildSidecars(), fluent.getSpec(), fluent.buildStepTemplate(), fluent.buildSteps(), fluent.buildVolumes(), fluent.buildWorkspaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}