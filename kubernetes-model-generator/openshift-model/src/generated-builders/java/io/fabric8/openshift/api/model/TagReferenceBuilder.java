package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TagReferenceBuilder extends TagReferenceFluent<TagReferenceBuilder> implements VisitableBuilder<TagReference,TagReferenceBuilder>{

  TagReferenceFluent<?> fluent;

  public TagReferenceBuilder() {
    this(new TagReference());
  }
  
  public TagReferenceBuilder(TagReferenceFluent<?> fluent) {
    this(fluent, new TagReference());
  }
  
  public TagReferenceBuilder(TagReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TagReferenceBuilder(TagReferenceFluent<?> fluent,TagReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TagReference build() {
    TagReference buildable = new TagReference(fluent.getAnnotations(), fluent.buildFrom(), fluent.getGeneration(), fluent.buildImportPolicy(), fluent.getName(), fluent.getReference(), fluent.buildReferencePolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}