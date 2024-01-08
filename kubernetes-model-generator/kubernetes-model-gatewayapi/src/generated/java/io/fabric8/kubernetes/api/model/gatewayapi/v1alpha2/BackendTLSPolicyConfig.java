
package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "caCertRefs",
    "hostname",
    "wellKnownCACerts"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class BackendTLSPolicyConfig implements Editable<BackendTLSPolicyConfigBuilder> , KubernetesResource
{

    @JsonProperty("caCertRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.gatewayapi.v1.LocalObjectReference> caCertRefs = new ArrayList<io.fabric8.kubernetes.api.model.gatewayapi.v1.LocalObjectReference>();
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("wellKnownCACerts")
    private String wellKnownCACerts;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BackendTLSPolicyConfig() {
    }

    public BackendTLSPolicyConfig(List<io.fabric8.kubernetes.api.model.gatewayapi.v1.LocalObjectReference> caCertRefs, String hostname, String wellKnownCACerts) {
        super();
        this.caCertRefs = caCertRefs;
        this.hostname = hostname;
        this.wellKnownCACerts = wellKnownCACerts;
    }

    @JsonProperty("caCertRefs")
    public List<io.fabric8.kubernetes.api.model.gatewayapi.v1.LocalObjectReference> getCaCertRefs() {
        return caCertRefs;
    }

    @JsonProperty("caCertRefs")
    public void setCaCertRefs(List<io.fabric8.kubernetes.api.model.gatewayapi.v1.LocalObjectReference> caCertRefs) {
        this.caCertRefs = caCertRefs;
    }

    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @JsonProperty("wellKnownCACerts")
    public String getWellKnownCACerts() {
        return wellKnownCACerts;
    }

    @JsonProperty("wellKnownCACerts")
    public void setWellKnownCACerts(String wellKnownCACerts) {
        this.wellKnownCACerts = wellKnownCACerts;
    }

    @JsonIgnore
    public BackendTLSPolicyConfigBuilder edit() {
        return new BackendTLSPolicyConfigBuilder(this);
    }

    @JsonIgnore
    public BackendTLSPolicyConfigBuilder toBuilder() {
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

}
