
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
    "altSource",
    "chartName",
    "configMapRef",
    "digest",
    "insecureSkipVerify",
    "secretRef",
    "source",
    "version"
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
public class HelmReleaseRepo implements KubernetesResource
{

    @JsonProperty("altSource")
    private AltSource altSource;
    @JsonProperty("chartName")
    private String chartName;
    @JsonProperty("configMapRef")
    private io.fabric8.kubernetes.api.model.ObjectReference configMapRef;
    @JsonProperty("digest")
    private String digest;
    @JsonProperty("insecureSkipVerify")
    private Boolean insecureSkipVerify;
    @JsonProperty("secretRef")
    private io.fabric8.kubernetes.api.model.ObjectReference secretRef;
    @JsonProperty("source")
    private Source source;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HelmReleaseRepo() {
    }

    /**
     * 
     * @param altSource
     * @param chartName
     * @param configMapRef
     * @param digest
     * @param insecureSkipVerify
     * @param secretRef
     * @param source
     * @param version
     */
    public HelmReleaseRepo(AltSource altSource, String chartName, io.fabric8.kubernetes.api.model.ObjectReference configMapRef, String digest, Boolean insecureSkipVerify, io.fabric8.kubernetes.api.model.ObjectReference secretRef, Source source, String version) {
        super();
        this.altSource = altSource;
        this.chartName = chartName;
        this.configMapRef = configMapRef;
        this.digest = digest;
        this.insecureSkipVerify = insecureSkipVerify;
        this.secretRef = secretRef;
        this.source = source;
        this.version = version;
    }

    @JsonProperty("altSource")
    public AltSource getAltSource() {
        return altSource;
    }

    @JsonProperty("altSource")
    public void setAltSource(AltSource altSource) {
        this.altSource = altSource;
    }

    @JsonProperty("chartName")
    public String getChartName() {
        return chartName;
    }

    @JsonProperty("chartName")
    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    @JsonProperty("configMapRef")
    public io.fabric8.kubernetes.api.model.ObjectReference getConfigMapRef() {
        return configMapRef;
    }

    @JsonProperty("configMapRef")
    public void setConfigMapRef(io.fabric8.kubernetes.api.model.ObjectReference configMapRef) {
        this.configMapRef = configMapRef;
    }

    @JsonProperty("digest")
    public String getDigest() {
        return digest;
    }

    @JsonProperty("digest")
    public void setDigest(String digest) {
        this.digest = digest;
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

    @JsonProperty("source")
    public Source getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(Source source) {
        this.source = source;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
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
