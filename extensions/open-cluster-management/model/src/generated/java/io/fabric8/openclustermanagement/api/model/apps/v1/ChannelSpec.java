
package io.fabric8.openclustermanagement.api.model.apps.v1;

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

/**
 * ChannelSpec defines the desired state of Channel
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configMapRef",
    "gates",
    "insecureSkipVerify",
    "pathname",
    "secretRef",
    "sourceNamespaces",
    "type"
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
public class ChannelSpec implements Editable<ChannelSpecBuilder>, KubernetesResource
{

    @JsonProperty("configMapRef")
    private ObjectReference configMapRef;
    @JsonProperty("gates")
    private ChannelGate gates;
    @JsonProperty("insecureSkipVerify")
    private Boolean insecureSkipVerify;
    @JsonProperty("pathname")
    private String pathname;
    @JsonProperty("secretRef")
    private ObjectReference secretRef;
    @JsonProperty("sourceNamespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> sourceNamespaces = new ArrayList<>();
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ChannelSpec() {
    }

    public ChannelSpec(ObjectReference configMapRef, ChannelGate gates, Boolean insecureSkipVerify, String pathname, ObjectReference secretRef, List<String> sourceNamespaces, String type) {
        super();
        this.configMapRef = configMapRef;
        this.gates = gates;
        this.insecureSkipVerify = insecureSkipVerify;
        this.pathname = pathname;
        this.secretRef = secretRef;
        this.sourceNamespaces = sourceNamespaces;
        this.type = type;
    }

    /**
     * ChannelSpec defines the desired state of Channel
     */
    @JsonProperty("configMapRef")
    public ObjectReference getConfigMapRef() {
        return configMapRef;
    }

    /**
     * ChannelSpec defines the desired state of Channel
     */
    @JsonProperty("configMapRef")
    public void setConfigMapRef(ObjectReference configMapRef) {
        this.configMapRef = configMapRef;
    }

    /**
     * ChannelSpec defines the desired state of Channel
     */
    @JsonProperty("gates")
    public ChannelGate getGates() {
        return gates;
    }

    /**
     * ChannelSpec defines the desired state of Channel
     */
    @JsonProperty("gates")
    public void setGates(ChannelGate gates) {
        this.gates = gates;
    }

    /**
     * Skip server TLS certificate verification for Git or Helm channel.
     */
    @JsonProperty("insecureSkipVerify")
    public Boolean getInsecureSkipVerify() {
        return insecureSkipVerify;
    }

    /**
     * Skip server TLS certificate verification for Git or Helm channel.
     */
    @JsonProperty("insecureSkipVerify")
    public void setInsecureSkipVerify(Boolean insecureSkipVerify) {
        this.insecureSkipVerify = insecureSkipVerify;
    }

    /**
     * For a `helmrepo` or `github` channel, pathname is the repo URL. For a `objectbucket` channel, pathname is the Object store URL with the name of the bucket.
     */
    @JsonProperty("pathname")
    public String getPathname() {
        return pathname;
    }

    /**
     * For a `helmrepo` or `github` channel, pathname is the repo URL. For a `objectbucket` channel, pathname is the Object store URL with the name of the bucket.
     */
    @JsonProperty("pathname")
    public void setPathname(String pathname) {
        this.pathname = pathname;
    }

    /**
     * ChannelSpec defines the desired state of Channel
     */
    @JsonProperty("secretRef")
    public ObjectReference getSecretRef() {
        return secretRef;
    }

    /**
     * ChannelSpec defines the desired state of Channel
     */
    @JsonProperty("secretRef")
    public void setSecretRef(ObjectReference secretRef) {
        this.secretRef = secretRef;
    }

    /**
     * A list of namespace names from which Deployables can be promoted.
     */
    @JsonProperty("sourceNamespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSourceNamespaces() {
        return sourceNamespaces;
    }

    /**
     * A list of namespace names from which Deployables can be promoted.
     */
    @JsonProperty("sourceNamespaces")
    public void setSourceNamespaces(List<String> sourceNamespaces) {
        this.sourceNamespaces = sourceNamespaces;
    }

    /**
     * ChannelSpec defines the desired state of Channel
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * ChannelSpec defines the desired state of Channel
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public ChannelSpecBuilder edit() {
        return new ChannelSpecBuilder(this);
    }

    @JsonIgnore
    public ChannelSpecBuilder toBuilder() {
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
        if (!(o instanceof ChannelSpec)) {
            return false;
        }
        ChannelSpec other = (ChannelSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$configMapRef = this.getConfigMapRef();
        Object other$configMapRef = other.getConfigMapRef();
        if (this$configMapRef == null ? other$configMapRef != null : !this$configMapRef.equals(other$configMapRef)) {
            return false;
        }
        Object this$gates = this.getGates();
        Object other$gates = other.getGates();
        if (this$gates == null ? other$gates != null : !this$gates.equals(other$gates)) {
            return false;
        }
        Object this$insecureSkipVerify = this.getInsecureSkipVerify();
        Object other$insecureSkipVerify = other.getInsecureSkipVerify();
        if (this$insecureSkipVerify == null ? other$insecureSkipVerify != null : !this$insecureSkipVerify.equals(other$insecureSkipVerify)) {
            return false;
        }
        Object this$pathname = this.getPathname();
        Object other$pathname = other.getPathname();
        if (this$pathname == null ? other$pathname != null : !this$pathname.equals(other$pathname)) {
            return false;
        }
        Object this$secretRef = this.getSecretRef();
        Object other$secretRef = other.getSecretRef();
        if (this$secretRef == null ? other$secretRef != null : !this$secretRef.equals(other$secretRef)) {
            return false;
        }
        Object this$sourceNamespaces = this.getSourceNamespaces();
        Object other$sourceNamespaces = other.getSourceNamespaces();
        if (this$sourceNamespaces == null ? other$sourceNamespaces != null : !this$sourceNamespaces.equals(other$sourceNamespaces)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof ChannelSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $configMapRef = this.getConfigMapRef();
        result = result * prime + ($configMapRef == null ? 43 : $configMapRef.hashCode());
        Object $gates = this.getGates();
        result = result * prime + ($gates == null ? 43 : $gates.hashCode());
        Object $insecureSkipVerify = this.getInsecureSkipVerify();
        result = result * prime + ($insecureSkipVerify == null ? 43 : $insecureSkipVerify.hashCode());
        Object $pathname = this.getPathname();
        result = result * prime + ($pathname == null ? 43 : $pathname.hashCode());
        Object $secretRef = this.getSecretRef();
        result = result * prime + ($secretRef == null ? 43 : $secretRef.hashCode());
        Object $sourceNamespaces = this.getSourceNamespaces();
        result = result * prime + ($sourceNamespaces == null ? 43 : $sourceNamespaces.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ChannelSpec(" + "configMapRef=" + this.getConfigMapRef() + ", gates=" + this.getGates() + ", insecureSkipVerify=" + this.getInsecureSkipVerify() + ", pathname=" + this.getPathname() + ", secretRef=" + this.getSecretRef() + ", sourceNamespaces=" + this.getSourceNamespaces() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
