
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
 * LDAPPasswordIdentityProvider provides identities for users authenticating using LDAP credentials
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attributes",
    "bindDN",
    "bindPassword",
    "ca",
    "insecure",
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
public class LDAPIdentityProvider implements Editable<LDAPIdentityProviderBuilder>, KubernetesResource
{

    @JsonProperty("attributes")
    private LDAPAttributeMapping attributes;
    @JsonProperty("bindDN")
    private String bindDN;
    @JsonProperty("bindPassword")
    private SecretNameReference bindPassword;
    @JsonProperty("ca")
    private ConfigMapNameReference ca;
    @JsonProperty("insecure")
    private Boolean insecure;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LDAPIdentityProvider() {
    }

    public LDAPIdentityProvider(LDAPAttributeMapping attributes, String bindDN, SecretNameReference bindPassword, ConfigMapNameReference ca, Boolean insecure, String url) {
        super();
        this.attributes = attributes;
        this.bindDN = bindDN;
        this.bindPassword = bindPassword;
        this.ca = ca;
        this.insecure = insecure;
        this.url = url;
    }

    /**
     * LDAPPasswordIdentityProvider provides identities for users authenticating using LDAP credentials
     */
    @JsonProperty("attributes")
    public LDAPAttributeMapping getAttributes() {
        return attributes;
    }

    /**
     * LDAPPasswordIdentityProvider provides identities for users authenticating using LDAP credentials
     */
    @JsonProperty("attributes")
    public void setAttributes(LDAPAttributeMapping attributes) {
        this.attributes = attributes;
    }

    /**
     * bindDN is an optional DN to bind with during the search phase.
     */
    @JsonProperty("bindDN")
    public String getBindDN() {
        return bindDN;
    }

    /**
     * bindDN is an optional DN to bind with during the search phase.
     */
    @JsonProperty("bindDN")
    public void setBindDN(String bindDN) {
        this.bindDN = bindDN;
    }

    /**
     * LDAPPasswordIdentityProvider provides identities for users authenticating using LDAP credentials
     */
    @JsonProperty("bindPassword")
    public SecretNameReference getBindPassword() {
        return bindPassword;
    }

    /**
     * LDAPPasswordIdentityProvider provides identities for users authenticating using LDAP credentials
     */
    @JsonProperty("bindPassword")
    public void setBindPassword(SecretNameReference bindPassword) {
        this.bindPassword = bindPassword;
    }

    /**
     * LDAPPasswordIdentityProvider provides identities for users authenticating using LDAP credentials
     */
    @JsonProperty("ca")
    public ConfigMapNameReference getCa() {
        return ca;
    }

    /**
     * LDAPPasswordIdentityProvider provides identities for users authenticating using LDAP credentials
     */
    @JsonProperty("ca")
    public void setCa(ConfigMapNameReference ca) {
        this.ca = ca;
    }

    /**
     * insecure, if true, indicates the connection should not use TLS WARNING: Should not be set to `true` with the URL scheme "ldaps://" as "ldaps://" URLs always<br><p>          attempt to connect using TLS, even when `insecure` is set to `true`<br><p> When `true`, "ldap://" URLS connect insecurely. When `false`, "ldap://" URLs are upgraded to a TLS connection using StartTLS as specified in https://tools.ietf.org/html/rfc2830.
     */
    @JsonProperty("insecure")
    public Boolean getInsecure() {
        return insecure;
    }

    /**
     * insecure, if true, indicates the connection should not use TLS WARNING: Should not be set to `true` with the URL scheme "ldaps://" as "ldaps://" URLs always<br><p>          attempt to connect using TLS, even when `insecure` is set to `true`<br><p> When `true`, "ldap://" URLS connect insecurely. When `false`, "ldap://" URLs are upgraded to a TLS connection using StartTLS as specified in https://tools.ietf.org/html/rfc2830.
     */
    @JsonProperty("insecure")
    public void setInsecure(Boolean insecure) {
        this.insecure = insecure;
    }

    /**
     * url is an RFC 2255 URL which specifies the LDAP search parameters to use. The syntax of the URL is: ldap://host:port/basedn?attribute?scope?filter
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * url is an RFC 2255 URL which specifies the LDAP search parameters to use. The syntax of the URL is: ldap://host:port/basedn?attribute?scope?filter
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public LDAPIdentityProviderBuilder edit() {
        return new LDAPIdentityProviderBuilder(this);
    }

    @JsonIgnore
    public LDAPIdentityProviderBuilder toBuilder() {
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
