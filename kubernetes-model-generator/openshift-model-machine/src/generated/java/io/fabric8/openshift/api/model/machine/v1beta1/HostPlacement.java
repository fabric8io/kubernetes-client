
package io.fabric8.openshift.api.model.machine.v1beta1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * HostPlacement is the type that will be used to configure the placement of AWS instances.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "affinity",
    "dedicatedHost"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class HostPlacement implements Editable<HostPlacementBuilder>, KubernetesResource
{

    @JsonProperty("affinity")
    private String affinity;
    @JsonProperty("dedicatedHost")
    private DedicatedHost dedicatedHost;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HostPlacement() {
    }

    public HostPlacement(String affinity, DedicatedHost dedicatedHost) {
        super();
        this.affinity = affinity;
        this.dedicatedHost = dedicatedHost;
    }

    /**
     * affinity specifies the affinity setting for the instance. Allowed values are AnyAvailable and DedicatedHost. When Affinity is set to DedicatedHost, an instance started onto a specific host always restarts on the same host if stopped. In this scenario, the `dedicatedHost` field must be set. When Affinity is set to AnyAvailable, and you stop and restart the instance, it can be restarted on any available host. When Affinity is set to AnyAvailable and the `dedicatedHost` field is defined, it runs on specified Dedicated Host, but may move if stopped.
     */
    @JsonProperty("affinity")
    public String getAffinity() {
        return affinity;
    }

    /**
     * affinity specifies the affinity setting for the instance. Allowed values are AnyAvailable and DedicatedHost. When Affinity is set to DedicatedHost, an instance started onto a specific host always restarts on the same host if stopped. In this scenario, the `dedicatedHost` field must be set. When Affinity is set to AnyAvailable, and you stop and restart the instance, it can be restarted on any available host. When Affinity is set to AnyAvailable and the `dedicatedHost` field is defined, it runs on specified Dedicated Host, but may move if stopped.
     */
    @JsonProperty("affinity")
    public void setAffinity(String affinity) {
        this.affinity = affinity;
    }

    /**
     * HostPlacement is the type that will be used to configure the placement of AWS instances.
     */
    @JsonProperty("dedicatedHost")
    public DedicatedHost getDedicatedHost() {
        return dedicatedHost;
    }

    /**
     * HostPlacement is the type that will be used to configure the placement of AWS instances.
     */
    @JsonProperty("dedicatedHost")
    public void setDedicatedHost(DedicatedHost dedicatedHost) {
        this.dedicatedHost = dedicatedHost;
    }

    @JsonIgnore
    public HostPlacementBuilder edit() {
        return new HostPlacementBuilder(this);
    }

    @JsonIgnore
    public HostPlacementBuilder toBuilder() {
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
