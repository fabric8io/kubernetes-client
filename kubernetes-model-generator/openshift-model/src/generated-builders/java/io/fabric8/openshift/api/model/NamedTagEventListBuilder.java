package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedTagEventListBuilder extends NamedTagEventListFluent<NamedTagEventListBuilder> implements VisitableBuilder<NamedTagEventList,NamedTagEventListBuilder>{

  NamedTagEventListFluent<?> fluent;

  public NamedTagEventListBuilder() {
    this(new NamedTagEventList());
  }
  
  public NamedTagEventListBuilder(NamedTagEventListFluent<?> fluent) {
    this(fluent, new NamedTagEventList());
  }
  
  public NamedTagEventListBuilder(NamedTagEventList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedTagEventListBuilder(NamedTagEventListFluent<?> fluent,NamedTagEventList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedTagEventList build() {
    NamedTagEventList buildable = new NamedTagEventList(fluent.buildConditions(), fluent.buildItems(), fluent.getTag());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}