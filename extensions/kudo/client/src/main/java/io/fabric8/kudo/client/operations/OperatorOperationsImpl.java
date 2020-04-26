package io.fabric8.kudo.client.operations;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kudo.api.model.v1beta1.DoneableOperator;
import io.fabric8.kudo.api.model.v1beta1.Operator;
import io.fabric8.kudo.api.model.v1beta1.OperatorList;
import io.fabric8.kudo.client.Constance;
import okhttp3.OkHttpClient;

/**
 * @author pangms
 * @date 2020/4/21
 */
// public class OperatorOperationsImpl extends HasMetadataOperation<Operator, OperatorList, DoneableOperator, Resource<Operator, DoneableOperator>>  {
public class OperatorOperationsImpl extends HasMetadataOperation<Operator, OperatorList, DoneableOperator, Resource<Operator, DoneableOperator>>  {
  public OperatorOperationsImpl(OkHttpClient client, Config config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public OperatorOperationsImpl(OperationContext context) {
    super(context.withApiGroupName(Constance.ApiGroupName)
      .withApiGroupVersion(Constance.ApiGroupVersion)
      .withPlural("operators"));
    this.type = Operator.class;
    this.listType = OperatorList.class;
    this.doneableType = DoneableOperator.class;
  }

  public OperatorOperationsImpl newInstance(OperationContext context) {
    return new OperatorOperationsImpl(context);
  }
}
