
package io.fabric8.openclustermanagement.api.model.operator.v1;

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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * BindConfiguration represents customization of server bindings
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "healthProbePort",
    "hostNetwork",
    "metricsPort",
    "port"
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
public class BindConfiguration implements Editable<BindConfigurationBuilder>, KubernetesResource
{

    @JsonProperty("healthProbePort")
    private Integer healthProbePort;
    @JsonProperty("hostNetwork")
    private Boolean hostNetwork;
    @JsonProperty("metricsPort")
    private Integer metricsPort;
    @JsonProperty("port")
    private Integer port;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BindConfiguration() {
    }

    public BindConfiguration(Integer healthProbePort, Boolean hostNetwork, Integer metricsPort, Integer port) {
        super();
        this.healthProbePort = healthProbePort;
        this.hostNetwork = hostNetwork;
        this.metricsPort = metricsPort;
        this.port = port;
    }

    /**
     * HealthProbePort represents the bind port of a webhook-server's healthcheck endpoint. The default value is 8000. Healthchecks may be disabled by setting a value less than or equal to 0.
     */
    @JsonProperty("healthProbePort")
    public Integer getHealthProbePort() {
        return healthProbePort;
    }

    /**
     * HealthProbePort represents the bind port of a webhook-server's healthcheck endpoint. The default value is 8000. Healthchecks may be disabled by setting a value less than or equal to 0.
     */
    @JsonProperty("healthProbePort")
    public void setHealthProbePort(Integer healthProbePort) {
        this.healthProbePort = healthProbePort;
    }

    /**
     * HostNetwork enables running webhook pods in host networking mode. This may be required in some installations, such as EKS with Calico CNI, to allow the API Server to communicate with the webhook pods.
     */
    @JsonProperty("hostNetwork")
    public Boolean getHostNetwork() {
        return hostNetwork;
    }

    /**
     * HostNetwork enables running webhook pods in host networking mode. This may be required in some installations, such as EKS with Calico CNI, to allow the API Server to communicate with the webhook pods.
     */
    @JsonProperty("hostNetwork")
    public void setHostNetwork(Boolean hostNetwork) {
        this.hostNetwork = hostNetwork;
    }

    /**
     * MetricsPort represents the bind port for a webhook-server's metric endpoint. The default value is 8080. Metrics may be disabled by setting a value less than or equal to 0.
     */
    @JsonProperty("metricsPort")
    public Integer getMetricsPort() {
        return metricsPort;
    }

    /**
     * MetricsPort represents the bind port for a webhook-server's metric endpoint. The default value is 8080. Metrics may be disabled by setting a value less than or equal to 0.
     */
    @JsonProperty("metricsPort")
    public void setMetricsPort(Integer metricsPort) {
        this.metricsPort = metricsPort;
    }

    /**
     * Port represents the primary bind port of a server. The default value is 9443.
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * Port represents the primary bind port of a server. The default value is 9443.
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    @JsonIgnore
    public BindConfigurationBuilder edit() {
        return new BindConfigurationBuilder(this);
    }

    @JsonIgnore
    public BindConfigurationBuilder toBuilder() {
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
