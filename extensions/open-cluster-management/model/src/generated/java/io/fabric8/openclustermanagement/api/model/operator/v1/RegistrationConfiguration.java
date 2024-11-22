
package io.fabric8.openclustermanagement.api.model.operator.v1;

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
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bootstrapKubeConfigs",
    "clientCertExpirationSeconds",
    "clusterAnnotations",
    "featureGates",
    "kubeAPIBurst",
    "kubeAPIQPS",
    "registrationDriver"
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
public class RegistrationConfiguration implements Editable<RegistrationConfigurationBuilder> , KubernetesResource
{

    @JsonProperty("bootstrapKubeConfigs")
    private BootstrapKubeConfigs bootstrapKubeConfigs;
    @JsonProperty("clientCertExpirationSeconds")
    private Integer clientCertExpirationSeconds;
    @JsonProperty("clusterAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> clusterAnnotations = new LinkedHashMap<>();
    @JsonProperty("featureGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FeatureGate> featureGates = new ArrayList<>();
    @JsonProperty("kubeAPIBurst")
    private Integer kubeAPIBurst;
    @JsonProperty("kubeAPIQPS")
    private Integer kubeAPIQPS;
    @JsonProperty("registrationDriver")
    private RegistrationDriver registrationDriver;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RegistrationConfiguration() {
    }

    public RegistrationConfiguration(BootstrapKubeConfigs bootstrapKubeConfigs, Integer clientCertExpirationSeconds, Map<String, String> clusterAnnotations, List<FeatureGate> featureGates, Integer kubeAPIBurst, Integer kubeAPIQPS, RegistrationDriver registrationDriver) {
        super();
        this.bootstrapKubeConfigs = bootstrapKubeConfigs;
        this.clientCertExpirationSeconds = clientCertExpirationSeconds;
        this.clusterAnnotations = clusterAnnotations;
        this.featureGates = featureGates;
        this.kubeAPIBurst = kubeAPIBurst;
        this.kubeAPIQPS = kubeAPIQPS;
        this.registrationDriver = registrationDriver;
    }

    @JsonProperty("bootstrapKubeConfigs")
    public BootstrapKubeConfigs getBootstrapKubeConfigs() {
        return bootstrapKubeConfigs;
    }

    @JsonProperty("bootstrapKubeConfigs")
    public void setBootstrapKubeConfigs(BootstrapKubeConfigs bootstrapKubeConfigs) {
        this.bootstrapKubeConfigs = bootstrapKubeConfigs;
    }

    @JsonProperty("clientCertExpirationSeconds")
    public Integer getClientCertExpirationSeconds() {
        return clientCertExpirationSeconds;
    }

    @JsonProperty("clientCertExpirationSeconds")
    public void setClientCertExpirationSeconds(Integer clientCertExpirationSeconds) {
        this.clientCertExpirationSeconds = clientCertExpirationSeconds;
    }

    @JsonProperty("clusterAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getClusterAnnotations() {
        return clusterAnnotations;
    }

    @JsonProperty("clusterAnnotations")
    public void setClusterAnnotations(Map<String, String> clusterAnnotations) {
        this.clusterAnnotations = clusterAnnotations;
    }

    @JsonProperty("featureGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FeatureGate> getFeatureGates() {
        return featureGates;
    }

    @JsonProperty("featureGates")
    public void setFeatureGates(List<FeatureGate> featureGates) {
        this.featureGates = featureGates;
    }

    @JsonProperty("kubeAPIBurst")
    public Integer getKubeAPIBurst() {
        return kubeAPIBurst;
    }

    @JsonProperty("kubeAPIBurst")
    public void setKubeAPIBurst(Integer kubeAPIBurst) {
        this.kubeAPIBurst = kubeAPIBurst;
    }

    @JsonProperty("kubeAPIQPS")
    public Integer getKubeAPIQPS() {
        return kubeAPIQPS;
    }

    @JsonProperty("kubeAPIQPS")
    public void setKubeAPIQPS(Integer kubeAPIQPS) {
        this.kubeAPIQPS = kubeAPIQPS;
    }

    @JsonProperty("registrationDriver")
    public RegistrationDriver getRegistrationDriver() {
        return registrationDriver;
    }

    @JsonProperty("registrationDriver")
    public void setRegistrationDriver(RegistrationDriver registrationDriver) {
        this.registrationDriver = registrationDriver;
    }

    @JsonIgnore
    public RegistrationConfigurationBuilder edit() {
        return new RegistrationConfigurationBuilder(this);
    }

    @JsonIgnore
    public RegistrationConfigurationBuilder toBuilder() {
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
