
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * SystemAssignedIdentityRole defines the role and scope to assign to the system assigned identity.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "definitionID",
    "name",
    "scope"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class SystemAssignedIdentityRole implements Editable<SystemAssignedIdentityRoleBuilder>, KubernetesResource
{

    @JsonProperty("definitionID")
    private String definitionID;
    @JsonProperty("name")
    private String name;
    @JsonProperty("scope")
    private String scope;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SystemAssignedIdentityRole() {
    }

    public SystemAssignedIdentityRole(String definitionID, String name, String scope) {
        super();
        this.definitionID = definitionID;
        this.name = name;
        this.scope = scope;
    }

    /**
     * DefinitionID is the ID of the role definition to create for a system assigned identity. It can be an Azure built-in role or a custom role. Refer to built-in roles: https://learn.microsoft.com/en-us/azure/role-based-access-control/built-in-roles
     */
    @JsonProperty("definitionID")
    public String getDefinitionID() {
        return definitionID;
    }

    /**
     * DefinitionID is the ID of the role definition to create for a system assigned identity. It can be an Azure built-in role or a custom role. Refer to built-in roles: https://learn.microsoft.com/en-us/azure/role-based-access-control/built-in-roles
     */
    @JsonProperty("definitionID")
    public void setDefinitionID(String definitionID) {
        this.definitionID = definitionID;
    }

    /**
     * Name is the name of the role assignment to create for a system assigned identity. It can be any valid UUID. If not specified, a random UUID will be generated.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the role assignment to create for a system assigned identity. It can be any valid UUID. If not specified, a random UUID will be generated.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Scope is the scope that the role assignment or definition applies to. The scope can be any REST resource instance. If not specified, the scope will be the subscription.
     */
    @JsonProperty("scope")
    public String getScope() {
        return scope;
    }

    /**
     * Scope is the scope that the role assignment or definition applies to. The scope can be any REST resource instance. If not specified, the scope will be the subscription.
     */
    @JsonProperty("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }

    @JsonIgnore
    public SystemAssignedIdentityRoleBuilder edit() {
        return new SystemAssignedIdentityRoleBuilder(this);
    }

    @JsonIgnore
    public SystemAssignedIdentityRoleBuilder toBuilder() {
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

}
