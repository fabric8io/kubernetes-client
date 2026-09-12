
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
 * GlobalRocketChatConfig configures global Rocket Chat parameters.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiURL",
    "token",
    "tokenID"
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
public class GlobalRocketChatConfig implements Editable<GlobalRocketChatConfigBuilder>, KubernetesResource
{

    @JsonProperty("apiURL")
    private String apiURL;
    @JsonProperty("token")
    private SecretKeySelector token;
    @JsonProperty("tokenID")
    private SecretKeySelector tokenID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GlobalRocketChatConfig() {
    }

    public GlobalRocketChatConfig(String apiURL, SecretKeySelector token, SecretKeySelector tokenID) {
        super();
        this.apiURL = apiURL;
        this.token = token;
        this.tokenID = tokenID;
    }

    /**
     * apiURL defines the default Rocket Chat API URL.<br><p> <br><p> It requires Alertmanager &gt;= v0.28.0.
     */
    @JsonProperty("apiURL")
    public String getApiURL() {
        return apiURL;
    }

    /**
     * apiURL defines the default Rocket Chat API URL.<br><p> <br><p> It requires Alertmanager &gt;= v0.28.0.
     */
    @JsonProperty("apiURL")
    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    /**
     * GlobalRocketChatConfig configures global Rocket Chat parameters.
     */
    @JsonProperty("token")
    public SecretKeySelector getToken() {
        return token;
    }

    /**
     * GlobalRocketChatConfig configures global Rocket Chat parameters.
     */
    @JsonProperty("token")
    public void setToken(SecretKeySelector token) {
        this.token = token;
    }

    /**
     * GlobalRocketChatConfig configures global Rocket Chat parameters.
     */
    @JsonProperty("tokenID")
    public SecretKeySelector getTokenID() {
        return tokenID;
    }

    /**
     * GlobalRocketChatConfig configures global Rocket Chat parameters.
     */
    @JsonProperty("tokenID")
    public void setTokenID(SecretKeySelector tokenID) {
        this.tokenID = tokenID;
    }

    @JsonIgnore
    public GlobalRocketChatConfigBuilder edit() {
        return new GlobalRocketChatConfigBuilder(this);
    }

    @JsonIgnore
    public GlobalRocketChatConfigBuilder toBuilder() {
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
        if (!(o instanceof GlobalRocketChatConfig)) {
            return false;
        }
        GlobalRocketChatConfig other = (GlobalRocketChatConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiURL = this.getApiURL();
        Object other$apiURL = other.getApiURL();
        if (this$apiURL == null ? other$apiURL != null : !this$apiURL.equals(other$apiURL)) {
            return false;
        }
        Object this$token = this.getToken();
        Object other$token = other.getToken();
        if (this$token == null ? other$token != null : !this$token.equals(other$token)) {
            return false;
        }
        Object this$tokenID = this.getTokenID();
        Object other$tokenID = other.getTokenID();
        if (this$tokenID == null ? other$tokenID != null : !this$tokenID.equals(other$tokenID)) {
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
        return other instanceof GlobalRocketChatConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiURL = this.getApiURL();
        result = result * prime + ($apiURL == null ? 43 : $apiURL.hashCode());
        Object $token = this.getToken();
        result = result * prime + ($token == null ? 43 : $token.hashCode());
        Object $tokenID = this.getTokenID();
        result = result * prime + ($tokenID == null ? 43 : $tokenID.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GlobalRocketChatConfig(" + "apiURL=" + this.getApiURL() + ", token=" + this.getToken() + ", tokenID=" + this.getTokenID() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
