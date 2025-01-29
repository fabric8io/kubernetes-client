
package io.fabric8.openclustermanagement.api.model.shared;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "name",
    "serviceAccountProjection",
    "tlsSecretMountPath",
    "tlsSecretName"
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
public class PreConfiguredStorage implements Editable<PreConfiguredStorageBuilder>, KubernetesResource
{

    @JsonProperty("key")
    private String key;
    @JsonProperty("name")
    private String name;
    @JsonProperty("serviceAccountProjection")
    private Boolean serviceAccountProjection;
    @JsonProperty("tlsSecretMountPath")
    private String tlsSecretMountPath;
    @JsonProperty("tlsSecretName")
    private String tlsSecretName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PreConfiguredStorage() {
    }

    public PreConfiguredStorage(String key, String name, Boolean serviceAccountProjection, String tlsSecretMountPath, String tlsSecretName) {
        super();
        this.key = key;
        this.name = name;
        this.serviceAccountProjection = serviceAccountProjection;
        this.tlsSecretMountPath = tlsSecretMountPath;
        this.tlsSecretName = tlsSecretName;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("serviceAccountProjection")
    public Boolean getServiceAccountProjection() {
        return serviceAccountProjection;
    }

    @JsonProperty("serviceAccountProjection")
    public void setServiceAccountProjection(Boolean serviceAccountProjection) {
        this.serviceAccountProjection = serviceAccountProjection;
    }

    @JsonProperty("tlsSecretMountPath")
    public String getTlsSecretMountPath() {
        return tlsSecretMountPath;
    }

    @JsonProperty("tlsSecretMountPath")
    public void setTlsSecretMountPath(String tlsSecretMountPath) {
        this.tlsSecretMountPath = tlsSecretMountPath;
    }

    @JsonProperty("tlsSecretName")
    public String getTlsSecretName() {
        return tlsSecretName;
    }

    @JsonProperty("tlsSecretName")
    public void setTlsSecretName(String tlsSecretName) {
        this.tlsSecretName = tlsSecretName;
    }

    @JsonIgnore
    public PreConfiguredStorageBuilder edit() {
        return new PreConfiguredStorageBuilder(this);
    }

    @JsonIgnore
    public PreConfiguredStorageBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
