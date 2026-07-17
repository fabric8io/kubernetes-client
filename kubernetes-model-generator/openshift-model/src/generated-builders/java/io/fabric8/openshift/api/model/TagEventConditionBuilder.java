package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TagEventConditionBuilder extends TagEventConditionFluent<TagEventConditionBuilder> implements VisitableBuilder<TagEventCondition,TagEventConditionBuilder>{

  TagEventConditionFluent<?> fluent;

  public TagEventConditionBuilder() {
    this(new TagEventCondition());
  }
  
  public TagEventConditionBuilder(TagEventConditionFluent<?> fluent) {
    this(fluent, new TagEventCondition());
  }
  
  public TagEventConditionBuilder(TagEventCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TagEventConditionBuilder(TagEventConditionFluent<?> fluent,TagEventCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TagEventCondition build() {
    TagEventCondition buildable = new TagEventCondition(fluent.getGeneration(), fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}