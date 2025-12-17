
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.infrastructure.v1beta1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Identity represents the Identity configuration for an AKS control plane. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/en-us/azure/aks/use-managed-identity
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "userAssignedIdentityResourceID"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
public class Identity implements Editable<IdentityBuilder>, KubernetesResource
{

    @JsonProperty("type")
    private String type;
    @JsonProperty("userAssignedIdentityResourceID")
    private String userAssignedIdentityResourceID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Identity() {
    }

    public Identity(String type, String userAssignedIdentityResourceID) {
        super();
        this.type = type;
        this.userAssignedIdentityResourceID = userAssignedIdentityResourceID;
    }

    /**
     * Type - The Identity type to use.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type - The Identity type to use.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * UserAssignedIdentityResourceID - Identity ARM resource ID when using user-assigned identity.
     */
    @JsonProperty("userAssignedIdentityResourceID")
    public String getUserAssignedIdentityResourceID() {
        return userAssignedIdentityResourceID;
    }

    /**
     * UserAssignedIdentityResourceID - Identity ARM resource ID when using user-assigned identity.
     */
    @JsonProperty("userAssignedIdentityResourceID")
    public void setUserAssignedIdentityResourceID(String userAssignedIdentityResourceID) {
        this.userAssignedIdentityResourceID = userAssignedIdentityResourceID;
    }

    @JsonIgnore
    public IdentityBuilder edit() {
        return new IdentityBuilder(this);
    }

    @JsonIgnore
    public IdentityBuilder toBuilder() {
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
