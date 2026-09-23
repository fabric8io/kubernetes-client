package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManifestSelectorBuilder extends ManifestSelectorFluent<ManifestSelectorBuilder> implements VisitableBuilder<ManifestSelector,ManifestSelectorBuilder>{

  ManifestSelectorFluent<?> fluent;

  public ManifestSelectorBuilder() {
    this(new ManifestSelector());
  }
  
  public ManifestSelectorBuilder(ManifestSelectorFluent<?> fluent) {
    this(fluent, new ManifestSelector());
  }
  
  public ManifestSelectorBuilder(ManifestSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManifestSelectorBuilder(ManifestSelectorFluent<?> fluent,ManifestSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManifestSelector build() {
    ManifestSelector buildable = new ManifestSelector(fluent.getGlob());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}