package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SourceSelectorBuilder extends SourceSelectorFluent<SourceSelectorBuilder> implements VisitableBuilder<SourceSelector,SourceSelectorBuilder>{

  SourceSelectorFluent<?> fluent;

  public SourceSelectorBuilder() {
    this(new SourceSelector());
  }
  
  public SourceSelectorBuilder(SourceSelectorFluent<?> fluent) {
    this(fluent, new SourceSelector());
  }
  
  public SourceSelectorBuilder(SourceSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SourceSelectorBuilder(SourceSelectorFluent<?> fluent,SourceSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SourceSelector build() {
    SourceSelector buildable = new SourceSelector(fluent.getFieldPath(), fluent.getGroup(), fluent.getKind(), fluent.getName(), fluent.getNamespace(), fluent.buildOptions(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}