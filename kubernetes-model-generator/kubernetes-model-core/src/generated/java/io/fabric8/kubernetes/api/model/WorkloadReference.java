
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * WorkloadReference identifies the Workload object and PodGroup membership that a Pod belongs to. The scheduler uses this information to apply workload-aware scheduling semantics.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "podGroup",
    "podGroupReplicaKey"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class WorkloadReference implements Editable<WorkloadReferenceBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("podGroup")
    private String podGroup;
    @JsonProperty("podGroupReplicaKey")
    private String podGroupReplicaKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WorkloadReference() {
    }

    public WorkloadReference(String name, String podGroup, String podGroupReplicaKey) {
        super();
        this.name = name;
        this.podGroup = podGroup;
        this.podGroupReplicaKey = podGroupReplicaKey;
    }

    /**
     * Name defines the name of the Workload object this Pod belongs to. Workload must be in the same namespace as the Pod. If it doesn't match any existing Workload, the Pod will remain unschedulable until a Workload object is created and observed by the kube-scheduler. It must be a DNS subdomain.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name defines the name of the Workload object this Pod belongs to. Workload must be in the same namespace as the Pod. If it doesn't match any existing Workload, the Pod will remain unschedulable until a Workload object is created and observed by the kube-scheduler. It must be a DNS subdomain.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * PodGroup is the name of the PodGroup within the Workload that this Pod belongs to. If it doesn't match any existing PodGroup within the Workload, the Pod will remain unschedulable until the Workload object is recreated and observed by the kube-scheduler. It must be a DNS label.
     */
    @JsonProperty("podGroup")
    public String getPodGroup() {
        return podGroup;
    }

    /**
     * PodGroup is the name of the PodGroup within the Workload that this Pod belongs to. If it doesn't match any existing PodGroup within the Workload, the Pod will remain unschedulable until the Workload object is recreated and observed by the kube-scheduler. It must be a DNS label.
     */
    @JsonProperty("podGroup")
    public void setPodGroup(String podGroup) {
        this.podGroup = podGroup;
    }

    /**
     * PodGroupReplicaKey specifies the replica key of the PodGroup to which this Pod belongs. It is used to distinguish pods belonging to different replicas of the same pod group. The pod group policy is applied separately to each replica. When set, it must be a DNS label.
     */
    @JsonProperty("podGroupReplicaKey")
    public String getPodGroupReplicaKey() {
        return podGroupReplicaKey;
    }

    /**
     * PodGroupReplicaKey specifies the replica key of the PodGroup to which this Pod belongs. It is used to distinguish pods belonging to different replicas of the same pod group. The pod group policy is applied separately to each replica. When set, it must be a DNS label.
     */
    @JsonProperty("podGroupReplicaKey")
    public void setPodGroupReplicaKey(String podGroupReplicaKey) {
        this.podGroupReplicaKey = podGroupReplicaKey;
    }

    @JsonIgnore
    public WorkloadReferenceBuilder edit() {
        return new WorkloadReferenceBuilder(this);
    }

    @JsonIgnore
    public WorkloadReferenceBuilder toBuilder() {
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
        if (!(o instanceof WorkloadReference)) {
            return false;
        }
        WorkloadReference other = (WorkloadReference) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$podGroup = this.getPodGroup();
        Object other$podGroup = other.getPodGroup();
        if (this$podGroup == null ? other$podGroup != null : !this$podGroup.equals(other$podGroup)) {
            return false;
        }
        Object this$podGroupReplicaKey = this.getPodGroupReplicaKey();
        Object other$podGroupReplicaKey = other.getPodGroupReplicaKey();
        if (this$podGroupReplicaKey == null ? other$podGroupReplicaKey != null : !this$podGroupReplicaKey.equals(other$podGroupReplicaKey)) {
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
        return other instanceof WorkloadReference;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $podGroup = this.getPodGroup();
        result = result * prime + ($podGroup == null ? 43 : $podGroup.hashCode());
        Object $podGroupReplicaKey = this.getPodGroupReplicaKey();
        result = result * prime + ($podGroupReplicaKey == null ? 43 : $podGroupReplicaKey.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "WorkloadReference(" + "name=" + this.getName() + ", podGroup=" + this.getPodGroup() + ", podGroupReplicaKey=" + this.getPodGroupReplicaKey() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
