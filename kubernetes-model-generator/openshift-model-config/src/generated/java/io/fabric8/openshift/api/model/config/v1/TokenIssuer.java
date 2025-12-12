
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
    "audiences",
    "issuerCertificateAuthority",
    "issuerURL"
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
public class TokenIssuer implements Editable<TokenIssuerBuilder>, KubernetesResource
{

    @JsonProperty("audiences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> audiences = new ArrayList<>();
    @JsonProperty("issuerCertificateAuthority")
    private ConfigMapNameReference issuerCertificateAuthority;
    @JsonProperty("issuerURL")
    private String issuerURL;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TokenIssuer() {
    }

    public TokenIssuer(List<String> audiences, ConfigMapNameReference issuerCertificateAuthority, String issuerURL) {
        super();
        this.audiences = audiences;
        this.issuerCertificateAuthority = issuerCertificateAuthority;
        this.issuerURL = issuerURL;
    }

    /**
     * audiences is a required field that configures the acceptable audiences the JWT token, issued by the identity provider, must be issued to. At least one of the entries must match the 'aud' claim in the JWT token.<br><p> <br><p> audiences must contain at least one entry and must not exceed ten entries.
     */
    @JsonProperty("audiences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAudiences() {
        return audiences;
    }

    /**
     * audiences is a required field that configures the acceptable audiences the JWT token, issued by the identity provider, must be issued to. At least one of the entries must match the 'aud' claim in the JWT token.<br><p> <br><p> audiences must contain at least one entry and must not exceed ten entries.
     */
    @JsonProperty("audiences")
    public void setAudiences(List<String> audiences) {
        this.audiences = audiences;
    }

    @JsonProperty("issuerCertificateAuthority")
    public ConfigMapNameReference getIssuerCertificateAuthority() {
        return issuerCertificateAuthority;
    }

    @JsonProperty("issuerCertificateAuthority")
    public void setIssuerCertificateAuthority(ConfigMapNameReference issuerCertificateAuthority) {
        this.issuerCertificateAuthority = issuerCertificateAuthority;
    }

    /**
     * issuerURL is a required field that configures the URL used to issue tokens by the identity provider. The Kubernetes API server determines how authentication tokens should be handled by matching the 'iss' claim in the JWT to the issuerURL of configured identity providers.<br><p> <br><p> Must be at least 1 character and must not exceed 512 characters in length. Must be a valid URL that uses the 'https' scheme and does not contain a query, fragment or user.
     */
    @JsonProperty("issuerURL")
    public String getIssuerURL() {
        return issuerURL;
    }

    /**
     * issuerURL is a required field that configures the URL used to issue tokens by the identity provider. The Kubernetes API server determines how authentication tokens should be handled by matching the 'iss' claim in the JWT to the issuerURL of configured identity providers.<br><p> <br><p> Must be at least 1 character and must not exceed 512 characters in length. Must be a valid URL that uses the 'https' scheme and does not contain a query, fragment or user.
     */
    @JsonProperty("issuerURL")
    public void setIssuerURL(String issuerURL) {
        this.issuerURL = issuerURL;
    }

    @JsonIgnore
    public TokenIssuerBuilder edit() {
        return new TokenIssuerBuilder(this);
    }

    @JsonIgnore
    public TokenIssuerBuilder toBuilder() {
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
