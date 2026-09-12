
package io.fabric8.knative.duck.v1;

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

/**
 * Destination represents a target of an invocation over HTTP.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CACerts",
    "audience",
    "ref",
    "uri"
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
public class Destination implements Editable<DestinationBuilder>, KubernetesResource
{

    @JsonProperty("CACerts")
    private String cACerts;
    @JsonProperty("audience")
    private String audience;
    @JsonProperty("ref")
    private KReference ref;
    @JsonProperty("uri")
    private String uri;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Destination() {
    }

    public Destination(String cACerts, String audience, KReference ref, String uri) {
        super();
        this.cACerts = cACerts;
        this.audience = audience;
        this.ref = ref;
        this.uri = uri;
    }

    /**
     * CACerts are Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468. If set, these CAs are appended to the set of CAs provided by the Addressable target, if any.
     */
    @JsonProperty("CACerts")
    public String getCACerts() {
        return cACerts;
    }

    /**
     * CACerts are Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468. If set, these CAs are appended to the set of CAs provided by the Addressable target, if any.
     */
    @JsonProperty("CACerts")
    public void setCACerts(String cACerts) {
        this.cACerts = cACerts;
    }

    /**
     * Audience is the OIDC audience. This need only be set, if the target is not an Addressable and thus the Audience can't be received from the Addressable itself. In case the Addressable specifies an Audience too, the Destinations Audience takes preference.
     */
    @JsonProperty("audience")
    public String getAudience() {
        return audience;
    }

    /**
     * Audience is the OIDC audience. This need only be set, if the target is not an Addressable and thus the Audience can't be received from the Addressable itself. In case the Addressable specifies an Audience too, the Destinations Audience takes preference.
     */
    @JsonProperty("audience")
    public void setAudience(String audience) {
        this.audience = audience;
    }

    /**
     * Destination represents a target of an invocation over HTTP.
     */
    @JsonProperty("ref")
    public KReference getRef() {
        return ref;
    }

    /**
     * Destination represents a target of an invocation over HTTP.
     */
    @JsonProperty("ref")
    public void setRef(KReference ref) {
        this.ref = ref;
    }

    /**
     * Destination represents a target of an invocation over HTTP.
     */
    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    /**
     * Destination represents a target of an invocation over HTTP.
     */
    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonIgnore
    public DestinationBuilder edit() {
        return new DestinationBuilder(this);
    }

    @JsonIgnore
    public DestinationBuilder toBuilder() {
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
        if (!(o instanceof Destination)) {
            return false;
        }
        Destination other = (Destination) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cACerts = this.getCACerts();
        Object other$cACerts = other.getCACerts();
        if (this$cACerts == null ? other$cACerts != null : !this$cACerts.equals(other$cACerts)) {
            return false;
        }
        Object this$audience = this.getAudience();
        Object other$audience = other.getAudience();
        if (this$audience == null ? other$audience != null : !this$audience.equals(other$audience)) {
            return false;
        }
        Object this$ref = this.getRef();
        Object other$ref = other.getRef();
        if (this$ref == null ? other$ref != null : !this$ref.equals(other$ref)) {
            return false;
        }
        Object this$uri = this.getUri();
        Object other$uri = other.getUri();
        if (this$uri == null ? other$uri != null : !this$uri.equals(other$uri)) {
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
        return other instanceof Destination;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cACerts = this.getCACerts();
        result = result * prime + ($cACerts == null ? 43 : $cACerts.hashCode());
        Object $audience = this.getAudience();
        result = result * prime + ($audience == null ? 43 : $audience.hashCode());
        Object $ref = this.getRef();
        result = result * prime + ($ref == null ? 43 : $ref.hashCode());
        Object $uri = this.getUri();
        result = result * prime + ($uri == null ? 43 : $uri.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Destination(" + "cACerts=" + this.getCACerts() + ", audience=" + this.getAudience() + ", ref=" + this.getRef() + ", uri=" + this.getUri() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
