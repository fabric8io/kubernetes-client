package me.snowdrop.servicecatalog.api.client;

import io.fabric8.kubernetes.client.GenericKubernetesClient;

public interface NamespacedServiceCatalogClient extends ServiceCatalogClient,
        GenericServiceCatalogClient<NamespacedServiceCatalogClient> {
}
