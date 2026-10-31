package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CompositePodGroupListBuilder extends CompositePodGroupListFluent<CompositePodGroupListBuilder> implements VisitableBuilder<CompositePodGroupList,CompositePodGroupListBuilder>{

  CompositePodGroupListFluent<?> fluent;

  public CompositePodGroupListBuilder() {
    this(new CompositePodGroupList());
  }
  
  public CompositePodGroupListBuilder(CompositePodGroupListFluent<?> fluent) {
    this(fluent, new CompositePodGroupList());
  }
  
  public CompositePodGroupListBuilder(CompositePodGroupList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CompositePodGroupListBuilder(CompositePodGroupListFluent<?> fluent,CompositePodGroupList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CompositePodGroupList build() {
    CompositePodGroupList buildable = new CompositePodGroupList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}