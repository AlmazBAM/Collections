package inline

import javax.naming.Name

fun main() {

    val user = User(UserId(0), "Nick")
    user.id.showValue()
    println(user)

}

data class User(val id: UserId, val name: String)
@JvmInline
value class UserId(val value: Int) {
    fun showValue() {
        println(value)
    }
}