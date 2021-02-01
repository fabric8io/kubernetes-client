/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.utils.Pluralize;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.fabric8.kubernetes.model.annotation.Singular;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.fabric8.kubernetes.client.utils.Utils.isNullOrEmpty;

/**
 * A base class for implementing a custom resource kind. Implementations must be annotated with
 * {@link io.fabric8.kubernetes.model.annotation.Group} and {@link io.fabric8.kubernetes.model.annotation.Version}.
 *
 * Properties are set up automatically as follows:
 * <ul>
 *   <li>group is set using {@link HasMetadata#getGroup(Class)}</li>
 *   <li>version is set using {@link HasMetadata#getVersion(Class)}</li>
 *   <li>singular is set using {@link CustomResource#getSingular(Class)}</li>
 *   <li>plural is set using {@link CustomResource#getPlural(Class)}</li>
 *   <li>computed CRD name using {@link CustomResource#getCRDName(Class)}</li>
 * </ul>
 *
 * In addition, {@link #setApiVersion(String)} and {@link #setKind(String)} are overridden to not do anything since these values
 * are set.
 *
 * @param <S> the class providing the {@code Spec} part of this CustomResource
 * @param <T> the class providing the {@code Status} part of this CustomResource
 */
@JsonDeserialize(
  using = JsonDeserializer.None.class
)
@JsonPropertyOrder({
  "apiVersion",
  "kind",
  "metadata",
  "spec",
  "status"
})
@Buildable(builderPackage = "io.fabric8.kubernetes.api.builder", editableEnabled = false)
public abstract class CustomResource<S, T> implements HasMetadata {
  private static final Logger LOG = LoggerFactory.getLogger(CustomResource.class);

  public static final String NAMESPACE_SCOPE = "Namespaced";
  public static final String CLUSTER_SCOPE = "Cluster";
  private ObjectMeta metadata = new ObjectMeta();

  @JsonProperty("spec")
  protected S spec;

  @JsonProperty("status")
  protected T status;

  private final String singular;
  private final String crdName;
  private final String kind;
  private final String apiVersion;
  private final String scope;
  private final String plural;

  public CustomResource() {
    final String version = HasMetadata.super.getApiVersion();
    final Class<? extends CustomResource> clazz = getClass();
    if (isNullOrEmpty(version)) {
      throw new IllegalArgumentException(clazz.getName() + " CustomResource must provide an API version using @"
        + Group.class.getName() + " and @" + Version.class.getName() + " annotations");
    }
    this.apiVersion = version;
    this.kind = HasMetadata.super.getKind();
    scope = this instanceof Namespaced ? NAMESPACE_SCOPE : CLUSTER_SCOPE;
    this.singular = getSingular(clazz);
    this.plural = getPlural(clazz);
    this.crdName = getCRDName(clazz);
    this.spec = initSpec();
    this.status = initStatus();
  }
  
  /**
   * Override to provide your own Spec instance
   * @return a new Spec instance
   */
  protected S initSpec() {
    return (S)genericInit(0);
  }
  
  /**
   * Override to provide your own Status instance
   * @return a new Status instance
   */
  protected T initStatus() {
    return (T)genericInit(1);
  }

  @Override
  public String toString() {
    return "CustomResource{" +
      "kind='" + getKind() + '\'' +
      ", apiVersion='" + getApiVersion() + '\'' +
      ", metadata=" + metadata +
      ", spec=" + spec +
      ", status=" + status +
      '}';
  }

  @Override
  public String getApiVersion() {
    return apiVersion;
  }

  @Override
  public void setApiVersion(String version) {
    // already set in constructor
    LOG.debug("Calling CustomResource#setApiVersion doesn't do anything because the API version is computed and shouldn't be changed");
  }

  @Override
  public String getKind() {
    return this.kind;
  }

  public void setKind(String kind) {
    // already set in constructor
    LOG.debug("Calling CustomResource#setKind doesn't do anything because the Kind is computed and shouldn't be changed");
  }

  @Override
  public ObjectMeta getMetadata() {
    return metadata;
  }

  @Override
  public void setMetadata(ObjectMeta metadata) {
    this.metadata = metadata;
  }

  /**
   * Retrieves the plural form associated with the specified CustomResource if annotated with {@link Plural} or computes a default value
   * using the value returned by {@link #getSingular(Class)} as input to {@link Pluralize#toPlural(String)}.
   *
   * @param clazz the CustomResource whose plural form we want to retrieve
   * @return the plural form defined by the {@link Plural} annotation or a computed default value
   */
  public static String getPlural(Class<? extends CustomResource> clazz) {
    final Plural fromAnnotation = clazz.getAnnotation(Plural.class);
    return (fromAnnotation != null ? fromAnnotation.value().toLowerCase(Locale.ROOT) : Pluralize.toPlural(getSingular(clazz)));
  }

  @JsonIgnore
  public String getPlural() {
    return plural;
  }

  /**
   * Retrieves the singular form associated with the specified CustomResource as defined by the {@link Singular} annotation or
   * computes a default value (lower-cased version of the value returned by {@link HasMetadata#getKind(Class)}) if the annotation
   * is not present.
   *
   * @param clazz the CustomResource whose singular form we want to retrieve
   * @return the singular form defined by the {@link Singular} annotation or a computed default value
   */
  public static String getSingular(Class<? extends CustomResource> clazz) {
    final Singular fromAnnotation = clazz.getAnnotation(Singular.class);
    return (fromAnnotation != null ? fromAnnotation.value() : HasMetadata.getKind(clazz)).toLowerCase(Locale.ROOT);
  }

  @JsonIgnore
  public String getSingular() {
    return singular;
  }

  /**
   * Computes the name of the Custom Resource Definition (CRD) associated with the specified CustomResource.
   * See https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/ for more details.
   *
   * @param clazz the CustomResource whose CRD name we want to compute
   * @return the CRD name associated with the CustomResource
   */
  public static String getCRDName(Class<? extends CustomResource> clazz) {
    return getPlural(clazz) + "." + HasMetadata.getGroup(clazz);
  }

  @JsonIgnore
  public String getCRDName() {
    return crdName;
  }

  /**
   * Retrieves the scope that this CustomResource targets
   *
   * @return the scope that this CustomResource targets. Possible values are {@link #CLUSTER_SCOPE} or {@link #NAMESPACE_SCOPE}.
   */
  @JsonIgnore
  public String getScope() {
    return scope;
  }

  @JsonIgnore
  public String getGroup() {
    return HasMetadata.getGroup(getClass());
  }

  @JsonIgnore
  public String getVersion() {
    return HasMetadata.getVersion(getClass());
  }

  public S getSpec() {
    return spec;
  }

  public void setSpec(S spec) {
    this.spec = spec;
  }

  public T getStatus() {
    return status;
  }

  public void setStatus(T status) {
    this.status = status;
  }
  
  private final static String TYPE_NAME = CustomResource.class.getTypeName();
  private final static String VOID_TYPE_NAME = Void.class.getTypeName();
  private final static Map<String, Instantiator> instantiators = new ConcurrentHashMap<>();
  
  /**
   * Encapsulates an instantiation means. Needed to provide no-op when needed.
   */
  @FunctionalInterface
  private interface Instantiator {
    
    Object instantiate() throws Exception;
    
    /**
     * No-op instantiator.
     */
    Instantiator NULL = () -> null;
  }
  
  /**
   * Returns the {@link Instantiator} instance associated with the type parameter associated with the specified index in the
   * generic type definition. Records the result so that it's only done once per CustomResource implementation.
   *
   * @param genericTypeIndex the index of the parameter type we want to instantiate in the CustomResource definition, i.e. with
   *                         the CustomResource<S,T> definition, {@code 0} corresponds to the {@code S} type (i.e. the Spec type)
   *                         while {@code 1} corresponds to the {@code T} (i.e. Status) type.
   * @return the {@link Instantiator} for the desired type
   * @throws Exception if the generic type cannot be identified or instantiated
   */
  private Instantiator getInstantiator(int genericTypeIndex) throws Exception {
    final String key = getKey(getClass(), genericTypeIndex);
    Instantiator instantiator = instantiators.get(key);
    if (instantiator == null) {
      instantiator = Instantiator.NULL;
      
      // walk the type hierarchy until we reach CustomResource or a ParameterizedType
      Type genericSuperclass = getClass().getGenericSuperclass();
      String typeName = genericSuperclass.getTypeName();
      while (!TYPE_NAME.equals(typeName) && !(genericSuperclass instanceof ParameterizedType)) {
        genericSuperclass = ((Class) genericSuperclass).getGenericSuperclass();
        typeName = genericSuperclass.getTypeName();
      }
  
      // this works because CustomResource is an abstract class
      if (genericSuperclass instanceof ParameterizedType) {
        final Type[] types = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        if (types.length != 2) {
          throw new IllegalArgumentException(
            "Automatic instantiation of Spec and Status only works for CustomResource implementations parameterized with both types, consider overriding initSpec and/or initStatus");
        }
        // get the associated class from the type name, if not Void
        String className = types[genericTypeIndex].getTypeName();
        if (!VOID_TYPE_NAME.equals(className)) {
          Class<?> clazz = Class.forName(className);
          if (clazz.isInterface() || Modifier.isAbstract(clazz.getModifiers())) {
            throw new IllegalArgumentException(
              "Cannot instantiate interface/abstract type " + className);
          }
          
          // record the instantiator associated with the identified type
          instantiator = () -> {
            final Constructor<?> constructor;
            try {
              // get the no-arg (declared needed if implicit) constructor
              constructor = clazz.getDeclaredConstructor();
              constructor.setAccessible(true); // and make it accessible
            } catch (NoSuchMethodException | SecurityException e) {
              throw new IllegalArgumentException(
                "Cannot find a no-arg constructor for " + className);
            }
            return constructor.newInstance();
          };
        }
      }
      instantiators.put(key, instantiator);
    }
    return instantiator;
  }
  
  private Object genericInit(int genericTypeIndex) {
    try {
      return getInstantiator(genericTypeIndex).instantiate();
    } catch (Exception e) {
      final String fieldName = genericTypeIndex == 0 ? "Spec" : "Status";
      throw new IllegalArgumentException(
        "Cannot instantiate " + fieldName + ", consider overriding init" + fieldName + ": "
          + e.getMessage(), e);
    }
  }
  
  private final static String getKey(Class<? extends CustomResource> clazz, int genericTypeIndex) {
    return clazz.getCanonicalName() + "_" + genericTypeIndex;
  }
}
