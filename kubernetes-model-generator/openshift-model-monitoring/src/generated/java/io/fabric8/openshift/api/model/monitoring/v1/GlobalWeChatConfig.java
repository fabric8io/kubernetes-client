
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiCorpID",
    "apiSecret",
    "apiURL"
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
public class GlobalWeChatConfig implements Editable<GlobalWeChatConfigBuilder>, KubernetesResource
{

    @JsonProperty("apiCorpID")
    private String apiCorpID;
    @JsonProperty("apiSecret")
    private SecretKeySelector apiSecret;
    @JsonProperty("apiURL")
    private String apiURL;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GlobalWeChatConfig() {
    }

    public GlobalWeChatConfig(String apiCorpID, SecretKeySelector apiSecret, String apiURL) {
        super();
        this.apiCorpID = apiCorpID;
        this.apiSecret = apiSecret;
        this.apiURL = apiURL;
    }

    /**
     * apiCorpID defines the default WeChat API Corporate ID.
     */
    @JsonProperty("apiCorpID")
    public String getApiCorpID() {
        return apiCorpID;
    }

    /**
     * apiCorpID defines the default WeChat API Corporate ID.
     */
    @JsonProperty("apiCorpID")
    public void setApiCorpID(String apiCorpID) {
        this.apiCorpID = apiCorpID;
    }

    @JsonProperty("apiSecret")
    public SecretKeySelector getApiSecret() {
        return apiSecret;
    }

    @JsonProperty("apiSecret")
    public void setApiSecret(SecretKeySelector apiSecret) {
        this.apiSecret = apiSecret;
    }

    /**
     * apiURL defines he default WeChat API URL. The default value is "https://qyapi.weixin.qq.com/cgi-bin/"
     */
    @JsonProperty("apiURL")
    public String getApiURL() {
        return apiURL;
    }

    /**
     * apiURL defines he default WeChat API URL. The default value is "https://qyapi.weixin.qq.com/cgi-bin/"
     */
    @JsonProperty("apiURL")
    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    @JsonIgnore
    public GlobalWeChatConfigBuilder edit() {
        return new GlobalWeChatConfigBuilder(this);
    }

    @JsonIgnore
    public GlobalWeChatConfigBuilder toBuilder() {
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
        if (!(o instanceof GlobalWeChatConfig)) {
            return false;
        }
        GlobalWeChatConfig other = (GlobalWeChatConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiCorpID = this.getApiCorpID();
        Object other$apiCorpID = other.getApiCorpID();
        if (this$apiCorpID == null ? other$apiCorpID != null : !this$apiCorpID.equals(other$apiCorpID)) {
            return false;
        }
        Object this$apiSecret = this.getApiSecret();
        Object other$apiSecret = other.getApiSecret();
        if (this$apiSecret == null ? other$apiSecret != null : !this$apiSecret.equals(other$apiSecret)) {
            return false;
        }
        Object this$apiURL = this.getApiURL();
        Object other$apiURL = other.getApiURL();
        if (this$apiURL == null ? other$apiURL != null : !this$apiURL.equals(other$apiURL)) {
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
        return other instanceof GlobalWeChatConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiCorpID = this.getApiCorpID();
        result = result * prime + ($apiCorpID == null ? 43 : $apiCorpID.hashCode());
        Object $apiSecret = this.getApiSecret();
        result = result * prime + ($apiSecret == null ? 43 : $apiSecret.hashCode());
        Object $apiURL = this.getApiURL();
        result = result * prime + ($apiURL == null ? 43 : $apiURL.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GlobalWeChatConfig(" + "apiCorpID=" + this.getApiCorpID() + ", apiSecret=" + this.getApiSecret() + ", apiURL=" + this.getApiURL() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
