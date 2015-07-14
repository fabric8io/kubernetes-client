package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.ResourceQuota;
import io.fabric8.kubernetes.api.model.ResourceQuotaFluent;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateableResourceQuota extends ResourceQuotaFluent<UpdateableResourceQuota> implements Updateable<ResourceQuota> {

  @Override
  public ResourceQuota update() {
    return null;
  }
}
