
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.model.CSIVolumeSource;
import io.fabric8.kubernetes.api.model.ConfigMapVolumeSource;
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
import io.fabric8.kubernetes.api.model.SecretVolumeSource;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * BuildVolumeSource represents the source of a volume to mount Only one of its supported types may be specified at any given time.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configMap",
    "csi",
    "secret",
    "type"
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
public class BuildVolumeSource implements Editable<BuildVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("configMap")
    private ConfigMapVolumeSource configMap;
    @JsonProperty("csi")
    private CSIVolumeSource csi;
    @JsonProperty("secret")
    private SecretVolumeSource secret;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BuildVolumeSource() {
    }

    public BuildVolumeSource(ConfigMapVolumeSource configMap, CSIVolumeSource csi, SecretVolumeSource secret, String type) {
        super();
        this.configMap = configMap;
        this.csi = csi;
        this.secret = secret;
        this.type = type;
    }

    /**
     * BuildVolumeSource represents the source of a volume to mount Only one of its supported types may be specified at any given time.
     */
    @JsonProperty("configMap")
    public ConfigMapVolumeSource getConfigMap() {
        return configMap;
    }

    /**
     * BuildVolumeSource represents the source of a volume to mount Only one of its supported types may be specified at any given time.
     */
    @JsonProperty("configMap")
    public void setConfigMap(ConfigMapVolumeSource configMap) {
        this.configMap = configMap;
    }

    /**
     * BuildVolumeSource represents the source of a volume to mount Only one of its supported types may be specified at any given time.
     */
    @JsonProperty("csi")
    public CSIVolumeSource getCsi() {
        return csi;
    }

    /**
     * BuildVolumeSource represents the source of a volume to mount Only one of its supported types may be specified at any given time.
     */
    @JsonProperty("csi")
    public void setCsi(CSIVolumeSource csi) {
        this.csi = csi;
    }

    /**
     * BuildVolumeSource represents the source of a volume to mount Only one of its supported types may be specified at any given time.
     */
    @JsonProperty("secret")
    public SecretVolumeSource getSecret() {
        return secret;
    }

    /**
     * BuildVolumeSource represents the source of a volume to mount Only one of its supported types may be specified at any given time.
     */
    @JsonProperty("secret")
    public void setSecret(SecretVolumeSource secret) {
        this.secret = secret;
    }

    /**
     * type is the BuildVolumeSourceType for the volume source. Type must match the populated volume source. Valid types are: Secret, ConfigMap
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the BuildVolumeSourceType for the volume source. Type must match the populated volume source. Valid types are: Secret, ConfigMap
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public BuildVolumeSourceBuilder edit() {
        return new BuildVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public BuildVolumeSourceBuilder toBuilder() {
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
        if (!(o instanceof BuildVolumeSource)) {
            return false;
        }
        BuildVolumeSource other = (BuildVolumeSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$configMap = this.getConfigMap();
        Object other$configMap = other.getConfigMap();
        if (this$configMap == null ? other$configMap != null : !this$configMap.equals(other$configMap)) {
            return false;
        }
        Object this$csi = this.getCsi();
        Object other$csi = other.getCsi();
        if (this$csi == null ? other$csi != null : !this$csi.equals(other$csi)) {
            return false;
        }
        Object this$secret = this.getSecret();
        Object other$secret = other.getSecret();
        if (this$secret == null ? other$secret != null : !this$secret.equals(other$secret)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof BuildVolumeSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $configMap = this.getConfigMap();
        result = result * prime + ($configMap == null ? 43 : $configMap.hashCode());
        Object $csi = this.getCsi();
        result = result * prime + ($csi == null ? 43 : $csi.hashCode());
        Object $secret = this.getSecret();
        result = result * prime + ($secret == null ? 43 : $secret.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BuildVolumeSource(" + "configMap=" + this.getConfigMap() + ", csi=" + this.getCsi() + ", secret=" + this.getSecret() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
