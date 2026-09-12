
package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

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
 * MandatoryDecisionGroup set the decision group name or group index. GroupName is considered first to select the decisionGroups then GroupIndex.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "groupIndex",
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
public class MandatoryDecisionGroup implements Editable<MandatoryDecisionGroupBuilder>, KubernetesResource
{

    @JsonProperty("groupIndex")
    private Integer groupIndex;
    @JsonProperty("groupName")
    private String groupName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MandatoryDecisionGroup() {
    }

    public MandatoryDecisionGroup(Integer groupIndex, String groupName) {
        super();
        this.groupIndex = groupIndex;
        this.groupName = groupName;
    }

    /**
     * groupIndex of the decision group should match the placementDecisions label value with label key cluster.open-cluster-management.io/decision-group-index
     */
    @JsonProperty("groupIndex")
    public Integer getGroupIndex() {
        return groupIndex;
    }

    /**
     * groupIndex of the decision group should match the placementDecisions label value with label key cluster.open-cluster-management.io/decision-group-index
     */
    @JsonProperty("groupIndex")
    public void setGroupIndex(Integer groupIndex) {
        this.groupIndex = groupIndex;
    }

    /**
     * groupName of the decision group should match the placementDecisions label value with label key cluster.open-cluster-management.io/decision-group-name
     */
    @JsonProperty("groupName")
    public String getGroupName() {
        return groupName;
    }

    /**
     * groupName of the decision group should match the placementDecisions label value with label key cluster.open-cluster-management.io/decision-group-name
     */
    @JsonProperty("groupName")
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @JsonIgnore
    public MandatoryDecisionGroupBuilder edit() {
        return new MandatoryDecisionGroupBuilder(this);
    }

    @JsonIgnore
    public MandatoryDecisionGroupBuilder toBuilder() {
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
        if (!(o instanceof MandatoryDecisionGroup)) {
            return false;
        }
        MandatoryDecisionGroup other = (MandatoryDecisionGroup) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$groupIndex = this.getGroupIndex();
        Object other$groupIndex = other.getGroupIndex();
        if (this$groupIndex == null ? other$groupIndex != null : !this$groupIndex.equals(other$groupIndex)) {
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
        return other instanceof MandatoryDecisionGroup;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $groupIndex = this.getGroupIndex();
        result = result * prime + ($groupIndex == null ? 43 : $groupIndex.hashCode());
        Object $groupName = this.getGroupName();
        result = result * prime + ($groupName == null ? 43 : $groupName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MandatoryDecisionGroup(" + "groupIndex=" + this.getGroupIndex() + ", groupName=" + this.getGroupName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
