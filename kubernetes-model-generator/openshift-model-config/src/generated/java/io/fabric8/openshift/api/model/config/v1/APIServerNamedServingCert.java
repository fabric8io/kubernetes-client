
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
 * APIServerNamedServingCert maps a server DNS name, as understood by a client, to a certificate.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "names",
    "servingCertificate"
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

}
