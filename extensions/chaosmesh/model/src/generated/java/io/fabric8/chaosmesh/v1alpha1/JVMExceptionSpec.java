
package io.fabric8.chaosmesh.v1alpha1;

import java.util.LinkedHashMap;
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
    "class",
    "exception",
    "method",
    "pid",
    "port"
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
public class JVMExceptionSpec implements Editable<JVMExceptionSpecBuilder>, KubernetesResource
{

    @JsonProperty("class")
    private String className;
    @JsonProperty("exception")
    private String exception;
    @JsonProperty("method")
    private String method;
    @JsonProperty("pid")
    private Integer pid;
    @JsonProperty("port")
    private Integer port;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JVMExceptionSpec() {
    }

    public JVMExceptionSpec(String className, String exception, String method, Integer pid, Integer port) {
        super();
        this.className = className;
        this.exception = exception;
        this.method = method;
        this.pid = pid;
        this.port = port;
    }

    /**
     * Java class
     */
    @JsonProperty("class")
    public String getClassName() {
        return className;
    }

    /**
     * Java class
     */
    @JsonProperty("class")
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * the exception which needs to throw for action `exception`
     */
    @JsonProperty("exception")
    public String getException() {
        return exception;
    }

    /**
     * the exception which needs to throw for action `exception`
     */
    @JsonProperty("exception")
    public void setException(String exception) {
        this.exception = exception;
    }

    /**
     * the method in Java class
     */
    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    /**
     * the method in Java class
     */
    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * the pid of Java process which needs to attach
     */
    @JsonProperty("pid")
    public Integer getPid() {
        return pid;
    }

    /**
     * the pid of Java process which needs to attach
     */
    @JsonProperty("pid")
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * the port of agent server, default 9277
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * the port of agent server, default 9277
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    @JsonIgnore
    public JVMExceptionSpecBuilder edit() {
        return new JVMExceptionSpecBuilder(this);
    }

    @JsonIgnore
    public JVMExceptionSpecBuilder toBuilder() {
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
        if (!(o instanceof JVMExceptionSpec)) {
            return false;
        }
        JVMExceptionSpec other = (JVMExceptionSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$className = this.getClassName();
        Object other$className = other.getClassName();
        if (this$className == null ? other$className != null : !this$className.equals(other$className)) {
            return false;
        }
        Object this$exception = this.getException();
        Object other$exception = other.getException();
        if (this$exception == null ? other$exception != null : !this$exception.equals(other$exception)) {
            return false;
        }
        Object this$method = this.getMethod();
        Object other$method = other.getMethod();
        if (this$method == null ? other$method != null : !this$method.equals(other$method)) {
            return false;
        }
        Object this$pid = this.getPid();
        Object other$pid = other.getPid();
        if (this$pid == null ? other$pid != null : !this$pid.equals(other$pid)) {
            return false;
        }
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
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
        return other instanceof JVMExceptionSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $className = this.getClassName();
        result = result * prime + ($className == null ? 43 : $className.hashCode());
        Object $exception = this.getException();
        result = result * prime + ($exception == null ? 43 : $exception.hashCode());
        Object $method = this.getMethod();
        result = result * prime + ($method == null ? 43 : $method.hashCode());
        Object $pid = this.getPid();
        result = result * prime + ($pid == null ? 43 : $pid.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "JVMExceptionSpec(" + "className=" + this.getClassName() + ", exception=" + this.getException() + ", method=" + this.getMethod() + ", pid=" + this.getPid() + ", port=" + this.getPort() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
