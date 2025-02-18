
package io.fabric8.istio.api.api.networking.v1alpha3;

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
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelector;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
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
 * DestinationRule defines policies that apply to traffic intended for a service after routing has occurred.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "exportTo",
    "host",
    "subsets",
    "trafficPolicy",
    "workloadSelector"
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
@Version("v1alpha3")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class DestinationRule implements Editable<DestinationRuleBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("exportTo")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> exportTo = new ArrayList<>();
    @JsonProperty("host")
    private String host;
    @JsonProperty("subsets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Subset> subsets = new ArrayList<>();
    @JsonProperty("trafficPolicy")
    private TrafficPolicy trafficPolicy;
    @JsonProperty("workloadSelector")
    private WorkloadSelector workloadSelector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DestinationRule() {
    }

    public DestinationRule(List<String> exportTo, String host, List<Subset> subsets, TrafficPolicy trafficPolicy, WorkloadSelector workloadSelector) {
        super();
        this.exportTo = exportTo;
        this.host = host;
        this.subsets = subsets;
        this.trafficPolicy = trafficPolicy;
        this.workloadSelector = workloadSelector;
    }

    /**
     * A list of namespaces to which this destination rule is exported. The resolution of a destination rule to apply to a service occurs in the context of a hierarchy of namespaces. Exporting a destination rule allows it to be included in the resolution hierarchy for services in other namespaces. This feature provides a mechanism for service owners and mesh administrators to control the visibility of destination rules across namespace boundaries.<br><p> <br><p> If no namespaces are specified then the destination rule is exported to all namespaces by default.<br><p> <br><p> The value "." is reserved and defines an export to the same namespace that the destination rule is declared in. Similarly, the value "&#42;" is reserved and defines an export to all namespaces.
     */
    @JsonProperty("exportTo")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExportTo() {
        return exportTo;
    }

    /**
     * A list of namespaces to which this destination rule is exported. The resolution of a destination rule to apply to a service occurs in the context of a hierarchy of namespaces. Exporting a destination rule allows it to be included in the resolution hierarchy for services in other namespaces. This feature provides a mechanism for service owners and mesh administrators to control the visibility of destination rules across namespace boundaries.<br><p> <br><p> If no namespaces are specified then the destination rule is exported to all namespaces by default.<br><p> <br><p> The value "." is reserved and defines an export to the same namespace that the destination rule is declared in. Similarly, the value "&#42;" is reserved and defines an export to all namespaces.
     */
    @JsonProperty("exportTo")
    public void setExportTo(List<String> exportTo) {
        this.exportTo = exportTo;
    }

    /**
     * The name of a service from the service registry. Service names are looked up from the platform's service registry (e.g., Kubernetes services, Consul services, etc.) and from the hosts declared by [ServiceEntries](https://istio.io/docs/reference/config/networking/service-entry/#ServiceEntry). Rules defined for services that do not exist in the service registry will be ignored.<br><p> <br><p> &#42;Note for Kubernetes users&#42;: When short names are used (e.g. "reviews" instead of "reviews.default.svc.cluster.local"), Istio will interpret the short name based on the namespace of the rule, not the service. A rule in the "default" namespace containing a host "reviews" will be interpreted as "reviews.default.svc.cluster.local", irrespective of the actual namespace associated with the reviews service. To avoid potential misconfigurations, it is recommended to always use fully qualified domain names over short names.<br><p> <br><p> Note that the host field applies to both HTTP and TCP services.
     */
    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    /**
     * The name of a service from the service registry. Service names are looked up from the platform's service registry (e.g., Kubernetes services, Consul services, etc.) and from the hosts declared by [ServiceEntries](https://istio.io/docs/reference/config/networking/service-entry/#ServiceEntry). Rules defined for services that do not exist in the service registry will be ignored.<br><p> <br><p> &#42;Note for Kubernetes users&#42;: When short names are used (e.g. "reviews" instead of "reviews.default.svc.cluster.local"), Istio will interpret the short name based on the namespace of the rule, not the service. A rule in the "default" namespace containing a host "reviews" will be interpreted as "reviews.default.svc.cluster.local", irrespective of the actual namespace associated with the reviews service. To avoid potential misconfigurations, it is recommended to always use fully qualified domain names over short names.<br><p> <br><p> Note that the host field applies to both HTTP and TCP services.
     */
    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * One or more named sets that represent individual versions of a service. Traffic policies can be overridden at subset level.
     */
    @JsonProperty("subsets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Subset> getSubsets() {
        return subsets;
    }

    /**
     * One or more named sets that represent individual versions of a service. Traffic policies can be overridden at subset level.
     */
    @JsonProperty("subsets")
    public void setSubsets(List<Subset> subsets) {
        this.subsets = subsets;
    }

    /**
     * DestinationRule defines policies that apply to traffic intended for a service after routing has occurred.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("trafficPolicy")
    public TrafficPolicy getTrafficPolicy() {
        return trafficPolicy;
    }

    /**
     * DestinationRule defines policies that apply to traffic intended for a service after routing has occurred.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("trafficPolicy")
    public void setTrafficPolicy(TrafficPolicy trafficPolicy) {
        this.trafficPolicy = trafficPolicy;
    }

    /**
     * DestinationRule defines policies that apply to traffic intended for a service after routing has occurred.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("workloadSelector")
    public WorkloadSelector getWorkloadSelector() {
        return workloadSelector;
    }

    /**
     * DestinationRule defines policies that apply to traffic intended for a service after routing has occurred.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("workloadSelector")
    public void setWorkloadSelector(WorkloadSelector workloadSelector) {
        this.workloadSelector = workloadSelector;
    }

    @JsonIgnore
    public DestinationRuleBuilder edit() {
        return new DestinationRuleBuilder(this);
    }

    @JsonIgnore
    public DestinationRuleBuilder toBuilder() {
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
