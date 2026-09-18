
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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

/**
 * InstallPlanSpec defines a set of Application resources to be installed
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "approval",
    "approved",
    "clusterServiceVersionNames",
    "generation",
    "source",
    "sourceNamespace"
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
public class InstallPlanSpec implements Editable<InstallPlanSpecBuilder>, KubernetesResource
{

    @JsonProperty("approval")
    private String approval;
    @JsonProperty("approved")
    private Boolean approved;
    @JsonProperty("clusterServiceVersionNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> clusterServiceVersionNames = new ArrayList<>();
    @JsonProperty("generation")
    private Integer generation;
    @JsonProperty("source")
    private String source;
    @JsonProperty("sourceNamespace")
    private String sourceNamespace;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public InstallPlanSpec() {
    }

    public InstallPlanSpec(String approval, Boolean approved, List<String> clusterServiceVersionNames, Integer generation, String source, String sourceNamespace) {
        super();
        this.approval = approval;
        this.approved = approved;
        this.clusterServiceVersionNames = clusterServiceVersionNames;
        this.generation = generation;
        this.source = source;
        this.sourceNamespace = sourceNamespace;
    }

    /**
     * InstallPlanSpec defines a set of Application resources to be installed
     */
    @JsonProperty("approval")
    public String getApproval() {
        return approval;
    }

    /**
     * InstallPlanSpec defines a set of Application resources to be installed
     */
    @JsonProperty("approval")
    public void setApproval(String approval) {
        this.approval = approval;
    }

    /**
     * InstallPlanSpec defines a set of Application resources to be installed
     */
    @JsonProperty("approved")
    public Boolean getApproved() {
        return approved;
    }

    /**
     * InstallPlanSpec defines a set of Application resources to be installed
     */
    @JsonProperty("approved")
    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    /**
     * InstallPlanSpec defines a set of Application resources to be installed
     */
    @JsonProperty("clusterServiceVersionNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getClusterServiceVersionNames() {
        return clusterServiceVersionNames;
    }

    /**
     * InstallPlanSpec defines a set of Application resources to be installed
     */
    @JsonProperty("clusterServiceVersionNames")
    public void setClusterServiceVersionNames(List<String> clusterServiceVersionNames) {
        this.clusterServiceVersionNames = clusterServiceVersionNames;
    }

    /**
     * InstallPlanSpec defines a set of Application resources to be installed
     */
    @JsonProperty("generation")
    public Integer getGeneration() {
        return generation;
    }

    /**
     * InstallPlanSpec defines a set of Application resources to be installed
     */
    @JsonProperty("generation")
    public void setGeneration(Integer generation) {
        this.generation = generation;
    }

    /**
     * InstallPlanSpec defines a set of Application resources to be installed
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * InstallPlanSpec defines a set of Application resources to be installed
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * InstallPlanSpec defines a set of Application resources to be installed
     */
    @JsonProperty("sourceNamespace")
    public String getSourceNamespace() {
        return sourceNamespace;
    }

    /**
     * InstallPlanSpec defines a set of Application resources to be installed
     */
    @JsonProperty("sourceNamespace")
    public void setSourceNamespace(String sourceNamespace) {
        this.sourceNamespace = sourceNamespace;
    }

    @JsonIgnore
    public InstallPlanSpecBuilder edit() {
        return new InstallPlanSpecBuilder(this);
    }

    @JsonIgnore
    public InstallPlanSpecBuilder toBuilder() {
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
        if (!(o instanceof InstallPlanSpec)) {
            return false;
        }
        InstallPlanSpec other = (InstallPlanSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$approval = this.getApproval();
        Object other$approval = other.getApproval();
        if (this$approval == null ? other$approval != null : !this$approval.equals(other$approval)) {
            return false;
        }
        Object this$approved = this.getApproved();
        Object other$approved = other.getApproved();
        if (this$approved == null ? other$approved != null : !this$approved.equals(other$approved)) {
            return false;
        }
        Object this$clusterServiceVersionNames = this.getClusterServiceVersionNames();
        Object other$clusterServiceVersionNames = other.getClusterServiceVersionNames();
        if (this$clusterServiceVersionNames == null ? other$clusterServiceVersionNames != null : !this$clusterServiceVersionNames.equals(other$clusterServiceVersionNames)) {
            return false;
        }
        Object this$generation = this.getGeneration();
        Object other$generation = other.getGeneration();
        if (this$generation == null ? other$generation != null : !this$generation.equals(other$generation)) {
            return false;
        }
        Object this$source = this.getSource();
        Object other$source = other.getSource();
        if (this$source == null ? other$source != null : !this$source.equals(other$source)) {
            return false;
        }
        Object this$sourceNamespace = this.getSourceNamespace();
        Object other$sourceNamespace = other.getSourceNamespace();
        if (this$sourceNamespace == null ? other$sourceNamespace != null : !this$sourceNamespace.equals(other$sourceNamespace)) {
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
        return other instanceof InstallPlanSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $approval = this.getApproval();
        result = result * prime + ($approval == null ? 43 : $approval.hashCode());
        Object $approved = this.getApproved();
        result = result * prime + ($approved == null ? 43 : $approved.hashCode());
        Object $clusterServiceVersionNames = this.getClusterServiceVersionNames();
        result = result * prime + ($clusterServiceVersionNames == null ? 43 : $clusterServiceVersionNames.hashCode());
        Object $generation = this.getGeneration();
        result = result * prime + ($generation == null ? 43 : $generation.hashCode());
        Object $source = this.getSource();
        result = result * prime + ($source == null ? 43 : $source.hashCode());
        Object $sourceNamespace = this.getSourceNamespace();
        result = result * prime + ($sourceNamespace == null ? 43 : $sourceNamespace.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "InstallPlanSpec(" + "approval=" + this.getApproval() + ", approved=" + this.getApproved() + ", clusterServiceVersionNames=" + this.getClusterServiceVersionNames() + ", generation=" + this.getGeneration() + ", source=" + this.getSource() + ", sourceNamespace=" + this.getSourceNamespace() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
