
package io.fabric8.openshift.api.model.config.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * BasicAuthPasswordIdentityProvider provides identities for users authenticating using HTTP basic auth credentials
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ca",
    "tlsClientCert",
    "tlsClientKey",
    "url"
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class BasicAuthIdentityProvider implements Editable<BasicAuthIdentityProviderBuilder>, KubernetesResource
{

    @JsonProperty("ca")
    private ConfigMapNameReference ca;
    @JsonProperty("tlsClientCert")
    private SecretNameReference tlsClientCert;
    @JsonProperty("tlsClientKey")
    private SecretNameReference tlsClientKey;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BasicAuthIdentityProvider() {
    }

    public BasicAuthIdentityProvider(ConfigMapNameReference ca, SecretNameReference tlsClientCert, SecretNameReference tlsClientKey, String url) {
        super();
        this.ca = ca;
        this.tlsClientCert = tlsClientCert;
        this.tlsClientKey = tlsClientKey;
        this.url = url;
    }

    /**
     * BasicAuthPasswordIdentityProvider provides identities for users authenticating using HTTP basic auth credentials
     */
    @JsonProperty("ca")
    public ConfigMapNameReference getCa() {
        return ca;
    }

    /**
     * BasicAuthPasswordIdentityProvider provides identities for users authenticating using HTTP basic auth credentials
     */
    @JsonProperty("ca")
    public void setCa(ConfigMapNameReference ca) {
        this.ca = ca;
    }

    /**
     * BasicAuthPasswordIdentityProvider provides identities for users authenticating using HTTP basic auth credentials
     */
    @JsonProperty("tlsClientCert")
    public SecretNameReference getTlsClientCert() {
        return tlsClientCert;
    }

    /**
     * BasicAuthPasswordIdentityProvider provides identities for users authenticating using HTTP basic auth credentials
     */
    @JsonProperty("tlsClientCert")
    public void setTlsClientCert(SecretNameReference tlsClientCert) {
        this.tlsClientCert = tlsClientCert;
    }

    /**
     * BasicAuthPasswordIdentityProvider provides identities for users authenticating using HTTP basic auth credentials
     */
    @JsonProperty("tlsClientKey")
    public SecretNameReference getTlsClientKey() {
        return tlsClientKey;
    }

    /**
     * BasicAuthPasswordIdentityProvider provides identities for users authenticating using HTTP basic auth credentials
     */
    @JsonProperty("tlsClientKey")
    public void setTlsClientKey(SecretNameReference tlsClientKey) {
        this.tlsClientKey = tlsClientKey;
    }

    /**
     * url is the remote URL to connect to
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * url is the remote URL to connect to
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public BasicAuthIdentityProviderBuilder edit() {
        return new BasicAuthIdentityProviderBuilder(this);
    }

    @JsonIgnore
    public BasicAuthIdentityProviderBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
