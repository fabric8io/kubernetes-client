
package io.fabric8.openshift.api.model.operator.network.v1;

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
 * EgressRouter is a feature allowing the user to define an egress router that acts as a bridge between pods and external systems. The egress router runs a service that redirects egress traffic originating from a pod or a group of pods to a remote external system or multiple destinations as per configuration.<br><p> <br><p> It is consumed by the cluster-network-operator. More specifically, given an EgressRouter CR with &lt;name&gt;, the CNO will create and manage: - A service called &lt;name&gt; - An egress pod called &lt;name&gt; - A NAD called &lt;name&gt;<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).<br><p> <br><p> EgressRouter is a single egressrouter pod configuration object.
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
@Group("network.operator.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class EgressRouter implements Editable<EgressRouterBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "network.operator.openshift.io/v1";
    @JsonProperty("kind")
    private String kind = "EgressRouter";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private EgressRouterSpec spec;
    @JsonProperty("status")
    private EgressRouterStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EgressRouter() {
    }

    public EgressRouter(String apiVersion, String kind, ObjectMeta metadata, EgressRouterSpec spec, EgressRouterStatus status) {
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
     * EgressRouter is a feature allowing the user to define an egress router that acts as a bridge between pods and external systems. The egress router runs a service that redirects egress traffic originating from a pod or a group of pods to a remote external system or multiple destinations as per configuration.<br><p> <br><p> It is consumed by the cluster-network-operator. More specifically, given an EgressRouter CR with &lt;name&gt;, the CNO will create and manage: - A service called &lt;name&gt; - An egress pod called &lt;name&gt; - A NAD called &lt;name&gt;<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).<br><p> <br><p> EgressRouter is a single egressrouter pod configuration object.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * EgressRouter is a feature allowing the user to define an egress router that acts as a bridge between pods and external systems. The egress router runs a service that redirects egress traffic originating from a pod or a group of pods to a remote external system or multiple destinations as per configuration.<br><p> <br><p> It is consumed by the cluster-network-operator. More specifically, given an EgressRouter CR with &lt;name&gt;, the CNO will create and manage: - A service called &lt;name&gt; - An egress pod called &lt;name&gt; - A NAD called &lt;name&gt;<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).<br><p> <br><p> EgressRouter is a single egressrouter pod configuration object.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * EgressRouter is a feature allowing the user to define an egress router that acts as a bridge between pods and external systems. The egress router runs a service that redirects egress traffic originating from a pod or a group of pods to a remote external system or multiple destinations as per configuration.<br><p> <br><p> It is consumed by the cluster-network-operator. More specifically, given an EgressRouter CR with &lt;name&gt;, the CNO will create and manage: - A service called &lt;name&gt; - An egress pod called &lt;name&gt; - A NAD called &lt;name&gt;<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).<br><p> <br><p> EgressRouter is a single egressrouter pod configuration object.
     */
    @JsonProperty("spec")
    public EgressRouterSpec getSpec() {
        return spec;
    }

    /**
     * EgressRouter is a feature allowing the user to define an egress router that acts as a bridge between pods and external systems. The egress router runs a service that redirects egress traffic originating from a pod or a group of pods to a remote external system or multiple destinations as per configuration.<br><p> <br><p> It is consumed by the cluster-network-operator. More specifically, given an EgressRouter CR with &lt;name&gt;, the CNO will create and manage: - A service called &lt;name&gt; - An egress pod called &lt;name&gt; - A NAD called &lt;name&gt;<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).<br><p> <br><p> EgressRouter is a single egressrouter pod configuration object.
     */
    @JsonProperty("spec")
    public void setSpec(EgressRouterSpec spec) {
        this.spec = spec;
    }

    /**
     * EgressRouter is a feature allowing the user to define an egress router that acts as a bridge between pods and external systems. The egress router runs a service that redirects egress traffic originating from a pod or a group of pods to a remote external system or multiple destinations as per configuration.<br><p> <br><p> It is consumed by the cluster-network-operator. More specifically, given an EgressRouter CR with &lt;name&gt;, the CNO will create and manage: - A service called &lt;name&gt; - An egress pod called &lt;name&gt; - A NAD called &lt;name&gt;<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).<br><p> <br><p> EgressRouter is a single egressrouter pod configuration object.
     */
    @JsonProperty("status")
    public EgressRouterStatus getStatus() {
        return status;
    }

    /**
     * EgressRouter is a feature allowing the user to define an egress router that acts as a bridge between pods and external systems. The egress router runs a service that redirects egress traffic originating from a pod or a group of pods to a remote external system or multiple destinations as per configuration.<br><p> <br><p> It is consumed by the cluster-network-operator. More specifically, given an EgressRouter CR with &lt;name&gt;, the CNO will create and manage: - A service called &lt;name&gt; - An egress pod called &lt;name&gt; - A NAD called &lt;name&gt;<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).<br><p> <br><p> EgressRouter is a single egressrouter pod configuration object.
     */
    @JsonProperty("status")
    public void setStatus(EgressRouterStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public EgressRouterBuilder edit() {
        return new EgressRouterBuilder(this);
    }

    @JsonIgnore
    public EgressRouterBuilder toBuilder() {
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
