
package io.fabric8.openclustermanagement.api.model.multicloudoperatorschannel.apps.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "configMapRef",
    "gates",
    "insecureSkipVerify",
    "pathname",
    "secretRef",
    "sourceNamespaces",
    "type"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class ChannelSpec implements KubernetesResource
{

    @JsonProperty("configMapRef")
    private io.fabric8.kubernetes.api.model.ObjectReference configMapRef;
    @JsonProperty("gates")
    private ChannelGate gates;
    @JsonProperty("insecureSkipVerify")
    private Boolean insecureSkipVerify;
    @JsonProperty("pathname")
    private String pathname;
    @JsonProperty("secretRef")
    private io.fabric8.kubernetes.api.model.ObjectReference secretRef;
    @JsonProperty("sourceNamespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> sourceNamespaces = new ArrayList<String>();
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ChannelSpec() {
    }

    /**
     * 
     * @param gates
     * @param configMapRef
     * @param sourceNamespaces
     * @param insecureSkipVerify
     * @param secretRef
     * @param type
     * @param pathname
     */
    public ChannelSpec(io.fabric8.kubernetes.api.model.ObjectReference configMapRef, ChannelGate gates, Boolean insecureSkipVerify, String pathname, io.fabric8.kubernetes.api.model.ObjectReference secretRef, List<String> sourceNamespaces, String type) {
        super();
        this.configMapRef = configMapRef;
        this.gates = gates;
        this.insecureSkipVerify = insecureSkipVerify;
        this.pathname = pathname;
        this.secretRef = secretRef;
        this.sourceNamespaces = sourceNamespaces;
        this.type = type;
    }

    @JsonProperty("configMapRef")
    public io.fabric8.kubernetes.api.model.ObjectReference getConfigMapRef() {
        return configMapRef;
    }

    @JsonProperty("configMapRef")
    public void setConfigMapRef(io.fabric8.kubernetes.api.model.ObjectReference configMapRef) {
        this.configMapRef = configMapRef;
    }

    @JsonProperty("gates")
    public ChannelGate getGates() {
        return gates;
    }

    @JsonProperty("gates")
    public void setGates(ChannelGate gates) {
        this.gates = gates;
    }

    @JsonProperty("insecureSkipVerify")
    public Boolean getInsecureSkipVerify() {
        return insecureSkipVerify;
    }

    @JsonProperty("insecureSkipVerify")
    public void setInsecureSkipVerify(Boolean insecureSkipVerify) {
        this.insecureSkipVerify = insecureSkipVerify;
    }

    @JsonProperty("pathname")
    public String getPathname() {
        return pathname;
    }

    @JsonProperty("pathname")
    public void setPathname(String pathname) {
        this.pathname = pathname;
    }

    @JsonProperty("secretRef")
    public io.fabric8.kubernetes.api.model.ObjectReference getSecretRef() {
        return secretRef;
    }

    @JsonProperty("secretRef")
    public void setSecretRef(io.fabric8.kubernetes.api.model.ObjectReference secretRef) {
        this.secretRef = secretRef;
    }

    @JsonProperty("sourceNamespaces")
    public List<String> getSourceNamespaces() {
        return sourceNamespaces;
    }

    @JsonProperty("sourceNamespaces")
    public void setSourceNamespaces(List<String> sourceNamespaces) {
        this.sourceNamespaces = sourceNamespaces;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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
