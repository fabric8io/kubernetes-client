package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.NamespaceFluent;
import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateableNamespace extends NamespaceFluent<UpdateableNamespace> implements Updateable<Namespace> {

  private final NamespaceBuilder builder;
  private final Update<Namespace> update;

  public UpdateableNamespace(Namespace namespace, Update<Namespace> update) {
    this.update = update;
    builder = new NamespaceBuilder(this, namespace);
  }

  @Override
  public Namespace update() {
    return update.apply(builder.build());
  }
}
