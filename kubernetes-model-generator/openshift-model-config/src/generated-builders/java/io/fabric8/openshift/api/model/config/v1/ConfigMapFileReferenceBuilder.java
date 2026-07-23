package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigMapFileReferenceBuilder extends ConfigMapFileReferenceFluent<ConfigMapFileReferenceBuilder> implements VisitableBuilder<ConfigMapFileReference,ConfigMapFileReferenceBuilder>{

  ConfigMapFileReferenceFluent<?> fluent;

  public ConfigMapFileReferenceBuilder() {
    this(new ConfigMapFileReference());
  }
  
  public ConfigMapFileReferenceBuilder(ConfigMapFileReferenceFluent<?> fluent) {
    this(fluent, new ConfigMapFileReference());
  }
  
  public ConfigMapFileReferenceBuilder(ConfigMapFileReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigMapFileReferenceBuilder(ConfigMapFileReferenceFluent<?> fluent,ConfigMapFileReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigMapFileReference build() {
    ConfigMapFileReference buildable = new ConfigMapFileReference(fluent.getKey(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}