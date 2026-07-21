package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HubTemplateOptionsBuilder extends HubTemplateOptionsFluent<HubTemplateOptionsBuilder> implements VisitableBuilder<HubTemplateOptions,HubTemplateOptionsBuilder>{

  HubTemplateOptionsFluent<?> fluent;

  public HubTemplateOptionsBuilder() {
    this(new HubTemplateOptions());
  }
  
  public HubTemplateOptionsBuilder(HubTemplateOptionsFluent<?> fluent) {
    this(fluent, new HubTemplateOptions());
  }
  
  public HubTemplateOptionsBuilder(HubTemplateOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HubTemplateOptionsBuilder(HubTemplateOptionsFluent<?> fluent,HubTemplateOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HubTemplateOptions build() {
    HubTemplateOptions buildable = new HubTemplateOptions(fluent.getServiceAccountName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}