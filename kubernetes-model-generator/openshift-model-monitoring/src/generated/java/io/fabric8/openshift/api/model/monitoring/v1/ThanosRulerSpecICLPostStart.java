
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "exec",
    "httpGet",
    "sleep",
    "tcpSocket"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ThanosRulerSpecICLPostStart implements Editable<ThanosRulerSpecICLPostStartBuilder> , KubernetesResource
{

    @JsonProperty("exec")
    private ThanosRulerSpecICLPSExec exec;
    @JsonProperty("httpGet")
    private ThanosRulerSpecICLPSHttpGet httpGet;
    @JsonProperty("sleep")
    private ThanosRulerSpecICLPSSleep sleep;
    @JsonProperty("tcpSocket")
    private ThanosRulerSpecICLPSTcpSocket tcpSocket;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ThanosRulerSpecICLPostStart() {
    }

    public ThanosRulerSpecICLPostStart(ThanosRulerSpecICLPSExec exec, ThanosRulerSpecICLPSHttpGet httpGet, ThanosRulerSpecICLPSSleep sleep, ThanosRulerSpecICLPSTcpSocket tcpSocket) {
        super();
        this.exec = exec;
        this.httpGet = httpGet;
        this.sleep = sleep;
        this.tcpSocket = tcpSocket;
    }

    @JsonProperty("exec")
    public ThanosRulerSpecICLPSExec getExec() {
        return exec;
    }

    @JsonProperty("exec")
    public void setExec(ThanosRulerSpecICLPSExec exec) {
        this.exec = exec;
    }

    @JsonProperty("httpGet")
    public ThanosRulerSpecICLPSHttpGet getHttpGet() {
        return httpGet;
    }

    @JsonProperty("httpGet")
    public void setHttpGet(ThanosRulerSpecICLPSHttpGet httpGet) {
        this.httpGet = httpGet;
    }

    @JsonProperty("sleep")
    public ThanosRulerSpecICLPSSleep getSleep() {
        return sleep;
    }

    @JsonProperty("sleep")
    public void setSleep(ThanosRulerSpecICLPSSleep sleep) {
        this.sleep = sleep;
    }

    @JsonProperty("tcpSocket")
    public ThanosRulerSpecICLPSTcpSocket getTcpSocket() {
        return tcpSocket;
    }

    @JsonProperty("tcpSocket")
    public void setTcpSocket(ThanosRulerSpecICLPSTcpSocket tcpSocket) {
        this.tcpSocket = tcpSocket;
    }

    @JsonIgnore
    public ThanosRulerSpecICLPostStartBuilder edit() {
        return new ThanosRulerSpecICLPostStartBuilder(this);
    }

    @JsonIgnore
    public ThanosRulerSpecICLPostStartBuilder toBuilder() {
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
