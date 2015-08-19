package io.fabric8.openshift.client.dsl;

import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.openshift.api.model.DoneablePolicy;
import io.fabric8.openshift.api.model.Policy;
import io.fabric8.openshift.api.model.PolicyList;
import io.fabric8.openshift.client.OpenShiftClient;

public class PolicyOperationsImpl extends OpenshiftOperation<OpenShiftClient, Policy, PolicyList, DoneablePolicy, ClientResource<Policy, DoneablePolicy>> {
  public PolicyOperationsImpl(OpenShiftClient client) {
    super(client, "policies", null, null);
  }

  public PolicyOperationsImpl(OpenShiftClient client, String namespace, String name) {
    super(client, "policies", namespace, name);
  }
}
