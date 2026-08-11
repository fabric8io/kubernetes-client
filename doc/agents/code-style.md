# Code Style

## Formatting

Use the make target for formatting. It applies license headers and Java
formatting.

```bash
# Format all code
make format

# Check formatting without applying
mvn spotless:check
```

## IDE Configuration

Import IDE settings from `/ide-config/`.

- Eclipse: `eclipse-format.xml` and `eclipse.importorder`.
- IntelliJ: import the Eclipse formatter profile.

## Conventions

- Package naming: `io.fabric8.kubernetes.*`.
- Logger variable: `logger`, not `LOG` or `LOGGER`.
- No wildcard imports. Use `import java.util.List;`, not `import java.util.*;`.
- Apache License 2.0 headers are required on all source files.
- Use fluent/DSL-style API design.
- Java 11+ syntax is allowed.
