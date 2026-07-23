package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BrokerTemplateInstanceBuilder extends BrokerTemplateInstanceFluent<BrokerTemplateInstanceBuilder> implements VisitableBuilder<BrokerTemplateInstance,BrokerTemplateInstanceBuilder>{

  BrokerTemplateInstanceFluent<?> fluent;

  public BrokerTemplateInstanceBuilder() {
    this(new BrokerTemplateInstance());
  }
  
  public BrokerTemplateInstanceBuilder(BrokerTemplateInstanceFluent<?> fluent) {
    this(fluent, new BrokerTemplateInstance());
  }
  
  public BrokerTemplateInstanceBuilder(BrokerTemplateInstance instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BrokerTemplateInstanceBuilder(BrokerTemplateInstanceFluent<?> fluent,BrokerTemplateInstance instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BrokerTemplateInstance build() {
    BrokerTemplateInstance buildable = new BrokerTemplateInstance(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}