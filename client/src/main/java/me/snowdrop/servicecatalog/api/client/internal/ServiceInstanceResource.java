package me.snowdrop.servicecatalog.api.client.internal;

import io.fabric8.kubernetes.client.dsl.Resource;
import me.snowdrop.servicecatalog.api.model.ClusterServicePlan;
import me.snowdrop.servicecatalog.api.model.DoneableClusterServicePlan;
import me.snowdrop.servicecatalog.api.model.DoneableServiceInstance;
import me.snowdrop.servicecatalog.api.model.ServiceBinding;
import me.snowdrop.servicecatalog.api.model.ServiceInstance;

public interface ServiceInstanceResource extends Resource<ServiceInstance, DoneableServiceInstance> {

    ServiceBinding bind(String secretName);
}
