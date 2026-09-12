
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
 * ClusterRoleScopeRestriction describes restrictions on cluster role scopes
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowEscalation",
    "namespaces",
    "roleNames"
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
public class ClusterRoleScopeRestriction implements Editable<ClusterRoleScopeRestrictionBuilder>, KubernetesResource
{

    @JsonProperty("allowEscalation")
    private Boolean allowEscalation;
    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> namespaces = new ArrayList<>();
    @JsonProperty("roleNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> roleNames = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterRoleScopeRestriction() {
    }

    public ClusterRoleScopeRestriction(Boolean allowEscalation, List<String> namespaces, List<String> roleNames) {
        super();
        this.allowEscalation = allowEscalation;
        this.namespaces = namespaces;
        this.roleNames = roleNames;
    }

    /**
     * allowEscalation indicates whether you can request roles and their escalating resources
     */
    @JsonProperty("allowEscalation")
    public Boolean getAllowEscalation() {
        return allowEscalation;
    }

    /**
     * allowEscalation indicates whether you can request roles and their escalating resources
     */
    @JsonProperty("allowEscalation")
    public void setAllowEscalation(Boolean allowEscalation) {
        this.allowEscalation = allowEscalation;
    }

    /**
     * namespaces is the list of namespaces that can be referenced.  &#42; means any of them (including &#42;)
     */
    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNamespaces() {
        return namespaces;
    }

    /**
     * namespaces is the list of namespaces that can be referenced.  &#42; means any of them (including &#42;)
     */
    @JsonProperty("namespaces")
    public void setNamespaces(List<String> namespaces) {
        this.namespaces = namespaces;
    }

    /**
     * roleNames is the list of cluster roles that can referenced.  &#42; means anything
     */
    @JsonProperty("roleNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRoleNames() {
        return roleNames;
    }

    /**
     * roleNames is the list of cluster roles that can referenced.  &#42; means anything
     */
    @JsonProperty("roleNames")
    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }

    @JsonIgnore
    public ClusterRoleScopeRestrictionBuilder edit() {
        return new ClusterRoleScopeRestrictionBuilder(this);
    }

    @JsonIgnore
    public ClusterRoleScopeRestrictionBuilder toBuilder() {
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
        if (!(o instanceof ClusterRoleScopeRestriction)) {
            return false;
        }
        ClusterRoleScopeRestriction other = (ClusterRoleScopeRestriction) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allowEscalation = this.getAllowEscalation();
        Object other$allowEscalation = other.getAllowEscalation();
        if (this$allowEscalation == null ? other$allowEscalation != null : !this$allowEscalation.equals(other$allowEscalation)) {
            return false;
        }
        Object this$namespaces = this.getNamespaces();
        Object other$namespaces = other.getNamespaces();
        if (this$namespaces == null ? other$namespaces != null : !this$namespaces.equals(other$namespaces)) {
            return false;
        }
        Object this$roleNames = this.getRoleNames();
        Object other$roleNames = other.getRoleNames();
        if (this$roleNames == null ? other$roleNames != null : !this$roleNames.equals(other$roleNames)) {
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
        return other instanceof ClusterRoleScopeRestriction;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allowEscalation = this.getAllowEscalation();
        result = result * prime + ($allowEscalation == null ? 43 : $allowEscalation.hashCode());
        Object $namespaces = this.getNamespaces();
        result = result * prime + ($namespaces == null ? 43 : $namespaces.hashCode());
        Object $roleNames = this.getRoleNames();
        result = result * prime + ($roleNames == null ? 43 : $roleNames.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterRoleScopeRestriction(" + "allowEscalation=" + this.getAllowEscalation() + ", namespaces=" + this.getNamespaces() + ", roleNames=" + this.getRoleNames() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
