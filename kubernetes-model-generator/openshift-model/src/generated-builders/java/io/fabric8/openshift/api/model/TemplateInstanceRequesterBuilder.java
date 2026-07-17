package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TemplateInstanceRequesterBuilder extends TemplateInstanceRequesterFluent<TemplateInstanceRequesterBuilder> implements VisitableBuilder<TemplateInstanceRequester,TemplateInstanceRequesterBuilder>{

  TemplateInstanceRequesterFluent<?> fluent;

  public TemplateInstanceRequesterBuilder() {
    this(new TemplateInstanceRequester());
  }
  
  public TemplateInstanceRequesterBuilder(TemplateInstanceRequesterFluent<?> fluent) {
    this(fluent, new TemplateInstanceRequester());
  }
  
  public TemplateInstanceRequesterBuilder(TemplateInstanceRequester instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TemplateInstanceRequesterBuilder(TemplateInstanceRequesterFluent<?> fluent,TemplateInstanceRequester instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TemplateInstanceRequester build() {
    TemplateInstanceRequester buildable = new TemplateInstanceRequester(fluent.getExtra(), fluent.getGroups(), fluent.getUid(), fluent.getUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}