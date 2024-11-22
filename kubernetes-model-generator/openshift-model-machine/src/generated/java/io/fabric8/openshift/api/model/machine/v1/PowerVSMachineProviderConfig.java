
package io.fabric8.openshift.api.model.machine.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "credentialsSecret",
    "image",
    "keyPairName",
    "loadBalancers",
    "memoryGiB",
    "network",
    "processorType",
    "processors",
    "serviceInstance",
    "systemType",
    "userDataSecret"
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
@Group("machine.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PowerVSMachineProviderConfig implements Editable<PowerVSMachineProviderConfigBuilder> , HasMetadata, Namespaced
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "machine.openshift.io/v1";
    @JsonProperty("credentialsSecret")
    private PowerVSSecretReference credentialsSecret;
    @JsonProperty("image")
    private PowerVSResource image;
    @JsonProperty("keyPairName")
    private String keyPairName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private String kind = "PowerVSMachineProviderConfig";
    @JsonProperty("loadBalancers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LoadBalancerReference> loadBalancers = new ArrayList<>();
    @JsonProperty("memoryGiB")
    private Integer memoryGiB;
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("network")
    private PowerVSResource network;
    @JsonProperty("processorType")
    private String processorType;
    @JsonProperty("processors")
    private IntOrString processors;
    @JsonProperty("serviceInstance")
    private PowerVSResource serviceInstance;
    @JsonProperty("systemType")
    private String systemType;
    @JsonProperty("userDataSecret")
    private PowerVSSecretReference userDataSecret;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PowerVSMachineProviderConfig() {
    }

    public PowerVSMachineProviderConfig(String apiVersion, PowerVSSecretReference credentialsSecret, PowerVSResource image, String keyPairName, String kind, List<LoadBalancerReference> loadBalancers, Integer memoryGiB, ObjectMeta metadata, PowerVSResource network, String processorType, IntOrString processors, PowerVSResource serviceInstance, String systemType, PowerVSSecretReference userDataSecret) {
        super();
        this.apiVersion = apiVersion;
        this.credentialsSecret = credentialsSecret;
        this.image = image;
        this.keyPairName = keyPairName;
        this.kind = kind;
        this.loadBalancers = loadBalancers;
        this.memoryGiB = memoryGiB;
        this.metadata = metadata;
        this.network = network;
        this.processorType = processorType;
        this.processors = processors;
        this.serviceInstance = serviceInstance;
        this.systemType = systemType;
        this.userDataSecret = userDataSecret;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("credentialsSecret")
    public PowerVSSecretReference getCredentialsSecret() {
        return credentialsSecret;
    }

    @JsonProperty("credentialsSecret")
    public void setCredentialsSecret(PowerVSSecretReference credentialsSecret) {
        this.credentialsSecret = credentialsSecret;
    }

    @JsonProperty("image")
    public PowerVSResource getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(PowerVSResource image) {
        this.image = image;
    }

    @JsonProperty("keyPairName")
    public String getKeyPairName() {
        return keyPairName;
    }

    @JsonProperty("keyPairName")
    public void setKeyPairName(String keyPairName) {
        this.keyPairName = keyPairName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("loadBalancers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LoadBalancerReference> getLoadBalancers() {
        return loadBalancers;
    }

    @JsonProperty("loadBalancers")
    public void setLoadBalancers(List<LoadBalancerReference> loadBalancers) {
        this.loadBalancers = loadBalancers;
    }

    @JsonProperty("memoryGiB")
    public Integer getMemoryGiB() {
        return memoryGiB;
    }

    @JsonProperty("memoryGiB")
    public void setMemoryGiB(Integer memoryGiB) {
        this.memoryGiB = memoryGiB;
    }

    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("network")
    public PowerVSResource getNetwork() {
        return network;
    }

    @JsonProperty("network")
    public void setNetwork(PowerVSResource network) {
        this.network = network;
    }

    @JsonProperty("processorType")
    public String getProcessorType() {
        return processorType;
    }

    @JsonProperty("processorType")
    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    @JsonProperty("processors")
    public IntOrString getProcessors() {
        return processors;
    }

    @JsonProperty("processors")
    public void setProcessors(IntOrString processors) {
        this.processors = processors;
    }

    @JsonProperty("serviceInstance")
    public PowerVSResource getServiceInstance() {
        return serviceInstance;
    }

    @JsonProperty("serviceInstance")
    public void setServiceInstance(PowerVSResource serviceInstance) {
        this.serviceInstance = serviceInstance;
    }

    @JsonProperty("systemType")
    public String getSystemType() {
        return systemType;
    }

    @JsonProperty("systemType")
    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    @JsonProperty("userDataSecret")
    public PowerVSSecretReference getUserDataSecret() {
        return userDataSecret;
    }

    @JsonProperty("userDataSecret")
    public void setUserDataSecret(PowerVSSecretReference userDataSecret) {
        this.userDataSecret = userDataSecret;
    }

    @JsonIgnore
    public PowerVSMachineProviderConfigBuilder edit() {
        return new PowerVSMachineProviderConfigBuilder(this);
    }

    @JsonIgnore
    public PowerVSMachineProviderConfigBuilder toBuilder() {
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
