package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TagEventBuilder extends TagEventFluent<TagEventBuilder> implements VisitableBuilder<TagEvent,TagEventBuilder>{

  TagEventFluent<?> fluent;

  public TagEventBuilder() {
    this(new TagEvent());
  }
  
  public TagEventBuilder(TagEventFluent<?> fluent) {
    this(fluent, new TagEvent());
  }
  
  public TagEventBuilder(TagEvent instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TagEventBuilder(TagEventFluent<?> fluent,TagEvent instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TagEvent build() {
    TagEvent buildable = new TagEvent(fluent.getCreated(), fluent.getDockerImageReference(), fluent.getGeneration(), fluent.getImage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}