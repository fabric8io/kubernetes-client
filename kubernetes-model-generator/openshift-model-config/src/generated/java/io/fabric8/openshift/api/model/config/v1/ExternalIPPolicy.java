
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
 * ExternalIPPolicy configures exactly which IPs are allowed for the ExternalIP field in a Service. If the zero struct is supplied, then none are permitted. The policy controller always allows automatically assigned external IPs.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowedCIDRs",
    "rejectedCIDRs"
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
public class ExternalIPPolicy implements Editable<ExternalIPPolicyBuilder>, KubernetesResource
{

    @JsonProperty("allowedCIDRs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowedCIDRs = new ArrayList<>();
    @JsonProperty("rejectedCIDRs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> rejectedCIDRs = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ExternalIPPolicy() {
    }

    public ExternalIPPolicy(List<String> allowedCIDRs, List<String> rejectedCIDRs) {
        super();
        this.allowedCIDRs = allowedCIDRs;
        this.rejectedCIDRs = rejectedCIDRs;
    }

    /**
     * allowedCIDRs is the list of allowed CIDRs.
     */
    @JsonProperty("allowedCIDRs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowedCIDRs() {
        return allowedCIDRs;
    }

    /**
     * allowedCIDRs is the list of allowed CIDRs.
     */
    @JsonProperty("allowedCIDRs")
    public void setAllowedCIDRs(List<String> allowedCIDRs) {
        this.allowedCIDRs = allowedCIDRs;
    }

    /**
     * rejectedCIDRs is the list of disallowed CIDRs. These take precedence over allowedCIDRs.
     */
    @JsonProperty("rejectedCIDRs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRejectedCIDRs() {
        return rejectedCIDRs;
    }

    /**
     * rejectedCIDRs is the list of disallowed CIDRs. These take precedence over allowedCIDRs.
     */
    @JsonProperty("rejectedCIDRs")
    public void setRejectedCIDRs(List<String> rejectedCIDRs) {
        this.rejectedCIDRs = rejectedCIDRs;
    }

    @JsonIgnore
    public ExternalIPPolicyBuilder edit() {
        return new ExternalIPPolicyBuilder(this);
    }

    @JsonIgnore
    public ExternalIPPolicyBuilder toBuilder() {
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
