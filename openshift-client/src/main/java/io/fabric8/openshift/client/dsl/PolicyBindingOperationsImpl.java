package io.fabric8.openshift.client.dsl;

import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.openshift.api.model.DoneablePolicyBinding;
import io.fabric8.openshift.api.model.PolicyBinding;
import io.fabric8.openshift.api.model.PolicyBindingList;
import io.fabric8.openshift.client.OpenShiftClient;

public class PolicyBindingOperationsImpl extends OpenshiftOperation<OpenShiftClient, PolicyBinding, PolicyBindingList, DoneablePolicyBinding, ClientResource<PolicyBinding, DoneablePolicyBinding>> {
  public PolicyBindingOperationsImpl(OpenShiftClient client) {
    super(client, "policybindings", null, null);
  }

  public PolicyBindingOperationsImpl(OpenShiftClient client, String namespace, String name) {
    super(client, "policybindings", namespace, name);
  }
}
