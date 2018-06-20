package me.snowdrop.servicecatalog.api.client.internal;

import io.fabric8.kubernetes.client.dsl.Resource;
import me.snowdrop.servicecatalog.api.model.ClusterServiceClass;
import me.snowdrop.servicecatalog.api.model.ClusterServicePlanList;
import me.snowdrop.servicecatalog.api.model.DoneableClusterServiceClass;
import me.snowdrop.servicecatalog.api.model.ServiceInstance;

public interface ClusterServiceClassResource extends Resource<ClusterServiceClass, DoneableClusterServiceClass> {

    ClusterServicePlanList listPlans();

    ServiceInstance instantiate(String instanceName, String plan);
}
