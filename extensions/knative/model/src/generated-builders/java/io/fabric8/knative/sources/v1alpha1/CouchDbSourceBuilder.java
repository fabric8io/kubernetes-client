package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CouchDbSourceBuilder extends CouchDbSourceFluent<CouchDbSourceBuilder> implements VisitableBuilder<CouchDbSource,CouchDbSourceBuilder>{

  CouchDbSourceFluent<?> fluent;

  public CouchDbSourceBuilder() {
    this(new CouchDbSource());
  }
  
  public CouchDbSourceBuilder(CouchDbSourceFluent<?> fluent) {
    this(fluent, new CouchDbSource());
  }
  
  public CouchDbSourceBuilder(CouchDbSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CouchDbSourceBuilder(CouchDbSourceFluent<?> fluent,CouchDbSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CouchDbSource build() {
    CouchDbSource buildable = new CouchDbSource(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}