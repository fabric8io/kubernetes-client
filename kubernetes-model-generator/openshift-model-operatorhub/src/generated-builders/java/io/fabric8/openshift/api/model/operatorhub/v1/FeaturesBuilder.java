package io.fabric8.openshift.api.model.operatorhub.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FeaturesBuilder extends FeaturesFluent<FeaturesBuilder> implements VisitableBuilder<Features,FeaturesBuilder>{

  FeaturesFluent<?> fluent;

  public FeaturesBuilder() {
    this(new Features());
  }
  
  public FeaturesBuilder(FeaturesFluent<?> fluent) {
    this(fluent, new Features());
  }
  
  public FeaturesBuilder(Features instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FeaturesBuilder(FeaturesFluent<?> fluent,Features instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Features build() {
    Features buildable = new Features(fluent.getDisableCopiedCSVs(), fluent.getPackageServerSyncInterval());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}