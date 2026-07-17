package io.fabric8.openshift.api.model.operatorhub.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OLMConfigStatusBuilder extends OLMConfigStatusFluent<OLMConfigStatusBuilder> implements VisitableBuilder<OLMConfigStatus,OLMConfigStatusBuilder>{

  OLMConfigStatusFluent<?> fluent;

  public OLMConfigStatusBuilder() {
    this(new OLMConfigStatus());
  }
  
  public OLMConfigStatusBuilder(OLMConfigStatusFluent<?> fluent) {
    this(fluent, new OLMConfigStatus());
  }
  
  public OLMConfigStatusBuilder(OLMConfigStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OLMConfigStatusBuilder(OLMConfigStatusFluent<?> fluent,OLMConfigStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OLMConfigStatus build() {
    OLMConfigStatus buildable = new OLMConfigStatus(fluent.getConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}