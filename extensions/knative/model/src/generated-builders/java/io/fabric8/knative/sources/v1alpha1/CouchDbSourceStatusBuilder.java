package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CouchDbSourceStatusBuilder extends CouchDbSourceStatusFluent<CouchDbSourceStatusBuilder> implements VisitableBuilder<CouchDbSourceStatus,CouchDbSourceStatusBuilder>{

  CouchDbSourceStatusFluent<?> fluent;

  public CouchDbSourceStatusBuilder() {
    this(new CouchDbSourceStatus());
  }
  
  public CouchDbSourceStatusBuilder(CouchDbSourceStatusFluent<?> fluent) {
    this(fluent, new CouchDbSourceStatus());
  }
  
  public CouchDbSourceStatusBuilder(CouchDbSourceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CouchDbSourceStatusBuilder(CouchDbSourceStatusFluent<?> fluent,CouchDbSourceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CouchDbSourceStatus build() {
    CouchDbSourceStatus buildable = new CouchDbSourceStatus(fluent.getAnnotations(), fluent.buildAuth(), fluent.buildCeAttributes(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.getSinkAudience(), fluent.getSinkCACerts(), fluent.getSinkUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}