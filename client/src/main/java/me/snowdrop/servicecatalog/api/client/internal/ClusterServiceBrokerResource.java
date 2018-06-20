package me.snowdrop.servicecatalog.api.client.internal;

import io.fabric8.kubernetes.client.dsl.Resource;
import me.snowdrop.servicecatalog.api.model.ClusterServiceBroker;
import me.snowdrop.servicecatalog.api.model.ClusterServiceClassList;
import me.snowdrop.servicecatalog.api.model.ClusterServicePlanList;
import me.snowdrop.servicecatalog.api.model.DoneableClusterServiceBroker;

public interface ClusterServiceBrokerResource extends Resource<ClusterServiceBroker, DoneableClusterServiceBroker> {


    /**
     * List all {@link me.snowdrop.servicecatalog.api.model.ClusterServicePlan}s available to the current broker.
     * It's an alternative of listing all plans and filtering by field.
     * @return The list of plans.
     */
    ClusterServicePlanList listPlans();

    /**
     * List all {@link me.snowdrop.servicecatalog.api.model.ClusterServiceClass}es available to the current broker.
     * It's an alternative of listing all classes and filtering by field.
     * @return The list of plans.
     */
    ClusterServiceClassList listClasses();
}
