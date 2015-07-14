package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceFluent;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateableNamespace extends NamespaceFluent<UpdateableNamespace> implements Updateable<Namespace> {

  @Override
  public Namespace update() {
    return null;
  }
}
