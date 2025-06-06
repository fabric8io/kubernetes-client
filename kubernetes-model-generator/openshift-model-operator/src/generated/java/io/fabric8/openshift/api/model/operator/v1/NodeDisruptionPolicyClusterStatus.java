
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
 * NodeDisruptionPolicyClusterStatus is the type for the status object, rendered by the controller as a merge of cluster defaults and user provided policies
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
public class NodeDisruptionPolicyClusterStatus implements Editable<NodeDisruptionPolicyClusterStatusBuilder>, KubernetesResource
{

    @JsonProperty("files")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeDisruptionPolicyStatusFile> files = new ArrayList<>();
    @JsonProperty("sshkey")
    private NodeDisruptionPolicyStatusSSHKey sshkey;
    @JsonProperty("units")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeDisruptionPolicyStatusUnit> units = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeDisruptionPolicyClusterStatus() {
    }

    public NodeDisruptionPolicyClusterStatus(List<NodeDisruptionPolicyStatusFile> files, NodeDisruptionPolicyStatusSSHKey sshkey, List<NodeDisruptionPolicyStatusUnit> units) {
        super();
        this.files = files;
        this.sshkey = sshkey;
        this.units = units;
    }

    /**
     * files is a list of MachineConfig file definitions and actions to take to changes on those paths
     */
    @JsonProperty("files")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeDisruptionPolicyStatusFile> getFiles() {
        return files;
    }

    /**
     * files is a list of MachineConfig file definitions and actions to take to changes on those paths
     */
    @JsonProperty("files")
    public void setFiles(List<NodeDisruptionPolicyStatusFile> files) {
        this.files = files;
    }

    /**
     * NodeDisruptionPolicyClusterStatus is the type for the status object, rendered by the controller as a merge of cluster defaults and user provided policies
     */
    @JsonProperty("sshkey")
    public NodeDisruptionPolicyStatusSSHKey getSshkey() {
        return sshkey;
    }

    /**
     * NodeDisruptionPolicyClusterStatus is the type for the status object, rendered by the controller as a merge of cluster defaults and user provided policies
     */
    @JsonProperty("sshkey")
    public void setSshkey(NodeDisruptionPolicyStatusSSHKey sshkey) {
        this.sshkey = sshkey;
    }

    /**
     * units is a list MachineConfig unit definitions and actions to take on changes to those services
     */
    @JsonProperty("units")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeDisruptionPolicyStatusUnit> getUnits() {
        return units;
    }

    /**
     * units is a list MachineConfig unit definitions and actions to take on changes to those services
     */
    @JsonProperty("units")
    public void setUnits(List<NodeDisruptionPolicyStatusUnit> units) {
        this.units = units;
    }

    @JsonIgnore
    public NodeDisruptionPolicyClusterStatusBuilder edit() {
        return new NodeDisruptionPolicyClusterStatusBuilder(this);
    }

    @JsonIgnore
    public NodeDisruptionPolicyClusterStatusBuilder toBuilder() {
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
