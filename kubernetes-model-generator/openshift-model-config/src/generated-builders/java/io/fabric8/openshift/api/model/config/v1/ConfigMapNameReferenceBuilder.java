package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigMapNameReferenceBuilder extends ConfigMapNameReferenceFluent<ConfigMapNameReferenceBuilder> implements VisitableBuilder<ConfigMapNameReference,ConfigMapNameReferenceBuilder>{

  ConfigMapNameReferenceFluent<?> fluent;

  public ConfigMapNameReferenceBuilder() {
    this(new ConfigMapNameReference());
  }
  
  public ConfigMapNameReferenceBuilder(ConfigMapNameReferenceFluent<?> fluent) {
    this(fluent, new ConfigMapNameReference());
  }
  
  public ConfigMapNameReferenceBuilder(ConfigMapNameReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigMapNameReferenceBuilder(ConfigMapNameReferenceFluent<?> fluent,ConfigMapNameReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigMapNameReference build() {
    ConfigMapNameReference buildable = new ConfigMapNameReference(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}