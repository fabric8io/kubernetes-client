package io.fabric8.openshift.client.dsl;

import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.openshift.api.model.DoneableGroup;
import io.fabric8.openshift.api.model.Group;
import io.fabric8.openshift.api.model.GroupList;
import io.fabric8.openshift.client.OpenShiftClient;

public class GroupOperationsImpl extends OpenshiftOperation<OpenShiftClient, Group, GroupList, DoneableGroup, ClientResource<Group, DoneableGroup>> {
  public GroupOperationsImpl(OpenShiftClient client) {
    super(client, "groups", null, null);
  }

  public GroupOperationsImpl(OpenShiftClient client, String namespace, String name) {
    super(client, "groups", namespace, name);
  }
}
