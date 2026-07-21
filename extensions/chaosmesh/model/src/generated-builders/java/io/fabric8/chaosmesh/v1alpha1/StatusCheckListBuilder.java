package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatusCheckListBuilder extends StatusCheckListFluent<StatusCheckListBuilder> implements VisitableBuilder<StatusCheckList,StatusCheckListBuilder>{

  StatusCheckListFluent<?> fluent;

  public StatusCheckListBuilder() {
    this(new StatusCheckList());
  }
  
  public StatusCheckListBuilder(StatusCheckListFluent<?> fluent) {
    this(fluent, new StatusCheckList());
  }
  
  public StatusCheckListBuilder(StatusCheckList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatusCheckListBuilder(StatusCheckListFluent<?> fluent,StatusCheckList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatusCheckList build() {
    StatusCheckList buildable = new StatusCheckList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}