package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BundleLookupBuilder extends BundleLookupFluent<BundleLookupBuilder> implements VisitableBuilder<BundleLookup,BundleLookupBuilder>{

  BundleLookupFluent<?> fluent;

  public BundleLookupBuilder() {
    this(new BundleLookup());
  }
  
  public BundleLookupBuilder(BundleLookupFluent<?> fluent) {
    this(fluent, new BundleLookup());
  }
  
  public BundleLookupBuilder(BundleLookup instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BundleLookupBuilder(BundleLookupFluent<?> fluent,BundleLookup instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BundleLookup build() {
    BundleLookup buildable = new BundleLookup(fluent.buildCatalogSourceRef(), fluent.buildConditions(), fluent.getIdentifier(), fluent.getPath(), fluent.getProperties(), fluent.getReplaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}