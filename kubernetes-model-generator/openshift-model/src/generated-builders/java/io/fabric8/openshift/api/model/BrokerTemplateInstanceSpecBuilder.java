package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BrokerTemplateInstanceSpecBuilder extends BrokerTemplateInstanceSpecFluent<BrokerTemplateInstanceSpecBuilder> implements VisitableBuilder<BrokerTemplateInstanceSpec,BrokerTemplateInstanceSpecBuilder>{

  BrokerTemplateInstanceSpecFluent<?> fluent;

  public BrokerTemplateInstanceSpecBuilder() {
    this(new BrokerTemplateInstanceSpec());
  }
  
  public BrokerTemplateInstanceSpecBuilder(BrokerTemplateInstanceSpecFluent<?> fluent) {
    this(fluent, new BrokerTemplateInstanceSpec());
  }
  
  public BrokerTemplateInstanceSpecBuilder(BrokerTemplateInstanceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BrokerTemplateInstanceSpecBuilder(BrokerTemplateInstanceSpecFluent<?> fluent,BrokerTemplateInstanceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BrokerTemplateInstanceSpec build() {
    BrokerTemplateInstanceSpec buildable = new BrokerTemplateInstanceSpec(fluent.getBindingIDs(), fluent.buildSecret(), fluent.buildTemplateInstance());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}