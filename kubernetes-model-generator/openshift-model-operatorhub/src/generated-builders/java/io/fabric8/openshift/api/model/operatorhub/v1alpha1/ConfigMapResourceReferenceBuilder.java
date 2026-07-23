package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigMapResourceReferenceBuilder extends ConfigMapResourceReferenceFluent<ConfigMapResourceReferenceBuilder> implements VisitableBuilder<ConfigMapResourceReference,ConfigMapResourceReferenceBuilder>{

  ConfigMapResourceReferenceFluent<?> fluent;

  public ConfigMapResourceReferenceBuilder() {
    this(new ConfigMapResourceReference());
  }
  
  public ConfigMapResourceReferenceBuilder(ConfigMapResourceReferenceFluent<?> fluent) {
    this(fluent, new ConfigMapResourceReference());
  }
  
  public ConfigMapResourceReferenceBuilder(ConfigMapResourceReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigMapResourceReferenceBuilder(ConfigMapResourceReferenceFluent<?> fluent,ConfigMapResourceReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigMapResourceReference build() {
    ConfigMapResourceReference buildable = new ConfigMapResourceReference(fluent.getLastUpdateTime(), fluent.getName(), fluent.getNamespace(), fluent.getResourceVersion(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}