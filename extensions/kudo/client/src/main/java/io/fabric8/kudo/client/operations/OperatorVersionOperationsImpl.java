package io.fabric8.kudo.client.operations;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kudo.client.Constance;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kudo.api.model.v1beta1.*;
import io.fabric8.kudo.api.model.v1beta1.DoneableInstance;
import io.fabric8.kudo.api.model.v1beta1.DoneableOperatorVersion;
import okhttp3.OkHttpClient;

/**
 * @author pangms
 * @date 2020/4/21
 */
public class OperatorVersionOperationsImpl extends HasMetadataOperation<OperatorVersion, OperatorVersionList, DoneableOperatorVersion, Resource<OperatorVersion, DoneableOperatorVersion>>  {
  public OperatorVersionOperationsImpl(OkHttpClient client, Config config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public OperatorVersionOperationsImpl(OperationContext context) {
    super(context.withApiGroupName(Constance.ApiGroupName)
      .withApiGroupVersion(Constance.ApiGroupVersion)
      .withPlural("operatorversions"));
    this.type = OperatorVersion.class;
    this.listType = OperatorVersionList.class;
    this.doneableType = DoneableOperatorVersion.class;
  }

  public OperatorVersionOperationsImpl newInstance(OperationContext context) {
    return new OperatorVersionOperationsImpl(context);
  }
}
