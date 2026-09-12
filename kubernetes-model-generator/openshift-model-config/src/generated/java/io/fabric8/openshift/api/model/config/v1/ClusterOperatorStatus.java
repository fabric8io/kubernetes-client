
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ClusterOperatorStatus provides information about the status of the operator.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "extension",
    "relatedObjects",
    "versions"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ClusterOperatorStatus implements Editable<ClusterOperatorStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterOperatorStatusCondition> conditions = new ArrayList<>();
    @JsonProperty("extension")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object extension;
    @JsonProperty("relatedObjects")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ObjectReference> relatedObjects = new ArrayList<>();
    @JsonProperty("versions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OperandVersion> versions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterOperatorStatus() {
    }

    public ClusterOperatorStatus(List<ClusterOperatorStatusCondition> conditions, Object extension, List<ObjectReference> relatedObjects, List<OperandVersion> versions) {
        super();
        this.conditions = conditions;
        this.extension = extension;
        this.relatedObjects = relatedObjects;
        this.versions = versions;
    }

    /**
     * conditions describes the state of the operator's managed and monitored components.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterOperatorStatusCondition> getConditions() {
        return conditions;
    }

    /**
     * conditions describes the state of the operator's managed and monitored components.
     */
    @JsonProperty("conditions")
    public void setConditions(List<ClusterOperatorStatusCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * ClusterOperatorStatus provides information about the status of the operator.
     */
    @JsonProperty("extension")
    public Object getExtension() {
        return extension;
    }

    /**
     * ClusterOperatorStatus provides information about the status of the operator.
     */
    @JsonProperty("extension")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setExtension(Object extension) {
        this.extension = extension;
    }

    /**
     * relatedObjects is a list of objects that are "interesting" or related to this operator.  Common uses are: 1. the detailed resource driving the operator 2. operator namespaces 3. operand namespaces
     */
    @JsonProperty("relatedObjects")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ObjectReference> getRelatedObjects() {
        return relatedObjects;
    }

    /**
     * relatedObjects is a list of objects that are "interesting" or related to this operator.  Common uses are: 1. the detailed resource driving the operator 2. operator namespaces 3. operand namespaces
     */
    @JsonProperty("relatedObjects")
    public void setRelatedObjects(List<ObjectReference> relatedObjects) {
        this.relatedObjects = relatedObjects;
    }

    /**
     * versions is a slice of operator and operand version tuples.  Operators which manage multiple operands will have multiple operand entries in the array.  Available operators must report the version of the operator itself with the name "operator". An operator reports a new "operator" version when it has rolled out the new version to all of its operands.
     */
    @JsonProperty("versions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OperandVersion> getVersions() {
        return versions;
    }

    /**
     * versions is a slice of operator and operand version tuples.  Operators which manage multiple operands will have multiple operand entries in the array.  Available operators must report the version of the operator itself with the name "operator". An operator reports a new "operator" version when it has rolled out the new version to all of its operands.
     */
    @JsonProperty("versions")
    public void setVersions(List<OperandVersion> versions) {
        this.versions = versions;
    }

    @JsonIgnore
    public ClusterOperatorStatusBuilder edit() {
        return new ClusterOperatorStatusBuilder(this);
    }

    @JsonIgnore
    public ClusterOperatorStatusBuilder toBuilder() {
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
        if (!(o instanceof ClusterOperatorStatus)) {
            return false;
        }
        ClusterOperatorStatus other = (ClusterOperatorStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$extension = this.getExtension();
        Object other$extension = other.getExtension();
        if (this$extension == null ? other$extension != null : !this$extension.equals(other$extension)) {
            return false;
        }
        Object this$relatedObjects = this.getRelatedObjects();
        Object other$relatedObjects = other.getRelatedObjects();
        if (this$relatedObjects == null ? other$relatedObjects != null : !this$relatedObjects.equals(other$relatedObjects)) {
            return false;
        }
        Object this$versions = this.getVersions();
        Object other$versions = other.getVersions();
        if (this$versions == null ? other$versions != null : !this$versions.equals(other$versions)) {
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
        return other instanceof ClusterOperatorStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $extension = this.getExtension();
        result = result * prime + ($extension == null ? 43 : $extension.hashCode());
        Object $relatedObjects = this.getRelatedObjects();
        result = result * prime + ($relatedObjects == null ? 43 : $relatedObjects.hashCode());
        Object $versions = this.getVersions();
        result = result * prime + ($versions == null ? 43 : $versions.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterOperatorStatus(" + "conditions=" + this.getConditions() + ", extension=" + this.getExtension() + ", relatedObjects=" + this.getRelatedObjects() + ", versions=" + this.getVersions() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
