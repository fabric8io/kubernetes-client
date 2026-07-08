package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PersistentVolumeClaimTemplateBuilder extends PersistentVolumeClaimTemplateFluent<PersistentVolumeClaimTemplateBuilder> implements VisitableBuilder<PersistentVolumeClaimTemplate,PersistentVolumeClaimTemplateBuilder>{

  PersistentVolumeClaimTemplateFluent<?> fluent;

  public PersistentVolumeClaimTemplateBuilder() {
    this(new PersistentVolumeClaimTemplate());
  }
  
  public PersistentVolumeClaimTemplateBuilder(PersistentVolumeClaimTemplateFluent<?> fluent) {
    this(fluent, new PersistentVolumeClaimTemplate());
  }
  
  public PersistentVolumeClaimTemplateBuilder(PersistentVolumeClaimTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PersistentVolumeClaimTemplateBuilder(PersistentVolumeClaimTemplateFluent<?> fluent,PersistentVolumeClaimTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PersistentVolumeClaimTemplate build() {
    PersistentVolumeClaimTemplate buildable = new PersistentVolumeClaimTemplate(fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}