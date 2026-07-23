package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IssuerListBuilder extends IssuerListFluent<IssuerListBuilder> implements VisitableBuilder<IssuerList,IssuerListBuilder>{

  IssuerListFluent<?> fluent;

  public IssuerListBuilder() {
    this(new IssuerList());
  }
  
  public IssuerListBuilder(IssuerListFluent<?> fluent) {
    this(fluent, new IssuerList());
  }
  
  public IssuerListBuilder(IssuerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IssuerListBuilder(IssuerListFluent<?> fluent,IssuerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IssuerList build() {
    IssuerList buildable = new IssuerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}