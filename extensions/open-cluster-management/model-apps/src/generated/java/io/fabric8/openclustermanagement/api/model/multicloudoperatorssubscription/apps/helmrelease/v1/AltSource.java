
package io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1;

import java.util.HashMap;
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
    "configMapRef",
    "git",
    "github",
    "helmRepo",
    "insecureSkipVerify",
    "secretRef",
    "type"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class AltSource implements KubernetesResource
{

    @JsonProperty("configMapRef")
    private io.fabric8.kubernetes.api.model.ObjectReference configMapRef;
    @JsonProperty("git")
    private Git git;
    @JsonProperty("github")
    private GitHub github;
    @JsonProperty("helmRepo")
    private HelmRepo helmRepo;
    @JsonProperty("insecureSkipVerify")
    private Boolean insecureSkipVerify;
    @JsonProperty("secretRef")
    private io.fabric8.kubernetes.api.model.ObjectReference secretRef;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AltSource() {
    }

    /**
     * 
     * @param helmRepo
     * @param github
     * @param git
     * @param configMapRef
     * @param insecureSkipVerify
     * @param secretRef
     * @param type
     */
    public AltSource(io.fabric8.kubernetes.api.model.ObjectReference configMapRef, Git git, GitHub github, HelmRepo helmRepo, Boolean insecureSkipVerify, io.fabric8.kubernetes.api.model.ObjectReference secretRef, String type) {
        super();
        this.configMapRef = configMapRef;
        this.git = git;
        this.github = github;
        this.helmRepo = helmRepo;
        this.insecureSkipVerify = insecureSkipVerify;
        this.secretRef = secretRef;
        this.type = type;
    }

    @JsonProperty("configMapRef")
    public io.fabric8.kubernetes.api.model.ObjectReference getConfigMapRef() {
        return configMapRef;
    }

    @JsonProperty("configMapRef")
    public void setConfigMapRef(io.fabric8.kubernetes.api.model.ObjectReference configMapRef) {
        this.configMapRef = configMapRef;
    }

    @JsonProperty("git")
    public Git getGit() {
        return git;
    }

    @JsonProperty("git")
    public void setGit(Git git) {
        this.git = git;
    }

    @JsonProperty("github")
    public GitHub getGithub() {
        return github;
    }

    @JsonProperty("github")
    public void setGithub(GitHub github) {
        this.github = github;
    }

    @JsonProperty("helmRepo")
    public HelmRepo getHelmRepo() {
        return helmRepo;
    }

    @JsonProperty("helmRepo")
    public void setHelmRepo(HelmRepo helmRepo) {
        this.helmRepo = helmRepo;
    }

    @JsonProperty("insecureSkipVerify")
    public Boolean getInsecureSkipVerify() {
        return insecureSkipVerify;
    }

    @JsonProperty("insecureSkipVerify")
    public void setInsecureSkipVerify(Boolean insecureSkipVerify) {
        this.insecureSkipVerify = insecureSkipVerify;
    }

    @JsonProperty("secretRef")
    public io.fabric8.kubernetes.api.model.ObjectReference getSecretRef() {
        return secretRef;
    }

    @JsonProperty("secretRef")
    public void setSecretRef(io.fabric8.kubernetes.api.model.ObjectReference secretRef) {
        this.secretRef = secretRef;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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
