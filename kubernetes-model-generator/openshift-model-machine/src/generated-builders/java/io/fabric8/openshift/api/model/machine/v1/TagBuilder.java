package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TagBuilder extends TagFluent<TagBuilder> implements VisitableBuilder<Tag,TagBuilder>{

  TagFluent<?> fluent;

  public TagBuilder() {
    this(new Tag());
  }
  
  public TagBuilder(TagFluent<?> fluent) {
    this(fluent, new Tag());
  }
  
  public TagBuilder(Tag instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TagBuilder(TagFluent<?> fluent,Tag instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Tag build() {
    Tag buildable = new Tag(fluent.getKey(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}