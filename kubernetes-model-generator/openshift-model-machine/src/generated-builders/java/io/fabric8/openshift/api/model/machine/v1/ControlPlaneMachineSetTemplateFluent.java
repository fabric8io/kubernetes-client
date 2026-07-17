package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ControlPlaneMachineSetTemplateFluent<A extends io.fabric8.openshift.api.model.machine.v1.ControlPlaneMachineSetTemplateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String machineType;
  private OpenShiftMachineV1Beta1MachineTemplateBuilder machinesV1beta1MachineOpenshiftIo;

  public ControlPlaneMachineSetTemplateFluent() {
  }
  
  public ControlPlaneMachineSetTemplateFluent(ControlPlaneMachineSetTemplate instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public OpenShiftMachineV1Beta1MachineTemplate buildMachinesV1beta1MachineOpenshiftIo() {
    return this.machinesV1beta1MachineOpenshiftIo != null ? this.machinesV1beta1MachineOpenshiftIo.build() : null;
  }
  
  protected void copyInstance(ControlPlaneMachineSetTemplate instance) {
    instance = instance != null ? instance : new ControlPlaneMachineSetTemplate();
    if (instance != null) {
        this.withMachineType(instance.getMachineType());
        this.withMachinesV1beta1MachineOpenshiftIo(instance.getMachinesV1beta1MachineOpenshiftIo());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MachinesV1beta1MachineOpenshiftIoNested<A> editMachinesV1beta1MachineOpenshiftIo() {
    return this.withNewMachinesV1beta1MachineOpenshiftIoLike(Optional.ofNullable(this.buildMachinesV1beta1MachineOpenshiftIo()).orElse(null));
  }
  
  public MachinesV1beta1MachineOpenshiftIoNested<A> editOrNewMachinesV1beta1MachineOpenshiftIo() {
    return this.withNewMachinesV1beta1MachineOpenshiftIoLike(Optional.ofNullable(this.buildMachinesV1beta1MachineOpenshiftIo()).orElse(new OpenShiftMachineV1Beta1MachineTemplateBuilder().build()));
  }
  
  public MachinesV1beta1MachineOpenshiftIoNested<A> editOrNewMachinesV1beta1MachineOpenshiftIoLike(OpenShiftMachineV1Beta1MachineTemplate item) {
    return this.withNewMachinesV1beta1MachineOpenshiftIoLike(Optional.ofNullable(this.buildMachinesV1beta1MachineOpenshiftIo()).orElse(item));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    ControlPlaneMachineSetTemplateFluent that = (ControlPlaneMachineSetTemplateFluent) o;
    if (!(Objects.equals(machineType, that.machineType))) {
      return false;
    }
    if (!(Objects.equals(machinesV1beta1MachineOpenshiftIo, that.machinesV1beta1MachineOpenshiftIo))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getMachineType() {
    return this.machineType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMachineType() {
    return this.machineType != null;
  }
  
  public boolean hasMachinesV1beta1MachineOpenshiftIo() {
    return this.machinesV1beta1MachineOpenshiftIo != null;
  }
  
  public int hashCode() {
    return Objects.hash(machineType, machinesV1beta1MachineOpenshiftIo, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(machineType == null)) {
        sb.append("machineType:");
        sb.append(machineType);
        sb.append(",");
    }
    if (!(machinesV1beta1MachineOpenshiftIo == null)) {
        sb.append("machinesV1beta1MachineOpenshiftIo:");
        sb.append(machinesV1beta1MachineOpenshiftIo);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withMachineType(String machineType) {
    this.machineType = machineType;
    return (A) this;
  }
  
  public A withMachinesV1beta1MachineOpenshiftIo(OpenShiftMachineV1Beta1MachineTemplate machinesV1beta1MachineOpenshiftIo) {
    this._visitables.remove("machinesV1beta1MachineOpenshiftIo");
    if (machinesV1beta1MachineOpenshiftIo != null) {
        this.machinesV1beta1MachineOpenshiftIo = new OpenShiftMachineV1Beta1MachineTemplateBuilder(machinesV1beta1MachineOpenshiftIo);
        this._visitables.get("machinesV1beta1MachineOpenshiftIo").add(this.machinesV1beta1MachineOpenshiftIo);
    } else {
        this.machinesV1beta1MachineOpenshiftIo = null;
        this._visitables.get("machinesV1beta1MachineOpenshiftIo").remove(this.machinesV1beta1MachineOpenshiftIo);
    }
    return (A) this;
  }
  
  public MachinesV1beta1MachineOpenshiftIoNested<A> withNewMachinesV1beta1MachineOpenshiftIo() {
    return new MachinesV1beta1MachineOpenshiftIoNested(null);
  }
  
  public MachinesV1beta1MachineOpenshiftIoNested<A> withNewMachinesV1beta1MachineOpenshiftIoLike(OpenShiftMachineV1Beta1MachineTemplate item) {
    return new MachinesV1beta1MachineOpenshiftIoNested(item);
  }
  public class MachinesV1beta1MachineOpenshiftIoNested<N> extends OpenShiftMachineV1Beta1MachineTemplateFluent<MachinesV1beta1MachineOpenshiftIoNested<N>> implements Nested<N>{
  
    OpenShiftMachineV1Beta1MachineTemplateBuilder builder;
  
    MachinesV1beta1MachineOpenshiftIoNested(OpenShiftMachineV1Beta1MachineTemplate item) {
      this.builder = new OpenShiftMachineV1Beta1MachineTemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) ControlPlaneMachineSetTemplateFluent.this.withMachinesV1beta1MachineOpenshiftIo(builder.build());
    }
    
    public N endMachinesV1beta1MachineOpenshiftIo() {
      return and();
    }
    
  }
}