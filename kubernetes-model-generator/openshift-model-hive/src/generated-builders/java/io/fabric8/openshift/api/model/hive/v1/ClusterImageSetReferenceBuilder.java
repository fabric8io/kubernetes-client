package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterImageSetReferenceBuilder extends ClusterImageSetReferenceFluent<ClusterImageSetReferenceBuilder> implements VisitableBuilder<ClusterImageSetReference,ClusterImageSetReferenceBuilder>{

  ClusterImageSetReferenceFluent<?> fluent;

  public ClusterImageSetReferenceBuilder() {
    this(new ClusterImageSetReference());
  }
  
  public ClusterImageSetReferenceBuilder(ClusterImageSetReferenceFluent<?> fluent) {
    this(fluent, new ClusterImageSetReference());
  }
  
  public ClusterImageSetReferenceBuilder(ClusterImageSetReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterImageSetReferenceBuilder(ClusterImageSetReferenceFluent<?> fluent,ClusterImageSetReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterImageSetReference build() {
    ClusterImageSetReference buildable = new ClusterImageSetReference(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}