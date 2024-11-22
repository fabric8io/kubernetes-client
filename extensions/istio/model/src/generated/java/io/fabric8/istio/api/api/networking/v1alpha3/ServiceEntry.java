
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
public class ServiceEntry implements Editable<ServiceEntryBuilder> , KubernetesResource, Namespaced
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
     * 
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

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAddresses() {
        return addresses;
    }

    @JsonProperty("addresses")
    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    @JsonProperty("endpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WorkloadEntry> getEndpoints() {
        return endpoints;
    }

    @JsonProperty("endpoints")
    public void setEndpoints(List<WorkloadEntry> endpoints) {
        this.endpoints = endpoints;
    }

    @JsonProperty("exportTo")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExportTo() {
        return exportTo;
    }

    @JsonProperty("exportTo")
    public void setExportTo(List<String> exportTo) {
        this.exportTo = exportTo;
    }

    @JsonProperty("hosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getHosts() {
        return hosts;
    }

    @JsonProperty("hosts")
    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    @JsonProperty("location")
    public ServiceEntryLocation getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(ServiceEntryLocation location) {
        this.location = location;
    }

    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ServicePort> getPorts() {
        return ports;
    }

    @JsonProperty("ports")
    public void setPorts(List<ServicePort> ports) {
        this.ports = ports;
    }

    @JsonProperty("resolution")
    public ServiceEntryResolution getResolution() {
        return resolution;
    }

    @JsonProperty("resolution")
    public void setResolution(ServiceEntryResolution resolution) {
        this.resolution = resolution;
    }

    @JsonProperty("subjectAltNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSubjectAltNames() {
        return subjectAltNames;
    }

    @JsonProperty("subjectAltNames")
    public void setSubjectAltNames(List<String> subjectAltNames) {
        this.subjectAltNames = subjectAltNames;
    }

    @JsonProperty("workloadSelector")
    public WorkloadSelector getWorkloadSelector() {
        return workloadSelector;
    }

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
