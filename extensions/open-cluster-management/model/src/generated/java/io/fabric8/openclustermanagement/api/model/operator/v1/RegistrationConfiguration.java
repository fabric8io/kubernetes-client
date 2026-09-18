
package io.fabric8.openclustermanagement.api.model.operator.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addOnKubeClientRegistrationDriver",
    "bootstrapKubeConfigs",
    "clientCertExpirationSeconds",
    "clusterAnnotations",
    "clusterClaimConfiguration",
    "clusterLabels",
    "featureGates",
    "kubeAPIBurst",
    "kubeAPIQPS",
    "registrationDriver"
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
public class RegistrationConfiguration implements Editable<RegistrationConfigurationBuilder>, KubernetesResource
{

    @JsonProperty("addOnKubeClientRegistrationDriver")
    private AddOnRegistrationDriver addOnKubeClientRegistrationDriver;
    @JsonProperty("bootstrapKubeConfigs")
    private BootstrapKubeConfigs bootstrapKubeConfigs;
    @JsonProperty("clientCertExpirationSeconds")
    private Integer clientCertExpirationSeconds;
    @JsonProperty("clusterAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> clusterAnnotations = new LinkedHashMap<>();
    @JsonProperty("clusterClaimConfiguration")
    private ClusterClaimConfiguration clusterClaimConfiguration;
    @JsonProperty("clusterLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> clusterLabels = new LinkedHashMap<>();
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
     */
    public RegistrationConfiguration() {
    }

    public RegistrationConfiguration(AddOnRegistrationDriver addOnKubeClientRegistrationDriver, BootstrapKubeConfigs bootstrapKubeConfigs, Integer clientCertExpirationSeconds, Map<String, String> clusterAnnotations, ClusterClaimConfiguration clusterClaimConfiguration, Map<String, String> clusterLabels, List<FeatureGate> featureGates, Integer kubeAPIBurst, Integer kubeAPIQPS, RegistrationDriver registrationDriver) {
        super();
        this.addOnKubeClientRegistrationDriver = addOnKubeClientRegistrationDriver;
        this.bootstrapKubeConfigs = bootstrapKubeConfigs;
        this.clientCertExpirationSeconds = clientCertExpirationSeconds;
        this.clusterAnnotations = clusterAnnotations;
        this.clusterClaimConfiguration = clusterClaimConfiguration;
        this.clusterLabels = clusterLabels;
        this.featureGates = featureGates;
        this.kubeAPIBurst = kubeAPIBurst;
        this.kubeAPIQPS = kubeAPIQPS;
        this.registrationDriver = registrationDriver;
    }

    @JsonProperty("addOnKubeClientRegistrationDriver")
    public AddOnRegistrationDriver getAddOnKubeClientRegistrationDriver() {
        return addOnKubeClientRegistrationDriver;
    }

    @JsonProperty("addOnKubeClientRegistrationDriver")
    public void setAddOnKubeClientRegistrationDriver(AddOnRegistrationDriver addOnKubeClientRegistrationDriver) {
        this.addOnKubeClientRegistrationDriver = addOnKubeClientRegistrationDriver;
    }

    @JsonProperty("bootstrapKubeConfigs")
    public BootstrapKubeConfigs getBootstrapKubeConfigs() {
        return bootstrapKubeConfigs;
    }

    @JsonProperty("bootstrapKubeConfigs")
    public void setBootstrapKubeConfigs(BootstrapKubeConfigs bootstrapKubeConfigs) {
        this.bootstrapKubeConfigs = bootstrapKubeConfigs;
    }

    /**
     * clientCertExpirationSeconds represents the seconds of a client certificate to expire. If it is not set or 0, the default duration seconds will be set by the hub cluster. If the value is larger than the max signing duration seconds set on the hub cluster, the max signing duration seconds will be set.
     */
    @JsonProperty("clientCertExpirationSeconds")
    public Integer getClientCertExpirationSeconds() {
        return clientCertExpirationSeconds;
    }

    /**
     * clientCertExpirationSeconds represents the seconds of a client certificate to expire. If it is not set or 0, the default duration seconds will be set by the hub cluster. If the value is larger than the max signing duration seconds set on the hub cluster, the max signing duration seconds will be set.
     */
    @JsonProperty("clientCertExpirationSeconds")
    public void setClientCertExpirationSeconds(Integer clientCertExpirationSeconds) {
        this.clientCertExpirationSeconds = clientCertExpirationSeconds;
    }

    /**
     * ClusterAnnotations is annotations with the reserve prefix "agent.open-cluster-management.io" set on ManagedCluster when creating only, other actors can update it afterwards.
     */
    @JsonProperty("clusterAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getClusterAnnotations() {
        return clusterAnnotations;
    }

    /**
     * ClusterAnnotations is annotations with the reserve prefix "agent.open-cluster-management.io" set on ManagedCluster when creating only, other actors can update it afterwards.
     */
    @JsonProperty("clusterAnnotations")
    public void setClusterAnnotations(Map<String, String> clusterAnnotations) {
        this.clusterAnnotations = clusterAnnotations;
    }

    @JsonProperty("clusterClaimConfiguration")
    public ClusterClaimConfiguration getClusterClaimConfiguration() {
        return clusterClaimConfiguration;
    }

    @JsonProperty("clusterClaimConfiguration")
    public void setClusterClaimConfiguration(ClusterClaimConfiguration clusterClaimConfiguration) {
        this.clusterClaimConfiguration = clusterClaimConfiguration;
    }

    /**
     * ClusterLabels is labels set on ManagedCluster when creating only, other actors can update it afterwards.
     */
    @JsonProperty("clusterLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getClusterLabels() {
        return clusterLabels;
    }

    /**
     * ClusterLabels is labels set on ManagedCluster when creating only, other actors can update it afterwards.
     */
    @JsonProperty("clusterLabels")
    public void setClusterLabels(Map<String, String> clusterLabels) {
        this.clusterLabels = clusterLabels;
    }

    /**
     * FeatureGates represents the list of feature gates for registration If it is set empty, default feature gates will be used. If it is set, featuregate/Foo is an example of one item in FeatureGates:<br><p>   1. If featuregate/Foo does not exist, registration-operator will discard it<br><p>   2. If featuregate/Foo exists and is false by default. It is now possible to set featuregate/Foo=[false|true]<br><p>   3. If featuregate/Foo exists and is true by default. If a cluster-admin upgrading from 1 to 2 wants to continue having featuregate/Foo=false,<br><p>  	he can set featuregate/Foo=false before upgrading. Let's say the cluster-admin wants featuregate/Foo=false.
     */
    @JsonProperty("featureGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FeatureGate> getFeatureGates() {
        return featureGates;
    }

    /**
     * FeatureGates represents the list of feature gates for registration If it is set empty, default feature gates will be used. If it is set, featuregate/Foo is an example of one item in FeatureGates:<br><p>   1. If featuregate/Foo does not exist, registration-operator will discard it<br><p>   2. If featuregate/Foo exists and is false by default. It is now possible to set featuregate/Foo=[false|true]<br><p>   3. If featuregate/Foo exists and is true by default. If a cluster-admin upgrading from 1 to 2 wants to continue having featuregate/Foo=false,<br><p>  	he can set featuregate/Foo=false before upgrading. Let's say the cluster-admin wants featuregate/Foo=false.
     */
    @JsonProperty("featureGates")
    public void setFeatureGates(List<FeatureGate> featureGates) {
        this.featureGates = featureGates;
    }

    /**
     * KubeAPIBurst indicates the maximum burst of the throttle while talking with apiserver on the spoke cluster. If it is set empty, use the default value: 100
     */
    @JsonProperty("kubeAPIBurst")
    public Integer getKubeAPIBurst() {
        return kubeAPIBurst;
    }

    /**
     * KubeAPIBurst indicates the maximum burst of the throttle while talking with apiserver on the spoke cluster. If it is set empty, use the default value: 100
     */
    @JsonProperty("kubeAPIBurst")
    public void setKubeAPIBurst(Integer kubeAPIBurst) {
        this.kubeAPIBurst = kubeAPIBurst;
    }

    /**
     * KubeAPIQPS indicates the maximum QPS while talking with apiserver on the spoke cluster. If it is set empty, use the default value: 50
     */
    @JsonProperty("kubeAPIQPS")
    public Integer getKubeAPIQPS() {
        return kubeAPIQPS;
    }

    /**
     * KubeAPIQPS indicates the maximum QPS while talking with apiserver on the spoke cluster. If it is set empty, use the default value: 50
     */
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
        if (!(o instanceof RegistrationConfiguration)) {
            return false;
        }
        RegistrationConfiguration other = (RegistrationConfiguration) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$addOnKubeClientRegistrationDriver = this.getAddOnKubeClientRegistrationDriver();
        Object other$addOnKubeClientRegistrationDriver = other.getAddOnKubeClientRegistrationDriver();
        if (this$addOnKubeClientRegistrationDriver == null ? other$addOnKubeClientRegistrationDriver != null : !this$addOnKubeClientRegistrationDriver.equals(other$addOnKubeClientRegistrationDriver)) {
            return false;
        }
        Object this$bootstrapKubeConfigs = this.getBootstrapKubeConfigs();
        Object other$bootstrapKubeConfigs = other.getBootstrapKubeConfigs();
        if (this$bootstrapKubeConfigs == null ? other$bootstrapKubeConfigs != null : !this$bootstrapKubeConfigs.equals(other$bootstrapKubeConfigs)) {
            return false;
        }
        Object this$clientCertExpirationSeconds = this.getClientCertExpirationSeconds();
        Object other$clientCertExpirationSeconds = other.getClientCertExpirationSeconds();
        if (this$clientCertExpirationSeconds == null ? other$clientCertExpirationSeconds != null : !this$clientCertExpirationSeconds.equals(other$clientCertExpirationSeconds)) {
            return false;
        }
        Object this$clusterAnnotations = this.getClusterAnnotations();
        Object other$clusterAnnotations = other.getClusterAnnotations();
        if (this$clusterAnnotations == null ? other$clusterAnnotations != null : !this$clusterAnnotations.equals(other$clusterAnnotations)) {
            return false;
        }
        Object this$clusterClaimConfiguration = this.getClusterClaimConfiguration();
        Object other$clusterClaimConfiguration = other.getClusterClaimConfiguration();
        if (this$clusterClaimConfiguration == null ? other$clusterClaimConfiguration != null : !this$clusterClaimConfiguration.equals(other$clusterClaimConfiguration)) {
            return false;
        }
        Object this$clusterLabels = this.getClusterLabels();
        Object other$clusterLabels = other.getClusterLabels();
        if (this$clusterLabels == null ? other$clusterLabels != null : !this$clusterLabels.equals(other$clusterLabels)) {
            return false;
        }
        Object this$featureGates = this.getFeatureGates();
        Object other$featureGates = other.getFeatureGates();
        if (this$featureGates == null ? other$featureGates != null : !this$featureGates.equals(other$featureGates)) {
            return false;
        }
        Object this$kubeAPIBurst = this.getKubeAPIBurst();
        Object other$kubeAPIBurst = other.getKubeAPIBurst();
        if (this$kubeAPIBurst == null ? other$kubeAPIBurst != null : !this$kubeAPIBurst.equals(other$kubeAPIBurst)) {
            return false;
        }
        Object this$kubeAPIQPS = this.getKubeAPIQPS();
        Object other$kubeAPIQPS = other.getKubeAPIQPS();
        if (this$kubeAPIQPS == null ? other$kubeAPIQPS != null : !this$kubeAPIQPS.equals(other$kubeAPIQPS)) {
            return false;
        }
        Object this$registrationDriver = this.getRegistrationDriver();
        Object other$registrationDriver = other.getRegistrationDriver();
        if (this$registrationDriver == null ? other$registrationDriver != null : !this$registrationDriver.equals(other$registrationDriver)) {
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
        return other instanceof RegistrationConfiguration;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $addOnKubeClientRegistrationDriver = this.getAddOnKubeClientRegistrationDriver();
        result = result * prime + ($addOnKubeClientRegistrationDriver == null ? 43 : $addOnKubeClientRegistrationDriver.hashCode());
        Object $bootstrapKubeConfigs = this.getBootstrapKubeConfigs();
        result = result * prime + ($bootstrapKubeConfigs == null ? 43 : $bootstrapKubeConfigs.hashCode());
        Object $clientCertExpirationSeconds = this.getClientCertExpirationSeconds();
        result = result * prime + ($clientCertExpirationSeconds == null ? 43 : $clientCertExpirationSeconds.hashCode());
        Object $clusterAnnotations = this.getClusterAnnotations();
        result = result * prime + ($clusterAnnotations == null ? 43 : $clusterAnnotations.hashCode());
        Object $clusterClaimConfiguration = this.getClusterClaimConfiguration();
        result = result * prime + ($clusterClaimConfiguration == null ? 43 : $clusterClaimConfiguration.hashCode());
        Object $clusterLabels = this.getClusterLabels();
        result = result * prime + ($clusterLabels == null ? 43 : $clusterLabels.hashCode());
        Object $featureGates = this.getFeatureGates();
        result = result * prime + ($featureGates == null ? 43 : $featureGates.hashCode());
        Object $kubeAPIBurst = this.getKubeAPIBurst();
        result = result * prime + ($kubeAPIBurst == null ? 43 : $kubeAPIBurst.hashCode());
        Object $kubeAPIQPS = this.getKubeAPIQPS();
        result = result * prime + ($kubeAPIQPS == null ? 43 : $kubeAPIQPS.hashCode());
        Object $registrationDriver = this.getRegistrationDriver();
        result = result * prime + ($registrationDriver == null ? 43 : $registrationDriver.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RegistrationConfiguration(" + "addOnKubeClientRegistrationDriver=" + this.getAddOnKubeClientRegistrationDriver() + ", bootstrapKubeConfigs=" + this.getBootstrapKubeConfigs() + ", clientCertExpirationSeconds=" + this.getClientCertExpirationSeconds() + ", clusterAnnotations=" + this.getClusterAnnotations() + ", clusterClaimConfiguration=" + this.getClusterClaimConfiguration() + ", clusterLabels=" + this.getClusterLabels() + ", featureGates=" + this.getFeatureGates() + ", kubeAPIBurst=" + this.getKubeAPIBurst() + ", kubeAPIQPS=" + this.getKubeAPIQPS() + ", registrationDriver=" + this.getRegistrationDriver() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
