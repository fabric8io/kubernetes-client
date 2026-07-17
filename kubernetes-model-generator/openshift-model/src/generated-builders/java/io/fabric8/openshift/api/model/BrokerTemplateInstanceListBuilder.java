package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BrokerTemplateInstanceListBuilder extends BrokerTemplateInstanceListFluent<BrokerTemplateInstanceListBuilder> implements VisitableBuilder<BrokerTemplateInstanceList,BrokerTemplateInstanceListBuilder>{

  BrokerTemplateInstanceListFluent<?> fluent;

  public BrokerTemplateInstanceListBuilder() {
    this(new BrokerTemplateInstanceList());
  }
  
  public BrokerTemplateInstanceListBuilder(BrokerTemplateInstanceListFluent<?> fluent) {
    this(fluent, new BrokerTemplateInstanceList());
  }
  
  public BrokerTemplateInstanceListBuilder(BrokerTemplateInstanceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BrokerTemplateInstanceListBuilder(BrokerTemplateInstanceListFluent<?> fluent,BrokerTemplateInstanceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BrokerTemplateInstanceList build() {
    BrokerTemplateInstanceList buildable = new BrokerTemplateInstanceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}