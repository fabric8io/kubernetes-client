package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IdentityListBuilder extends IdentityListFluent<IdentityListBuilder> implements VisitableBuilder<IdentityList,IdentityListBuilder>{

  IdentityListFluent<?> fluent;

  public IdentityListBuilder() {
    this(new IdentityList());
  }
  
  public IdentityListBuilder(IdentityListFluent<?> fluent) {
    this(fluent, new IdentityList());
  }
  
  public IdentityListBuilder(IdentityList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IdentityListBuilder(IdentityListFluent<?> fluent,IdentityList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IdentityList build() {
    IdentityList buildable = new IdentityList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}