package io.fabric8.kudo.client;

import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kudo.api.model.kubectl.OperatorFile;
import io.fabric8.kudo.api.model.kubectl.ParamsFile;
import io.fabric8.kudo.api.model.v1beta1.*;
import io.fabric8.kudo.api.model.v1beta1.DoneableInstance;
import io.fabric8.kudo.api.model.v1beta1.DoneableOperator;
import io.fabric8.kudo.api.model.v1beta1.DoneableOperatorVersion;

import java.util.Map;

/**
 * Main interface for kudo client library.
 * @author pangms
 * @date 2020/4/20
 */
public interface KudoClient {
  MixedOperation<Operator, OperatorList, DoneableOperator, Resource<Operator, DoneableOperator>> operators();

  MixedOperation<Instance, InstanceList, DoneableInstance, Resource<Instance, DoneableInstance>> instances();

  MixedOperation<OperatorVersion, OperatorVersionList, DoneableOperatorVersion, Resource<OperatorVersion, DoneableOperatorVersion>> operatorVersion();
}
