package collections


interface CustomMap<K, out V> {
    val size: Int

    operator fun get(key: K): V?

    fun containsKey(key: K): Boolean

    fun containsValue(value: @UnsafeVariance V): Boolean

    val keys: CustomSet<K>

    val values: CustomCollection<V>
}