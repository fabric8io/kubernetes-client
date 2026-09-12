
package io.fabric8.certmanager.api.model.acme.v1;

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
import io.fabric8.certmanager.api.model.meta.v1.IssuerReference;
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
    "authorizationURL",
    "dnsName",
    "issuerRef",
    "key",
    "solver",
    "token",
    "type",
    "url",
    "wildcard"
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
public class ChallengeSpec implements Editable<ChallengeSpecBuilder>, KubernetesResource
{

    @JsonProperty("authorizationURL")
    private String authorizationURL;
    @JsonProperty("dnsName")
    private String dnsName;
    @JsonProperty("issuerRef")
    private IssuerReference issuerRef;
    @JsonProperty("key")
    private String key;
    @JsonProperty("solver")
    private ACMEChallengeSolver solver;
    @JsonProperty("token")
    private String token;
    @JsonProperty("type")
    private String type;
    @JsonProperty("url")
    private String url;
    @JsonProperty("wildcard")
    private Boolean wildcard;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ChallengeSpec() {
    }

    public ChallengeSpec(String authorizationURL, String dnsName, IssuerReference issuerRef, String key, ACMEChallengeSolver solver, String token, String type, String url, Boolean wildcard) {
        super();
        this.authorizationURL = authorizationURL;
        this.dnsName = dnsName;
        this.issuerRef = issuerRef;
        this.key = key;
        this.solver = solver;
        this.token = token;
        this.type = type;
        this.url = url;
        this.wildcard = wildcard;
    }

    /**
     * The URL to the ACME Authorization resource that this challenge is a part of.
     */
    @JsonProperty("authorizationURL")
    public String getAuthorizationURL() {
        return authorizationURL;
    }

    /**
     * The URL to the ACME Authorization resource that this challenge is a part of.
     */
    @JsonProperty("authorizationURL")
    public void setAuthorizationURL(String authorizationURL) {
        this.authorizationURL = authorizationURL;
    }

    /**
     * dnsName is the identifier that this challenge is for, e.g., example.com. If the requested DNSName is a 'wildcard', this field MUST be set to the non-wildcard domain, e.g., for `&#42;.example.com`, it must be `example.com`.
     */
    @JsonProperty("dnsName")
    public String getDnsName() {
        return dnsName;
    }

    /**
     * dnsName is the identifier that this challenge is for, e.g., example.com. If the requested DNSName is a 'wildcard', this field MUST be set to the non-wildcard domain, e.g., for `&#42;.example.com`, it must be `example.com`.
     */
    @JsonProperty("dnsName")
    public void setDnsName(String dnsName) {
        this.dnsName = dnsName;
    }

    @JsonProperty("issuerRef")
    public IssuerReference getIssuerRef() {
        return issuerRef;
    }

    @JsonProperty("issuerRef")
    public void setIssuerRef(IssuerReference issuerRef) {
        this.issuerRef = issuerRef;
    }

    /**
     * The ACME challenge key for this challenge For HTTP01 challenges, this is the value that must be responded with to complete the HTTP01 challenge in the format: `&lt;private key JWK thumbprint&gt;.&lt;key from acme server for challenge&gt;`. For DNS01 challenges, this is the base64 encoded SHA256 sum of the `&lt;private key JWK thumbprint&gt;.&lt;key from acme server for challenge&gt;` text that must be set as the TXT record content.
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * The ACME challenge key for this challenge For HTTP01 challenges, this is the value that must be responded with to complete the HTTP01 challenge in the format: `&lt;private key JWK thumbprint&gt;.&lt;key from acme server for challenge&gt;`. For DNS01 challenges, this is the base64 encoded SHA256 sum of the `&lt;private key JWK thumbprint&gt;.&lt;key from acme server for challenge&gt;` text that must be set as the TXT record content.
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("solver")
    public ACMEChallengeSolver getSolver() {
        return solver;
    }

    @JsonProperty("solver")
    public void setSolver(ACMEChallengeSolver solver) {
        this.solver = solver;
    }

    /**
     * The ACME challenge token for this challenge. This is the raw value returned from the ACME server.
     */
    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    /**
     * The ACME challenge token for this challenge. This is the raw value returned from the ACME server.
     */
    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * The type of ACME challenge this resource represents. One of "HTTP-01" or "DNS-01".
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * The type of ACME challenge this resource represents. One of "HTTP-01" or "DNS-01".
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * The URL of the ACME Challenge resource for this challenge. This can be used to lookup details about the status of this challenge.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * The URL of the ACME Challenge resource for this challenge. This can be used to lookup details about the status of this challenge.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * wildcard will be true if this challenge is for a wildcard identifier, for example '&#42;.example.com'.
     */
    @JsonProperty("wildcard")
    public Boolean getWildcard() {
        return wildcard;
    }

    /**
     * wildcard will be true if this challenge is for a wildcard identifier, for example '&#42;.example.com'.
     */
    @JsonProperty("wildcard")
    public void setWildcard(Boolean wildcard) {
        this.wildcard = wildcard;
    }

    @JsonIgnore
    public ChallengeSpecBuilder edit() {
        return new ChallengeSpecBuilder(this);
    }

    @JsonIgnore
    public ChallengeSpecBuilder toBuilder() {
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
        if (!(o instanceof ChallengeSpec)) {
            return false;
        }
        ChallengeSpec other = (ChallengeSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$authorizationURL = this.getAuthorizationURL();
        Object other$authorizationURL = other.getAuthorizationURL();
        if (this$authorizationURL == null ? other$authorizationURL != null : !this$authorizationURL.equals(other$authorizationURL)) {
            return false;
        }
        Object this$dnsName = this.getDnsName();
        Object other$dnsName = other.getDnsName();
        if (this$dnsName == null ? other$dnsName != null : !this$dnsName.equals(other$dnsName)) {
            return false;
        }
        Object this$issuerRef = this.getIssuerRef();
        Object other$issuerRef = other.getIssuerRef();
        if (this$issuerRef == null ? other$issuerRef != null : !this$issuerRef.equals(other$issuerRef)) {
            return false;
        }
        Object this$key = this.getKey();
        Object other$key = other.getKey();
        if (this$key == null ? other$key != null : !this$key.equals(other$key)) {
            return false;
        }
        Object this$solver = this.getSolver();
        Object other$solver = other.getSolver();
        if (this$solver == null ? other$solver != null : !this$solver.equals(other$solver)) {
            return false;
        }
        Object this$token = this.getToken();
        Object other$token = other.getToken();
        if (this$token == null ? other$token != null : !this$token.equals(other$token)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        Object this$url = this.getUrl();
        Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
            return false;
        }
        Object this$wildcard = this.getWildcard();
        Object other$wildcard = other.getWildcard();
        if (this$wildcard == null ? other$wildcard != null : !this$wildcard.equals(other$wildcard)) {
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
        return other instanceof ChallengeSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $authorizationURL = this.getAuthorizationURL();
        result = result * prime + ($authorizationURL == null ? 43 : $authorizationURL.hashCode());
        Object $dnsName = this.getDnsName();
        result = result * prime + ($dnsName == null ? 43 : $dnsName.hashCode());
        Object $issuerRef = this.getIssuerRef();
        result = result * prime + ($issuerRef == null ? 43 : $issuerRef.hashCode());
        Object $key = this.getKey();
        result = result * prime + ($key == null ? 43 : $key.hashCode());
        Object $solver = this.getSolver();
        result = result * prime + ($solver == null ? 43 : $solver.hashCode());
        Object $token = this.getToken();
        result = result * prime + ($token == null ? 43 : $token.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $wildcard = this.getWildcard();
        result = result * prime + ($wildcard == null ? 43 : $wildcard.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ChallengeSpec(" + "authorizationURL=" + this.getAuthorizationURL() + ", dnsName=" + this.getDnsName() + ", issuerRef=" + this.getIssuerRef() + ", key=" + this.getKey() + ", solver=" + this.getSolver() + ", token=" + this.getToken() + ", type=" + this.getType() + ", url=" + this.getUrl() + ", wildcard=" + this.getWildcard() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
