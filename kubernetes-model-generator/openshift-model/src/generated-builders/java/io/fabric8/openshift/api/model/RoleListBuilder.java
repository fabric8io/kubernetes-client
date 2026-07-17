package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RoleListBuilder extends RoleListFluent<RoleListBuilder> implements VisitableBuilder<RoleList,RoleListBuilder>{

  RoleListFluent<?> fluent;

  public RoleListBuilder() {
    this(new RoleList());
  }
  
  public RoleListBuilder(RoleListFluent<?> fluent) {
    this(fluent, new RoleList());
  }
  
  public RoleListBuilder(RoleList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RoleListBuilder(RoleListFluent<?> fluent,RoleList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RoleList build() {
    RoleList buildable = new RoleList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}