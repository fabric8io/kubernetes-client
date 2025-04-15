
package io.fabric8.openshift.api.model.installer.v1;

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
 * MachinePool is a pool of machines to be installed.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "architecture",
    "hyperthreading",
    "name",
    "platform",
    "replicas"
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
public class MachinePool implements Editable<MachinePoolBuilder>, KubernetesResource
{

    @JsonProperty("architecture")
    private String architecture;
    @JsonProperty("hyperthreading")
    private String hyperthreading;
    @JsonProperty("name")
    private String name;
    @JsonProperty("platform")
    private MachinePoolPlatform platform;
    @JsonProperty("replicas")
    private Long replicas;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachinePool() {
    }

    public MachinePool(String architecture, String hyperthreading, String name, MachinePoolPlatform platform, Long replicas) {
        super();
        this.architecture = architecture;
        this.hyperthreading = hyperthreading;
        this.name = name;
        this.platform = platform;
        this.replicas = replicas;
    }

    /**
     * Architecture is the instruction set architecture of the machine pool. Defaults to amd64.
     */
    @JsonProperty("architecture")
    public String getArchitecture() {
        return architecture;
    }

    /**
     * Architecture is the instruction set architecture of the machine pool. Defaults to amd64.
     */
    @JsonProperty("architecture")
    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    /**
     * Hyperthreading determines the mode of hyperthreading that machines in the pool will utilize. Default is for hyperthreading to be enabled.
     */
    @JsonProperty("hyperthreading")
    public String getHyperthreading() {
        return hyperthreading;
    }

    /**
     * Hyperthreading determines the mode of hyperthreading that machines in the pool will utilize. Default is for hyperthreading to be enabled.
     */
    @JsonProperty("hyperthreading")
    public void setHyperthreading(String hyperthreading) {
        this.hyperthreading = hyperthreading;
    }

    /**
     * Name is the name of the machine pool. For the control plane machine pool, the name will always be "master". For the compute machine pools, the only valid name is "worker".
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the machine pool. For the control plane machine pool, the name will always be "master". For the compute machine pools, the only valid name is "worker".
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * MachinePool is a pool of machines to be installed.
     */
    @JsonProperty("platform")
    public MachinePoolPlatform getPlatform() {
        return platform;
    }

    /**
     * MachinePool is a pool of machines to be installed.
     */
    @JsonProperty("platform")
    public void setPlatform(MachinePoolPlatform platform) {
        this.platform = platform;
    }

    /**
     * Replicas is the machine count for the machine pool.
     */
    @JsonProperty("replicas")
    public Long getReplicas() {
        return replicas;
    }

    /**
     * Replicas is the machine count for the machine pool.
     */
    @JsonProperty("replicas")
    public void setReplicas(Long replicas) {
        this.replicas = replicas;
    }

    @JsonIgnore
    public MachinePoolBuilder edit() {
        return new MachinePoolBuilder(this);
    }

    @JsonIgnore
    public MachinePoolBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
