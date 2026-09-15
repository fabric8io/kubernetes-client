
package io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accessKey",
    "secret",
    "secretKey",
    "serviceAccountName"
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
public class Auth implements Editable<AuthBuilder>, KubernetesResource
{

    @JsonProperty("accessKey")
    private String accessKey;
    @JsonProperty("secret")
    private Secret secret;
    @JsonProperty("secretKey")
    private String secretKey;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Auth() {
    }

    public Auth(String accessKey, Secret secret, String secretKey, String serviceAccountName) {
        super();
        this.accessKey = accessKey;
        this.secret = secret;
        this.secretKey = secretKey;
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * AccessKey is the AWS access key ID.
     */
    @JsonProperty("accessKey")
    public String getAccessKey() {
        return accessKey;
    }

    /**
     * AccessKey is the AWS access key ID.
     */
    @JsonProperty("accessKey")
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    @JsonProperty("secret")
    public Secret getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(Secret secret) {
        this.secret = secret;
    }

    /**
     * SecretKey is the AWS secret access key.
     */
    @JsonProperty("secretKey")
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * SecretKey is the AWS secret access key.
     */
    @JsonProperty("secretKey")
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    @JsonIgnore
    public AuthBuilder edit() {
        return new AuthBuilder(this);
    }

    @JsonIgnore
    public AuthBuilder toBuilder() {
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
        if (!(o instanceof Auth)) {
            return false;
        }
        Auth other = (Auth) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$accessKey = this.getAccessKey();
        Object other$accessKey = other.getAccessKey();
        if (this$accessKey == null ? other$accessKey != null : !this$accessKey.equals(other$accessKey)) {
            return false;
        }
        Object this$secret = this.getSecret();
        Object other$secret = other.getSecret();
        if (this$secret == null ? other$secret != null : !this$secret.equals(other$secret)) {
            return false;
        }
        Object this$secretKey = this.getSecretKey();
        Object other$secretKey = other.getSecretKey();
        if (this$secretKey == null ? other$secretKey != null : !this$secretKey.equals(other$secretKey)) {
            return false;
        }
        Object this$serviceAccountName = this.getServiceAccountName();
        Object other$serviceAccountName = other.getServiceAccountName();
        if (this$serviceAccountName == null ? other$serviceAccountName != null : !this$serviceAccountName.equals(other$serviceAccountName)) {
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
        return other instanceof Auth;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $accessKey = this.getAccessKey();
        result = result * prime + ($accessKey == null ? 43 : $accessKey.hashCode());
        Object $secret = this.getSecret();
        result = result * prime + ($secret == null ? 43 : $secret.hashCode());
        Object $secretKey = this.getSecretKey();
        result = result * prime + ($secretKey == null ? 43 : $secretKey.hashCode());
        Object $serviceAccountName = this.getServiceAccountName();
        result = result * prime + ($serviceAccountName == null ? 43 : $serviceAccountName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Auth(" + "accessKey=" + this.getAccessKey() + ", secret=" + this.getSecret() + ", secretKey=" + this.getSecretKey() + ", serviceAccountName=" + this.getServiceAccountName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
