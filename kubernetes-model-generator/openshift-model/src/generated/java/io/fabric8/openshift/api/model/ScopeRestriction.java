
package io.fabric8.openshift.api.model;

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
 * ScopeRestriction describe one restriction on scopes.  Exactly one option must be non-nil.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterRole",
    "literals"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ScopeRestriction implements Editable<ScopeRestrictionBuilder>, KubernetesResource
{

    @JsonProperty("clusterRole")
    private ClusterRoleScopeRestriction clusterRole;
    @JsonProperty("literals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> literals = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ScopeRestriction() {
    }

    public ScopeRestriction(ClusterRoleScopeRestriction clusterRole, List<String> literals) {
        super();
        this.clusterRole = clusterRole;
        this.literals = literals;
    }

    /**
     * ScopeRestriction describe one restriction on scopes.  Exactly one option must be non-nil.
     */
    @JsonProperty("clusterRole")
    public ClusterRoleScopeRestriction getClusterRole() {
        return clusterRole;
    }

    /**
     * ScopeRestriction describe one restriction on scopes.  Exactly one option must be non-nil.
     */
    @JsonProperty("clusterRole")
    public void setClusterRole(ClusterRoleScopeRestriction clusterRole) {
        this.clusterRole = clusterRole;
    }

    /**
     * ExactValues means the scope has to match a particular set of strings exactly
     */
    @JsonProperty("literals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getLiterals() {
        return literals;
    }

    /**
     * ExactValues means the scope has to match a particular set of strings exactly
     */
    @JsonProperty("literals")
    public void setLiterals(List<String> literals) {
        this.literals = literals;
    }

    @JsonIgnore
    public ScopeRestrictionBuilder edit() {
        return new ScopeRestrictionBuilder(this);
    }

    @JsonIgnore
    public ScopeRestrictionBuilder toBuilder() {
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
        if (!(o instanceof ScopeRestriction)) {
            return false;
        }
        ScopeRestriction other = (ScopeRestriction) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clusterRole = this.getClusterRole();
        Object other$clusterRole = other.getClusterRole();
        if (this$clusterRole == null ? other$clusterRole != null : !this$clusterRole.equals(other$clusterRole)) {
            return false;
        }
        Object this$literals = this.getLiterals();
        Object other$literals = other.getLiterals();
        if (this$literals == null ? other$literals != null : !this$literals.equals(other$literals)) {
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
        return other instanceof ScopeRestriction;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clusterRole = this.getClusterRole();
        result = result * prime + ($clusterRole == null ? 43 : $clusterRole.hashCode());
        Object $literals = this.getLiterals();
        result = result * prime + ($literals == null ? 43 : $literals.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ScopeRestriction(" + "clusterRole=" + this.getClusterRole() + ", literals=" + this.getLiterals() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
