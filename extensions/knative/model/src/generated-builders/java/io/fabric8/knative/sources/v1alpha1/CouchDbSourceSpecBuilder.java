package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CouchDbSourceSpecBuilder extends CouchDbSourceSpecFluent<CouchDbSourceSpecBuilder> implements VisitableBuilder<CouchDbSourceSpec,CouchDbSourceSpecBuilder>{

  CouchDbSourceSpecFluent<?> fluent;

  public CouchDbSourceSpecBuilder() {
    this(new CouchDbSourceSpec());
  }
  
  public CouchDbSourceSpecBuilder(CouchDbSourceSpecFluent<?> fluent) {
    this(fluent, new CouchDbSourceSpec());
  }
  
  public CouchDbSourceSpecBuilder(CouchDbSourceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CouchDbSourceSpecBuilder(CouchDbSourceSpecFluent<?> fluent,CouchDbSourceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CouchDbSourceSpec build() {
    CouchDbSourceSpec buildable = new CouchDbSourceSpec(fluent.buildCredentials(), fluent.getDatabase(), fluent.getFeed(), fluent.getServiceAccountName(), fluent.buildSink());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}