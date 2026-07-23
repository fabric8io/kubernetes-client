package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetadataServiceOptionsBuilder extends MetadataServiceOptionsFluent<MetadataServiceOptionsBuilder> implements VisitableBuilder<MetadataServiceOptions,MetadataServiceOptionsBuilder>{

  MetadataServiceOptionsFluent<?> fluent;

  public MetadataServiceOptionsBuilder() {
    this(new MetadataServiceOptions());
  }
  
  public MetadataServiceOptionsBuilder(MetadataServiceOptionsFluent<?> fluent) {
    this(fluent, new MetadataServiceOptions());
  }
  
  public MetadataServiceOptionsBuilder(MetadataServiceOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetadataServiceOptionsBuilder(MetadataServiceOptionsFluent<?> fluent,MetadataServiceOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetadataServiceOptions build() {
    MetadataServiceOptions buildable = new MetadataServiceOptions(fluent.getAuthentication());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}