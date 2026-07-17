package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSResourceReferenceBuilder extends AWSResourceReferenceFluent<AWSResourceReferenceBuilder> implements VisitableBuilder<AWSResourceReference,AWSResourceReferenceBuilder>{

  AWSResourceReferenceFluent<?> fluent;

  public AWSResourceReferenceBuilder() {
    this(new AWSResourceReference());
  }
  
  public AWSResourceReferenceBuilder(AWSResourceReferenceFluent<?> fluent) {
    this(fluent, new AWSResourceReference());
  }
  
  public AWSResourceReferenceBuilder(AWSResourceReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSResourceReferenceBuilder(AWSResourceReferenceFluent<?> fluent,AWSResourceReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSResourceReference build() {
    AWSResourceReference buildable = new AWSResourceReference(fluent.getArn(), fluent.buildFilters(), fluent.getId());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}