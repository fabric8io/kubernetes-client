package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KlusterletListBuilder extends KlusterletListFluent<KlusterletListBuilder> implements VisitableBuilder<KlusterletList,KlusterletListBuilder>{

  KlusterletListFluent<?> fluent;

  public KlusterletListBuilder() {
    this(new KlusterletList());
  }
  
  public KlusterletListBuilder(KlusterletListFluent<?> fluent) {
    this(fluent, new KlusterletList());
  }
  
  public KlusterletListBuilder(KlusterletList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KlusterletListBuilder(KlusterletListFluent<?> fluent,KlusterletList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KlusterletList build() {
    KlusterletList buildable = new KlusterletList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}