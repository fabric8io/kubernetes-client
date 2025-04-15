
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
 * NodeDisruptionPolicySpecUnit is a systemd unit name and corresponding actions to take and is used in the NodeDisruptionPolicyConfig object
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "actions",
    "name"
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
public class NodeDisruptionPolicySpecUnit implements Editable<NodeDisruptionPolicySpecUnitBuilder>, KubernetesResource
{

    @JsonProperty("actions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeDisruptionPolicySpecAction> actions = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeDisruptionPolicySpecUnit() {
    }

    public NodeDisruptionPolicySpecUnit(List<NodeDisruptionPolicySpecAction> actions, String name) {
        super();
        this.actions = actions;
        this.name = name;
    }

    /**
     * actions represents the series of commands to be executed on changes to the file at the corresponding file path. Actions will be applied in the order that they are set in this list. If there are other incoming changes to other MachineConfig entries in the same update that require a reboot, the reboot will supercede these actions. Valid actions are Reboot, Drain, Reload, DaemonReload and None. The Reboot action and the None action cannot be used in conjunction with any of the other actions. This list supports a maximum of 10 entries.
     */
    @JsonProperty("actions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeDisruptionPolicySpecAction> getActions() {
        return actions;
    }

    /**
     * actions represents the series of commands to be executed on changes to the file at the corresponding file path. Actions will be applied in the order that they are set in this list. If there are other incoming changes to other MachineConfig entries in the same update that require a reboot, the reboot will supercede these actions. Valid actions are Reboot, Drain, Reload, DaemonReload and None. The Reboot action and the None action cannot be used in conjunction with any of the other actions. This list supports a maximum of 10 entries.
     */
    @JsonProperty("actions")
    public void setActions(List<NodeDisruptionPolicySpecAction> actions) {
        this.actions = actions;
    }

    /**
     * name represents the service name of a systemd service managed through a MachineConfig Actions specified will be applied for changes to the named service. Service names should be of the format ${NAME}${SERVICETYPE} and can up to 255 characters long. ${NAME} must be atleast 1 character long and can only consist of alphabets, digits, ":", "-", "_", ".", and "\". ${SERVICETYPE} must be one of ".service", ".socket", ".device", ".mount", ".automount", ".swap", ".target", ".path", ".timer", ".snapshot", ".slice" or ".scope".
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name represents the service name of a systemd service managed through a MachineConfig Actions specified will be applied for changes to the named service. Service names should be of the format ${NAME}${SERVICETYPE} and can up to 255 characters long. ${NAME} must be atleast 1 character long and can only consist of alphabets, digits, ":", "-", "_", ".", and "\". ${SERVICETYPE} must be one of ".service", ".socket", ".device", ".mount", ".automount", ".swap", ".target", ".path", ".timer", ".snapshot", ".slice" or ".scope".
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public NodeDisruptionPolicySpecUnitBuilder edit() {
        return new NodeDisruptionPolicySpecUnitBuilder(this);
    }

    @JsonIgnore
    public NodeDisruptionPolicySpecUnitBuilder toBuilder() {
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
