
package io.fabric8.istio.api.security.v1beta1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
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
    "hosts",
    "methods",
    "notHosts",
    "notMethods",
    "notPaths",
    "notPorts",
    "paths",
    "ports"
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class Operation implements KubernetesResource
{

    @JsonProperty("hosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> hosts = new ArrayList<String>();
    @JsonProperty("methods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> methods = new ArrayList<String>();
    @JsonProperty("notHosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notHosts = new ArrayList<String>();
    @JsonProperty("notMethods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notMethods = new ArrayList<String>();
    @JsonProperty("notPaths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notPaths = new ArrayList<String>();
    @JsonProperty("notPorts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notPorts = new ArrayList<String>();
    @JsonProperty("paths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> paths = new ArrayList<String>();
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ports = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Operation() {
    }

    /**
     * 
     * @param notMethods
     * @param hosts
     * @param methods
     * @param paths
     * @param notPaths
     * @param notHosts
     * @param ports
     * @param notPorts
     */
    public Operation(List<String> hosts, List<String> methods, List<String> notHosts, List<String> notMethods, List<String> notPaths, List<String> notPorts, List<String> paths, List<String> ports) {
        super();
        this.hosts = hosts;
        this.methods = methods;
        this.notHosts = notHosts;
        this.notMethods = notMethods;
        this.notPaths = notPaths;
        this.notPorts = notPorts;
        this.paths = paths;
        this.ports = ports;
    }

    @JsonProperty("hosts")
    public List<String> getHosts() {
        return hosts;
    }

    @JsonProperty("hosts")
    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    @JsonProperty("methods")
    public List<String> getMethods() {
        return methods;
    }

    @JsonProperty("methods")
    public void setMethods(List<String> methods) {
        this.methods = methods;
    }

    @JsonProperty("notHosts")
    public List<String> getNotHosts() {
        return notHosts;
    }

    @JsonProperty("notHosts")
    public void setNotHosts(List<String> notHosts) {
        this.notHosts = notHosts;
    }

    @JsonProperty("notMethods")
    public List<String> getNotMethods() {
        return notMethods;
    }

    @JsonProperty("notMethods")
    public void setNotMethods(List<String> notMethods) {
        this.notMethods = notMethods;
    }

    @JsonProperty("notPaths")
    public List<String> getNotPaths() {
        return notPaths;
    }

    @JsonProperty("notPaths")
    public void setNotPaths(List<String> notPaths) {
        this.notPaths = notPaths;
    }

    @JsonProperty("notPorts")
    public List<String> getNotPorts() {
        return notPorts;
    }

    @JsonProperty("notPorts")
    public void setNotPorts(List<String> notPorts) {
        this.notPorts = notPorts;
    }

    @JsonProperty("paths")
    public List<String> getPaths() {
        return paths;
    }

    @JsonProperty("paths")
    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    @JsonProperty("ports")
    public List<String> getPorts() {
        return ports;
    }

    @JsonProperty("ports")
    public void setPorts(List<String> ports) {
        this.ports = ports;
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
