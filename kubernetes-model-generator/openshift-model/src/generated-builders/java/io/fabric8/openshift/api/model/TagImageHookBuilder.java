package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TagImageHookBuilder extends TagImageHookFluent<TagImageHookBuilder> implements VisitableBuilder<TagImageHook,TagImageHookBuilder>{

  TagImageHookFluent<?> fluent;

  public TagImageHookBuilder() {
    this(new TagImageHook());
  }
  
  public TagImageHookBuilder(TagImageHookFluent<?> fluent) {
    this(fluent, new TagImageHook());
  }
  
  public TagImageHookBuilder(TagImageHook instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TagImageHookBuilder(TagImageHookFluent<?> fluent,TagImageHook instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TagImageHook build() {
    TagImageHook buildable = new TagImageHook(fluent.getContainerName(), fluent.buildTo());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}