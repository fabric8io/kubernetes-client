package io.fabric8.kubernetes.api.model.admission.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.Status;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class AdmissionResponseFluent<A extends io.fabric8.kubernetes.api.model.admission.v1beta1.AdmissionResponseFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean allowed;
  private Map<String,String> auditAnnotations;
  private String patch;
  private String patchType;
  private Status status;
  private String uid;
  private List<String> warnings = new ArrayList<String>();

  public AdmissionResponseFluent() {
  }
  
  public AdmissionResponseFluent(AdmissionResponse instance) {
    this.copyInstance(instance);
  }

  public A addAllToWarnings(Collection<String> items) {
    if (this.warnings == null) {
      this.warnings = new ArrayList();
    }
    for (String item : items) {
      this.warnings.add(item);
    }
    return (A) this;
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
  
  public A addToAuditAnnotations(Map<String,String> map) {
    if (this.auditAnnotations == null && map != null) {
      this.auditAnnotations = new LinkedHashMap();
    }
    if (map != null) {
      this.auditAnnotations.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAuditAnnotations(String key,String value) {
    if (this.auditAnnotations == null && key != null && value != null) {
      this.auditAnnotations = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.auditAnnotations.put(key, value);
    }
    return (A) this;
  }
  
  public A addToWarnings(String... items) {
    if (this.warnings == null) {
      this.warnings = new ArrayList();
    }
    for (String item : items) {
      this.warnings.add(item);
    }
    return (A) this;
  }
  
  public A addToWarnings(int index,String item) {
    if (this.warnings == null) {
      this.warnings = new ArrayList();
    }
    this.warnings.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(AdmissionResponse instance) {
    instance = instance != null ? instance : new AdmissionResponse();
    if (instance != null) {
        this.withAllowed(instance.getAllowed());
        this.withAuditAnnotations(instance.getAuditAnnotations());
        this.withPatch(instance.getPatch());
        this.withPatchType(instance.getPatchType());
        this.withStatus(instance.getStatus());
        this.withUid(instance.getUid());
        this.withWarnings(instance.getWarnings());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    AdmissionResponseFluent that = (AdmissionResponseFluent) o;
    if (!(Objects.equals(allowed, that.allowed))) {
      return false;
    }
    if (!(Objects.equals(auditAnnotations, that.auditAnnotations))) {
      return false;
    }
    if (!(Objects.equals(patch, that.patch))) {
      return false;
    }
    if (!(Objects.equals(patchType, that.patchType))) {
      return false;
    }
    if (!(Objects.equals(status, that.status))) {
      return false;
    }
    if (!(Objects.equals(uid, that.uid))) {
      return false;
    }
    if (!(Objects.equals(warnings, that.warnings))) {
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
  
  public Boolean getAllowed() {
    return this.allowed;
  }
  
  public Map<String,String> getAuditAnnotations() {
    return this.auditAnnotations;
  }
  
  public String getFirstWarning() {
    return this.warnings.get(0);
  }
  
  public String getLastWarning() {
    return this.warnings.get(warnings.size() - 1);
  }
  
  public String getMatchingWarning(Predicate<String> predicate) {
      for (String item : warnings) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPatch() {
    return this.patch;
  }
  
  public String getPatchType() {
    return this.patchType;
  }
  
  public Status getStatus() {
    return this.status;
  }
  
  public String getUid() {
    return this.uid;
  }
  
  public String getWarning(int index) {
    return this.warnings.get(index);
  }
  
  public List<String> getWarnings() {
    return this.warnings;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllowed() {
    return this.allowed != null;
  }
  
  public boolean hasAuditAnnotations() {
    return this.auditAnnotations != null;
  }
  
  public boolean hasMatchingWarning(Predicate<String> predicate) {
      for (String item : warnings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPatch() {
    return this.patch != null;
  }
  
  public boolean hasPatchType() {
    return this.patchType != null;
  }
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public boolean hasUid() {
    return this.uid != null;
  }
  
  public boolean hasWarnings() {
    return this.warnings != null && !(this.warnings.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(allowed, auditAnnotations, patch, patchType, status, uid, warnings, additionalProperties);
  }
  
  public A removeAllFromWarnings(Collection<String> items) {
    if (this.warnings == null) {
      return (A) this;
    }
    for (String item : items) {
      this.warnings.remove(item);
    }
    return (A) this;
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
  
  public A removeFromAuditAnnotations(String key) {
    if (this.auditAnnotations == null) {
      return (A) this;
    }
    if (key != null && this.auditAnnotations != null) {
      this.auditAnnotations.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAuditAnnotations(Map<String,String> map) {
    if (this.auditAnnotations == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.auditAnnotations != null) {
          this.auditAnnotations.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromWarnings(String... items) {
    if (this.warnings == null) {
      return (A) this;
    }
    for (String item : items) {
      this.warnings.remove(item);
    }
    return (A) this;
  }
  
  public A setToWarnings(int index,String item) {
    if (this.warnings == null) {
      this.warnings = new ArrayList();
    }
    this.warnings.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allowed == null)) {
        sb.append("allowed:");
        sb.append(allowed);
        sb.append(",");
    }
    if (!(auditAnnotations == null) && !(auditAnnotations.isEmpty())) {
        sb.append("auditAnnotations:");
        sb.append(auditAnnotations);
        sb.append(",");
    }
    if (!(patch == null)) {
        sb.append("patch:");
        sb.append(patch);
        sb.append(",");
    }
    if (!(patchType == null)) {
        sb.append("patchType:");
        sb.append(patchType);
        sb.append(",");
    }
    if (!(status == null)) {
        sb.append("status:");
        sb.append(status);
        sb.append(",");
    }
    if (!(uid == null)) {
        sb.append("uid:");
        sb.append(uid);
        sb.append(",");
    }
    if (!(warnings == null) && !(warnings.isEmpty())) {
        sb.append("warnings:");
        sb.append(warnings);
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
  
  public A withAllowed() {
    return withAllowed(true);
  }
  
  public A withAllowed(Boolean allowed) {
    this.allowed = allowed;
    return (A) this;
  }
  
  public <K,V>A withAuditAnnotations(Map<String,String> auditAnnotations) {
    if (auditAnnotations == null) {
      this.auditAnnotations = null;
    } else {
      this.auditAnnotations = new LinkedHashMap(auditAnnotations);
    }
    return (A) this;
  }
  
  public A withPatch(String patch) {
    this.patch = patch;
    return (A) this;
  }
  
  public A withPatchType(String patchType) {
    this.patchType = patchType;
    return (A) this;
  }
  
  public A withStatus(Status status) {
    this.status = status;
    return (A) this;
  }
  
  public A withUid(String uid) {
    this.uid = uid;
    return (A) this;
  }
  
  public A withWarnings(List<String> warnings) {
    if (warnings != null) {
        this.warnings = new ArrayList();
        for (String item : warnings) {
          this.addToWarnings(item);
        }
    } else {
      this.warnings = null;
    }
    return (A) this;
  }
  
  public A withWarnings(String... warnings) {
    if (this.warnings != null) {
        this.warnings.clear();
        _visitables.remove("warnings");
    }
    if (warnings != null) {
      for (String item : warnings) {
        this.addToWarnings(item);
      }
    }
    return (A) this;
  }
  
}