
package io.fabric8.chaosmesh.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "branches",
    "context"
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
public class ConditionalBranchesStatus implements Editable<ConditionalBranchesStatusBuilder>, KubernetesResource
{

    @JsonProperty("branches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ConditionalBranchStatus> branches = new ArrayList<>();
    @JsonProperty("context")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> context = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConditionalBranchesStatus() {
    }

    public ConditionalBranchesStatus(List<ConditionalBranchStatus> branches, List<String> context) {
        super();
        this.branches = branches;
        this.context = context;
    }

    @JsonProperty("branches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ConditionalBranchStatus> getBranches() {
        return branches;
    }

    @JsonProperty("branches")
    public void setBranches(List<ConditionalBranchStatus> branches) {
        this.branches = branches;
    }

    @JsonProperty("context")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getContext() {
        return context;
    }

    @JsonProperty("context")
    public void setContext(List<String> context) {
        this.context = context;
    }

    @JsonIgnore
    public ConditionalBranchesStatusBuilder edit() {
        return new ConditionalBranchesStatusBuilder(this);
    }

    @JsonIgnore
    public ConditionalBranchesStatusBuilder toBuilder() {
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
        if (!(o instanceof ConditionalBranchesStatus)) {
            return false;
        }
        ConditionalBranchesStatus other = (ConditionalBranchesStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$branches = this.getBranches();
        Object other$branches = other.getBranches();
        if (this$branches == null ? other$branches != null : !this$branches.equals(other$branches)) {
            return false;
        }
        Object this$context = this.getContext();
        Object other$context = other.getContext();
        if (this$context == null ? other$context != null : !this$context.equals(other$context)) {
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
        return other instanceof ConditionalBranchesStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $branches = this.getBranches();
        result = result * prime + ($branches == null ? 43 : $branches.hashCode());
        Object $context = this.getContext();
        result = result * prime + ($context == null ? 43 : $context.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ConditionalBranchesStatus(" + "branches=" + this.getBranches() + ", context=" + this.getContext() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
