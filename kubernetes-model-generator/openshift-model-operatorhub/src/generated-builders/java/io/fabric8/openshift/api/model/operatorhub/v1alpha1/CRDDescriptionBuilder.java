package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CRDDescriptionBuilder extends CRDDescriptionFluent<CRDDescriptionBuilder> implements VisitableBuilder<CRDDescription,CRDDescriptionBuilder>{

  CRDDescriptionFluent<?> fluent;

  public CRDDescriptionBuilder() {
    this(new CRDDescription());
  }
  
  public CRDDescriptionBuilder(CRDDescriptionFluent<?> fluent) {
    this(fluent, new CRDDescription());
  }
  
  public CRDDescriptionBuilder(CRDDescription instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CRDDescriptionBuilder(CRDDescriptionFluent<?> fluent,CRDDescription instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CRDDescription build() {
    CRDDescription buildable = new CRDDescription(fluent.buildActionDescriptors(), fluent.getDescription(), fluent.getDisplayName(), fluent.getKind(), fluent.getName(), fluent.buildResources(), fluent.buildSpecDescriptors(), fluent.buildStatusDescriptors(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}