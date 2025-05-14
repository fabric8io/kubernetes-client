
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "autoApproveUsers",
    "featureGates",
    "registrationDrivers"
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
public class RegistrationHubConfiguration implements Editable<RegistrationHubConfigurationBuilder>, KubernetesResource
{

    @JsonProperty("autoApproveUsers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> autoApproveUsers = new ArrayList<>();
    @JsonProperty("featureGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FeatureGate> featureGates = new ArrayList<>();
    @JsonProperty("registrationDrivers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RegistrationDriverHub> registrationDrivers = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RegistrationHubConfiguration() {
    }

    public RegistrationHubConfiguration(List<String> autoApproveUsers, List<FeatureGate> featureGates, List<RegistrationDriverHub> registrationDrivers) {
        super();
        this.autoApproveUsers = autoApproveUsers;
        this.featureGates = featureGates;
        this.registrationDrivers = registrationDrivers;
    }

    /**
     * AutoApproveUser represents a list of users that can auto approve CSR and accept client. If the credential of the bootstrap-hub-kubeconfig matches to the users, the cluster created by the bootstrap-hub-kubeconfig will be auto-registered into the hub cluster. This takes effect only when ManagedClusterAutoApproval feature gate is enabled.
     */
    @JsonProperty("autoApproveUsers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAutoApproveUsers() {
        return autoApproveUsers;
    }

    /**
     * AutoApproveUser represents a list of users that can auto approve CSR and accept client. If the credential of the bootstrap-hub-kubeconfig matches to the users, the cluster created by the bootstrap-hub-kubeconfig will be auto-registered into the hub cluster. This takes effect only when ManagedClusterAutoApproval feature gate is enabled.
     */
    @JsonProperty("autoApproveUsers")
    public void setAutoApproveUsers(List<String> autoApproveUsers) {
        this.autoApproveUsers = autoApproveUsers;
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
     * RegistrationDrivers represent the list of hub registration drivers that contain information used by hub to initialize the hub cluster A RegistrationDriverHub contains details of authentication type and the hub cluster ARN
     */
    @JsonProperty("registrationDrivers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RegistrationDriverHub> getRegistrationDrivers() {
        return registrationDrivers;
    }

    /**
     * RegistrationDrivers represent the list of hub registration drivers that contain information used by hub to initialize the hub cluster A RegistrationDriverHub contains details of authentication type and the hub cluster ARN
     */
    @JsonProperty("registrationDrivers")
    public void setRegistrationDrivers(List<RegistrationDriverHub> registrationDrivers) {
        this.registrationDrivers = registrationDrivers;
    }

    @JsonIgnore
    public RegistrationHubConfigurationBuilder edit() {
        return new RegistrationHubConfigurationBuilder(this);
    }

    @JsonIgnore
    public RegistrationHubConfigurationBuilder toBuilder() {
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

}
