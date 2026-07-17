package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TagImportPolicyBuilder extends TagImportPolicyFluent<TagImportPolicyBuilder> implements VisitableBuilder<TagImportPolicy,TagImportPolicyBuilder>{

  TagImportPolicyFluent<?> fluent;

  public TagImportPolicyBuilder() {
    this(new TagImportPolicy());
  }
  
  public TagImportPolicyBuilder(TagImportPolicyFluent<?> fluent) {
    this(fluent, new TagImportPolicy());
  }
  
  public TagImportPolicyBuilder(TagImportPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TagImportPolicyBuilder(TagImportPolicyFluent<?> fluent,TagImportPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TagImportPolicy build() {
    TagImportPolicy buildable = new TagImportPolicy(fluent.getImportMode(), fluent.getInsecure(), fluent.getScheduled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}