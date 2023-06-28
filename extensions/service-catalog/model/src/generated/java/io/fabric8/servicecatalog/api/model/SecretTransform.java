
package io.fabric8.servicecatalog.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "addKey",
    "addKeysFrom",
    "removeKey",
    "renameKey"
})
@ToString
@EqualsAndHashCode
@Setter
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
@Generated("jsonschema2pojo")
public class SecretTransform implements KubernetesResource
{

    @JsonProperty("addKey")
    private AddKeyTransform addKey;
    @JsonProperty("addKeysFrom")
    private AddKeysFromTransform addKeysFrom;
    @JsonProperty("removeKey")
    private RemoveKeyTransform removeKey;
    @JsonProperty("renameKey")
    private RenameKeyTransform renameKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SecretTransform() {
    }

    public SecretTransform(AddKeyTransform addKey, AddKeysFromTransform addKeysFrom, RemoveKeyTransform removeKey, RenameKeyTransform renameKey) {
        super();
        this.addKey = addKey;
        this.addKeysFrom = addKeysFrom;
        this.removeKey = removeKey;
        this.renameKey = renameKey;
    }

    @JsonProperty("addKey")
    public AddKeyTransform getAddKey() {
        return addKey;
    }

    @JsonProperty("addKey")
    public void setAddKey(AddKeyTransform addKey) {
        this.addKey = addKey;
    }

    @JsonProperty("addKeysFrom")
    public AddKeysFromTransform getAddKeysFrom() {
        return addKeysFrom;
    }

    @JsonProperty("addKeysFrom")
    public void setAddKeysFrom(AddKeysFromTransform addKeysFrom) {
        this.addKeysFrom = addKeysFrom;
    }

    @JsonProperty("removeKey")
    public RemoveKeyTransform getRemoveKey() {
        return removeKey;
    }

    @JsonProperty("removeKey")
    public void setRemoveKey(RemoveKeyTransform removeKey) {
        this.removeKey = removeKey;
    }

    @JsonProperty("renameKey")
    public RenameKeyTransform getRenameKey() {
        return renameKey;
    }

    @JsonProperty("renameKey")
    public void setRenameKey(RenameKeyTransform renameKey) {
        this.renameKey = renameKey;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
