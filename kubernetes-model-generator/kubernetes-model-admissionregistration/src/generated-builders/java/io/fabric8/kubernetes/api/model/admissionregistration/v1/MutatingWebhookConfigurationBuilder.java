package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MutatingWebhookConfigurationBuilder extends MutatingWebhookConfigurationFluent<MutatingWebhookConfigurationBuilder> implements VisitableBuilder<MutatingWebhookConfiguration,MutatingWebhookConfigurationBuilder>{

  MutatingWebhookConfigurationFluent<?> fluent;

  public MutatingWebhookConfigurationBuilder() {
    this(new MutatingWebhookConfiguration());
  }
  
  public MutatingWebhookConfigurationBuilder(MutatingWebhookConfigurationFluent<?> fluent) {
    this(fluent, new MutatingWebhookConfiguration());
  }
  
  public MutatingWebhookConfigurationBuilder(MutatingWebhookConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MutatingWebhookConfigurationBuilder(MutatingWebhookConfigurationFluent<?> fluent,MutatingWebhookConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MutatingWebhookConfiguration build() {
    MutatingWebhookConfiguration buildable = new MutatingWebhookConfiguration(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildWebhooks());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}