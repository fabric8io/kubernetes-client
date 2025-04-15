
package io.fabric8.openshift.api.model.operator.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * NodeDisruptionPolicyConfig is the overall spec definition for files/units/sshkeys
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "files",
    "sshkey",
    "units"
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
public class NodeDisruptionPolicyConfig implements Editable<NodeDisruptionPolicyConfigBuilder>, KubernetesResource
{

    @JsonProperty("files")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeDisruptionPolicySpecFile> files = new ArrayList<>();
    @JsonProperty("sshkey")
    private NodeDisruptionPolicySpecSSHKey sshkey;
    @JsonProperty("units")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeDisruptionPolicySpecUnit> units = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeDisruptionPolicyConfig() {
    }

    public NodeDisruptionPolicyConfig(List<NodeDisruptionPolicySpecFile> files, NodeDisruptionPolicySpecSSHKey sshkey, List<NodeDisruptionPolicySpecUnit> units) {
        super();
        this.files = files;
        this.sshkey = sshkey;
        this.units = units;
    }

    /**
     * files is a list of MachineConfig file definitions and actions to take to changes on those paths This list supports a maximum of 50 entries.
     */
    @JsonProperty("files")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeDisruptionPolicySpecFile> getFiles() {
        return files;
    }

    /**
     * files is a list of MachineConfig file definitions and actions to take to changes on those paths This list supports a maximum of 50 entries.
     */
    @JsonProperty("files")
    public void setFiles(List<NodeDisruptionPolicySpecFile> files) {
        this.files = files;
    }

    /**
     * NodeDisruptionPolicyConfig is the overall spec definition for files/units/sshkeys
     */
    @JsonProperty("sshkey")
    public NodeDisruptionPolicySpecSSHKey getSshkey() {
        return sshkey;
    }

    /**
     * NodeDisruptionPolicyConfig is the overall spec definition for files/units/sshkeys
     */
    @JsonProperty("sshkey")
    public void setSshkey(NodeDisruptionPolicySpecSSHKey sshkey) {
        this.sshkey = sshkey;
    }

    /**
     * units is a list MachineConfig unit definitions and actions to take on changes to those services This list supports a maximum of 50 entries.
     */
    @JsonProperty("units")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeDisruptionPolicySpecUnit> getUnits() {
        return units;
    }

    /**
     * units is a list MachineConfig unit definitions and actions to take on changes to those services This list supports a maximum of 50 entries.
     */
    @JsonProperty("units")
    public void setUnits(List<NodeDisruptionPolicySpecUnit> units) {
        this.units = units;
    }

    @JsonIgnore
    public NodeDisruptionPolicyConfigBuilder edit() {
        return new NodeDisruptionPolicyConfigBuilder(this);
    }

    @JsonIgnore
    public NodeDisruptionPolicyConfigBuilder toBuilder() {
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
