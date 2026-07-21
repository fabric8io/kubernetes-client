package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NameConstraintItemBuilder extends NameConstraintItemFluent<NameConstraintItemBuilder> implements VisitableBuilder<NameConstraintItem,NameConstraintItemBuilder>{

  NameConstraintItemFluent<?> fluent;

  public NameConstraintItemBuilder() {
    this(new NameConstraintItem());
  }
  
  public NameConstraintItemBuilder(NameConstraintItemFluent<?> fluent) {
    this(fluent, new NameConstraintItem());
  }
  
  public NameConstraintItemBuilder(NameConstraintItem instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NameConstraintItemBuilder(NameConstraintItemFluent<?> fluent,NameConstraintItem instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NameConstraintItem build() {
    NameConstraintItem buildable = new NameConstraintItem(fluent.getDnsDomains(), fluent.getEmailAddresses(), fluent.getIpRanges(), fluent.getUriDomains());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}