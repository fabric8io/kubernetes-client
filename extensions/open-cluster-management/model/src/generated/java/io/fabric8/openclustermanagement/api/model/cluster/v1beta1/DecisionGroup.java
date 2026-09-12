
package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

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

/**
 * DecisionGroup define a subset of clusters that will be added to placementDecisions with groupName label.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "groupClusterSelector",
    "groupName"
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
public class DecisionGroup implements Editable<DecisionGroupBuilder>, KubernetesResource
{

    @JsonProperty("groupClusterSelector")
    private GroupClusterSelector groupClusterSelector;
    @JsonProperty("groupName")
    private String groupName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DecisionGroup() {
    }

    public DecisionGroup(GroupClusterSelector groupClusterSelector, String groupName) {
        super();
        this.groupClusterSelector = groupClusterSelector;
        this.groupName = groupName;
    }

    /**
     * DecisionGroup define a subset of clusters that will be added to placementDecisions with groupName label.
     */
    @JsonProperty("groupClusterSelector")
    public GroupClusterSelector getGroupClusterSelector() {
        return groupClusterSelector;
    }

    /**
     * DecisionGroup define a subset of clusters that will be added to placementDecisions with groupName label.
     */
    @JsonProperty("groupClusterSelector")
    public void setGroupClusterSelector(GroupClusterSelector groupClusterSelector) {
        this.groupClusterSelector = groupClusterSelector;
    }

    /**
     * groupName to set as the label value on created PlacementDecision resources using the label key cluster.open-cluster-management.io/decision-group-name.
     */
    @JsonProperty("groupName")
    public String getGroupName() {
        return groupName;
    }

    /**
     * groupName to set as the label value on created PlacementDecision resources using the label key cluster.open-cluster-management.io/decision-group-name.
     */
    @JsonProperty("groupName")
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @JsonIgnore
    public DecisionGroupBuilder edit() {
        return new DecisionGroupBuilder(this);
    }

    @JsonIgnore
    public DecisionGroupBuilder toBuilder() {
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
        if (!(o instanceof DecisionGroup)) {
            return false;
        }
        DecisionGroup other = (DecisionGroup) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$groupClusterSelector = this.getGroupClusterSelector();
        Object other$groupClusterSelector = other.getGroupClusterSelector();
        if (this$groupClusterSelector == null ? other$groupClusterSelector != null : !this$groupClusterSelector.equals(other$groupClusterSelector)) {
            return false;
        }
        Object this$groupName = this.getGroupName();
        Object other$groupName = other.getGroupName();
        if (this$groupName == null ? other$groupName != null : !this$groupName.equals(other$groupName)) {
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
        return other instanceof DecisionGroup;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $groupClusterSelector = this.getGroupClusterSelector();
        result = result * prime + ($groupClusterSelector == null ? 43 : $groupClusterSelector.hashCode());
        Object $groupName = this.getGroupName();
        result = result * prime + ($groupName == null ? 43 : $groupName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DecisionGroup(" + "groupClusterSelector=" + this.getGroupClusterSelector() + ", groupName=" + this.getGroupName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
