package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetadataConfigBuilder extends MetadataConfigFluent<MetadataConfigBuilder> implements VisitableBuilder<MetadataConfig,MetadataConfigBuilder>{

  MetadataConfigFluent<?> fluent;

  public MetadataConfigBuilder() {
    this(new MetadataConfig());
  }
  
  public MetadataConfigBuilder(MetadataConfigFluent<?> fluent) {
    this(fluent, new MetadataConfig());
  }
  
  public MetadataConfigBuilder(MetadataConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetadataConfigBuilder(MetadataConfigFluent<?> fluent,MetadataConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetadataConfig build() {
    MetadataConfig buildable = new MetadataConfig(fluent.getMaxSamplesPerSend(), fluent.getSend(), fluent.getSendInterval());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}