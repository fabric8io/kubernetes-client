
package io.fabric8.certmanager.api.model.acme.v1alpha2;

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
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
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
    "disableAccountKeyGeneration",
    "email",
    "enableDurationFeature",
    "externalAccountBinding",
    "preferredChain",
    "privateKeySecretRef",
    "server",
    "skipTLSVerify",
    "solvers"
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
public class ACMEIssuer implements KubernetesResource
{

    @JsonProperty("disableAccountKeyGeneration")
    private Boolean disableAccountKeyGeneration;
    @JsonProperty("email")
    private String email;
    @JsonProperty("enableDurationFeature")
    private Boolean enableDurationFeature;
    @JsonProperty("externalAccountBinding")
    private ACMEExternalAccountBinding externalAccountBinding;
    @JsonProperty("preferredChain")
    private String preferredChain;
    @JsonProperty("privateKeySecretRef")
    private SecretKeySelector privateKeySecretRef;
    @JsonProperty("server")
    private String server;
    @JsonProperty("skipTLSVerify")
    private Boolean skipTLSVerify;
    @JsonProperty("solvers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ACMEChallengeSolver> solvers = new ArrayList<ACMEChallengeSolver>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ACMEIssuer() {
    }

    /**
     * 
     * @param disableAccountKeyGeneration
     * @param privateKeySecretRef
     * @param server
     * @param skipTLSVerify
     * @param enableDurationFeature
     * @param externalAccountBinding
     * @param preferredChain
     * @param email
     * @param solvers
     */
    public ACMEIssuer(Boolean disableAccountKeyGeneration, String email, Boolean enableDurationFeature, ACMEExternalAccountBinding externalAccountBinding, String preferredChain, SecretKeySelector privateKeySecretRef, String server, Boolean skipTLSVerify, List<ACMEChallengeSolver> solvers) {
        super();
        this.disableAccountKeyGeneration = disableAccountKeyGeneration;
        this.email = email;
        this.enableDurationFeature = enableDurationFeature;
        this.externalAccountBinding = externalAccountBinding;
        this.preferredChain = preferredChain;
        this.privateKeySecretRef = privateKeySecretRef;
        this.server = server;
        this.skipTLSVerify = skipTLSVerify;
        this.solvers = solvers;
    }

    @JsonProperty("disableAccountKeyGeneration")
    public Boolean getDisableAccountKeyGeneration() {
        return disableAccountKeyGeneration;
    }

    @JsonProperty("disableAccountKeyGeneration")
    public void setDisableAccountKeyGeneration(Boolean disableAccountKeyGeneration) {
        this.disableAccountKeyGeneration = disableAccountKeyGeneration;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("enableDurationFeature")
    public Boolean getEnableDurationFeature() {
        return enableDurationFeature;
    }

    @JsonProperty("enableDurationFeature")
    public void setEnableDurationFeature(Boolean enableDurationFeature) {
        this.enableDurationFeature = enableDurationFeature;
    }

    @JsonProperty("externalAccountBinding")
    public ACMEExternalAccountBinding getExternalAccountBinding() {
        return externalAccountBinding;
    }

    @JsonProperty("externalAccountBinding")
    public void setExternalAccountBinding(ACMEExternalAccountBinding externalAccountBinding) {
        this.externalAccountBinding = externalAccountBinding;
    }

    @JsonProperty("preferredChain")
    public String getPreferredChain() {
        return preferredChain;
    }

    @JsonProperty("preferredChain")
    public void setPreferredChain(String preferredChain) {
        this.preferredChain = preferredChain;
    }

    @JsonProperty("privateKeySecretRef")
    public SecretKeySelector getPrivateKeySecretRef() {
        return privateKeySecretRef;
    }

    @JsonProperty("privateKeySecretRef")
    public void setPrivateKeySecretRef(SecretKeySelector privateKeySecretRef) {
        this.privateKeySecretRef = privateKeySecretRef;
    }

    @JsonProperty("server")
    public String getServer() {
        return server;
    }

    @JsonProperty("server")
    public void setServer(String server) {
        this.server = server;
    }

    @JsonProperty("skipTLSVerify")
    public Boolean getSkipTLSVerify() {
        return skipTLSVerify;
    }

    @JsonProperty("skipTLSVerify")
    public void setSkipTLSVerify(Boolean skipTLSVerify) {
        this.skipTLSVerify = skipTLSVerify;
    }

    @JsonProperty("solvers")
    public List<ACMEChallengeSolver> getSolvers() {
        return solvers;
    }

    @JsonProperty("solvers")
    public void setSolvers(List<ACMEChallengeSolver> solvers) {
        this.solvers = solvers;
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
