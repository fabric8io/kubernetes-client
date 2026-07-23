package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SelectorBuilder extends SelectorFluent<SelectorBuilder> implements VisitableBuilder<Selector,SelectorBuilder>{

  SelectorFluent<?> fluent;

  public SelectorBuilder() {
    this(new Selector());
  }
  
  public SelectorBuilder(SelectorFluent<?> fluent) {
    this(fluent, new Selector());
  }
  
  public SelectorBuilder(Selector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SelectorBuilder(SelectorFluent<?> fluent,Selector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Selector build() {
    Selector buildable = new Selector(fluent.getAnnotationSelector(), fluent.getGroup(), fluent.getKind(), fluent.getLabelSelector(), fluent.getName(), fluent.getNamespace(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}