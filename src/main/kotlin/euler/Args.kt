package euler

/**
 * Parses `key=value` arguments into a map, e.g. `["limit=10", "second=7"]` to `{limit=10, second=7}`.
 *
 * Fails on a malformed argument, a key not in [keys], a repeated key, or a value that is not an integer,
 * so that a typo never silently falls back to the default.
 */
fun parseArgs(args: Array<String>, vararg keys: String): Map<String, Int> {
    val options = mutableMapOf<String, Int>()
    for (arg in args) {
        val key = arg.substringBefore("=")
        val value = arg.substringAfter("=", missingDelimiterValue = "")
        require(key in keys) { "Unknown argument '$arg'. Expected: ${keys.joinToString { "$it=<number>" }}" }
        require(key !in options) { "Duplicate argument '$key'" }
        options[key] = requireNotNull(value.toIntOrNull()) { "'$key' must be an integer, but was '$value'" }
    }
    return options
}
