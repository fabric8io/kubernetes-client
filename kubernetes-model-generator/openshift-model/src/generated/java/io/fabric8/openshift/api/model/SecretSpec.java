
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
 * SecretSpec specifies a secret to be included in a build pod and its corresponding mount point
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mountPath",
    "secretSource"
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
public class SecretSpec implements Editable<SecretSpecBuilder>, KubernetesResource
{

    @JsonProperty("mountPath")
    private String mountPath;
    @JsonProperty("secretSource")
    private LocalObjectReference secretSource;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SecretSpec() {
    }

    public SecretSpec(String mountPath, LocalObjectReference secretSource) {
        super();
        this.mountPath = mountPath;
        this.secretSource = secretSource;
    }

    /**
     * mountPath is the path at which to mount the secret
     */
    @JsonProperty("mountPath")
    public String getMountPath() {
        return mountPath;
    }

    /**
     * mountPath is the path at which to mount the secret
     */
    @JsonProperty("mountPath")
    public void setMountPath(String mountPath) {
        this.mountPath = mountPath;
    }

    /**
     * SecretSpec specifies a secret to be included in a build pod and its corresponding mount point
     */
    @JsonProperty("secretSource")
    public LocalObjectReference getSecretSource() {
        return secretSource;
    }

    /**
     * SecretSpec specifies a secret to be included in a build pod and its corresponding mount point
     */
    @JsonProperty("secretSource")
    public void setSecretSource(LocalObjectReference secretSource) {
        this.secretSource = secretSource;
    }

    @JsonIgnore
    public SecretSpecBuilder edit() {
        return new SecretSpecBuilder(this);
    }

    @JsonIgnore
    public SecretSpecBuilder toBuilder() {
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
        if (!(o instanceof SecretSpec)) {
            return false;
        }
        SecretSpec other = (SecretSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$mountPath = this.getMountPath();
        Object other$mountPath = other.getMountPath();
        if (this$mountPath == null ? other$mountPath != null : !this$mountPath.equals(other$mountPath)) {
            return false;
        }
        Object this$secretSource = this.getSecretSource();
        Object other$secretSource = other.getSecretSource();
        if (this$secretSource == null ? other$secretSource != null : !this$secretSource.equals(other$secretSource)) {
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
        return other instanceof SecretSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $mountPath = this.getMountPath();
        result = result * prime + ($mountPath == null ? 43 : $mountPath.hashCode());
        Object $secretSource = this.getSecretSource();
        result = result * prime + ($secretSource == null ? 43 : $secretSource.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SecretSpec(" + "mountPath=" + this.getMountPath() + ", secretSource=" + this.getSecretSource() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
