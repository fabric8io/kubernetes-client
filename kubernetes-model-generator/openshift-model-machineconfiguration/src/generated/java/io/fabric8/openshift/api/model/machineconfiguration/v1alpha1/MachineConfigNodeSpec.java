
package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

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
 * MachineConfigNodeSpec describes the MachineConfigNode we are managing.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configVersion",
    "node",
    "pool"
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
public class MachineConfigNodeSpec implements Editable<MachineConfigNodeSpecBuilder>, KubernetesResource
{

    @JsonProperty("configVersion")
    private MachineConfigNodeSpecMachineConfigVersion configVersion;
    @JsonProperty("node")
    private MCOObjectReference node;
    @JsonProperty("pool")
    private MCOObjectReference pool;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineConfigNodeSpec() {
    }

    public MachineConfigNodeSpec(MachineConfigNodeSpecMachineConfigVersion configVersion, MCOObjectReference node, MCOObjectReference pool) {
        super();
        this.configVersion = configVersion;
        this.node = node;
        this.pool = pool;
    }

    /**
     * MachineConfigNodeSpec describes the MachineConfigNode we are managing.
     */
    @JsonProperty("configVersion")
    public MachineConfigNodeSpecMachineConfigVersion getConfigVersion() {
        return configVersion;
    }

    /**
     * MachineConfigNodeSpec describes the MachineConfigNode we are managing.
     */
    @JsonProperty("configVersion")
    public void setConfigVersion(MachineConfigNodeSpecMachineConfigVersion configVersion) {
        this.configVersion = configVersion;
    }

    /**
     * MachineConfigNodeSpec describes the MachineConfigNode we are managing.
     */
    @JsonProperty("node")
    public MCOObjectReference getNode() {
        return node;
    }

    /**
     * MachineConfigNodeSpec describes the MachineConfigNode we are managing.
     */
    @JsonProperty("node")
    public void setNode(MCOObjectReference node) {
        this.node = node;
    }

    /**
     * MachineConfigNodeSpec describes the MachineConfigNode we are managing.
     */
    @JsonProperty("pool")
    public MCOObjectReference getPool() {
        return pool;
    }

    /**
     * MachineConfigNodeSpec describes the MachineConfigNode we are managing.
     */
    @JsonProperty("pool")
    public void setPool(MCOObjectReference pool) {
        this.pool = pool;
    }

    @JsonIgnore
    public MachineConfigNodeSpecBuilder edit() {
        return new MachineConfigNodeSpecBuilder(this);
    }

    @JsonIgnore
    public MachineConfigNodeSpecBuilder toBuilder() {
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
