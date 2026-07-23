package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlibabaResourceReferenceBuilder extends AlibabaResourceReferenceFluent<AlibabaResourceReferenceBuilder> implements VisitableBuilder<AlibabaResourceReference,AlibabaResourceReferenceBuilder>{

  AlibabaResourceReferenceFluent<?> fluent;

  public AlibabaResourceReferenceBuilder() {
    this(new AlibabaResourceReference());
  }
  
  public AlibabaResourceReferenceBuilder(AlibabaResourceReferenceFluent<?> fluent) {
    this(fluent, new AlibabaResourceReference());
  }
  
  public AlibabaResourceReferenceBuilder(AlibabaResourceReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlibabaResourceReferenceBuilder(AlibabaResourceReferenceFluent<?> fluent,AlibabaResourceReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlibabaResourceReference build() {
    AlibabaResourceReference buildable = new AlibabaResourceReference(fluent.getId(), fluent.getName(), fluent.buildTags(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}