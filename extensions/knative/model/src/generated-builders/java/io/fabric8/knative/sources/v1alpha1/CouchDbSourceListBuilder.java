package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CouchDbSourceListBuilder extends CouchDbSourceListFluent<CouchDbSourceListBuilder> implements VisitableBuilder<CouchDbSourceList,CouchDbSourceListBuilder>{

  CouchDbSourceListFluent<?> fluent;

  public CouchDbSourceListBuilder() {
    this(new CouchDbSourceList());
  }
  
  public CouchDbSourceListBuilder(CouchDbSourceListFluent<?> fluent) {
    this(fluent, new CouchDbSourceList());
  }
  
  public CouchDbSourceListBuilder(CouchDbSourceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CouchDbSourceListBuilder(CouchDbSourceListFluent<?> fluent,CouchDbSourceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CouchDbSourceList build() {
    CouchDbSourceList buildable = new CouchDbSourceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}