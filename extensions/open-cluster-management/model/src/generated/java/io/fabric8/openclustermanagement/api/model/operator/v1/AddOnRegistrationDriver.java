
package io.fabric8.openclustermanagement.api.model.operator.v1;

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
    "authType",
    "token"
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
public class AddOnRegistrationDriver implements Editable<AddOnRegistrationDriverBuilder>, KubernetesResource
{

    @JsonProperty("authType")
    private String authType;
    @JsonProperty("token")
    private TokenConfig token;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AddOnRegistrationDriver() {
    }

    public AddOnRegistrationDriver(String authType, TokenConfig token) {
        super();
        this.authType = authType;
        this.token = token;
    }

    /**
     * AuthType is the authentication driver used for add-on registration. Possible values are csr and token. Currently, this field only affects kubeClient type add-on registration. The csr type add-on registration always uses csr driver. In the future, this may be extended to customize authentication for csr type add-on registration as well.
     */
    @JsonProperty("authType")
    public String getAuthType() {
        return authType;
    }

    /**
     * AuthType is the authentication driver used for add-on registration. Possible values are csr and token. Currently, this field only affects kubeClient type add-on registration. The csr type add-on registration always uses csr driver. In the future, this may be extended to customize authentication for csr type add-on registration as well.
     */
    @JsonProperty("authType")
    public void setAuthType(String authType) {
        this.authType = authType;
    }

    @JsonProperty("token")
    public TokenConfig getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(TokenConfig token) {
        this.token = token;
    }

    @JsonIgnore
    public AddOnRegistrationDriverBuilder edit() {
        return new AddOnRegistrationDriverBuilder(this);
    }

    @JsonIgnore
    public AddOnRegistrationDriverBuilder toBuilder() {
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
        if (!(o instanceof AddOnRegistrationDriver)) {
            return false;
        }
        AddOnRegistrationDriver other = (AddOnRegistrationDriver) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$authType = this.getAuthType();
        Object other$authType = other.getAuthType();
        if (this$authType == null ? other$authType != null : !this$authType.equals(other$authType)) {
            return false;
        }
        Object this$token = this.getToken();
        Object other$token = other.getToken();
        if (this$token == null ? other$token != null : !this$token.equals(other$token)) {
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
        return other instanceof AddOnRegistrationDriver;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $authType = this.getAuthType();
        result = result * prime + ($authType == null ? 43 : $authType.hashCode());
        Object $token = this.getToken();
        result = result * prime + ($token == null ? 43 : $token.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AddOnRegistrationDriver(" + "authType=" + this.getAuthType() + ", token=" + this.getToken() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
