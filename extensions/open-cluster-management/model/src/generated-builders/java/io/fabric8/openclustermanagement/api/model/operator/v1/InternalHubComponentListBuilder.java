package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InternalHubComponentListBuilder extends InternalHubComponentListFluent<InternalHubComponentListBuilder> implements VisitableBuilder<InternalHubComponentList,InternalHubComponentListBuilder>{

  InternalHubComponentListFluent<?> fluent;

  public InternalHubComponentListBuilder() {
    this(new InternalHubComponentList());
  }
  
  public InternalHubComponentListBuilder(InternalHubComponentListFluent<?> fluent) {
    this(fluent, new InternalHubComponentList());
  }
  
  public InternalHubComponentListBuilder(InternalHubComponentList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InternalHubComponentListBuilder(InternalHubComponentListFluent<?> fluent,InternalHubComponentList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InternalHubComponentList build() {
    InternalHubComponentList buildable = new InternalHubComponentList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}