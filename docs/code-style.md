# Code Style

The intent here is to maintain a common style across the project and rely on the process to enforce it instead of
individuals.

## Automated code style check

The [pom.xml](../pom.xml) is configured to enforce a coding style defined in [checkstyle.xml](../checkstyle.xml) when
maven `validate` phase executed.

## Formatting

The project uses formatting rules described in `.editorconfig` file. Most of the popular IDEs have support of it. For
example, in `IntelliJ IDEA` hit `Code -> Reformat Code` to organize your code.

## Code conventions

### Max line length

Line length is limited to 150 columns for `*.java` files. Other file types are unrestricted.

### Transitive dependencies

Don't use transitive dependencies in project code. If it needed, recommended adding a library as a dependency of Maven
in `pom.xml` directly.

### Add library as maven dependency

It is recommended to define version of library to separate property in `pom.xml`:

```
<project>
    <properties>
        <caffeine.version>2.6.2</caffeine.version>
    </properties>
    
    <dependencies>
        <dependency>
            <groupId>com.github.ben-manes.caffeine</groupId>
            <artifactId>caffeine</artifactId>
            <version>${caffeine.version}</version>
        </dependency>
    </dependencies>
</project>
```

### Avoid wildcards in imports

Do not use wildcard in imports because they hide what exactly is required by the class.

```
// bad
import java.util.*;

// good
import java.util.HashMap;
import java.util.Map;
```

### Variable and method naming

Prefer to use `camelCase` naming convention for variables and methods.

```
// bad
String account_id = "id";

// good
String accountId = "id";
```

Name of variable should be self-explanatory:

```
// bad
String s = resolveParamA();

// good
String resolvedParamA = resolveParamA();
```

This helps other developers flesh your code out better without additional questions.

For `Map`s it is recommended to use `To` between key and value designation:

```
// bad
Map<Imp, ExtImp> map = getData();

// good
Map<String, Integer> keyToValue = getData();
```

And `And` for `Map.Entry` of `Tupple` 

```
// bad
Map.Entry<String, Integer> keyWithValue = getData();

// good
Map.Entry<String, Integer> keyAndValue = getData();
```

### Ternary expressions

Results of long ternary operators should be on separate lines:

```
// bad
boolean result = someVeryVeryLongConditionThatForcesLineWrap ? firstResult
    : secondResult;

// good
boolean result = someVeryVeryLongConditionThatForcesLineWrap
    ? firstResult
    : secondResult;
```

Not so strict, but short ternary operations should be on one line:

```
// bad
boolean result = someShortCondition
    ? firstResult
    : secondResult;

// good
boolean result = someShortCondition ? firstResult : secondResult;
```

### Nested method calls

Try to avoid hard-readable multiple nested method calls:

```
// bad
int resolvedValue = resolveValue(fetchExternalJson(url, httpClient), populateAdditionalKeys(mainKeys, keyResolver));

// good
String externalJson = fetchExternalJson(url, httpClient);
List<Key> additionalKeys = fetchAdditionalKeys(mainKeys, keyResolver);
int resolvedValue = resolveValue(externalJson, additionalKeys);
```

### Data retrieval calls of same result

Try not to retrieve same data more than once:

```
// bad
if (getData() != null) {
    Data resolvedData = resolveData(getData());
    ...
}

// good
Data data = getData();
if (data != null) {
    Data resolvedData = resolveData(data);
    ...
}
```

### Check for NULL

If you're dealing with incoming data, please be sure to check if the nested object is not null before chaining.

```
// bad
ExtRequestTargeting targeting = bidRequest.getExt().getPrebid().getTargeting();

// good
ExtRequest requestExt = bidRequest.getExt();
ExtRequestPrebid prebid = requestExt != null ? requestExt.getPrebid() : null;
ExtRequestTargeting targeting = prebid != null ? prebid.getTargeting() : null;
```

### Garbage code

Don't leave commented code (don't think about the future).

```
// bad
// String iWillUseThisLater = "never";
```

You can always add it later when it will be really desired.

### Tests

The code should be covered over 90%.

#### Given-When-Then approach

The common way for writing tests has to comply with `given-when-then` style.

```
// given
BidRequest bidRequest = BidRequest.builder().id("").build();

// when
ValidationResult result = requestValidator.validate(bidRequest);

// then
assertThat(result.getErrors()).containsOnly("request missing required field: \"id\"");
```

where:

- `given` - initial state, data or conditions.
- `when` - stimulus: some action against the system under test.
- `then` - expectations/assertions.

#### Real data in tests

Don't use real information in tests, like existing endpoint URLs, account IDs, etc.

```
// bad
String ENDPOINT_URL = "https://prebid.org";

// good
String ENDPOINT_URL = "https://test-endpoint.url";
```
