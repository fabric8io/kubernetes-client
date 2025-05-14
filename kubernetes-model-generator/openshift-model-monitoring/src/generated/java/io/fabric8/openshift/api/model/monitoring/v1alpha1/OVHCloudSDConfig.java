
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
     * Access key to use. https://api.ovh.com.
     */
    @JsonProperty("applicationKey")
    public String getApplicationKey() {
        return applicationKey;
    }

    /**
     * Access key to use. https://api.ovh.com.
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
     * Custom endpoint to be used.
     */
    @JsonProperty("endpoint")
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Custom endpoint to be used.
     */
    @JsonProperty("endpoint")
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * Refresh interval to re-read the resources list.
     */
    @JsonProperty("refreshInterval")
    public String getRefreshInterval() {
        return refreshInterval;
    }

    /**
     * Refresh interval to re-read the resources list.
     */
    @JsonProperty("refreshInterval")
    public void setRefreshInterval(String refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    /**
     * Service of the targets to retrieve. Must be `VPS` or `DedicatedServer`.
     */
    @JsonProperty("service")
    public String getService() {
        return service;
    }

    /**
     * Service of the targets to retrieve. Must be `VPS` or `DedicatedServer`.
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

}
