
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

/**
 * OVHCloudSDConfig configurations allow retrieving scrape targets from OVHcloud's dedicated servers and VPS using their API. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#ovhcloud_sd_config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "applicationKey",
    "applicationSecret",
    "consumerKey",
    "endpoint",
    "refreshInterval",
    "service"
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
public class OVHCloudSDConfig implements Editable<OVHCloudSDConfigBuilder>, KubernetesResource
{

    @JsonProperty("applicationKey")
    private String applicationKey;
    @JsonProperty("applicationSecret")
    private SecretKeySelector applicationSecret;
    @JsonProperty("consumerKey")
    private SecretKeySelector consumerKey;
    @JsonProperty("endpoint")
    private String endpoint;
    @JsonProperty("refreshInterval")
    private String refreshInterval;
    @JsonProperty("service")
    private String service;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OVHCloudSDConfig() {
    }

    public OVHCloudSDConfig(String applicationKey, SecretKeySelector applicationSecret, SecretKeySelector consumerKey, String endpoint, String refreshInterval, String service) {
        super();
        this.applicationKey = applicationKey;
        this.applicationSecret = applicationSecret;
        this.consumerKey = consumerKey;
        this.endpoint = endpoint;
        this.refreshInterval = refreshInterval;
        this.service = service;
    }

    /**
     * applicationKey defines the access key to use for OVHCloud API authentication. This is obtained from the OVHCloud API credentials at https://api.ovh.com.
     */
    @JsonProperty("applicationKey")
    public String getApplicationKey() {
        return applicationKey;
    }

    /**
     * applicationKey defines the access key to use for OVHCloud API authentication. This is obtained from the OVHCloud API credentials at https://api.ovh.com.
     */
    @JsonProperty("applicationKey")
    public void setApplicationKey(String applicationKey) {
        this.applicationKey = applicationKey;
    }

    /**
     * OVHCloudSDConfig configurations allow retrieving scrape targets from OVHcloud's dedicated servers and VPS using their API. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#ovhcloud_sd_config
     */
    @JsonProperty("applicationSecret")
    public SecretKeySelector getApplicationSecret() {
        return applicationSecret;
    }

    /**
     * OVHCloudSDConfig configurations allow retrieving scrape targets from OVHcloud's dedicated servers and VPS using their API. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#ovhcloud_sd_config
     */
    @JsonProperty("applicationSecret")
    public void setApplicationSecret(SecretKeySelector applicationSecret) {
        this.applicationSecret = applicationSecret;
    }

    /**
     * OVHCloudSDConfig configurations allow retrieving scrape targets from OVHcloud's dedicated servers and VPS using their API. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#ovhcloud_sd_config
     */
    @JsonProperty("consumerKey")
    public SecretKeySelector getConsumerKey() {
        return consumerKey;
    }

    /**
     * OVHCloudSDConfig configurations allow retrieving scrape targets from OVHcloud's dedicated servers and VPS using their API. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#ovhcloud_sd_config
     */
    @JsonProperty("consumerKey")
    public void setConsumerKey(SecretKeySelector consumerKey) {
        this.consumerKey = consumerKey;
    }

    /**
     * endpoint defines a custom API endpoint to be used. When not specified, defaults to the standard OVHCloud API endpoint for the region.
     */
    @JsonProperty("endpoint")
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * endpoint defines a custom API endpoint to be used. When not specified, defaults to the standard OVHCloud API endpoint for the region.
     */
    @JsonProperty("endpoint")
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * refreshInterval defines the time after which the provided names are refreshed. If not set, Prometheus uses its default value.
     */
    @JsonProperty("refreshInterval")
    public String getRefreshInterval() {
        return refreshInterval;
    }

    /**
     * refreshInterval defines the time after which the provided names are refreshed. If not set, Prometheus uses its default value.
     */
    @JsonProperty("refreshInterval")
    public void setRefreshInterval(String refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    /**
     * service defines the service type of the targets to retrieve. Must be either `VPS` or `DedicatedServer` to specify which OVHCloud resources to discover.
     */
    @JsonProperty("service")
    public String getService() {
        return service;
    }

    /**
     * service defines the service type of the targets to retrieve. Must be either `VPS` or `DedicatedServer` to specify which OVHCloud resources to discover.
     */
    @JsonProperty("service")
    public void setService(String service) {
        this.service = service;
    }

    @JsonIgnore
    public OVHCloudSDConfigBuilder edit() {
        return new OVHCloudSDConfigBuilder(this);
    }

    @JsonIgnore
    public OVHCloudSDConfigBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof OVHCloudSDConfig)) {
            return false;
        }
        OVHCloudSDConfig other = (OVHCloudSDConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$applicationKey = this.getApplicationKey();
        Object other$applicationKey = other.getApplicationKey();
        if (this$applicationKey == null ? other$applicationKey != null : !this$applicationKey.equals(other$applicationKey)) {
            return false;
        }
        Object this$applicationSecret = this.getApplicationSecret();
        Object other$applicationSecret = other.getApplicationSecret();
        if (this$applicationSecret == null ? other$applicationSecret != null : !this$applicationSecret.equals(other$applicationSecret)) {
            return false;
        }
        Object this$consumerKey = this.getConsumerKey();
        Object other$consumerKey = other.getConsumerKey();
        if (this$consumerKey == null ? other$consumerKey != null : !this$consumerKey.equals(other$consumerKey)) {
            return false;
        }
        Object this$endpoint = this.getEndpoint();
        Object other$endpoint = other.getEndpoint();
        if (this$endpoint == null ? other$endpoint != null : !this$endpoint.equals(other$endpoint)) {
            return false;
        }
        Object this$refreshInterval = this.getRefreshInterval();
        Object other$refreshInterval = other.getRefreshInterval();
        if (this$refreshInterval == null ? other$refreshInterval != null : !this$refreshInterval.equals(other$refreshInterval)) {
            return false;
        }
        Object this$service = this.getService();
        Object other$service = other.getService();
        if (this$service == null ? other$service != null : !this$service.equals(other$service)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof OVHCloudSDConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $applicationKey = this.getApplicationKey();
        result = result * prime + ($applicationKey == null ? 43 : $applicationKey.hashCode());
        Object $applicationSecret = this.getApplicationSecret();
        result = result * prime + ($applicationSecret == null ? 43 : $applicationSecret.hashCode());
        Object $consumerKey = this.getConsumerKey();
        result = result * prime + ($consumerKey == null ? 43 : $consumerKey.hashCode());
        Object $endpoint = this.getEndpoint();
        result = result * prime + ($endpoint == null ? 43 : $endpoint.hashCode());
        Object $refreshInterval = this.getRefreshInterval();
        result = result * prime + ($refreshInterval == null ? 43 : $refreshInterval.hashCode());
        Object $service = this.getService();
        result = result * prime + ($service == null ? 43 : $service.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OVHCloudSDConfig(" + "applicationKey=" + this.getApplicationKey() + ", applicationSecret=" + this.getApplicationSecret() + ", consumerKey=" + this.getConsumerKey() + ", endpoint=" + this.getEndpoint() + ", refreshInterval=" + this.getRefreshInterval() + ", service=" + this.getService() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
