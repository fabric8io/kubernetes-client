package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TagReferencePolicyBuilder extends TagReferencePolicyFluent<TagReferencePolicyBuilder> implements VisitableBuilder<TagReferencePolicy,TagReferencePolicyBuilder>{

  TagReferencePolicyFluent<?> fluent;

  public TagReferencePolicyBuilder() {
    this(new TagReferencePolicy());
  }
  
  public TagReferencePolicyBuilder(TagReferencePolicyFluent<?> fluent) {
    this(fluent, new TagReferencePolicy());
  }
  
  public TagReferencePolicyBuilder(TagReferencePolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TagReferencePolicyBuilder(TagReferencePolicyFluent<?> fluent,TagReferencePolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TagReferencePolicy build() {
    TagReferencePolicy buildable = new TagReferencePolicy(fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}