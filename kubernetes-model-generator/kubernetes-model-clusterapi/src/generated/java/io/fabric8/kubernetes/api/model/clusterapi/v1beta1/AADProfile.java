
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * AADProfile - AAD integration managed by AKS. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/aks/managed-aad
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "adminGroupObjectIDs",
    "managed"
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
public class AADProfile implements Editable<AADProfileBuilder>, KubernetesResource
{

    @JsonProperty("adminGroupObjectIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> adminGroupObjectIDs = new ArrayList<>();
    @JsonProperty("managed")
    private Boolean managed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AADProfile() {
    }

    public AADProfile(List<String> adminGroupObjectIDs, Boolean managed) {
        super();
        this.adminGroupObjectIDs = adminGroupObjectIDs;
        this.managed = managed;
    }

    /**
     * AdminGroupObjectIDs - AAD group object IDs that will have admin role of the cluster.
     */
    @JsonProperty("adminGroupObjectIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdminGroupObjectIDs() {
        return adminGroupObjectIDs;
    }

    /**
     * AdminGroupObjectIDs - AAD group object IDs that will have admin role of the cluster.
     */
    @JsonProperty("adminGroupObjectIDs")
    public void setAdminGroupObjectIDs(List<String> adminGroupObjectIDs) {
        this.adminGroupObjectIDs = adminGroupObjectIDs;
    }

    /**
     * Managed - Whether to enable managed AAD.
     */
    @JsonProperty("managed")
    public Boolean getManaged() {
        return managed;
    }

    /**
     * Managed - Whether to enable managed AAD.
     */
    @JsonProperty("managed")
    public void setManaged(Boolean managed) {
        this.managed = managed;
    }

    @JsonIgnore
    public AADProfileBuilder edit() {
        return new AADProfileBuilder(this);
    }

    @JsonIgnore
    public AADProfileBuilder toBuilder() {
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
