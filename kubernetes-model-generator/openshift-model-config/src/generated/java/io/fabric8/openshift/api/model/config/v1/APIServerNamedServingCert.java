
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

/**
 * APIServerNamedServingCert maps a server DNS name, as understood by a client, to a certificate.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "names",
    "servingCertificate"
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
public class APIServerNamedServingCert implements Editable<APIServerNamedServingCertBuilder>, KubernetesResource
{

    @JsonProperty("names")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> names = new ArrayList<>();
    @JsonProperty("servingCertificate")
    private SecretNameReference servingCertificate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public APIServerNamedServingCert() {
    }

    public APIServerNamedServingCert(List<String> names, SecretNameReference servingCertificate) {
        super();
        this.names = names;
        this.servingCertificate = servingCertificate;
    }

    /**
     * names is a optional list of explicit DNS names (leading wildcards allowed) that should use this certificate to serve secure traffic. If no names are provided, the implicit names will be extracted from the certificates. Exact names trump over wildcard names. Explicit names defined here trump over extracted implicit names.
     */
    @JsonProperty("names")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNames() {
        return names;
    }

    /**
     * names is a optional list of explicit DNS names (leading wildcards allowed) that should use this certificate to serve secure traffic. If no names are provided, the implicit names will be extracted from the certificates. Exact names trump over wildcard names. Explicit names defined here trump over extracted implicit names.
     */
    @JsonProperty("names")
    public void setNames(List<String> names) {
        this.names = names;
    }

    /**
     * APIServerNamedServingCert maps a server DNS name, as understood by a client, to a certificate.
     */
    @JsonProperty("servingCertificate")
    public SecretNameReference getServingCertificate() {
        return servingCertificate;
    }

    /**
     * APIServerNamedServingCert maps a server DNS name, as understood by a client, to a certificate.
     */
    @JsonProperty("servingCertificate")
    public void setServingCertificate(SecretNameReference servingCertificate) {
        this.servingCertificate = servingCertificate;
    }

    @JsonIgnore
    public APIServerNamedServingCertBuilder edit() {
        return new APIServerNamedServingCertBuilder(this);
    }

    @JsonIgnore
    public APIServerNamedServingCertBuilder toBuilder() {
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
        if (!(o instanceof APIServerNamedServingCert)) {
            return false;
        }
        APIServerNamedServingCert other = (APIServerNamedServingCert) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$names = this.getNames();
        Object other$names = other.getNames();
        if (this$names == null ? other$names != null : !this$names.equals(other$names)) {
            return false;
        }
        Object this$servingCertificate = this.getServingCertificate();
        Object other$servingCertificate = other.getServingCertificate();
        if (this$servingCertificate == null ? other$servingCertificate != null : !this$servingCertificate.equals(other$servingCertificate)) {
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
        return other instanceof APIServerNamedServingCert;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $names = this.getNames();
        result = result * prime + ($names == null ? 43 : $names.hashCode());
        Object $servingCertificate = this.getServingCertificate();
        result = result * prime + ($servingCertificate == null ? 43 : $servingCertificate.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "APIServerNamedServingCert(" + "names=" + this.getNames() + ", servingCertificate=" + this.getServingCertificate() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
