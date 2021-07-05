package io.fabric8.crd.generator.visitor;

import io.fabric8.crd.generator.utils.Types;
import io.sundr.builder.TypedVisitor;
import io.sundr.model.ClassRef;
import io.sundr.model.Property;
import io.sundr.model.TypeDef;
import io.sundr.model.TypeDefBuilder;

import java.util.*;

public class ClassPropertyVisitor extends TypedVisitor<TypeDefBuilder> {
  private final static Map<String, Set<String>> traversedClasses = new HashMap<>();
  private final static Map<String, String> crdNameToCrClass = new HashMap<>();
  private final String crClassName;

  public ClassPropertyVisitor(String crClassName, String crdName) {
    this.crClassName = crClassName;
    crdNameToCrClass.put(crdName, crClassName);
  }

  @Override
  public void visit(TypeDefBuilder builder) {
    TypeDef type = builder.build();
    final List<Property> props = type.getProperties();
    props.stream().filter(p -> p.getTypeRef() instanceof ClassRef).forEach(p -> {
      ClassRef classRef = (ClassRef) p.getTypeRef();
      final String fqn = classRef.getFullyQualifiedName();
      if (!fqn.startsWith("java.lang") && traversedClasses.computeIfAbsent(crClassName, k -> new HashSet<>()).add(fqn)) {
        TypeDef propertyType = Types.typeDefFrom(classRef);
        new TypeDefBuilder(propertyType)
          .accept(this)
          .build();
      }
    });
  }

  public static Map<String, Set<String>> getTraversedClasses() {
    return traversedClasses;
  }

  public static Set<String> getDependentClasses(String crClassName) {
    return traversedClasses.get(crClassName);
  }

  public static Set<String> getDependentClassesFromCRDName(String crdName) {
    return traversedClasses.get(crdNameToCrClass.get(crdName));
  }
}
