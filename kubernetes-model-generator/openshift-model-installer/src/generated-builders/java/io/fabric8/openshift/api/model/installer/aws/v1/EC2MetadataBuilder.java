package io.fabric8.openshift.api.model.installer.aws.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EC2MetadataBuilder extends EC2MetadataFluent<EC2MetadataBuilder> implements VisitableBuilder<EC2Metadata,EC2MetadataBuilder>{

  EC2MetadataFluent<?> fluent;

  public EC2MetadataBuilder() {
    this(new EC2Metadata());
  }
  
  public EC2MetadataBuilder(EC2MetadataFluent<?> fluent) {
    this(fluent, new EC2Metadata());
  }
  
  public EC2MetadataBuilder(EC2Metadata instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EC2MetadataBuilder(EC2MetadataFluent<?> fluent,EC2Metadata instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EC2Metadata build() {
    EC2Metadata buildable = new EC2Metadata(fluent.getAuthentication());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}