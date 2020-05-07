package io.fabric8.kudo.client.operations;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kudo.v1beta1.*;
import io.fabric8.kudo.v1beta1.DoneableInstance;
import io.fabric8.kudo.client.Constance;
import okhttp3.OkHttpClient;

/**
 * @author pangms
 * @date 2020/4/21
 */
public class InstanceOperationsImpl extends HasMetadataOperation<Instance, InstanceList, DoneableInstance, Resource<Instance, DoneableInstance>>  {
  public InstanceOperationsImpl(OkHttpClient client, Config config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public InstanceOperationsImpl(OperationContext context) {
    super(context.withApiGroupName(Constance.ApiGroupName)
      .withApiGroupVersion(Constance.ApiGroupVersion)
      .withPlural(Constance.InstancesPlural));
    this.type = Instance.class;
    this.listType = InstanceList.class;
    this.doneableType = DoneableInstance.class;
  }

  public InstanceOperationsImpl newInstance(OperationContext context) {
    return new InstanceOperationsImpl(context);
  }
}
