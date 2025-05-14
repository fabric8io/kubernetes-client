
package io.fabric8.openshift.api.model.hive.v1;

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
 * ControllerConfig contains the configuration for a controller
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clientBurst",
    "clientQPS",
    "concurrentReconciles",
    "queueBurst",
    "queueQPS",
    "replicas",
    "resources"
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
public class ControllerConfig implements Editable<ControllerConfigBuilder>, KubernetesResource
{

    @JsonProperty("clientBurst")
    private Integer clientBurst;
    @JsonProperty("clientQPS")
    private Integer clientQPS;
    @JsonProperty("concurrentReconciles")
    private Integer concurrentReconciles;
    @JsonProperty("queueBurst")
    private Integer queueBurst;
    @JsonProperty("queueQPS")
    private Integer queueQPS;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ControllerConfig() {
    }

    public ControllerConfig(Integer clientBurst, Integer clientQPS, Integer concurrentReconciles, Integer queueBurst, Integer queueQPS, Integer replicas, ResourceRequirements resources) {
        super();
        this.clientBurst = clientBurst;
        this.clientQPS = clientQPS;
        this.concurrentReconciles = concurrentReconciles;
        this.queueBurst = queueBurst;
        this.queueQPS = queueQPS;
        this.replicas = replicas;
        this.resources = resources;
    }

    /**
     * ClientBurst specifies client rate limiter burst for a controller
     */
    @JsonProperty("clientBurst")
    public Integer getClientBurst() {
        return clientBurst;
    }

    /**
     * ClientBurst specifies client rate limiter burst for a controller
     */
    @JsonProperty("clientBurst")
    public void setClientBurst(Integer clientBurst) {
        this.clientBurst = clientBurst;
    }

    /**
     * ClientQPS specifies client rate limiter QPS for a controller
     */
    @JsonProperty("clientQPS")
    public Integer getClientQPS() {
        return clientQPS;
    }

    /**
     * ClientQPS specifies client rate limiter QPS for a controller
     */
    @JsonProperty("clientQPS")
    public void setClientQPS(Integer clientQPS) {
        this.clientQPS = clientQPS;
    }

    /**
     * ConcurrentReconciles specifies number of concurrent reconciles for a controller
     */
    @JsonProperty("concurrentReconciles")
    public Integer getConcurrentReconciles() {
        return concurrentReconciles;
    }

    /**
     * ConcurrentReconciles specifies number of concurrent reconciles for a controller
     */
    @JsonProperty("concurrentReconciles")
    public void setConcurrentReconciles(Integer concurrentReconciles) {
        this.concurrentReconciles = concurrentReconciles;
    }

    /**
     * QueueBurst specifies workqueue rate limiter burst for a controller
     */
    @JsonProperty("queueBurst")
    public Integer getQueueBurst() {
        return queueBurst;
    }

    /**
     * QueueBurst specifies workqueue rate limiter burst for a controller
     */
    @JsonProperty("queueBurst")
    public void setQueueBurst(Integer queueBurst) {
        this.queueBurst = queueBurst;
    }

    /**
     * QueueQPS specifies workqueue rate limiter QPS for a controller
     */
    @JsonProperty("queueQPS")
    public Integer getQueueQPS() {
        return queueQPS;
    }

    /**
     * QueueQPS specifies workqueue rate limiter QPS for a controller
     */
    @JsonProperty("queueQPS")
    public void setQueueQPS(Integer queueQPS) {
        this.queueQPS = queueQPS;
    }

    /**
     * Replicas specifies the number of replicas the specific controller pod should use. This is ONLY for controllers that have been split out into their own pods. This is ignored for all others.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * Replicas specifies the number of replicas the specific controller pod should use. This is ONLY for controllers that have been split out into their own pods. This is ignored for all others.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * ControllerConfig contains the configuration for a controller
     */
    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    /**
     * ControllerConfig contains the configuration for a controller
     */
    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    @JsonIgnore
    public ControllerConfigBuilder edit() {
        return new ControllerConfigBuilder(this);
    }

    @JsonIgnore
    public ControllerConfigBuilder toBuilder() {
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
