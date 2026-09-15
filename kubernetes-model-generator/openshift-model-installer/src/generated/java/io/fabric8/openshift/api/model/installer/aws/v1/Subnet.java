
package io.fabric8.openshift.api.model.installer.aws.v1;

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
 * Subnet specifies a subnet in an existing VPC and can optionally specify their intended roles.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "roles"
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
public class Subnet implements Editable<SubnetBuilder>, KubernetesResource
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("roles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubnetRole> roles = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Subnet() {
    }

    public Subnet(String id, List<SubnetRole> roles) {
        super();
        this.id = id;
        this.roles = roles;
    }

    /**
     * ID specifies the subnet ID of an existing subnet. The subnet ID must start with "subnet-", consist only of alphanumeric characters, and must be exactly 24 characters long.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * ID specifies the subnet ID of an existing subnet. The subnet ID must start with "subnet-", consist only of alphanumeric characters, and must be exactly 24 characters long.
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Roles specifies the roles (aka functions) that the subnet will provide in the cluster. If no roles are specified on any subnet, then the subnet roles are decided automatically. Each role must be unique.
     */
    @JsonProperty("roles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubnetRole> getRoles() {
        return roles;
    }

    /**
     * Roles specifies the roles (aka functions) that the subnet will provide in the cluster. If no roles are specified on any subnet, then the subnet roles are decided automatically. Each role must be unique.
     */
    @JsonProperty("roles")
    public void setRoles(List<SubnetRole> roles) {
        this.roles = roles;
    }

    @JsonIgnore
    public SubnetBuilder edit() {
        return new SubnetBuilder(this);
    }

    @JsonIgnore
    public SubnetBuilder toBuilder() {
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
        if (!(o instanceof Subnet)) {
            return false;
        }
        Subnet other = (Subnet) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$id = this.getId();
        Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
            return false;
        }
        Object this$roles = this.getRoles();
        Object other$roles = other.getRoles();
        if (this$roles == null ? other$roles != null : !this$roles.equals(other$roles)) {
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
        return other instanceof Subnet;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $id = this.getId();
        result = result * prime + ($id == null ? 43 : $id.hashCode());
        Object $roles = this.getRoles();
        result = result * prime + ($roles == null ? 43 : $roles.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Subnet(" + "id=" + this.getId() + ", roles=" + this.getRoles() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
