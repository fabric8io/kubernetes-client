
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * AzureSDConfig allow retrieving scrape targets from Azure VMs. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#azure_sd_config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authenticationMethod",
    "clientID",
    "clientSecret",
    "environment",
    "port",
    "refreshInterval",
    "resourceGroup",
    "subscriptionID",
    "tenantID"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AzureSDConfig implements Editable<AzureSDConfigBuilder>, KubernetesResource
{

    @JsonProperty("authenticationMethod")
    private String authenticationMethod;
    @JsonProperty("clientID")
    private String clientID;
    @JsonProperty("clientSecret")
    private SecretKeySelector clientSecret;
    @JsonProperty("environment")
    private String environment;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("refreshInterval")
    private String refreshInterval;
    @JsonProperty("resourceGroup")
    private String resourceGroup;
    @JsonProperty("subscriptionID")
    private String subscriptionID;
    @JsonProperty("tenantID")
    private String tenantID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureSDConfig() {
    }

    public AzureSDConfig(String authenticationMethod, String clientID, SecretKeySelector clientSecret, String environment, Integer port, String refreshInterval, String resourceGroup, String subscriptionID, String tenantID) {
        super();
        this.authenticationMethod = authenticationMethod;
        this.clientID = clientID;
        this.clientSecret = clientSecret;
        this.environment = environment;
        this.port = port;
        this.refreshInterval = refreshInterval;
        this.resourceGroup = resourceGroup;
        this.subscriptionID = subscriptionID;
        this.tenantID = tenantID;
    }

    /**
     * # The authentication method, either `OAuth` or `ManagedIdentity` or `SDK`. See https://docs.microsoft.com/en-us/azure/active-directory/managed-identities-azure-resources/overview SDK authentication method uses environment variables by default. See https://learn.microsoft.com/en-us/azure/developer/go/azure-sdk-authentication
     */
    @JsonProperty("authenticationMethod")
    public String getAuthenticationMethod() {
        return authenticationMethod;
    }

    /**
     * # The authentication method, either `OAuth` or `ManagedIdentity` or `SDK`. See https://docs.microsoft.com/en-us/azure/active-directory/managed-identities-azure-resources/overview SDK authentication method uses environment variables by default. See https://learn.microsoft.com/en-us/azure/developer/go/azure-sdk-authentication
     */
    @JsonProperty("authenticationMethod")
    public void setAuthenticationMethod(String authenticationMethod) {
        this.authenticationMethod = authenticationMethod;
    }

    /**
     * Optional client ID. Only required with the OAuth authentication method.
     */
    @JsonProperty("clientID")
    public String getClientID() {
        return clientID;
    }

    /**
     * Optional client ID. Only required with the OAuth authentication method.
     */
    @JsonProperty("clientID")
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    /**
     * AzureSDConfig allow retrieving scrape targets from Azure VMs. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#azure_sd_config
     */
    @JsonProperty("clientSecret")
    public SecretKeySelector getClientSecret() {
        return clientSecret;
    }

    /**
     * AzureSDConfig allow retrieving scrape targets from Azure VMs. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#azure_sd_config
     */
    @JsonProperty("clientSecret")
    public void setClientSecret(SecretKeySelector clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * The Azure environment.
     */
    @JsonProperty("environment")
    public String getEnvironment() {
        return environment;
    }

    /**
     * The Azure environment.
     */
    @JsonProperty("environment")
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    /**
     * The port to scrape metrics from. If using the public IP address, this must instead be specified in the relabeling rule.
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * The port to scrape metrics from. If using the public IP address, this must instead be specified in the relabeling rule.
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * RefreshInterval configures the refresh interval at which Prometheus will re-read the instance list.
     */
    @JsonProperty("refreshInterval")
    public String getRefreshInterval() {
        return refreshInterval;
    }

    /**
     * RefreshInterval configures the refresh interval at which Prometheus will re-read the instance list.
     */
    @JsonProperty("refreshInterval")
    public void setRefreshInterval(String refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    /**
     * Optional resource group name. Limits discovery to this resource group.
     */
    @JsonProperty("resourceGroup")
    public String getResourceGroup() {
        return resourceGroup;
    }

    /**
     * Optional resource group name. Limits discovery to this resource group.
     */
    @JsonProperty("resourceGroup")
    public void setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    /**
     * The subscription ID. Always required.
     */
    @JsonProperty("subscriptionID")
    public String getSubscriptionID() {
        return subscriptionID;
    }

    /**
     * The subscription ID. Always required.
     */
    @JsonProperty("subscriptionID")
    public void setSubscriptionID(String subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    /**
     * Optional tenant ID. Only required with the OAuth authentication method.
     */
    @JsonProperty("tenantID")
    public String getTenantID() {
        return tenantID;
    }

    /**
     * Optional tenant ID. Only required with the OAuth authentication method.
     */
    @JsonProperty("tenantID")
    public void setTenantID(String tenantID) {
        this.tenantID = tenantID;
    }

    @JsonIgnore
    public AzureSDConfigBuilder edit() {
        return new AzureSDConfigBuilder(this);
    }

    @JsonIgnore
    public AzureSDConfigBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
