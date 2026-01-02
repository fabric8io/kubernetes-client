
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
 * PKICertificateSubject defines the requirements imposed on the subject to which the certificate was issued.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "email",
    "hostname"
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
public class PKICertificateSubject implements Editable<PKICertificateSubjectBuilder>, KubernetesResource
{

    @JsonProperty("email")
    private String email;
    @JsonProperty("hostname")
    private String hostname;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PKICertificateSubject() {
    }

    public PKICertificateSubject(String email, String hostname) {
        super();
        this.email = email;
        this.hostname = hostname;
    }

    /**
     * email specifies the expected email address imposed on the subject to which the certificate was issued, and must match the email address listed in the Subject Alternative Name (SAN) field of the certificate. The email must be a valid email address and at most 320 characters in length.
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * email specifies the expected email address imposed on the subject to which the certificate was issued, and must match the email address listed in the Subject Alternative Name (SAN) field of the certificate. The email must be a valid email address and at most 320 characters in length.
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * hostname specifies the expected hostname imposed on the subject to which the certificate was issued, and it must match the hostname listed in the Subject Alternative Name (SAN) DNS field of the certificate. The hostname must be a valid dns 1123 subdomain name, optionally prefixed by '&#42;.', and at most 253 characters in length. It must consist only of lowercase alphanumeric characters, hyphens, periods and the optional preceding asterisk.
     */
    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    /**
     * hostname specifies the expected hostname imposed on the subject to which the certificate was issued, and it must match the hostname listed in the Subject Alternative Name (SAN) DNS field of the certificate. The hostname must be a valid dns 1123 subdomain name, optionally prefixed by '&#42;.', and at most 253 characters in length. It must consist only of lowercase alphanumeric characters, hyphens, periods and the optional preceding asterisk.
     */
    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @JsonIgnore
    public PKICertificateSubjectBuilder edit() {
        return new PKICertificateSubjectBuilder(this);
    }

    @JsonIgnore
    public PKICertificateSubjectBuilder toBuilder() {
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
