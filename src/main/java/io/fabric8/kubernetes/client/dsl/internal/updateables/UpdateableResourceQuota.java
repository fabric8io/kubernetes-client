package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.ResourceQuota;
import io.fabric8.kubernetes.api.model.ResourceQuotaBuilder;
import io.fabric8.kubernetes.api.model.ResourceQuotaFluent;
import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateableResourceQuota extends ResourceQuotaFluent<UpdateableResourceQuota> implements Updateable<ResourceQuota> {

  private final ResourceQuotaBuilder builder;
  private final Update<ResourceQuota> update;

  public UpdateableResourceQuota(ResourceQuota resourceQuota, Update<ResourceQuota> update) {
    this.update = update;
    builder = new ResourceQuotaBuilder(this, resourceQuota);
  }

  @Override
  public ResourceQuota update() {
    return update.apply(builder.build());
  }
}
