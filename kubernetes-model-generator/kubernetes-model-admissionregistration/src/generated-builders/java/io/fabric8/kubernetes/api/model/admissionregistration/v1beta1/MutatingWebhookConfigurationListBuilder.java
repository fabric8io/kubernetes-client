package io.fabric8.kubernetes.api.model.admissionregistration.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MutatingWebhookConfigurationListBuilder extends MutatingWebhookConfigurationListFluent<MutatingWebhookConfigurationListBuilder> implements VisitableBuilder<MutatingWebhookConfigurationList,MutatingWebhookConfigurationListBuilder>{

  MutatingWebhookConfigurationListFluent<?> fluent;

  public MutatingWebhookConfigurationListBuilder() {
    this(new MutatingWebhookConfigurationList());
  }
  
  public MutatingWebhookConfigurationListBuilder(MutatingWebhookConfigurationListFluent<?> fluent) {
    this(fluent, new MutatingWebhookConfigurationList());
  }
  
  public MutatingWebhookConfigurationListBuilder(MutatingWebhookConfigurationList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MutatingWebhookConfigurationListBuilder(MutatingWebhookConfigurationListFluent<?> fluent,MutatingWebhookConfigurationList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MutatingWebhookConfigurationList build() {
    MutatingWebhookConfigurationList buildable = new MutatingWebhookConfigurationList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}