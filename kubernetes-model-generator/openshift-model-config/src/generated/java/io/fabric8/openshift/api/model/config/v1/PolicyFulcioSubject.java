
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * PolicyFulcioSubject defines the OIDC issuer and the email of the Fulcio authentication configuration.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "oidcIssuer",
    "signedEmail"
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
public class PolicyFulcioSubject implements Editable<PolicyFulcioSubjectBuilder>, KubernetesResource
{

    @JsonProperty("oidcIssuer")
    private String oidcIssuer;
    @JsonProperty("signedEmail")
    private String signedEmail;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PolicyFulcioSubject() {
    }

    public PolicyFulcioSubject(String oidcIssuer, String signedEmail) {
        super();
        this.oidcIssuer = oidcIssuer;
        this.signedEmail = signedEmail;
    }

    /**
     * oidcIssuer is a required filed contains the expected OIDC issuer. The oidcIssuer must be a valid URL and at most 2048 characters in length. It will be verified that the Fulcio-issued certificate contains a (Fulcio-defined) certificate extension pointing at this OIDC issuer URL. When Fulcio issues certificates, it includes a value based on an URL inside the client-provided ID token. Example: "https://expected.OIDC.issuer/"
     */
    @JsonProperty("oidcIssuer")
    public String getOidcIssuer() {
        return oidcIssuer;
    }

    /**
     * oidcIssuer is a required filed contains the expected OIDC issuer. The oidcIssuer must be a valid URL and at most 2048 characters in length. It will be verified that the Fulcio-issued certificate contains a (Fulcio-defined) certificate extension pointing at this OIDC issuer URL. When Fulcio issues certificates, it includes a value based on an URL inside the client-provided ID token. Example: "https://expected.OIDC.issuer/"
     */
    @JsonProperty("oidcIssuer")
    public void setOidcIssuer(String oidcIssuer) {
        this.oidcIssuer = oidcIssuer;
    }

    /**
     * signedEmail is a required field holds the email address that the Fulcio certificate is issued for. The signedEmail must be a valid email address and at most 320 characters in length. Example: "expected-signing-user@example.com"
     */
    @JsonProperty("signedEmail")
    public String getSignedEmail() {
        return signedEmail;
    }

    /**
     * signedEmail is a required field holds the email address that the Fulcio certificate is issued for. The signedEmail must be a valid email address and at most 320 characters in length. Example: "expected-signing-user@example.com"
     */
    @JsonProperty("signedEmail")
    public void setSignedEmail(String signedEmail) {
        this.signedEmail = signedEmail;
    }

    @JsonIgnore
    public PolicyFulcioSubjectBuilder edit() {
        return new PolicyFulcioSubjectBuilder(this);
    }

    @JsonIgnore
    public PolicyFulcioSubjectBuilder toBuilder() {
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
