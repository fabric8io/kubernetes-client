package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TagSpecificationBuilder extends TagSpecificationFluent<TagSpecificationBuilder> implements VisitableBuilder<TagSpecification,TagSpecificationBuilder>{

  TagSpecificationFluent<?> fluent;

  public TagSpecificationBuilder() {
    this(new TagSpecification());
  }
  
  public TagSpecificationBuilder(TagSpecificationFluent<?> fluent) {
    this(fluent, new TagSpecification());
  }
  
  public TagSpecificationBuilder(TagSpecification instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TagSpecificationBuilder(TagSpecificationFluent<?> fluent,TagSpecification instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TagSpecification build() {
    TagSpecification buildable = new TagSpecification(fluent.getName(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}