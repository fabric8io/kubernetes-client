package io.fabric8.kubernetes.client.mock.impl;

import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusList;
import io.fabric8.kubernetes.api.model.DoneableComponentStatus;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.mock.BaseMockOperation;
import io.fabric8.kubernetes.client.mock.MockResource;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableComponentStatus;

public class MockComponentStatus  extends BaseMockOperation<ComponentStatus, ComponentStatusList, DoneableComponentStatus,
MockDoneableComponentStatus, ClientResource<ComponentStatus, DoneableComponentStatus>,
MockResource<ComponentStatus, MockDoneableComponentStatus, Boolean>> {

}
