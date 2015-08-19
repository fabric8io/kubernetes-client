package io.fabric8.openshift.client.dsl;

import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.openshift.api.model.DoneableUser;
import io.fabric8.openshift.api.model.User;
import io.fabric8.openshift.api.model.UserList;
import io.fabric8.openshift.client.OpenShiftClient;

public class UserOperationsImpl extends OpenshiftOperation<OpenShiftClient, User, UserList, DoneableUser, ClientResource<User, DoneableUser>> {
  public UserOperationsImpl(OpenShiftClient client) {
    super(client, "users", null, null);
  }

  public UserOperationsImpl(OpenShiftClient client, String namespace, String name) {
    super(client, "users", namespace, name);
  }
}
