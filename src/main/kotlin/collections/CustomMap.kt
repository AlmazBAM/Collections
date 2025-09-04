package collections


interface CustomMap<K, V> {
    val size: Int

    operator fun get(key: K): V?

    fun containsKey(key: K): Boolean

    fun containsValue(value: V): Boolean

    val keys: CustomSet<K>

    val values: CustomCollection<V>
}