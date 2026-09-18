
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * SafeAuthorization specifies a subset of the Authorization struct, that is safe for use because it doesn't provide access to the Prometheus container's filesystem.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "credentials",
    "type"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SafeAuthorization implements Editable<SafeAuthorizationBuilder>, KubernetesResource
{

    @JsonProperty("credentials")
    private SecretKeySelector credentials;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SafeAuthorization() {
    }

    public SafeAuthorization(SecretKeySelector credentials, String type) {
        super();
        this.credentials = credentials;
        this.type = type;
    }

    /**
     * SafeAuthorization specifies a subset of the Authorization struct, that is safe for use because it doesn't provide access to the Prometheus container's filesystem.
     */
    @JsonProperty("credentials")
    public SecretKeySelector getCredentials() {
        return credentials;
    }

    /**
     * SafeAuthorization specifies a subset of the Authorization struct, that is safe for use because it doesn't provide access to the Prometheus container's filesystem.
     */
    @JsonProperty("credentials")
    public void setCredentials(SecretKeySelector credentials) {
        this.credentials = credentials;
    }

    /**
     * type defines the authentication type. The value is case-insensitive.<br><p> <br><p> "Basic" is not a supported value.<br><p> <br><p> Default: "Bearer"
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type defines the authentication type. The value is case-insensitive.<br><p> <br><p> "Basic" is not a supported value.<br><p> <br><p> Default: "Bearer"
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public SafeAuthorizationBuilder edit() {
        return new SafeAuthorizationBuilder(this);
    }

    @JsonIgnore
    public SafeAuthorizationBuilder toBuilder() {
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
        if (!(o instanceof SafeAuthorization)) {
            return false;
        }
        SafeAuthorization other = (SafeAuthorization) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$credentials = this.getCredentials();
        Object other$credentials = other.getCredentials();
        if (this$credentials == null ? other$credentials != null : !this$credentials.equals(other$credentials)) {
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
        return other instanceof SafeAuthorization;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $credentials = this.getCredentials();
        result = result * prime + ($credentials == null ? 43 : $credentials.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SafeAuthorization(" + "credentials=" + this.getCredentials() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
