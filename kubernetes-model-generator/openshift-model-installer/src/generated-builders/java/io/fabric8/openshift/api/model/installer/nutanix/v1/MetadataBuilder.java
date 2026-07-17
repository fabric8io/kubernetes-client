package io.fabric8.openshift.api.model.installer.nutanix.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetadataBuilder extends MetadataFluent<MetadataBuilder> implements VisitableBuilder<Metadata,MetadataBuilder>{

  MetadataFluent<?> fluent;

  public MetadataBuilder() {
    this(new Metadata());
  }
  
  public MetadataBuilder(MetadataFluent<?> fluent) {
    this(fluent, new Metadata());
  }
  
  public MetadataBuilder(Metadata instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetadataBuilder(MetadataFluent<?> fluent,Metadata instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metadata build() {
    Metadata buildable = new Metadata(fluent.getPassword(), fluent.getPort(), fluent.getPrismCentral(), fluent.getUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}