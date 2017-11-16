import java.time.Instant.now
import java.util.*

fun main(args:Array<String>){
    returnDemo_4()
}


fun returnDemo_4() {
    println(" START " + ::returnDemo_4.name)
    val intArray = intArrayOf(1, 2, 3, 4, 5)
    intArray.forEach {
        if (it == 3) return@forEach // 从 lambda 表达式 @forEach 中返回。
        println(it)
    }

    var ss=null
    println(ss?:1)
    println(" END " + ::returnDemo_4.name)
}