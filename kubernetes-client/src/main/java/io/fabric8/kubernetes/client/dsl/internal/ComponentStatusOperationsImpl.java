package io.fabric8.kubernetes.client.dsl.internal;

import com.squareup.okhttp.OkHttpClient;

import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusList;
import io.fabric8.kubernetes.api.model.DoneableComponentStatus;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;

public class ComponentStatusOperationsImpl extends HasMetadataOperation<ComponentStatus, ComponentStatusList, DoneableComponentStatus,
ClientResource<ComponentStatus, DoneableComponentStatus>> {

	public ComponentStatusOperationsImpl(OkHttpClient client, Config config, String namespace) {
		this(client, config, null, namespace, null, true, null, null);
	}


	public ComponentStatusOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, ComponentStatus item, String resourceVersion) {
		super(client, config, null, apiVersion, "componentstatuses", namespace, name, cascading, item, resourceVersion);
	}

}
