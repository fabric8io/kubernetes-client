package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSResourceTagBuilder extends AWSResourceTagFluent<AWSResourceTagBuilder> implements VisitableBuilder<AWSResourceTag,AWSResourceTagBuilder>{

  AWSResourceTagFluent<?> fluent;

  public AWSResourceTagBuilder() {
    this(new AWSResourceTag());
  }
  
  public AWSResourceTagBuilder(AWSResourceTagFluent<?> fluent) {
    this(fluent, new AWSResourceTag());
  }
  
  public AWSResourceTagBuilder(AWSResourceTag instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSResourceTagBuilder(AWSResourceTagFluent<?> fluent,AWSResourceTag instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSResourceTag build() {
    AWSResourceTag buildable = new AWSResourceTag(fluent.getKey(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}