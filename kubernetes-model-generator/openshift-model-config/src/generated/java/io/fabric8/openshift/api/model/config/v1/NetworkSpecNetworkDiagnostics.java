
package io.fabric8.openshift.api.model.config.v1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mode",
    "sourcePlacement",
    "targetPlacement"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class NetworkSpecNetworkDiagnostics implements Editable<NetworkSpecNetworkDiagnosticsBuilder> , KubernetesResource
{

    @JsonProperty("mode")
    private String mode;
    @JsonProperty("sourcePlacement")
    private NetworkSpecNDSourcePlacement sourcePlacement;
    @JsonProperty("targetPlacement")
    private NetworkSpecNDTargetPlacement targetPlacement;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NetworkSpecNetworkDiagnostics() {
    }

    public NetworkSpecNetworkDiagnostics(String mode, NetworkSpecNDSourcePlacement sourcePlacement, NetworkSpecNDTargetPlacement targetPlacement) {
        super();
        this.mode = mode;
        this.sourcePlacement = sourcePlacement;
        this.targetPlacement = targetPlacement;
    }

    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonProperty("sourcePlacement")
    public NetworkSpecNDSourcePlacement getSourcePlacement() {
        return sourcePlacement;
    }

    @JsonProperty("sourcePlacement")
    public void setSourcePlacement(NetworkSpecNDSourcePlacement sourcePlacement) {
        this.sourcePlacement = sourcePlacement;
    }

    @JsonProperty("targetPlacement")
    public NetworkSpecNDTargetPlacement getTargetPlacement() {
        return targetPlacement;
    }

    @JsonProperty("targetPlacement")
    public void setTargetPlacement(NetworkSpecNDTargetPlacement targetPlacement) {
        this.targetPlacement = targetPlacement;
    }

    @JsonIgnore
    public NetworkSpecNetworkDiagnosticsBuilder edit() {
        return new NetworkSpecNetworkDiagnosticsBuilder(this);
    }

    @JsonIgnore
    public NetworkSpecNetworkDiagnosticsBuilder toBuilder() {
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
