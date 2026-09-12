
package io.fabric8.certmanager.api.model.v1;

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
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
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
 * VenafiCloud defines connection configuration details for CyberArk Certificate Manager SaaS
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiTokenSecretRef",
    "url"
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
public class VenafiCloud implements Editable<VenafiCloudBuilder>, KubernetesResource
{

    @JsonProperty("apiTokenSecretRef")
    private SecretKeySelector apiTokenSecretRef;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VenafiCloud() {
    }

    public VenafiCloud(SecretKeySelector apiTokenSecretRef, String url) {
        super();
        this.apiTokenSecretRef = apiTokenSecretRef;
        this.url = url;
    }

    /**
     * VenafiCloud defines connection configuration details for CyberArk Certificate Manager SaaS
     */
    @JsonProperty("apiTokenSecretRef")
    public SecretKeySelector getApiTokenSecretRef() {
        return apiTokenSecretRef;
    }

    /**
     * VenafiCloud defines connection configuration details for CyberArk Certificate Manager SaaS
     */
    @JsonProperty("apiTokenSecretRef")
    public void setApiTokenSecretRef(SecretKeySelector apiTokenSecretRef) {
        this.apiTokenSecretRef = apiTokenSecretRef;
    }

    /**
     * URL is the base URL for CyberArk Certificate Manager SaaS. Defaults to "https://api.venafi.cloud/".
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * URL is the base URL for CyberArk Certificate Manager SaaS. Defaults to "https://api.venafi.cloud/".
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public VenafiCloudBuilder edit() {
        return new VenafiCloudBuilder(this);
    }

    @JsonIgnore
    public VenafiCloudBuilder toBuilder() {
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
        if (!(o instanceof VenafiCloud)) {
            return false;
        }
        VenafiCloud other = (VenafiCloud) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiTokenSecretRef = this.getApiTokenSecretRef();
        Object other$apiTokenSecretRef = other.getApiTokenSecretRef();
        if (this$apiTokenSecretRef == null ? other$apiTokenSecretRef != null : !this$apiTokenSecretRef.equals(other$apiTokenSecretRef)) {
            return false;
        }
        Object this$url = this.getUrl();
        Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
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
        return other instanceof VenafiCloud;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiTokenSecretRef = this.getApiTokenSecretRef();
        result = result * prime + ($apiTokenSecretRef == null ? 43 : $apiTokenSecretRef.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VenafiCloud(" + "apiTokenSecretRef=" + this.getApiTokenSecretRef() + ", url=" + this.getUrl() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
