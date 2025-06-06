
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clientID",
    "clientSecret",
    "componentName",
    "componentNamespace",
    "extraScopes"
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
     * ClientID is the identifier of the OIDC client from the OIDC provider
     */
    @JsonProperty("clientID")
    public String getClientID() {
        return clientID;
    }

    /**
     * ClientID is the identifier of the OIDC client from the OIDC provider
     */
    @JsonProperty("clientID")
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    @JsonProperty("clientSecret")
    public SecretNameReference getClientSecret() {
        return clientSecret;
    }

    @JsonProperty("clientSecret")
    public void setClientSecret(SecretNameReference clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * ComponentName is the name of the component that is supposed to consume this client configuration
     */
    @JsonProperty("componentName")
    public String getComponentName() {
        return componentName;
    }

    /**
     * ComponentName is the name of the component that is supposed to consume this client configuration
     */
    @JsonProperty("componentName")
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    /**
     * ComponentNamespace is the namespace of the component that is supposed to consume this client configuration
     */
    @JsonProperty("componentNamespace")
    public String getComponentNamespace() {
        return componentNamespace;
    }

    /**
     * ComponentNamespace is the namespace of the component that is supposed to consume this client configuration
     */
    @JsonProperty("componentNamespace")
    public void setComponentNamespace(String componentNamespace) {
        this.componentNamespace = componentNamespace;
    }

    /**
     * ExtraScopes is an optional set of scopes to request tokens with.
     */
    @JsonProperty("extraScopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExtraScopes() {
        return extraScopes;
    }

    /**
     * ExtraScopes is an optional set of scopes to request tokens with.
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

}
