package io.fabric8.kudo.client;

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kudo.api.model.v1beta1.*;
import io.fabric8.kudo.api.model.v1beta1.DoneableInstance;
import io.fabric8.kudo.api.model.v1beta1.DoneableOperator;
import io.fabric8.kudo.api.model.v1beta1.DoneableOperatorVersion;
import io.fabric8.kudo.client.operations.InstanceOperationsImpl;
import io.fabric8.kudo.client.operations.OperatorOperationsImpl;
import io.fabric8.kudo.client.operations.OperatorVersionOperationsImpl;
import okhttp3.OkHttpClient;

/**
 * @author pangms
 * @date 2020/4/20
 */
public class DefaultKudoClient extends BaseClient implements KudoClient {
  public DefaultKudoClient() throws KubernetesClientException {
    super();
  }

  public DefaultKudoClient(String masterUrl) throws KubernetesClientException {
    super(masterUrl);
  }

  public DefaultKudoClient(Config config) throws KubernetesClientException {
    super(config);
  }


  public DefaultKudoClient(OkHttpClient httpClient, Config config) throws KubernetesClientException {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<Operator, OperatorList, DoneableOperator, Resource<Operator, DoneableOperator>> operators() {
    return new OperatorOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<Instance, InstanceList, DoneableInstance, Resource<Instance, DoneableInstance>> instances() {
    return new InstanceOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<OperatorVersion, OperatorVersionList, DoneableOperatorVersion, Resource<OperatorVersion, DoneableOperatorVersion>> operatorVersion() {
    return new OperatorVersionOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }
}
