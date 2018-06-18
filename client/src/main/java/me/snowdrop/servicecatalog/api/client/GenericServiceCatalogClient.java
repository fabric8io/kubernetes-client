package me.snowdrop.servicecatalog.api.client;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.AnyNamespaceable;
import io.fabric8.kubernetes.client.dsl.Namespaceable;
import io.fabric8.kubernetes.client.dsl.RequestConfigurable;

public interface GenericServiceCatalogClient<C extends Client> extends Client, ServiceCatalogClient,
        Namespaceable<C>,
        AnyNamespaceable<C>,
        RequestConfigurable<C> {
}
