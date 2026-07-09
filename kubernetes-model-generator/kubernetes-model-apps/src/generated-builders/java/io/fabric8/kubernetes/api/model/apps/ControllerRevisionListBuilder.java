package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ControllerRevisionListBuilder extends ControllerRevisionListFluent<ControllerRevisionListBuilder> implements VisitableBuilder<ControllerRevisionList,ControllerRevisionListBuilder>{

  ControllerRevisionListFluent<?> fluent;

  public ControllerRevisionListBuilder() {
    this(new ControllerRevisionList());
  }
  
  public ControllerRevisionListBuilder(ControllerRevisionListFluent<?> fluent) {
    this(fluent, new ControllerRevisionList());
  }
  
  public ControllerRevisionListBuilder(ControllerRevisionList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ControllerRevisionListBuilder(ControllerRevisionListFluent<?> fluent,ControllerRevisionList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ControllerRevisionList build() {
    ControllerRevisionList buildable = new ControllerRevisionList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}