
package io.fabric8.istio.api.api.networking.v1alpha3;

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
 * ServiceEntry enables adding additional entries into Istio's internal service registry.<br><p> <br><p> &lt;!-- crd generation tags mesh or part of the mesh (MESH_EXTERNAL or MESH_INTERNAL)" (NONE, STATIC, or DNS)" representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags istiostatus-override: ServiceEntryStatus: istio.io/api/networking/v1alpha3 --&gt;
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addresses",
    "endpoints",
    "exportTo",
    "hosts",
    "location",
    "ports",
    "resolution",
    "subjectAltNames",
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
public class ServiceEntry implements Editable<ServiceEntryBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> addresses = new ArrayList<>();
    @JsonProperty("endpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WorkloadEntry> endpoints = new ArrayList<>();
    @JsonProperty("exportTo")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> exportTo = new ArrayList<>();
    @JsonProperty("hosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> hosts = new ArrayList<>();
    @JsonProperty("location")
    private ServiceEntryLocation location;
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ServicePort> ports = new ArrayList<>();
    @JsonProperty("resolution")
    private ServiceEntryResolution resolution;
    @JsonProperty("subjectAltNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> subjectAltNames = new ArrayList<>();
    @JsonProperty("workloadSelector")
    private WorkloadSelector workloadSelector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ServiceEntry() {
    }

    public ServiceEntry(List<String> addresses, List<WorkloadEntry> endpoints, List<String> exportTo, List<String> hosts, ServiceEntryLocation location, List<ServicePort> ports, ServiceEntryResolution resolution, List<String> subjectAltNames, WorkloadSelector workloadSelector) {
        super();
        this.addresses = addresses;
        this.endpoints = endpoints;
        this.exportTo = exportTo;
        this.hosts = hosts;
        this.location = location;
        this.ports = ports;
        this.resolution = resolution;
        this.subjectAltNames = subjectAltNames;
        this.workloadSelector = workloadSelector;
    }

    /**
     * The virtual IP addresses associated with the service. Could be CIDR prefix. For HTTP traffic, generated route configurations will include http route domains for both the `addresses` and `hosts` field values and the destination will be identified based on the HTTP Host/Authority header. If one or more IP addresses are specified, the incoming traffic will be identified as belonging to this service if the destination IP matches the IP/CIDRs specified in the addresses field. If the Addresses field is empty, traffic will be identified solely based on the destination port. In such scenarios, the port on which the service is being accessed must not be shared by any other service in the mesh. In other words, the sidecar will behave as a simple TCP proxy, forwarding incoming traffic on a specified port to the specified destination endpoint IP/host. Unix domain socket addresses are not supported in this field.
     */
    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAddresses() {
        return addresses;
    }

    /**
     * The virtual IP addresses associated with the service. Could be CIDR prefix. For HTTP traffic, generated route configurations will include http route domains for both the `addresses` and `hosts` field values and the destination will be identified based on the HTTP Host/Authority header. If one or more IP addresses are specified, the incoming traffic will be identified as belonging to this service if the destination IP matches the IP/CIDRs specified in the addresses field. If the Addresses field is empty, traffic will be identified solely based on the destination port. In such scenarios, the port on which the service is being accessed must not be shared by any other service in the mesh. In other words, the sidecar will behave as a simple TCP proxy, forwarding incoming traffic on a specified port to the specified destination endpoint IP/host. Unix domain socket addresses are not supported in this field.
     */
    @JsonProperty("addresses")
    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    /**
     * One or more endpoints associated with the service. Only one of `endpoints` or `workloadSelector` can be specified.
     */
    @JsonProperty("endpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WorkloadEntry> getEndpoints() {
        return endpoints;
    }

    /**
     * One or more endpoints associated with the service. Only one of `endpoints` or `workloadSelector` can be specified.
     */
    @JsonProperty("endpoints")
    public void setEndpoints(List<WorkloadEntry> endpoints) {
        this.endpoints = endpoints;
    }

    /**
     * A list of namespaces to which this service is exported. Exporting a service allows it to be used by sidecars, gateways and virtual services defined in other namespaces. This feature provides a mechanism for service owners and mesh administrators to control the visibility of services across namespace boundaries.<br><p> <br><p> If no namespaces are specified then the service is exported to all namespaces by default.<br><p> <br><p> The value "." is reserved and defines an export to the same namespace that the service is declared in. Similarly the value "&#42;" is reserved and defines an export to all namespaces.<br><p> <br><p> For a Kubernetes Service, the equivalent effect can be achieved by setting the annotation "networking.istio.io/exportTo" to a comma-separated list of namespace names.
     */
    @JsonProperty("exportTo")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExportTo() {
        return exportTo;
    }

    /**
     * A list of namespaces to which this service is exported. Exporting a service allows it to be used by sidecars, gateways and virtual services defined in other namespaces. This feature provides a mechanism for service owners and mesh administrators to control the visibility of services across namespace boundaries.<br><p> <br><p> If no namespaces are specified then the service is exported to all namespaces by default.<br><p> <br><p> The value "." is reserved and defines an export to the same namespace that the service is declared in. Similarly the value "&#42;" is reserved and defines an export to all namespaces.<br><p> <br><p> For a Kubernetes Service, the equivalent effect can be achieved by setting the annotation "networking.istio.io/exportTo" to a comma-separated list of namespace names.
     */
    @JsonProperty("exportTo")
    public void setExportTo(List<String> exportTo) {
        this.exportTo = exportTo;
    }

    /**
     * The hosts associated with the ServiceEntry. Could be a DNS name with wildcard prefix.<br><p> <br><p> 1. The hosts field is used to select matching hosts in VirtualServices and DestinationRules. 2. For HTTP traffic the HTTP Host/Authority header will be matched against the hosts field. 3. For HTTPs or TLS traffic containing Server Name Indication (SNI), the SNI value will be matched against the hosts field.<br><p> <br><p> &#42;&#42;NOTE 1:&#42;&#42; When resolution is set to type DNS and no endpoints are specified, the host field will be used as the DNS name of the endpoint to route traffic to.<br><p> <br><p> &#42;&#42;NOTE 2:&#42;&#42; If the hostname matches with the name of a service from another service registry such as Kubernetes that also supplies its own set of endpoints, the ServiceEntry will be treated as a decorator of the existing Kubernetes service. Properties in the service entry will be added to the Kubernetes service if applicable. Currently, only the following additional properties will be considered by `istiod`:<br><p> <br><p>  1. subjectAltNames: In addition to verifying the SANs of the<br><p>     service accounts associated with the pods of the service, the<br><p>     SANs specified here will also be verified.
     */
    @JsonProperty("hosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getHosts() {
        return hosts;
    }

    /**
     * The hosts associated with the ServiceEntry. Could be a DNS name with wildcard prefix.<br><p> <br><p> 1. The hosts field is used to select matching hosts in VirtualServices and DestinationRules. 2. For HTTP traffic the HTTP Host/Authority header will be matched against the hosts field. 3. For HTTPs or TLS traffic containing Server Name Indication (SNI), the SNI value will be matched against the hosts field.<br><p> <br><p> &#42;&#42;NOTE 1:&#42;&#42; When resolution is set to type DNS and no endpoints are specified, the host field will be used as the DNS name of the endpoint to route traffic to.<br><p> <br><p> &#42;&#42;NOTE 2:&#42;&#42; If the hostname matches with the name of a service from another service registry such as Kubernetes that also supplies its own set of endpoints, the ServiceEntry will be treated as a decorator of the existing Kubernetes service. Properties in the service entry will be added to the Kubernetes service if applicable. Currently, only the following additional properties will be considered by `istiod`:<br><p> <br><p>  1. subjectAltNames: In addition to verifying the SANs of the<br><p>     service accounts associated with the pods of the service, the<br><p>     SANs specified here will also be verified.
     */
    @JsonProperty("hosts")
    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    /**
     * ServiceEntry enables adding additional entries into Istio's internal service registry.<br><p> <br><p> &lt;!-- crd generation tags mesh or part of the mesh (MESH_EXTERNAL or MESH_INTERNAL)" (NONE, STATIC, or DNS)" representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags istiostatus-override: ServiceEntryStatus: istio.io/api/networking/v1alpha3 --&gt;
     */
    @JsonProperty("location")
    public ServiceEntryLocation getLocation() {
        return location;
    }

    /**
     * ServiceEntry enables adding additional entries into Istio's internal service registry.<br><p> <br><p> &lt;!-- crd generation tags mesh or part of the mesh (MESH_EXTERNAL or MESH_INTERNAL)" (NONE, STATIC, or DNS)" representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags istiostatus-override: ServiceEntryStatus: istio.io/api/networking/v1alpha3 --&gt;
     */
    @JsonProperty("location")
    public void setLocation(ServiceEntryLocation location) {
        this.location = location;
    }

    /**
     * The ports associated with the external service. If the Endpoints are Unix domain socket addresses, there must be exactly one port.
     */
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ServicePort> getPorts() {
        return ports;
    }

    /**
     * The ports associated with the external service. If the Endpoints are Unix domain socket addresses, there must be exactly one port.
     */
    @JsonProperty("ports")
    public void setPorts(List<ServicePort> ports) {
        this.ports = ports;
    }

    /**
     * ServiceEntry enables adding additional entries into Istio's internal service registry.<br><p> <br><p> &lt;!-- crd generation tags mesh or part of the mesh (MESH_EXTERNAL or MESH_INTERNAL)" (NONE, STATIC, or DNS)" representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags istiostatus-override: ServiceEntryStatus: istio.io/api/networking/v1alpha3 --&gt;
     */
    @JsonProperty("resolution")
    public ServiceEntryResolution getResolution() {
        return resolution;
    }

    /**
     * ServiceEntry enables adding additional entries into Istio's internal service registry.<br><p> <br><p> &lt;!-- crd generation tags mesh or part of the mesh (MESH_EXTERNAL or MESH_INTERNAL)" (NONE, STATIC, or DNS)" representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags istiostatus-override: ServiceEntryStatus: istio.io/api/networking/v1alpha3 --&gt;
     */
    @JsonProperty("resolution")
    public void setResolution(ServiceEntryResolution resolution) {
        this.resolution = resolution;
    }

    /**
     * If specified, the proxy will verify that the server certificate's subject alternate name matches one of the specified values.<br><p> <br><p> NOTE: When using the workloadEntry with workloadSelectors, the service account specified in the workloadEntry will also be used to derive the additional subject alternate names that should be verified.
     */
    @JsonProperty("subjectAltNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSubjectAltNames() {
        return subjectAltNames;
    }

    /**
     * If specified, the proxy will verify that the server certificate's subject alternate name matches one of the specified values.<br><p> <br><p> NOTE: When using the workloadEntry with workloadSelectors, the service account specified in the workloadEntry will also be used to derive the additional subject alternate names that should be verified.
     */
    @JsonProperty("subjectAltNames")
    public void setSubjectAltNames(List<String> subjectAltNames) {
        this.subjectAltNames = subjectAltNames;
    }

    /**
     * ServiceEntry enables adding additional entries into Istio's internal service registry.<br><p> <br><p> &lt;!-- crd generation tags mesh or part of the mesh (MESH_EXTERNAL or MESH_INTERNAL)" (NONE, STATIC, or DNS)" representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags istiostatus-override: ServiceEntryStatus: istio.io/api/networking/v1alpha3 --&gt;
     */
    @JsonProperty("workloadSelector")
    public WorkloadSelector getWorkloadSelector() {
        return workloadSelector;
    }

    /**
     * ServiceEntry enables adding additional entries into Istio's internal service registry.<br><p> <br><p> &lt;!-- crd generation tags mesh or part of the mesh (MESH_EXTERNAL or MESH_INTERNAL)" (NONE, STATIC, or DNS)" representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags istiostatus-override: ServiceEntryStatus: istio.io/api/networking/v1alpha3 --&gt;
     */
    @JsonProperty("workloadSelector")
    public void setWorkloadSelector(WorkloadSelector workloadSelector) {
        this.workloadSelector = workloadSelector;
    }

    @JsonIgnore
    public ServiceEntryBuilder edit() {
        return new ServiceEntryBuilder(this);
    }

    @JsonIgnore
    public ServiceEntryBuilder toBuilder() {
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
