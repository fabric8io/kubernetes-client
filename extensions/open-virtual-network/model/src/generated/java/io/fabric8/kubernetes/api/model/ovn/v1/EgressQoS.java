
package io.fabric8.kubernetes.api.model.ovn.v1;

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
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * EgressQoS is a CRD that allows the user to define a DSCP value for pods egress traffic on its namespace to specified CIDRs. Traffic from these pods will be checked against each EgressQoSRule in the namespace's EgressQoS, and if there is a match the traffic is marked with the relevant DSCP value.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "spec",
    "status"
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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("k8s.ovn.org")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class EgressQoS implements Editable<EgressQoSBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "k8s.ovn.org/v1";
    @JsonProperty("kind")
    private String kind = "EgressQoS";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private EgressQoSSpec spec;
    @JsonProperty("status")
    private EgressQoSStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EgressQoS() {
    }

    public EgressQoS(String apiVersion, String kind, ObjectMeta metadata, EgressQoSSpec spec, EgressQoSStatus status) {
        super();
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.metadata = metadata;
        this.spec = spec;
        this.status = status;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * EgressQoS is a CRD that allows the user to define a DSCP value for pods egress traffic on its namespace to specified CIDRs. Traffic from these pods will be checked against each EgressQoSRule in the namespace's EgressQoS, and if there is a match the traffic is marked with the relevant DSCP value.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * EgressQoS is a CRD that allows the user to define a DSCP value for pods egress traffic on its namespace to specified CIDRs. Traffic from these pods will be checked against each EgressQoSRule in the namespace's EgressQoS, and if there is a match the traffic is marked with the relevant DSCP value.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * EgressQoS is a CRD that allows the user to define a DSCP value for pods egress traffic on its namespace to specified CIDRs. Traffic from these pods will be checked against each EgressQoSRule in the namespace's EgressQoS, and if there is a match the traffic is marked with the relevant DSCP value.
     */
    @JsonProperty("spec")
    public EgressQoSSpec getSpec() {
        return spec;
    }

    /**
     * EgressQoS is a CRD that allows the user to define a DSCP value for pods egress traffic on its namespace to specified CIDRs. Traffic from these pods will be checked against each EgressQoSRule in the namespace's EgressQoS, and if there is a match the traffic is marked with the relevant DSCP value.
     */
    @JsonProperty("spec")
    public void setSpec(EgressQoSSpec spec) {
        this.spec = spec;
    }

    /**
     * EgressQoS is a CRD that allows the user to define a DSCP value for pods egress traffic on its namespace to specified CIDRs. Traffic from these pods will be checked against each EgressQoSRule in the namespace's EgressQoS, and if there is a match the traffic is marked with the relevant DSCP value.
     */
    @JsonProperty("status")
    public EgressQoSStatus getStatus() {
        return status;
    }

    /**
     * EgressQoS is a CRD that allows the user to define a DSCP value for pods egress traffic on its namespace to specified CIDRs. Traffic from these pods will be checked against each EgressQoSRule in the namespace's EgressQoS, and if there is a match the traffic is marked with the relevant DSCP value.
     */
    @JsonProperty("status")
    public void setStatus(EgressQoSStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public EgressQoSBuilder edit() {
        return new EgressQoSBuilder(this);
    }

    @JsonIgnore
    public EgressQoSBuilder toBuilder() {
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
