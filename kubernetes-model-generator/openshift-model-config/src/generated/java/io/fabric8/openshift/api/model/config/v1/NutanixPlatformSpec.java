
package io.fabric8.openshift.api.model.config.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "failureDomains",
    "prismCentral",
    "prismElements"
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
public class NutanixPlatformSpec implements Editable<NutanixPlatformSpecBuilder> , KubernetesResource
{

    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NutanixFailureDomain> failureDomains = new ArrayList<>();
    @JsonProperty("prismCentral")
    private NutanixPrismEndpoint prismCentral;
    @JsonProperty("prismElements")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NutanixPrismElementEndpoint> prismElements = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NutanixPlatformSpec() {
    }

    public NutanixPlatformSpec(List<NutanixFailureDomain> failureDomains, NutanixPrismEndpoint prismCentral, List<NutanixPrismElementEndpoint> prismElements) {
        super();
        this.failureDomains = failureDomains;
        this.prismCentral = prismCentral;
        this.prismElements = prismElements;
    }

    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NutanixFailureDomain> getFailureDomains() {
        return failureDomains;
    }

    @JsonProperty("failureDomains")
    public void setFailureDomains(List<NutanixFailureDomain> failureDomains) {
        this.failureDomains = failureDomains;
    }

    @JsonProperty("prismCentral")
    public NutanixPrismEndpoint getPrismCentral() {
        return prismCentral;
    }

    @JsonProperty("prismCentral")
    public void setPrismCentral(NutanixPrismEndpoint prismCentral) {
        this.prismCentral = prismCentral;
    }

    @JsonProperty("prismElements")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NutanixPrismElementEndpoint> getPrismElements() {
        return prismElements;
    }

    @JsonProperty("prismElements")
    public void setPrismElements(List<NutanixPrismElementEndpoint> prismElements) {
        this.prismElements = prismElements;
    }

    @JsonIgnore
    public NutanixPlatformSpecBuilder edit() {
        return new NutanixPlatformSpecBuilder(this);
    }

    @JsonIgnore
    public NutanixPlatformSpecBuilder toBuilder() {
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

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
