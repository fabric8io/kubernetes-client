
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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LDAPIdentityProvider)) {
            return false;
        }
        LDAPIdentityProvider other = (LDAPIdentityProvider) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$attributes = this.getAttributes();
        Object other$attributes = other.getAttributes();
        if (this$attributes == null ? other$attributes != null : !this$attributes.equals(other$attributes)) {
            return false;
        }
        Object this$bindDN = this.getBindDN();
        Object other$bindDN = other.getBindDN();
        if (this$bindDN == null ? other$bindDN != null : !this$bindDN.equals(other$bindDN)) {
            return false;
        }
        Object this$bindPassword = this.getBindPassword();
        Object other$bindPassword = other.getBindPassword();
        if (this$bindPassword == null ? other$bindPassword != null : !this$bindPassword.equals(other$bindPassword)) {
            return false;
        }
        Object this$ca = this.getCa();
        Object other$ca = other.getCa();
        if (this$ca == null ? other$ca != null : !this$ca.equals(other$ca)) {
            return false;
        }
        Object this$insecure = this.getInsecure();
        Object other$insecure = other.getInsecure();
        if (this$insecure == null ? other$insecure != null : !this$insecure.equals(other$insecure)) {
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
        return other instanceof LDAPIdentityProvider;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $attributes = this.getAttributes();
        result = result * prime + ($attributes == null ? 43 : $attributes.hashCode());
        Object $bindDN = this.getBindDN();
        result = result * prime + ($bindDN == null ? 43 : $bindDN.hashCode());
        Object $bindPassword = this.getBindPassword();
        result = result * prime + ($bindPassword == null ? 43 : $bindPassword.hashCode());
        Object $ca = this.getCa();
        result = result * prime + ($ca == null ? 43 : $ca.hashCode());
        Object $insecure = this.getInsecure();
        result = result * prime + ($insecure == null ? 43 : $insecure.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "LDAPIdentityProvider(" + "attributes=" + this.getAttributes() + ", bindDN=" + this.getBindDN() + ", bindPassword=" + this.getBindPassword() + ", ca=" + this.getCa() + ", insecure=" + this.getInsecure() + ", url=" + this.getUrl() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
