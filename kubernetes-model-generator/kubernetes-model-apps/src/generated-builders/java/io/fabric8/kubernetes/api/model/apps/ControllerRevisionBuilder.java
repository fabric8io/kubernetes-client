package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ControllerRevisionBuilder extends ControllerRevisionFluent<ControllerRevisionBuilder> implements VisitableBuilder<ControllerRevision,ControllerRevisionBuilder>{

  ControllerRevisionFluent<?> fluent;

  public ControllerRevisionBuilder() {
    this(new ControllerRevision());
  }
  
  public ControllerRevisionBuilder(ControllerRevisionFluent<?> fluent) {
    this(fluent, new ControllerRevision());
  }
  
  public ControllerRevisionBuilder(ControllerRevision instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ControllerRevisionBuilder(ControllerRevisionFluent<?> fluent,ControllerRevision instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ControllerRevision build() {
    ControllerRevision buildable = new ControllerRevision(fluent.getApiVersion(), fluent.getData(), fluent.getKind(), fluent.buildMetadata(), fluent.getRevision());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}