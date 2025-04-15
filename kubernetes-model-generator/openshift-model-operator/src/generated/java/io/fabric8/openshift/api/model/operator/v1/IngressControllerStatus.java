
package io.fabric8.openshift.api.model.operator.v1;

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
import io.fabric8.openshift.api.model.config.v1.TLSProfileSpec;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * IngressControllerStatus defines the observed status of the IngressController.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availableReplicas",
    "conditions",
    "domain",
    "endpointPublishingStrategy",
    "namespaceSelector",
    "observedGeneration",
    "routeSelector",
    "selector",
    "tlsProfile"
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
public class IngressControllerStatus implements Editable<IngressControllerStatusBuilder>, KubernetesResource
{

    @JsonProperty("availableReplicas")
    private Integer availableReplicas;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OperatorCondition> conditions = new ArrayList<>();
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("endpointPublishingStrategy")
    private EndpointPublishingStrategy endpointPublishingStrategy;
    @JsonProperty("namespaceSelector")
    private LabelSelector namespaceSelector;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("routeSelector")
    private LabelSelector routeSelector;
    @JsonProperty("selector")
    private String selector;
    @JsonProperty("tlsProfile")
    private TLSProfileSpec tlsProfile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IngressControllerStatus() {
    }

    public IngressControllerStatus(Integer availableReplicas, List<OperatorCondition> conditions, String domain, EndpointPublishingStrategy endpointPublishingStrategy, LabelSelector namespaceSelector, Long observedGeneration, LabelSelector routeSelector, String selector, TLSProfileSpec tlsProfile) {
        super();
        this.availableReplicas = availableReplicas;
        this.conditions = conditions;
        this.domain = domain;
        this.endpointPublishingStrategy = endpointPublishingStrategy;
        this.namespaceSelector = namespaceSelector;
        this.observedGeneration = observedGeneration;
        this.routeSelector = routeSelector;
        this.selector = selector;
        this.tlsProfile = tlsProfile;
    }

    /**
     * availableReplicas is number of observed available replicas according to the ingress controller deployment.
     */
    @JsonProperty("availableReplicas")
    public Integer getAvailableReplicas() {
        return availableReplicas;
    }

    /**
     * availableReplicas is number of observed available replicas according to the ingress controller deployment.
     */
    @JsonProperty("availableReplicas")
    public void setAvailableReplicas(Integer availableReplicas) {
        this.availableReplicas = availableReplicas;
    }

    /**
     * conditions is a list of conditions and their status.<br><p> <br><p> Available means the ingress controller deployment is available and servicing route and ingress resources (i.e, .status.availableReplicas equals .spec.replicas)<br><p> <br><p> There are additional conditions which indicate the status of other ingress controller features and capabilities.<br><p> <br><p>   &#42; LoadBalancerManaged<br><p>   - True if the following conditions are met:<br><p>     &#42; The endpoint publishing strategy requires a service load balancer.<br><p>   - False if any of those conditions are unsatisfied.<br><p> <br><p>   &#42; LoadBalancerReady<br><p>   - True if the following conditions are met:<br><p>     &#42; A load balancer is managed.<br><p>     &#42; The load balancer is ready.<br><p>   - False if any of those conditions are unsatisfied.<br><p> <br><p>   &#42; DNSManaged<br><p>   - True if the following conditions are met:<br><p>     &#42; The endpoint publishing strategy and platform support DNS.<br><p>     &#42; The ingress controller domain is set.<br><p>     &#42; dns.config.openshift.io/cluster configures DNS zones.<br><p>   - False if any of those conditions are unsatisfied.<br><p> <br><p>   &#42; DNSReady<br><p>   - True if the following conditions are met:<br><p>     &#42; DNS is managed.<br><p>     &#42; DNS records have been successfully created.<br><p>   - False if any of those conditions are unsatisfied.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OperatorCondition> getConditions() {
        return conditions;
    }

    /**
     * conditions is a list of conditions and their status.<br><p> <br><p> Available means the ingress controller deployment is available and servicing route and ingress resources (i.e, .status.availableReplicas equals .spec.replicas)<br><p> <br><p> There are additional conditions which indicate the status of other ingress controller features and capabilities.<br><p> <br><p>   &#42; LoadBalancerManaged<br><p>   - True if the following conditions are met:<br><p>     &#42; The endpoint publishing strategy requires a service load balancer.<br><p>   - False if any of those conditions are unsatisfied.<br><p> <br><p>   &#42; LoadBalancerReady<br><p>   - True if the following conditions are met:<br><p>     &#42; A load balancer is managed.<br><p>     &#42; The load balancer is ready.<br><p>   - False if any of those conditions are unsatisfied.<br><p> <br><p>   &#42; DNSManaged<br><p>   - True if the following conditions are met:<br><p>     &#42; The endpoint publishing strategy and platform support DNS.<br><p>     &#42; The ingress controller domain is set.<br><p>     &#42; dns.config.openshift.io/cluster configures DNS zones.<br><p>   - False if any of those conditions are unsatisfied.<br><p> <br><p>   &#42; DNSReady<br><p>   - True if the following conditions are met:<br><p>     &#42; DNS is managed.<br><p>     &#42; DNS records have been successfully created.<br><p>   - False if any of those conditions are unsatisfied.
     */
    @JsonProperty("conditions")
    public void setConditions(List<OperatorCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * domain is the actual domain in use.
     */
    @JsonProperty("domain")
    public String getDomain() {
        return domain;
    }

    /**
     * domain is the actual domain in use.
     */
    @JsonProperty("domain")
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * IngressControllerStatus defines the observed status of the IngressController.
     */
    @JsonProperty("endpointPublishingStrategy")
    public EndpointPublishingStrategy getEndpointPublishingStrategy() {
        return endpointPublishingStrategy;
    }

    /**
     * IngressControllerStatus defines the observed status of the IngressController.
     */
    @JsonProperty("endpointPublishingStrategy")
    public void setEndpointPublishingStrategy(EndpointPublishingStrategy endpointPublishingStrategy) {
        this.endpointPublishingStrategy = endpointPublishingStrategy;
    }

    /**
     * IngressControllerStatus defines the observed status of the IngressController.
     */
    @JsonProperty("namespaceSelector")
    public LabelSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    /**
     * IngressControllerStatus defines the observed status of the IngressController.
     */
    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(LabelSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    /**
     * observedGeneration is the most recent generation observed.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * observedGeneration is the most recent generation observed.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * IngressControllerStatus defines the observed status of the IngressController.
     */
    @JsonProperty("routeSelector")
    public LabelSelector getRouteSelector() {
        return routeSelector;
    }

    /**
     * IngressControllerStatus defines the observed status of the IngressController.
     */
    @JsonProperty("routeSelector")
    public void setRouteSelector(LabelSelector routeSelector) {
        this.routeSelector = routeSelector;
    }

    /**
     * selector is a label selector, in string format, for ingress controller pods corresponding to the IngressController. The number of matching pods should equal the value of availableReplicas.
     */
    @JsonProperty("selector")
    public String getSelector() {
        return selector;
    }

    /**
     * selector is a label selector, in string format, for ingress controller pods corresponding to the IngressController. The number of matching pods should equal the value of availableReplicas.
     */
    @JsonProperty("selector")
    public void setSelector(String selector) {
        this.selector = selector;
    }

    /**
     * IngressControllerStatus defines the observed status of the IngressController.
     */
    @JsonProperty("tlsProfile")
    public TLSProfileSpec getTlsProfile() {
        return tlsProfile;
    }

    /**
     * IngressControllerStatus defines the observed status of the IngressController.
     */
    @JsonProperty("tlsProfile")
    public void setTlsProfile(TLSProfileSpec tlsProfile) {
        this.tlsProfile = tlsProfile;
    }

    @JsonIgnore
    public IngressControllerStatusBuilder edit() {
        return new IngressControllerStatusBuilder(this);
    }

    @JsonIgnore
    public IngressControllerStatusBuilder toBuilder() {
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
