package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlibabaCloudResourceTagBuilder extends AlibabaCloudResourceTagFluent<AlibabaCloudResourceTagBuilder> implements VisitableBuilder<AlibabaCloudResourceTag,AlibabaCloudResourceTagBuilder>{

  AlibabaCloudResourceTagFluent<?> fluent;

  public AlibabaCloudResourceTagBuilder() {
    this(new AlibabaCloudResourceTag());
  }
  
  public AlibabaCloudResourceTagBuilder(AlibabaCloudResourceTagFluent<?> fluent) {
    this(fluent, new AlibabaCloudResourceTag());
  }
  
  public AlibabaCloudResourceTagBuilder(AlibabaCloudResourceTag instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlibabaCloudResourceTagBuilder(AlibabaCloudResourceTagFluent<?> fluent,AlibabaCloudResourceTag instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlibabaCloudResourceTag build() {
    AlibabaCloudResourceTag buildable = new AlibabaCloudResourceTag(fluent.getKey(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}