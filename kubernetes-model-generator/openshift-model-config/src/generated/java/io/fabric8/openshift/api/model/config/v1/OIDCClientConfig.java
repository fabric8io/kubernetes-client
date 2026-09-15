
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * OIDCClientConfig configures how platform clients interact with identity providers as an authentication method
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clientID",
    "clientSecret",
    "componentName",
    "componentNamespace",
    "extraScopes"
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
public class OIDCClientConfig implements Editable<OIDCClientConfigBuilder>, KubernetesResource
{

    @JsonProperty("clientID")
    private String clientID;
    @JsonProperty("clientSecret")
    private SecretNameReference clientSecret;
    @JsonProperty("componentName")
    private String componentName;
    @JsonProperty("componentNamespace")
    private String componentNamespace;
    @JsonProperty("extraScopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> extraScopes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OIDCClientConfig() {
    }

    public OIDCClientConfig(String clientID, SecretNameReference clientSecret, String componentName, String componentNamespace, List<String> extraScopes) {
        super();
        this.clientID = clientID;
        this.clientSecret = clientSecret;
        this.componentName = componentName;
        this.componentNamespace = componentNamespace;
        this.extraScopes = extraScopes;
    }

    /**
     * clientID is a required field that configures the client identifier, from the identity provider, that the platform component uses for authentication requests made to the identity provider. The identity provider must accept this identifier for platform components to be able to use the identity provider as an authentication mode.<br><p> <br><p> clientID must not be an empty string ("").
     */
    @JsonProperty("clientID")
    public String getClientID() {
        return clientID;
    }

    /**
     * clientID is a required field that configures the client identifier, from the identity provider, that the platform component uses for authentication requests made to the identity provider. The identity provider must accept this identifier for platform components to be able to use the identity provider as an authentication mode.<br><p> <br><p> clientID must not be an empty string ("").
     */
    @JsonProperty("clientID")
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    /**
     * OIDCClientConfig configures how platform clients interact with identity providers as an authentication method
     */
    @JsonProperty("clientSecret")
    public SecretNameReference getClientSecret() {
        return clientSecret;
    }

    /**
     * OIDCClientConfig configures how platform clients interact with identity providers as an authentication method
     */
    @JsonProperty("clientSecret")
    public void setClientSecret(SecretNameReference clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * componentName is a required field that specifies the name of the platform component being configured to use the identity provider as an authentication mode. It is used in combination with componentNamespace as a unique identifier.<br><p> <br><p> componentName must not be an empty string ("") and must not exceed 256 characters in length.
     */
    @JsonProperty("componentName")
    public String getComponentName() {
        return componentName;
    }

    /**
     * componentName is a required field that specifies the name of the platform component being configured to use the identity provider as an authentication mode. It is used in combination with componentNamespace as a unique identifier.<br><p> <br><p> componentName must not be an empty string ("") and must not exceed 256 characters in length.
     */
    @JsonProperty("componentName")
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    /**
     * componentNamespace is a required field that specifies the namespace in which the platform component being configured to use the identity provider as an authentication mode is running. It is used in combination with componentName as a unique identifier.<br><p> <br><p> componentNamespace must not be an empty string ("") and must not exceed 63 characters in length.
     */
    @JsonProperty("componentNamespace")
    public String getComponentNamespace() {
        return componentNamespace;
    }

    /**
     * componentNamespace is a required field that specifies the namespace in which the platform component being configured to use the identity provider as an authentication mode is running. It is used in combination with componentName as a unique identifier.<br><p> <br><p> componentNamespace must not be an empty string ("") and must not exceed 63 characters in length.
     */
    @JsonProperty("componentNamespace")
    public void setComponentNamespace(String componentNamespace) {
        this.componentNamespace = componentNamespace;
    }

    /**
     * extraScopes is an optional field that configures the extra scopes that should be requested by the platform component when making authentication requests to the identity provider. This is useful if you have configured claim mappings that requires specific scopes to be requested beyond the standard OIDC scopes.<br><p> <br><p> When omitted, no additional scopes are requested.
     */
    @JsonProperty("extraScopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExtraScopes() {
        return extraScopes;
    }

    /**
     * extraScopes is an optional field that configures the extra scopes that should be requested by the platform component when making authentication requests to the identity provider. This is useful if you have configured claim mappings that requires specific scopes to be requested beyond the standard OIDC scopes.<br><p> <br><p> When omitted, no additional scopes are requested.
     */
    @JsonProperty("extraScopes")
    public void setExtraScopes(List<String> extraScopes) {
        this.extraScopes = extraScopes;
    }

    @JsonIgnore
    public OIDCClientConfigBuilder edit() {
        return new OIDCClientConfigBuilder(this);
    }

    @JsonIgnore
    public OIDCClientConfigBuilder toBuilder() {
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
        if (!(o instanceof OIDCClientConfig)) {
            return false;
        }
        OIDCClientConfig other = (OIDCClientConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clientID = this.getClientID();
        Object other$clientID = other.getClientID();
        if (this$clientID == null ? other$clientID != null : !this$clientID.equals(other$clientID)) {
            return false;
        }
        Object this$clientSecret = this.getClientSecret();
        Object other$clientSecret = other.getClientSecret();
        if (this$clientSecret == null ? other$clientSecret != null : !this$clientSecret.equals(other$clientSecret)) {
            return false;
        }
        Object this$componentName = this.getComponentName();
        Object other$componentName = other.getComponentName();
        if (this$componentName == null ? other$componentName != null : !this$componentName.equals(other$componentName)) {
            return false;
        }
        Object this$componentNamespace = this.getComponentNamespace();
        Object other$componentNamespace = other.getComponentNamespace();
        if (this$componentNamespace == null ? other$componentNamespace != null : !this$componentNamespace.equals(other$componentNamespace)) {
            return false;
        }
        Object this$extraScopes = this.getExtraScopes();
        Object other$extraScopes = other.getExtraScopes();
        if (this$extraScopes == null ? other$extraScopes != null : !this$extraScopes.equals(other$extraScopes)) {
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
        return other instanceof OIDCClientConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clientID = this.getClientID();
        result = result * prime + ($clientID == null ? 43 : $clientID.hashCode());
        Object $clientSecret = this.getClientSecret();
        result = result * prime + ($clientSecret == null ? 43 : $clientSecret.hashCode());
        Object $componentName = this.getComponentName();
        result = result * prime + ($componentName == null ? 43 : $componentName.hashCode());
        Object $componentNamespace = this.getComponentNamespace();
        result = result * prime + ($componentNamespace == null ? 43 : $componentNamespace.hashCode());
        Object $extraScopes = this.getExtraScopes();
        result = result * prime + ($extraScopes == null ? 43 : $extraScopes.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OIDCClientConfig(" + "clientID=" + this.getClientID() + ", clientSecret=" + this.getClientSecret() + ", componentName=" + this.getComponentName() + ", componentNamespace=" + this.getComponentNamespace() + ", extraScopes=" + this.getExtraScopes() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
